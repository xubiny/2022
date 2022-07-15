# Background Thread 동적 작업 실행시키기 ThreadPoolTaskExecutor
- 생각보다 개발을 진행할 때 Runnable Thread를 이용하는 경우가 많지 않다. 특히 웹개발이나 서버개발을 하다보면, 게임처럼 동적인 기능보다 정적인 기능이 많이 요구된다. 프로젝트 진행중, API와 지속적인 연결을 하면서 다른 작업들을 동시에 할 수 있는 기능을 코드상으로만 구현해야하는 상황에서는 Spring에서 제공해주는 ThreadPoolTaskExecutor를 사용하면 좋다. <br/><br/>

<br/>

- 간단한 데모웹페이지를 만들어 버튼을 클릭했을 때 작업이 백그라운드에서 진행이 되고 버튼은 disable 시키는 작업을 해볼 것이다. <br/><br/>
- 간단한 테스팅모듈이라 최대한 가볍고 새로고침했을 때마다 확인이 가능하도록 구현해보기로 한다. <br/><br/>

<br/>

## Package Tree
- Background Thread 기능을 구현하기 위해 4개의 클래스를 만들어 사용할 것이다.<br/><br/>

<br/>

![image](https://user-images.githubusercontent.com/61584142/179136445-580f6a18-7de7-4403-8599-19864e0c4d3c.png)

<br/>

## pom.xml
- 여기서는 크게 사용하는 이유가 없지만, 앞으로 ajax 통신할 때 데이터를 편하게 주고받기 위해 jackson databind 라이브러리를 사용한다. form 형태의 데이터를 json 형태로 백엔드에서 받아서 사용이 가능하다. <br/><br/>

```
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-core</artifactId>
		    <version>2.9.0.pr4</version>
		</dependency>
		
		<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
		    <groupId>com.fasterxml.jackson.core</groupId>
		    <artifactId>jackson-databind</artifactId>
		    <version>2.7.9.1</version>
		</dependency>     
	</dependencies>
```

<br/><br/>

## servlet context
- Spring 프로젝트를 생성했을 때 기본적으로 만들어지는 context.xml 파일에 jsonView 매핑이 들어왔을 때 자동으로 Object와 매핑해주는 설정을 해줘야 한다. <br/><br/>
- 주의사항으로 BeanNameViewResolver order를 0으로 변경해준다. <br/><br/>
- 설정을 안해주면 beanName이 아닌 view 매핑으로 간주하여 404 에러가 발생할 것이다. <br/><br/>

```
<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<context:component-scan base-package="test.*" />
	
	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<beans:bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<beans:property name="order" value="0"></beans:property>
	</beans:bean>
	
	<beans:bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
	
</beans:beans>
```

<br/><br/>

## AsyncConfig.java
- Task 실행을 위한 설정을 해주는 파일이다. <br/><br/>
- 해당 Task가 실행되었을 때 같은 Task를 실행하지 못하게 최대 Thread 수를 1로 지정했다. <br/><br/>
- 기본 Thread 수가 최대 Thread 수를 넘어가면 에러가 발생한다. <br/><br/>

```
package test.async.mongo.async;

import java.util.concurrent.Executor;

import javax.annotation.Resource;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/*
 * @Configuration : bean 객체 등록
 * @EnableAsync : 비동기 프로세서 사용선
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer{
	
	//기본 Thread 수
	private static int TASK_CORE_POOL_SIZE = 1;
	//최대 Thread 수
	private static int TASK_MAX_POOL_SIZE = 1;
	//QUEUE 수
	private static int TASK_QUEUE_CAPACITY = 0;
	//Thread Bean Name
	private final String EXECUTOR_BEAN_NAME = "executor1";
	
	@Resource(name="executor1")
	private ThreadPoolTaskExecutor executor1;
	
	@Bean(name="executor1")
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(TASK_CORE_POOL_SIZE);
		executor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
		executor.setQueueCapacity(TASK_QUEUE_CAPACITY);
		executor.setBeanName(EXECUTOR_BEAN_NAME);
		executor.setWaitForTasksToCompleteOnShutdown(false);
		executor.initialize();
		return executor;
	}
	
	/*
	 * Thread Process도중 에러 발생시
	 */
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}
	
	/*
	 * task 생성전에 pool이 찼는지를 체크
	 */
	public boolean checkSampleTaskExecute() {
		boolean result = true;
		
		System.out.println("활성 Task 수 :::: " + executor1.getActiveCount());
		
		if(executor1.getActiveCount() >= (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)) {
			result = false;
		}
		return result;
	}
}
```

<br/><br/>

## AsyncExceptionHandler.java
- Task 에러가 발생했을 때 실행되는 코드 내용이다. <br/><br/>

```
package test.async.mongo.async;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

	@Override
		public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
		System.out.println("Thread Error Exception");
		System.out.println("exception Message :: " + throwable.getMessage());
		System.out.println("method name :: " + method.getName());
			for(Object param : obj) {
				System.out.println("param Val ::: " + param);
			}
		}
}
```

<br/><br/>

## AsyncTaskService.java
- 해당 파일에서 백그라운드에서 실행할 로직을 구현한다. <br/><br/>
- 간단한 예시로 0~29까지 1초에 한 번씩 로그가 찍히는 코드를 구현했다. <br/><br/>

```
package test.async.mongo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("asyncTaskService")
public class AsyncTaskService {
	
	@Async
	public void jobRunningInBackground(String temp) {
		System.out.println("Thread Start");
		for(int i=0; i < 30; i++) {
			System.out.println(temp + "  i ::::: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread End");
	}
}
```

<br/><br/>

## HomeController.java
- ableToRunThread 파라미터에 현재 Thread가 백그라운드에서 돌고 있는지의 여부를 보내고, AJAX 통신을 위한 POST request 코드를 작성했다. <br/><br/>

```
package test.async.mongo.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import test.async.mongo.async.AsyncConfig;
import test.async.mongo.service.AsyncTaskService;

@Controller
public class HomeController {
	
	@Resource(name="asyncTaskService")
	private AsyncTaskService asyncTaskService;
	
	@Resource(name="asyncConfig")
	private AsyncConfig asyncConfig;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("ableToRunThread",asyncConfig.checkSampleTaskExecute());
		return mav;
	}
	
	
	@RequestMapping(value = "/testing", method = RequestMethod.POST)
	public ModelAndView testing() {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			//Task 실행가능 여부 확
			if(asyncConfig.checkSampleTaskExecute()) {
				asyncTaskService.jobRunningInBackground("Jamong");
			}else {
				System.out.println("Thread 개수 초과");
			}
		} catch (Exception e) {
			System.out.println("Thread Err :: " + e.getMessage());
		}
		return mav;
	}
}
```

<br/><br/>

## home.jsp
- 클라이언트 부분의 코드이다. <br/><br/>
- Thread가 백그라운드에서 돌고 있는지 확인하여, 새로고침을 눌렀을 때 버튼의 disable 여부로 작업의 진행 여부를 확인할 수 있도록 구현했다. <br/><br/>

```
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
	function testing(){
		$.ajax({
			url:"testing",
			type:"POST",
			cache:false,
			data:$("#form1").serialize(),
			async:false,
			success:function(data){
				$('#testingBtn').attr("disabled","disabled");
				$('#testingBtn').val('testing');
			},
			error:function(e){
				console.log("err : " + e);
			}
		});
	}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form name="form1" id="form1" method="post" onsubmit="return false;">
	<input type="text" name="txt1" id="txt1"/>
</form>
<c:choose>
	<c:when test="${ableToRunThread == false}">
		<input id="testingBtn" type="button" onclick="testing()" value="testing" disabled="disabled"/>
	</c:when>
	<c:otherwise>
		<input id="testingBtn" type="button" onclick="testing()" value="test Ready"/>
	</c:otherwise>
</c:choose>
</body>
</html>
```

<br/><br/>
