**컨테이너 인프라 환경 구축을 위한 쿠버네티스/도커**

<br/>

# 1. 새로운 인프라 환경이 온다
- IT만큼 빠르게 변화하는 분야가 없다. 엔지니어가 개발 환경을 만들어 제공하면 사용자(주로 개발자)는 그에 맞는 도구를 모두 설치해야 했던 온프레미스(on-premises) 환경은 이제 고전적인 인프라 환경이 됐다. 이제는 돈을 넣으면 자판기에서 미리 준비된 상품이 나오듯 이미 구성된 환경을 사용자가 필요에 따라 선택하고 조합해서 사용할 수 있게 제공되는 **서비스로서의 인프라 환경(IaaS, Infrastructure as a Service)** 이 됐다.

<br/>

- 인프라 환경이 빠르게 갖춰지는 만큼 소프트웨어도 빠르게 개발하고 적용되길 고대했다. 그래서 대두된 개발 방법론이 **애자일(agile)** 이다. 기존 개발 방법론인 폭포수(waterfall) 방법론은 계획 단계에서 설계와 환경을 완전히 구비한 후 예정된 목표를 달성해 나가지만, 애자일은 일정 주기를 정한 다음에 해당 주기에 맞춰 요구 사항을 만족하는 프로토타입을 만들고 이를 개선해 나가며 최종 목표에 점진적으로 접근한다.

<br/>

- 이런 애자일 방법론의 시대에 맞춰 인프라는 또 한 번 변화하고 있다. 사용자가 요구하는 인프라를 즉각 제공하는 주요 기능은 유지하면서, 사용자마다 독립적인 환경에서 개발해도 모두 동일한 결과를 얻을 수 있고 개발된 소프트웨어의 성능을 보장하며 인프라의 가용 리소스를 최대한 확보할 수 있는 그런 인프라 환경으로 말이다.

<br/><br/><br/><br/>

## 1.1 컨테이너 인프라 환경이란
- 컨테이너 인프라 환경은 컨테이너를 중심으로 구성된 인프라 환경이다. 여기서 **컨테이너(container)** 는 하나의 운영 체제 커널에서 다른 프로세스에 영향을 받지 않고 독립적으로 실행되는 프로세스 상태를 의미한다. 이렇게 구현된 컨테이너는 가상화 상태에서 동작하는 프로세스보다 가볍고 빠르게 동작한다.

<br/><br/>

### 1.1.1 모놀로식 아키텍처
- 모놀리식 아키텍처(monolithic architecture)는 하나의 큰 목적이 있는 서비스 또는 애플리케이션에 여러 기능이 통합돼 있는 구조를 의미한다. 모놀리식 아키텍처에서는 소프트웨어가 하나의 결합된 코드가 구성되기 때문에 초기 단계에서 설계하기 용이하며 개발이 좀 더 단순하고 코드 관리가 간편하다. 그러나 서비스를 운영하는 과정에서 수정이 많을 경우, 어떤 서비스에서 이뤄진 수정이 연관된 다른 서비스에 영향을 미칠 가능성이 커진다. 또한 서비스가 점점 성장해 기능이 추가될수록 처음에는 단순했던 서비스 간의 관계가 매우 복잡해질 수 있다.

<br/>

#### 모놀리식 아키텍처의 구성 예시
![image](https://user-images.githubusercontent.com/61584142/160961425-faa054df-ade3-4b18-a671-de9fd74b396b.png)

<br/>

- 그림처럼 뉴스, 카페, 웹툰, 결제 등의 서비스가 하나의 애플리케이션 안에 포함된 경우를 생각해보자. 보안이나 데이터베이스 접속과 같은 설정을 공통으로 사용하면서 서비스를 구현한다면 개발 속도는 매우 빠를 것이다. 하지만 웹툰 서비스의 사용량이 폭발적으로 증가해 서버를 증설해야 한다고 가정해 보자. IaaS 덕분에 사용량 증가에 따라 인프라를 증설하는 것은 어렵지 않다. 그렇지만 웹툰 서비스의 사용량이 늘었따고 해서 뉴스, 블로그 등의 다른 서비스가 포함된 애플리케이션까지 확장하는 것은 상당히 비효율적이다. 게다가 특정 서비스를 수정하는 과정에서 예기지 못한 에러가 발생한다면 해당 서비스 외에 전체 서비스를 이용할 수 없는 상황이 생길 수도 있다. 그래서 이러한 문제를 해결하는 방안으로 마이크로서비스 아키텍처가 등장했다.

<br/><br/>

### 1.1.2 마이크로서비스 아키텍처
- 마이크로서비스 아키텍처(MSA, Microservices Architecture)는 시스템 전체가 하나의 목적을 지향하는 바는 모놀리식 아키텍처와 동일하다. 하지만 개별 기능을 하는 작은 서비스를 각각 개발해 연결하는 데서 그 차이를 보인다. 보안, 인증 등과 관련된 기능이 독립된 서비스를 구성하고 있으며 다른 서비스들도 독립적으로 동작할 수 있는 완결된 구조이다.

<br/>

- 이런 구조는 개발된 서비스를 재사용하기 쉽고, 향후 서비스가 변경됐을 때 다른 서비스에 영향을 미칠 가능성이 줄어들며 사용량의 변화에 따라 특정 서비스만 확장할 수 있다. 따라서 사용자의 요구 사항에 따라 가용성을 즉각적으로 확보해야 하는 IaaS 환경에 적합하다. 하지만 마이크로서비스 아키텍처는 모놀리식 아키텍처보다 복잡도가 높으며 각 서비스가 서로 유기적으로 통신하는 구조로 설계되기 때문에 네트워크를 통한 호출 횟수가 증가해 성능에 영향을 줄 수 있다.

<br/>

#### 마이크로서비스 아키텍처의 구성 예시

![image](https://user-images.githubusercontent.com/61584142/160963444-e6747b83-159c-4de4-96a4-4a9e6fe429b6.png)

<br/>

- 하나의 애플리케이션 안에 포함돼 있던 뉴스, 블로그, 웹툰 서비스가 각 서비스와 관련된 기능과 데이터베이스를 독립적으로 가지는 구조로 표현됐다. 각 서비스는 API 게이트웨이와 REST(REpresentational State Transfer) API를 이용한 통신 방식으로 사용자(외부)의 요청을 전달한다. 서비스 개수는 고정된 것이 아니기 때문에 어떤 서비스가 등록돼 있는지 파악하기 위해 서비스 디스커버리를 사용한다. 또한 수많은 서비스의 내부 통신을 이벤트로 일원화하고 이를 효과적으로 관리하기 위해 별도로 이벤트 버스를 서비스로 구성한다.

<br/>

- 이런 구조 덕분에 각 서비스는 필요한 기능이 특화된 데이터베이스를 선택해 개별 서비스에 할당할 수 있다. 고객의 요구 사항에 따라 분석 서비스를 새로 추가해야 할 때도 기존에 있는 이벤트 버스에 바로 연결하며 되므로 매우 유연하게 대응할 수 있다. 각 서비스는 독립적으로 동작할 수 있는 완결된 구조라서 이미 개발된 기능이 다른 서비스에 필요하다면 바로 재사용할 수 있다.

<br/><br/>

### 1.1.3 컨테이너 인프라 환경에 적합한 아키텍처
- 그러면 컨테이너 인프라 환경에서는 어떤 아키텍처를 사용해야 좋을까? IT 세계에서는 대부분 정해진 답이 없다. 주어진 상황에 적합한 기술이 있을 뿐이다. 모놀리식 아키텍처로 구현을 시작했지만, 시스셈이 성장하고 기능이 늘어나면 마이크로서비스 아키텍처로 전환할 수도 있다.

<br/>

- 예전에는 기존 시스템을 확장하는 것은 시간과 비용이 많이 들어가는 복잡한 작업이자 변경된 시스템을 잘못 배포했을 때 전체 시스템 중단을 초래할 수 있는 위험한 작업이었다. 그러나 현재는 작은 단위로 빠르게 배포할 수 있으며 시스템 확장에 유연하게 대처할 수 있는 기반 기술이 충분히 마련돼 있다. 보통 중소기업에서 진행하는 소규모 프로젝트는 구현할 서비스 종류가 많지 않거나 규모가 크지 않아 모놀리식 아키텍처를 선호하는 경향이 있다. 하지만 소규모 프로젝트라도 마이크로서비스 아키텍처로 설계하면 기능에 집중한 안정적인 서비스를 구현할 수 있고 구현된 서비스를 재사용할 수 있으며, 해당 서비스를 다른 서비스와 연결해 구조화하기 때문에 장기적으로 볼 때 유지보수 측면에서 매우 유리하다.

<br/>

- 우리가 공부할 컨테이너 인프라 환경은 특히 마이크로서비스 아키텍처로 구현하기에 적합하다. 컨테이너 인프라 환경에서는 컨테이너를 서비스 단위로 포장해 손쉽게 배포하고 확장할 수 있다. 컨테이너 인프라 환경에서 제공하는 컨테이너는 마이크로서비스 아키텍처의 서비스와 1:1로 완벽하게 대응하며, 이후 소개할 도구들을 이용하면 도입, 설계, 운용 비용이 감소하고 생산성이 향상된다.

<br/>

#### 서비스와 1:1로 결합되는 컨테이너

![image](https://user-images.githubusercontent.com/61584142/160964050-3031867f-d54f-4329-95fa-428ae2507070.png)

<br/>

**그렇다면 컨테이너 인프라 환경을 지원하는 도구 중 현업에서 자주 사용하는 몇 가지를 간략하게 살펴보자.

<br/><br/><br/><br/>

## 1.2 컨테이너 인프라 환경을 지원하는 도구
- 컨테이너 인프라 환경은 크게 **컨테이너, 컨테이너 관리, 개발 환경 구성 및 배포 자동화, 모니터링** 으로 구성된다. 이를 지원하는 도구 가운데 업계에서 가장 많이 사용하는 도구 몇 가지를 알아보자.

<br/><br/>

### 1.2.1 도커
- 도커(Docker)는 컨테이너 환경에서 독립적으로 애플리케이션을 실행할 수 있도록 컨테이너를 만들고 관리하는 것을 도와주는 컨테이너 도구이다. 도커로 애플리케이션을 실행하면 운영체제 환경에 관계없이 독립적인 환경에서 일관된 결과를 보장한다. 컨테이너 도구는 도커외에도 컨테이너디(Containerd), 크라이오(CRI-O), 파드맨(Podman) 등이 있지만, 현업에서 가장 많이 사용하는 소프트웨어는 도커이다.

<br/><br/>

### 1.2.2 쿠버네티스
- 쿠버네티스(Kubernetes)는 다수의 컨테이너를 관리하는 데 사용한다. 컨테이너의 자동 배포와 배포된 컨테이너에 대한 동작 보증, 부하에 따른 동적 확장 등의 기능을 제공한다. 처음에는 다수의 컨테이너만 관리하는 도구였지만, 지금은 컨테이너 인프라 필요한 기능을 통합하고 관리하는 솔루션으로 발전했다. 쿠버네티스는 컨테이너 인프라를 기반으로 '1.1.2 마이크로 서비스 아키텍처'에서 설명한 API 게이트웨이, 서비스 디스커버리, 이벤트 버스, 인증 및 결제 등의 다양한 서비스를 효율적으로 관리할 수 있는 환경을 제공하고 이를 내외부와 유연하게 연결해 준다. 컨테이너 관리 도구는 도커 스웜(Docker Swarm), 메소스(Mesos), 노마드(Nomad) 등도 있지만, 오직 쿠버네티스만이 급격한 상승세를 보이고 있다.

<br/><br/>

### 1.2.3 젠킨스
- 젠킨스(Jenkins)는 지속적 통합(CI, Continuous Integrationg)과 지속적 배포(CD, Continuous Deployment)를 지원한다. 지속적 통합과 지속적 배포는 개발한 프로그램의 빌드, 테스트, 패키지화, 배포 단계를 모두 자동화해 개발 단계를 표준화한다. 아울러 개발된 코드의 빠른 적용과 효과적인 관리를 통해 개발 생산성을 높이는 데 초점이 맞춰져 있다. 즉 컨테이너 인프라 환경처럼 단일 기능을 빠르게 개발해 적용해야 하는 환경에 매우 적합한 도구이다. 지속적 통합과 배포를 위한 도구는 뱀부(Bamboo), 깃허브 액션(Github Action), 팀시티(Teamcity) 등도 있지만, 젠킨스가 가장 유명하고 대표적이다.

<br/><br/>

### 1.2.4 프로메테우스와 그라파나
- 프로메테우스(Prometheus)와 그라파나(Grafana)는 모니터링을 위한 도구이다. 프로메테우스는 상태 데이터를 수집하고, 그라파나는 프로메테우스로 수집한 데이터를 관리자가 보기 좋게 시각화한다. 컨테이너 인프라 환경에서는 많은 종류의 소규모 기능이 각각 나누어 개발되기 때문에 중앙 모니터링이 필요하다. 이때 효율적으로 모니터링하는 방법 중 하나가 프로메테우스와 그라파나의 조합이다. 프로메테우스와 그라파나는 컨테이너로 패키징돼 동작하며 최소한의 자원으로 쿠버네티스 클러스터의 상태를 시작적으로 표현한다.

<br/>

- 모니터링 데이터 수집 도구는 프로메테우스 외에도 데이터독(DataDog), 인플럭스DB(InfluxDB), 뉴 렐릭(New Relic) 등이 있지만, 오픈 소스를 활용하는 기업은 프로메테우스 외에 다른 선택지가 없을 정도로 가장 탁월한 효율을 자랑한다.

<br/>

- 데이터를 시각화하는 도구는 그라파나 외에도 키바나(Kibana), 크로노그래프(Chronograf) 등이 있으나 업계에서는 그라파나와 키바나가 시장을 양분한 상태이다. 하지만 키바나는 프로메테우스와 연결 구성이 복잡하므로 프로메테우스를 사용할 때는 간결하게 구성할 수 있는 그라파나를 더 선호한다.

<br/><br/><br/><br/>

## 1.3 새로운 인프라 환경의 시작
- 소규모로 빠르게 각 기능을 개발하는 마이크로서비스 아키텍처의 의미와 이를 효과적으로 지원하는 컨테이너 인프라 환경이 어떤 것인지 살펴봤다. 그리고 컨테이너 인프라 환경을 지원하는 도커, 쿠버네티스, 젠킨스, 프로메테우스, 그라파나 등의 도구도 소개했다.

<br/>

![image](https://user-images.githubusercontent.com/61584142/160972055-88661ab4-a0c1-4b21-a5a7-d55f32362c1a.png)

---

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

---

# 2. 테스트 환경 구성하기
- 먼저 2장에서는 가상 환경을 구성하는 데 사용하는 도구를 살펴본 다음, 직접 가상 환경을 구축해보자. 이떄 일관성 있는 결과를 얻으려면 프로젝트 환경이 가능한 한 일정하게 생성되고 유지돼야 한다. 그래서 여기서는 코드형 인프라로 인프라 환경을 일정하게 유지하고 구성한다. 코드형 인프라(IaC, Infrastructure as Code)란 쉽게 말해 코드로 하드웨어를 설정하고, 운영 체제를 설치하고, 네트워크를 구성하고, 개발 환경을 구축하는 것이다. 즉, 코드로 인프라를 소프트웨어처럼 다룰 수 있다.

<br/>

- 이렇게 설치된 환경은 사용자가 모두 동일한 환경에서 테스트할 수 있고, 문제가 발생했을 때 몇 번의 명령 실행만으로 환경을 다시 새것처럼 구성할 수 있다는 장점이 있다.

![image](https://user-images.githubusercontent.com/61584142/160975026-e5ae46c7-82a4-43bc-8049-8fea5357ebf1.png)

<br/><br/><br/><br/>

## 2.1 테스트 환경을 자동으로 구성하는 도구
- 코드로 인프라를 생성할 수 있게 지원하는 소프트웨어는 여러 개이지만, 교육용 및 소규모 환경에서는 베이그런트(Vagrant)가 가장 배우기 쉽고 사용 방법도 간단하다. 베이그런트는 가상화 소프트웨어인 버추얼박스(VirtualBox)와도 호환성이 매우 좋다.

<br/><br/>

### 2.1.1 버추얼박스 설치하기
- 버추얼박스는 이노테크(InnoTek)에서 개발한 가상화 소프트웨어로 오라클에서 배포한다. 버추얼박스는 현존하는 대부분의 운영 체제를 게스트 운영 체제로 사용할 수 있으며, 확장팩을 제외하면 아무런 제한 없이 소프트웨어의 모든 기능을 무료로 이용할 수 있다. 또한 다른 가상화 소프트웨어보다 기능이 강력하고 안정적이다.

<br/>

1. 웹 브라우저를 열고 버추얼박스 다운로드 페이지(https://www.virtualbox.org/wiki/Downloads)에 접속한다. 사용하는 운영 체제에 맞는 버전을 내려받는다.
2. 윈도용 버추얼박스 설치 파일에는 설치 마법사가 포함돼 있어 쉽게 설치할 수 있다. 내려받은 버추얼박스 설치 파일을 찾아 실행하고 설치 환영 메시지가 나오면 Next 버튼을 클릭한다.
3. 설치 경로를 포함한 여러 옵션이 나온다. 기본으로 설치하는 것이 가장 무난하므로 기본 상태 그대로 두고 Next 버튼을 클릭한다.
4. 버추얼박스를 바탕 화면에서 바로 실행할 수 있는 바로가기 아이콘을 만드는 화면이 나온다. 기본 옵션으로 진행하므로 마찬가지로 Next 버튼을 클릭한다.
5. 버추얼박스에서 사용할 네트워크 인터페이스를 위해 잠시 네트워크가 중단된다는 경고문이 뜬다. 다른 중요한 파일을 내려받고 있지 않다면 신경 쓰지 말고 Yes 버튼을 클릭한다.
6. 이제 설치할 준비가 다 됐으니 Install 버튼을 클릭한다. 시스템에 따라 설치 허용 여부를 묻는 경우가 있는데, 이런 경우 예 버튼을 클릭한다. 설치 도중에 시스템에 따라 추가 드라이버가 설치될 수도 있다.
7. 설치가 완료되면 화면에 체크 상태를 그대로 두고 Finish 버튼을 클릭해 설치 프로그램을 종료하고 버추얼박스를 실행한다.
8. 실행된 버추얼박스는 어떤 가상 머신도 없이 깨끗한 상태이다. 이제 베이그런트로 가상 머신을 생성해 보자.

<br/><br/>

### 2.1.2 베이그런트 설치하기
- 베이그런트는 사용자의 요구에 맞게 시스템 자원을 할당, 배치, 배포해 두었다가 필요할 때 시스템을 사용할 수 있는 상태로 만들어 준다. 이를 프로비저닝(provisioning)이라고 하는데, 프로비저닝을 하면 필요할 때 환경을 매우 쉽고 간단하게 구현할 수 있다. 베이그런트를 설치하는 방법은 다음과 같다.

<br/>

1. 웹 브라우저를 열고 베이그런트 다운로드 페이지(https://www.vagrantup.com/downloads.html)에 접속한다. 사용자 환경에 따라 자동으로 다운로드 페이지가 설정되므로 각자의 운영 체제에 맞는 설치 파일이 표시된다. 바로 내려받기(Download) 버튼을 눌러 베이그런트 설치 파일을 내려받는다. 윈도용 베이그런트 설치 파일에는 설치 마법사가 포함돼 있어 쉽게 설치할 수 있다.
2. 내려받은 베이그런트 설치 파일을 찾아 실행하고 설치 환영 메시지가 나오면 Next 버튼을 클릭한다.
3. 라이선스 동의에 체크하고, Next 버튼을 클릭한다.
4. 베이그런트의 설치 경로가 나온다. Change... 버튼을 눌러 원하는 폴더로 변경할 수 있지만, 여기서는 기본 설정 값 그대로 설치하므로 Next 버튼을 클릭한다.
5. 설치할 준비가 끝났으니 Install 버튼을 클릭해 설치를 시작한다. 시스템에 따라 설치 허용 여부를 묻는 경우가 있는데, 이런 경우 예 버튼을 클릭한다.
6. 설치가 완료되면 Finish 버튼을 클릭해 설치 프로그램을 종료한다.
7. 팝업 창이 뜨면 Yes 버튼을 눌러 시스템을 다시 시작해 변경 사항을 적용한다.

<br/><br/>

### 2.1.3 베이그런트 구성하고 테스트하기
- 테스트 환경을 구성하기 전에 설치된 도구가 정상적으로 작동하는지 확인해 본다. 먼저 프로비저닝을 위한 코드를 작성하고, 이를 베이그런트에서 불러온 후 버추얼박스에 운영체제를 설치한다.

<br/>

- 베이그런트의 프로비저닝 코드를 개인이 원하는 위치에 구현해 사용할 수 있으나 실습할 때 혼동하지 않도록 베이그런트 설치 디렉터리(C:\HashiCorp)에 프로비저닝에 필요한 모든 코드를 작성한다.

<br/>

1. 명령 프롬프트를 실행하고 베이그런트 설치 디렉터리로 이동한다. vagrant init(베이그런트 초기화) 명령을 실행해 프로비저닝에 필요한 기본 코드를 생성한다.
2. 베이그런트 초기화 명령으로 생성된 c:\HashiCorp 폴더의 Vagrantfile(베이그런트 스크립트 파일)을 에디터 프로그램(메모장 같은 문서 에디터, notepad++, VS Code 같은 코드 에디터 등 아무거나 상관없다)으로 열고 파일에서 config.vm.box = "base"라는 내용이 있는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/160975916-3f300a37-b85a-418a-bd90-3a6a3c077c75.png)

3. 아무것도 변경하지 않은 채 파일을 닫고 명령 프롬프트에서 vagrant up을 바로 실행한다. 그러면 다음과 같은 에러가 발생한다. 설치하려는 이미지가 'base'로 명시돼 있으나 베이그런트가 해당 이미지를 찾지 못해 발생하는 에러이다.
4. 에러가 발생하지 않게 설치할 운영 체제 이미지를 선택해 보자. 먼저 사용할 가상 머신의 이미지를 선택하고 필요에 맞게 이미지를 수정하는 과정이 필요한데, 이 과정이 복잡하고 험난하다. 가상 이미지는 베이그런트 클라우드(https://app.vagrantup.com/boxes/search)에 접속해 내려받는다. 검색창에 sysnet4admin을 입력하면 올려 둔 파일들이 보인다. 이 가운데 sysnet4admin/CentOS-k8s를 확인한다. 참고로 CetnOS-k8s에는 쿠버네티스 실습에 필요한 설정 변경 사항이 포함돼 있다. 자세한 내용은 https://app.vagrantup.com/sysnet4admin/boxes/CentOS-k8s를 참고한다.

![image](https://user-images.githubusercontent.com/61584142/160976057-e5294264-f040-4476-b93c-0198bd4d5f91.png)

5. 앞에서 확인한 Vagrantfile을 다시 열어 config.vm.box = "base"를 config.vm.box = "sysnet4admin/ CentOS-k8s"로 변경하고 저장한다.

![image](https://user-images.githubusercontent.com/61584142/160976093-cce3699b-c58d-403c-ac0e-fe8e9c785e3d.png)

6. 다시 한 번 vagrant up을 실행하고 해당 가상 머신 이미지를 내려받는지 확인한다.
7. 설치가 끝나면 버추얼박스를 실행해 가상 머신이 제대로 생성됐는지 확인한다.
8. 명령 프롬프트로 돌아와 vagrant ssh 명령을 실행해 설치된 CentOS에 접속한다.
9. 설치가 정상적으로 이루어졌는지 CentOS의 실행 시간(uptime)과 운영 체제의 종류(cat /etc/redhat-release)를 확인한다.
10. CentOS가 베이그런트로 버추얼박스에 아주 간단하게 설치됐다. 설치 테스트를 해봤으니 본격적으로 실습하기 위해 설치한 가상 머신을 삭제한다. 먼저 접속한 가상 머신을 exit로 빠져나온 다음 명령 프롬프트에서 vagrant destroy- f를 실행한다. 설치된 가상 머신이 삭제되는데, 여기서 -f는 가상 머신을 강제 종료하는 옵션이다.

<br/>

#### 자주 사용하는 베이그런트 명령
![image](https://user-images.githubusercontent.com/61584142/160975862-cc1c7e1f-f601-48f2-92af-e30dbae4ac88.png)

<br/><br/><br/><br/>

## 2.2 베이그런트로 테스트 환경 구축하기
- 베이그런트로 버추얼박스에 가상 머신을 설치하는 방법을 알아봤다. 이번에는 Vagrantfile을 수정해 원하는 구성이 자동으로 CentOS에 입력되도록 해 보자.

<br/><br/>

### 2.2.1 가상 머신에 필요한 설정 자동으로 구성하기
- 앞에서는 Vagrantfile에 기존에 있던 이미지 파일을 추가해 가상 머신을 생성했다. 이번에는 원하는 구성을 자동으로 생성할 수 있도록 Vagrantfile을 새롭게 작성해 보자. 베이그런트 코드는 루비(Ruby)라는 언어로 작성한다.

<br/>

#### 베이그런트로 구성되는 테스트 환경 구성도
![image](https://user-images.githubusercontent.com/61584142/160977465-2eaf5859-cefa-4cf7-87af-24fd9e9bc401.png)

<br/>

#### 코드 입력
- 앞에서 열어본 Vagrantfile을 다음과 같은 내용으로 수정한 후 저장한다.
<pre><code># -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|
  config.vm.define "m-k8s" do |cfg|
    cfg.vm.box = "sysnet4admin/CentOS-k8s"
    cfg.vm.provider "virtualbox" do |vb|
      vb.name = "m-k8s(github_SysNet4Admin)"
      vb.cpus = 2
      vb.memory = 2048
      vb.customize ["modifyvm", :id, "--groups", "/k8s-SM(github_SysNet4Admin)"]
    end
    cfg.vm.host_name = "m-k8s"
    cfg.vm.network "private_network", ip: "192.168.1.10"
    cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true, id: "ssh"
    cfg.vm.synced_folder "../data", "/vagrant", disabled: true
  end
end</code></pre>

```
• 1~2번째 줄: 에디터에 현재 파일이 루비(ruby)임을 인식하게 하는 호환 코드입니다. 
여기서 ft는 파일 종류(file type)의 약자이며, 해당 내용은 실행에 아무런 영향을 미치지 않습니다.

• 3번째 줄: "2"는 베이그런트에서 루비로 코드를 읽어 들여 실행할 때 작동하는 API 버전이고, 
뒤의 do |config|는 베이그런트 설정의 시작을 알립니다.

• 4번째 줄: 버추얼박스에서 보이는 가상 머신을 "m-k8s"로 정의하고, do|cfg|를 추가해 원하는 설정으로 변경합니다. 
이렇게 do |이름|으로 시작한 작업은 end로 종료합니다.

• 5번째 줄: 기본값 config.vm.box를 do |cfg|에 적용한 내용을 받아 cfg.vm.box로 변경합니다.

• 6번째 줄: 베이그런트의 프로바이더(provider)가 버추얼박스라는 것을 정의합니다. 
프로바이더는 베이그런트를 통해 제공되는 코드가 실제로 가상 머신으로 배포되게 하는 소트프웨어입니다. 
버추얼박스가 여기에 해당합니다. 다음으로 버추얼박스에서 필요한 설정을 정의하는데, 그 시작을 do |vb|로 선언합니다.

• 7~11번째 줄: 버추얼박스에 생성한 가상 머신의 이름, CPU 수, 메모리 크기, 소속된 그룹을 명시합니다. 
그리고 마지막으로 end를 적어 버추얼박스 설정이 끝났음을 알립니다.

• 12번째 줄: 여기부터는 가상 머신 자체에 대한 설정으로, do |cfg|에 속한 작업입니다. 
12번째 줄은 호스트의 이름(m-k8s)을 설정합니다.

• 13번째 줄: 호스트 전용 네트워크를 private_network로 설정해 
eth1 인터페이스를 호스트 전용(Host-Only)으로 구성하고 IP는 192.168.1.10으로 지정합니다.2

• 14번째 줄: ssh 통신은 호스트 60010번을 게스트 22번으로 전달되도록 구성합니다. 
이때 혹시 모를 포트 중복을 대비해 auto_correct: true로 설정해서 포트가 중복되면 포트가 자동으로 변경되도록 합니다.

• 15번째 줄: 호스트(PC 또는 노트북)와 게스트(가상 머신) 사이에 디렉터리 동기화가 이뤄지지 않게 설정(disabled: true)합니다.

• 16~17번째 줄: 설정 작업(do |config|, do |cfg|)이 종료됐음을 end 구문으로 명시합니다. 
이때 do와 end의 들여쓰기(indentation) 위치가 정확하게 일치해야 합니다.

+
호스트 전용 네트워크는 호스트 내부에 192.168.1.0대의 사설망을 구성합니다. 
가상 머신은 NAT(Network Address Translation, 네트워크 주소 변환) 인터페이스인 eth0를 통해서 인터넷에 접속합니다.
```

<br/>

+

```
베이그런트에서는 ssh 서비스의 기본 포트 번호인 22번을 id: "ssh"로 설정하지 않으면 다음과 같이 중복된 두 개의 포트로 설정합니다. 
자기 자신(127.0.0.1/localhost)의 2222번 포트로 오는 내용과 모든 IP(0.0.0.0)의 60010 포트에서 오는 내용을 게스트의 22번으로 포워딩합니다. 
기능적으로는 큰 문제를 일으키지 않으나 명시적으로는 좋지 않습니다.

c:\HashiCorp>vagrant port
    22 (guest) => 2222 (host)
    22 (guest) => 60010 (host)

c:\HashiCorp>netstat -an | findstr 2222
  TCP     127.0.0.1:2222     0.0.0.0:0     LISTENING

c:\HashiCorp>netstat -an | findstr 60010
  TCP     0.0.0.0:60010      0.0.0.0:0     LISTENING
```

```
따라서 이와 같은 설정의 낭비를 줄이고자 id: "ssh"로 설정해 다음과 같이 하나의 포트만 사용합니다. 참고로 vagrant port는 베이그런트에서 사용하는 포트를 확인하는 명령입니다.

c:\HashiCorp>vagrant port
    22 (guest) => 60010 (host)

c:\HashiCorp>netstat -an | findstr 60010
  TCP     0.0.0.0:60010     0.0.0.0:0     LISTENING
```

<br/><br/>

#### 코드 실행
- 앞에서 작성한 Vagrantfile로 가상 머신을 생성해 보자.

<br/>

1. 명령 프롬프트에서 vagrant up 명령을 다시 실행한다.
```
c:\HashiCorp>vagrant up
Bringing machine 'm-k8s' up with 'virtualbox' provider...
==> m-k8s: Importing base box 'sysnet4admin/CentOS-k8s'...
==> m-k8s: Matching MAC address for NAT networking...
==> m-k8s: Checking if box 'sysnet4admin/CentOS-k8s' version '0.7.0' is up to date...
==> m-k8s: Setting the name of the VM: m-k8s(github_SysNet4Admin)
==> m-k8s: Clearing any previously set network interfaces...
==> m-k8s: Preparing network interfaces based on configuration...
    m-k8s: Adapter 1: nat
    m-k8s: Adapter 2: hostonly
==> m-k8s: Forwarding ports...
    m-k8s: 22 (guest) => 60010 (host) (adapter 1)
[생략]
```

<br/>

2. vagrant up 실행이 끝나면 vagrant ssh 명령을 실행해 생성된 가상 머신(CentOS)에 접속한다.
```
c:\HashiCorp>vagrant ssh
[vagrant@m-k8s ~]$
```

<br/>

3. CentOS에서 ip addr show eth1 명령을 입력해 IP(192.168.1.10)가 제대로 설정됐는지 확인한다.
```
[vagrant@m-k8s ~]$ ip addr show eth1
3: eth1: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP group default qlen 1000
    link/ether 08:00:27:08:4b:e9 brd ff:ff:ff:ff:ff:ff
    inet 192.168.1.10/24 brd 192.168.1.255 scope global noprefixroute eth1
        valid_lft forever preferred_lft forever
```

<br/>

4. exit 명령을 실행해 CentOS 접속을 종료한다.
```
[vagrant@m-k8s ~]$ exit
logout
Connection to 127.0.0.1 closed.
```

<br/>

#### 호스트 전용 네트워크가 정상적으로 작동하지 않는 경우
- 처음 사용했을 때는 문제가 발생하지 않지만, 최대 절전 모드나 여러 차례 가상 머신을 다시 시작할 때 호스트 전용 네트워크가 정상적으로 작동하지 않는다면 호스트 전용 네트워크에 설정된 어댑터 IP를 192.168.1.1로 지정해 해결할 수 있다.

<br/>

1. 버추얼박스에서 파일 > 호스트 네트워크 관리자를 선택한다(단축키 Ctrl+H)

![image](https://user-images.githubusercontent.com/61584142/161176675-09862658-ec7b-4cf9-bf23-5ffc3a98c3f4.png)

<br/>

2. 창이 나타나면 속성을 클릭하고 DHCP 서버를 사용하지 않도록 체크를 해제하고, IPv4 주소에 192.168.1.1을 입력한다.

![image](https://user-images.githubusercontent.com/61584142/161176704-f24d7c57-8010-47d0-9d81-4285a2cc2f5f.png)

<br/><br/>

### 2.2.2 가상 머신에 추가 패키지 설치하기
- 2.2.1에서 필요한 내용이 설정된 Vagrantfile을 통해 CentOS에 호스트네임, IP 등을 자동으로 설정해봤다.
- 이번에는 CentOS에 필요한 패키지를 설치하는 방법을 알아보자.

<br/>

#### 코드입력
- Vagrantfile에 셸 프로비전을 추가한다.
```
# -*- mode: ruby -*-
# vi: set ft=ruby :
Vagrant.configure("2") do |config|
  config.vm.define "m-k8s" do |cfg|
    cfg.vm.box = "sysnet4admin/CentOS-k8s"
    cfg.vm.provider "virtualbox" do |vb|
      vb.name = "m-k8s(github_SysNet4Admin)"
      vb.cpus = 2
      vb.memory = 2048
      vb.customize ["modifyvm", :id, "--groups", "/k8s-SM(github_SysNet4Admin)"]
    end
    cfg.vm.host_name = "m-k8s"
    cfg.vm.network "private_network", ip: "192.168.1.10"
    cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true, id: "ssh"
    cfg.vm.synced_folder "../data", "/vagrant", disabled: true
    cfg.vm.provision "shell", path: "install_pkg.sh" #add provisioning script
  end
end
```

```
• 16번째 줄: vm.provision "shell" 구문으로 경로(path)에 있는 install_pkg.sh를 게스트(CentOS) 내부에서 호출해 실행되도록 한다.
```

<br/>

- Vagrantfile이 위치한 디렉터리에서 추가 패키지를 설치하기 위한 스크립트를 다음과 같이 작성하고 install_pkg.sh라는 이름으로 저장한다.
<pre><code>#!/usr/bin/env bash
# install packages
yum install epel-release -y
yum install vim-enhanced -y</code></pre>

- Vagrantfile에서 호출한 install_pkg.sh로 입력해 둔 배시 셸 파일을 실행해 EPEL(Extra Package for Enterprise Linux) 저장소와 코드 하이라이트를 위한 Vim의 추가 기능을 설치한다.

<br/>

#### 코드 실행
- 앞에서 수정한 Vagrantfile로 추가 패키지를 설치해 보자.

<br/>

1. 명령 프롬프트에서 vagrant provision 명령으로 추가한 프로비전 구문을 실행한다.
```
c:\HashiCorp>vagrant provision
==> m-k8s: Running provisioner: shell...
    m-k8s: Running: C:/Users/HOONJO~1/AppData/Local/Temp/vagrant-shell20191003-23188-14wl2fv.sh
    m-k8s: Loaded plugins: fastestmirror
    m-k8s: Loading mirror speeds from cached hostfile
    m-k8s: * base: mirror.kakao.com
    m-k8s: * extras: mirror.kakao.com
    m-k8s: * updates: mirror.navercorp.com
    m-k8s: Resolving Dependencies
    m-k8s: --> Running transaction check
    m-k8s: ---> Package epel-release.noarch 0:7-11 will be installed
    m-k8s: --> Finished Dependency Resolution
[생략]
```

<br/>

2. vagrant ssh 명령을 실행해 CentOS에 접속한다.
```
c:\HashiCorp>vagrant ssh
[vagrant@m-k8s ~]$
```

<br/>

3. yum repolist 명령으로 추가한 EPEL 저장소가 구성됐는지 확인한다.
```
[vagrant@m-k8s ~]$ yum repolist
Loaded plugins: fastestmirror
Determining fastest mirrors
* base: mirror.navercorp.com
* epel: ftp.jaist.ac.jp
* extras: mirror.navercorp.com
* updates: mirror.navercorp.com
repo id                      repo name status
base/7/x86_64                CentOS-7 - Base 10,070
epel/x86_64                  Extra Packages for Enterprise Linux 7 - x86_64 13,425
extras/7/x86_64              CentOS-7 - Extras 41
updates/7/x86_64             CentOS-7 - Updates 945
repolist: 24,852
```

<br/>

4. vi .bashrc를 실행해 문법 하이라이트가 적용됐는지 확인한다.
```
[vagrant@m-k8s ~]$ vi .bashrc
# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
        . /etc/bashrc
fi

# Uncomment the following line if you don't like systemctl's auto-paging feature:
# export SYSTEMD_PAGER=

# User specific aliases and functions
~
~
~
```

<br/>

5. vi로 문법 하이라이트가 적용된 것을 확인했다면 :q를 눌러서 vi 프로그램을 종료하고, exit 명령으로 가상 머신에서 빠져나온다. 그 다음 vagrant destroy -f 명령으로 베이그런트를 사용해 생성한 가상 머신을 삭제한다.
```
[vagrant@m-k8s ~]$ exit
logout
Connection to 127.0.0.1 closed.
c:\HashiCorp>vagrant destroy -f
==> m-k8s: Forcing shutdown of VM...
==> m-k8s: Destroying VM and associated drives...
```

<br/>

#### vi와 Vim
- Vim의 추가 기능을 설치한다고 했는데 vi(visual editor) 에디터를 사용해서 의문이 들 수도 있다. 대부분 리눅스는 vi를 호출하면 내부적으로 Vim(Vi Improved, 향상된 vi)이 실행되기 때문에 vi를 호출해 사용했다. 하지만 여전히 일부 리눅스와 유닉스에서는 vi만 설치돼 있는 경우가 있다.
- vi와 Vim의 다른 점은 많지만, 가장 큰 차이점은 '에디터에서 커서의 이동이 화살표로 되는가 아닌가'이다. Vim은 화살표로 커서가 이동하지만, 순수하게 vi만 설치돼 있다면  H(⇦) J(⇩) K(⇧) L(⇨)로 커서를 이동할 수 있다.

<br/><br/>

### 2.2.3 가상 머신 추가로 구성하기
- 베이그런트로 운영 체제를 자동으로 설치하고 구성하면 편리하다. 하지만 단순히 운영 체제 1개를 구성하려고 베이그런트를 사용하지는 않는다. 그래서 이번에는 기존에 설치한 가상 머신 외에 가상 머신 3대를 추가로 설치한다. 그리고 기존의 가상 머신과 추가한 가상 머신 간에 네트워크 통신이 원할하게 작동하는지 확인해 보자.

<br/>

#### CentOS 3대를 추가로 구성한 테스트 환경
![image](https://user-images.githubusercontent.com/61584142/161177476-b8c71ffb-4e23-4010-9cd9-c08658ceca68.png)

<br/><br/>

#### 코드 입력
- Vagrantfile에 CentOS 3대와 네트워크 구성을 테스트할 파일을 추가한다.
```
# -*- mode: ruby -*-
# vi: set ft=ruby :
 
Vagrant.configure("2") do |config|
  config.vm.define "m-k8s" do |cfg|
    cfg.vm.box = "sysnet4admin/CentOS-k8s"
    cfg.vm.provider "virtualbox" do |vb|
      vb.name = "m-k8s(github_SysNet4Admin)"
      vb.cpus = 2
      vb.memory = 2048
      vb.customize ["modifyvm", :id, "--groups", "/k8s-SM(github_SysNet4Admin)"]
    end
    cfg.vm.host_name = "m-k8s"
    cfg.vm.network "private_network", ip: "192.168.1.10"
    cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true, id: "ssh"
    cfg.vm.synced_folder "../data", "/vagrant", disabled: true
    cfg.vm.provision "shell", path: "install_pkg.sh"
    cfg.vm.provision "file", source: "ping_2_nds.sh", destination: "ping_2_nds.sh"
    cfg.vm.provision "shell", path: "config.sh"
  end
 
  #=============#
  # Added Nodes #
  #=============#
 
  (1..3).each do |i| # 1부터 3까지 3개의 인자를 반복해 i로 입력
    config.vm.define "w#{i}-k8s" do |cfg| # {i} 값이 1, 2, 3으로 차례대로 치환됨
      cfg.vm.box = "sysnet4admin/CentOS-k8s"
      cfg.vm.provider "virtualbox" do |vb|
        vb.name = "w#{i}-k8s(github_SysNet4Admin)" # {i} 값이 1, 2, 3으로 차례대로 치환됨
        vb.cpus = 1
        vb.memory = 1024 # 메모리를 1GB 사용하도록 변경
        vb.customize ["modifyvm", :id, "--groups", "/k8s-SM(github_SysNet4Admin)"]
      end
      cfg.vm.host_name = "w#{i}-k8s" # {i} 값이 1, 2, 3으로 차례대로 치환됨
      cfg.vm.network "private_network", ip: "192.168.1.10#{i}" # {i} 값이 1, 2, 3으로 차례대로 치환됨
      cfg.vm.network "forwarded_port", guest: 22, host: "6010#{i}",auto_correct: true, id: "ssh" # {i} 값이 1, 2, 3으로 차례대로 치환됨
      cfg.vm.synced_folder "../data", "/vagrant", disabled: true
      cfg.vm.provision "shell", path: "install_pkg.sh"
    end
  end
end
```
```
• 18번째 줄: 파일을 게스트 운영 체제에 전달하기 위해 "shell"이 아닌 "file" 구문으로 변경합니다. 이렇게 하면 호스트에 있는 ping_2_nds.sh 파일을 게스트의 홈 디렉터리(/home/vagrant)로 전달합니다.

• 19번째 줄: config.sh를 게스트에서 실행합니다.

• 26~37번째 줄: 추가한 3대의 CentOS에 대한 구성입니다. 거의 모든 내용이 기존에 CentOS와 동일하나, 3대를 효율적으로 구성하기 위해 반복문을 사용합니다. 반복은 (1..3).each로 이루어지며, 해당 값은 |i|를 통해 #{i}로 치환돼 사용됩니다.
```

<br/>

- 이전처럼 추가 패키지를 설치하는 스크립트를 작성한다.(install_pkg.sh)
```
#!/usr/bin/env bash
# install packages
yum install epel-release -y
yum install vim-enhanced -y
```

<br/>

- ping 테스트 파일을 작성한다.(ping_2_nds.sh)
```
# ping 3 times per nodes
ping 192.168.1.101 -c 3
ping 192.168.1.102 -c 3
ping 192.168.1.103 -c 3
```
- 추가로 설치한 CentOS 3대로 ping을 보내 네트워크가 제대로 작동하는지 확인하는 명령이다.
- -c 옵션은 몇 번의 ping을 보낼 것인지 지정한다.

<br/>

- 이번엔 설정을 변경하는 스크립트를 작성한다.(config.sh)
```
#!/usr/bin/env bash
# modify permission
chmod 744 ./ping_2_nds.sh
```
- ping 테스트 파일(ping_2_nds.sh)이 업로드되고 난 후에 실행할 수 있도록 권한을 744로 준다.

<br/>

#### 파일 권한 744의 의미

![image](https://user-images.githubusercontent.com/61584142/161177745-b575e974-19bd-4337-9237-725f148c1e69.png)

<br/><br/>

#### 코드 실행
- 4대의 가상 머신을 구성해 보자. 앞에 작성한 파일들을 Vagrantfile과 같은 위치에 저장한다.

<br/>

1. vagrant up을 실행해 총 4대의 CentOS를 설치하고 구성한다.
```
c:\HashiCorp>vagrant up
Bringing machine 'm-k8s' up with 'virtualbox' provider...
Bringing machine 'w1-k8s' up with 'virtualbox' provider...
Bringing machine 'w2-k8s' up with 'virtualbox' provider...
Bringing machine 'w3-k8s' up with 'virtualbox' provider...
==> m-k8s: Importing base box 'sysnet4admin/CentOS-k8s'...
==> m-k8s: Matching MAC address for NAT networking...
[생략]
```

<br/>

2. vagrant ssh 명령으로 설치된 CentOS에 접속한다. 설치된 가상 머신이 여러 대라서 접속할 가상 머신의 이름을 입력해야 한다는 메시지가 출력된다.
```
c:\HashiCorp>vagrant ssh
This command requires a specific VM name to target in a multi-VM environment.
```

<br/>

3. vagrant ssh m-k8s를 입력한다. m-ks는 가장 먼저 설치된 가상 머신의 이름이다.
```
c:\HashiCorp>vagrant ssh m-k8s
[vagrant@m-k8s ~]$
```

<br/>

4. 업로드된 ping_2_nds.sh 파일을 실행해 3대의 CentOS(192.168.101~103)와 통신하는 데 문제가 없는지 확인한다.
```
[vagrant@m-k8s ~]$ ./ping_2_nds.sh
PING 192.168.1.101 (192.168.1.101) 56(84) bytes of data.
64 bytes from 192.168.1.101: icmp_seq=1 ttl=64 time=0.750 ms
64 bytes from 192.168.1.101: icmp_seq=2 ttl=64 time=0.606 ms
64 bytes from 192.168.1.101: icmp_seq=3 ttl=64 time=0.770 ms

--- 192.168.1.101 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2008ms
rtt min/avg/max/mdev = 0.606/0.708/0.770/0.079 ms
PING 192.168.1.102 (192.168.1.102) 56(84) bytes of data.
64 bytes from 192.168.1.102: icmp_seq=1 ttl=64 time=4.42 ms
64 bytes from 192.168.1.102: icmp_seq=2 ttl=64 time=0.792 ms
64 bytes from 192.168.1.102: icmp_seq=3 ttl=64 time=0.812 ms

--- 192.168.1.102 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2001ms
rtt min/avg/max/mdev = 0.792/2.008/4.422/1.707 ms
PING 192.168.1.103 (192.168.1.103) 56(84) bytes of data.
64 bytes from 192.168.1.103: icmp_seq=1 ttl=64 time=3.64 ms
64 bytes from 192.168.1.103: icmp_seq=2 ttl=64 time=0.684 ms
64 bytes from 192.168.1.103: icmp_seq=3 ttl=64 time=0.834 ms

--- 192.168.1.103 ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2004ms
rtt min/avg/max/mdev = 0.684/1.720/3.643/1.361 ms
```

<br/>

5. 4대 모두 이상 없음이 확인됐으니 exit 명령으로 가상 머신 접속을 종료한다.
```
[vagrant@m-k8s ~]$ exit
logout
```

<br/><br/><br/><br/>

## 2.3 터미널 프로그램으로 가상 머신 접속하기
- 윈도우의 명령 프롬프트로 가상 머신에 접근(vagrant ssh `가상 머신 이름`)할 수 있지만, 이미 확인한 것처럼 여러 개의 가상 머신에 접근할 때는 유용한 방법이 아니다. 그래서 여기서는 여러 대의 가상 머신에 한번에 접속하도록 구성해 보자.

<br/><br/>

### 2.3.1 Putty 설치하기
- 터미널 접속 프로그램 중에서 가장 많이 사용하는 것이 푸티(PuTTY)이다. 푸티는 가볍고 무료이며 다양한 플러그인을 통해 여러 대의 가상 머신에 접근할 수 있다. 이뿐만 아니라 접속 정보를 저장하고 바로 불러와 실행할 수 있는 기능이 있다. 여기서는 푸티로 가상머신에 접근하도록 설정해 보자.

<br/>

1. 먼저 푸티 실행 파일을 저장할 디렉터리(C:\putty)를 생성한다.
```
c:\HashiCorp>mkdir C:\putty
```

<br/>

2. 웹 브라우저에서 푸티 다운로드 페이지(https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html)에 접속한다. Alternative binary files 항목에서 운영 체제 및 버전에 맞는 putty.exe 실행 파일을 C:\putty 디렉터리에 내려받는다.

![image](https://user-images.githubusercontent.com/61584142/161178502-c1f5cb02-fb6e-442a-adde-0c3731a7bca1.png)

<br/>

3. 내려받은 putty.exe 파일을 실행해 정상적으로 구동하는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161178522-09903af6-4e79-4d9f-9804-175e21bcee1f.png)

<br/>

- 푸티로 여러 대 가상 머신에 접근할 수 있지만, 한 번에 한 대씩만 접근할 수 있다. 우리가 원하는 것은 한 번에 여러 대의 가상 머신에 접근해서 관리하는 것이므로 추가 프로그램을 설치한다.

<br/><br/>

### 2.3.2 슈퍼푸티 설치하기
- 푸티를 단독으로 사용하면 창을 여러 개 띄워야 해서 명령을 내리기가 매우 번거롭다. 슈퍼푸티(SuperPuTTY)를 사용하면 푸티의 이런 제약 사항이 해결된다.

<br/>

1. 웹 브라우저에서 슈퍼푸티를 제공하는 깃허브 페이지(https://github.com/jimradford/superputty/releases)에 접속해 화면에 보이는 최신 버전 파일을 내려받는다.

![image](https://user-images.githubusercontent.com/61584142/161178619-97c9eda9-b723-40a4-9e32-918ad55377e9.png)

<br/>

2. 내려받은 SuperPuttySetup-1.4.0.9.msi를 실행하고 설치 환영 메시지가 나오면 Next 버튼을 클릭한다.
3. 라이선스 동의에 체크하고, Next 버튼을 클릭한다.
4. 슈퍼푸티가 설치될 위치는 기본값으로 두고 Next 버튼을 클릭한다.
5. 설치할 준비가 끝나면 Install 버튼을 클릭한다. ‘게시자를 알 수 없는 앱의 설치’ 창이 뜨면 동의하고 설치를 계속 진행한다.
6. 슈퍼푸티 설치가 완료되면 Finish 버튼을 클릭해 슈퍼푸티를 실행한다.
7. 슈퍼푸티는 푸티를 통해 실행되므로 푸티의 위치를 지정해야 한다. 다음 화면이 보이면 putty.exe Location 옆의 Browse 버튼을 클릭해 푸티의 위치를 지정한다.

![image](https://user-images.githubusercontent.com/61584142/161178744-b80d0626-d76f-48a9-a6cf-af88dd8e661d.png)

<br/>

8. C:\putty에서 putty.exe를 찾아 선택하고 열기 버튼을 누른다.
9. 푸티 실행 경로가 지정된 것을 확인하면 Ok 버튼을 클릭한다.
10.슈퍼푸티가 정상적으로 실행되는지 확인한다.

<br/><br/>

### 2.3.3 슈퍼푸티로 다수의 가상 머신 접속하기
- 슈퍼푸티로 ‘2.2.3 가상 머신 추가로 구성하기’에서 설치한 가상 머신 4대(m-k8s, w1-k8s, w2-k8s, w3-k8s)에 접속해 보자. 반복적으로 사용할 가상 머신의 접속 정보부터 슈퍼푸티에 구성한다.

<br/>

1. 먼저 새로운 세션 디렉터리를 생성한다. 슈퍼푸티 화면 오른쪽에 위치한 Sessions 창의 PuTTY Sessions에서 마우스 오른쪽 버튼을 클릭하고, New Folder를 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161178860-3b92bc53-ae22-4c88-9b92-f554bea5cacb.png)

<br/>

2. 접속 정보 입력 창에서 k8s를 입력하고, OK 버튼을 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161178882-052c2dd8-880d-4182-a111-ded661ef989e.png)

<br/>

3. 새로 추가된 k8s 디렉터리에서 마우스 오른쪽 버튼을 클릭하고 New 메뉴를 선택한다(추가된 디렉터리가 보이지 않으면 PuTTY Sessions를 더블클릭).

![image](https://user-images.githubusercontent.com/61584142/161178910-5ab09063-ea6d-4daf-aa54-05f655a22316.png)

<br/>

4. 가상 머신의 정보를 입력하는 창에 다음과 같이 입력하고 Save 버튼을 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161178932-5f56307c-1716-48f9-8fc2-c0c4709995b5.png)

<br/>

#### 127.0.0.1로 접속하는 이유
- 현재 가상 머신들은 192.168.1.0/24 영역대에 있어서 대부분의 경우 모두 접속할 수 있다. 하지만 현업에서는 데이터 통신과 관리 네트워크를 분리해 사용하는데, 이와 비슷하게 관리 네트워크를 분리한 것으로 보면 된다. 또한 127.0.0.1로 접속하면 192.168.1.0/24에서 문제가 발생해도 접속하는 데 문제가 없다.
- 각 가상 머신은 베이그런트에서 NAT로 사용하는 eth0에 고유의 포트 포워딩 규칙이 적용된다.

<br/>

##### 버추얼박스에 설정된 포트 포워딩 규칙
- 각 가상 머신의 설정 > 네트워크 > 고급 > 포트 포워딩을 누르면 확인이 가능하다.
![image](https://user-images.githubusercontent.com/61584142/161178970-5dc8030e-34a6-4496-8354-922cc5fa502c.png)

<br/>

- Vagrantfile에서는 다음과 같이 설정했다.
```
[중략]
cfg.vm.network "private_network", ip: "192.168.1.10"
cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true, id: "ssh"
cfg.vm.synced_folder "../data", "/vagrant", disabled: true
[생략]
```

<br/>

5. Extra PuTTY Arguments에 입력된 -pw vagrant는 평문으로 저장되기 때문에 보안상 위험하다는 내용을 안내하는 창이 뜬다. 여기서는 테스트 환경이므로 편의를 위해 그대로 평문으로 진행한다. 확인 버튼을 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161179104-47f0cf16-fe65-4b18-8a40-cf7316aaff72.png)

<br/>

6. m-k8s에서 마우스 오른쪽 버튼을 클릭한다. 메뉴에서 Copy As를 선택해 m-k8s의 접속 정보를 그대로 복사한다.

![image](https://user-images.githubusercontent.com/61584142/161179117-a08d1020-aaa2-4f00-9d10-7ff43f7c93cc.png)

<br/>

7. 복사한 접속 정보에서 표시된 부분만 맞춰서 수정하고 Save 버튼을 클릭해 저장한다.

![image](https://user-images.githubusercontent.com/61584142/161179137-67585f5c-a8db-4c28-b048-c00a7b1ff511.png)

<br/>

8. 6번과 7번 과정을 반복해 w2-k8s와 w3-k8s의 접속 정보를 추가로 생성한다.

![image](https://user-images.githubusercontent.com/61584142/161179171-f95348bb-4592-49bf-a003-c7a158cda9ad.png)
![image](https://user-images.githubusercontent.com/61584142/161179172-2575f1f2-a807-4472-9521-9164dd7cb0e2.png)

<br/>

9. 평문으로 접속하려면 슈퍼푸티의 보안 설정을 변경해야 한다. F2를 누르거나 메뉴에서 Tools > Options를 선택한다.

![image](https://user-images.githubusercontent.com/61584142/161179208-15892790-2dbc-4485-b0d9-dc616fb4aeeb.png)

<br/>

10. GUI 탭에서 Allow plain text passwords on putty command line 항목을 체크하고 Ok 버튼을 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161179218-79aef400-aaae-4bdc-abdb-2efca3413728.png)

<br/>

11. k8s 디렉터리에서 마우스 오른쪽 버튼을 누르고, Connect All을 선택해 모든 가상 머신에 한 번에 접속한다.

![image](https://user-images.githubusercontent.com/61584142/161179242-87c47b81-f7b7-4f00-9b4b-0538785fb105.png)

<br/>

12. 슈퍼푸티가 푸티를 호출하면서 발생한 파일 열기-보안 경고 창을 확인한다. 다음부터 이 경고 창이 보이지 않도록 이 파일을 열기 전에 항상 확인에 대한 체크를 해제한다. 그리고 가상 머신의 수(4개)만큼 실행 버튼을 클릭한다.

![image](https://user-images.githubusercontent.com/61584142/161179272-f2dce606-75b1-40ec-a364-be10b5c7aa69.png)

<br/>

13. 추가로 발생하는 보안 경고(PuTTY Security Alert) 창이 나오면 예 버튼을 클릭한다. 이 보안 경고는 known_hosts(알려진 호스트)가 없어서 발생하는 경고로 예를 누르면 known_hosts를 등록한다.

![image](https://user-images.githubusercontent.com/61584142/161179298-9af8a6f0-2cdb-417b-b6a6-3bc563e13e74.png)

<br/>

14. 가상 머신에 접속되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161179313-e89c76fc-619c-4997-9338-fd76e32097a3.png)

<br/>

15. 가상 머신의 작동을 한눈에 확인하기 위해 창을 분리 배치해 보자. 우선 w1-k8s 탭에서 마우스 왼쪽 버튼을 클릭한 상태에서 드래그 앤 드롭으로 오른쪽 창으로 분리한다.

![image](https://user-images.githubusercontent.com/61584142/161179350-d23e8376-5501-44f2-ad94-44ce5f1dca3c.png)

<br/>

16. 이번에는 w2-k8s를 왼쪽 하단으로 분할한다.

![image](https://user-images.githubusercontent.com/61584142/161179369-e56be672-3a6d-4262-a3cc-77d72aa60a2c.png)

<br/>

17. 마지막으로 w3-k8s를 오른쪽 하단으로 분리한다.

![image](https://user-images.githubusercontent.com/61584142/161179388-56ed7b69-4602-469b-9416-5e4d418bd96c.png)

<br/>

18. 4개의 창에 한 번에 명령이 실행되는지 명령(commands) 창에서 hostname을 입력해 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161179400-7f9d6a6c-0537-4de0-ba2b-07635e349daf.png)

<br/>

19. 4개 창에서 hostname(m-k8s, w1-k8s, w2-k8s, w3-k8s)에 해당하는 값이 출력된다.

![image](https://user-images.githubusercontent.com/61584142/161179427-1ff0f8d2-036c-4b2e-ac05-5424ebc37828.png)

<br/>

20. 확인이 끝났으니 다음 실습을 위해 가상 머신을 모두 삭제한다. 명령 프롬프트에서 vagrant destroy -f를 실행한다.
```
c:\HashiCorp>vagrant destroy -f
==> default: Forcing shutdown of VM...
==> default: Destroying VM and associated drives...
```

<br/>

- 컨테이너 인프라 환경을 만들기 위한 도구인 베이그런트와 버추얼박스가 무엇인지 살펴보고 실습해봤다.
- 이 도구들을 이용하면 우리가 원하는 형태의 실습 환경을 자유자재로 구성할 수 있다.

---

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

---

# 3. 컨테이너를 다루는 표준 아키텍처, 쿠버네티스
- **컨테이너 인프라 환경** 이란 리눅스 운영 체제의 커널 하나에서 여러 개의 컨테이너가 격리된 상태로 실행되는 인프라 환경을 말한다. 여기서 컨테이너는 하나 이상의 목적을 위해 독립적으로 작동하는 프로세스다. 좀 더 간단하게 말하면 친구와 대화를 주고받는 메신저 프로그램이나 음악 감상 프로그램을 컨테이너로 구현할 수 있다.

<br/>

- 개인 환경에서는 1명의 관리자(사용자)가 다양한 응용프로그램을 사용하므로 각각의 프로그램을 컨테이너로 구현할 필요가 거의 없다. 하지만 기업 환경에서는 다수의 관리자가 수백 또는 수천 대의 서버를 함께 관리하기 때문에 일관성을 유지하는 것이 매우 중요하다.

<br/>

- 이런 경우 컨테이너 인프라 환경을 구성하면 눈송이 서버(여러 사람이 만져서 설정의 일관성이 떨어진 서버)를 방지하는 데 효과적이다.

![image](https://user-images.githubusercontent.com/61584142/161184070-7a19d4da-508c-462b-a7f8-4841fd1b0469.png)

<br/>

- 또한 가상화 환경에서는 각각의 가상 머신이 모두 독립적인 운영 체제 커널을 가지고 있어야 하기 때문에 그만큼 자원을 더 소모해야 하고 성능이 떨어질 수 밖에 없다. 하지만 컨테이너 인프라 환경은 운영 체제 커널 하나에 컨테이너 여러 개가 격리된 형태로 실행되기 때문에 자원을 효율적으로 사용할 수 있고 거치는 단계가 적어서 속도도 훨씬 빠르다.

![image](https://user-images.githubusercontent.com/61584142/161184251-3571ed3a-ee78-4596-9b44-e53037680f1f.png)

<br/>

- 컨테이너 인프라 환경이 처음부터 주목받았던 것은 아니다. 이미 가상화 환경에서 상용 솔루션(VMware)을 이용해 안정적으로 시스템을 운용하고 있었고, 기술 성숙도가 높아 문제없이 관리되고 있었다. 그러다 시간이 지나 커널을 공유해 더 많은 애플리케이션을 올릴 수 있는 컨테이너가 도입되기 시작하면서 늘어난 컨테이너를 관리해야 했다. 하지만 기존의 컨테이너 관리 솔루션(Docker Swarm, Mesos, Nomad 등)들은 현업의 요구 사항을 충족시키기에는 부족한 점이 있었다. 그래서 컨테이너 인프라 환경이 주는 장점이 많이 있음에도 컨테이너 관리 문제 때문에 보편화되기가 어려웠다.

<br/>

- 하지만 그 이후 컨테이너 인프라 환경이 성장하게 된 결정적인 계기가 된 사건이 일어난다. 구글이 **쿠버네티스(Kubernetes)** 를 오픈 소스로 공개한 것이다. 구글은 2014년 자사에서 컨테이너 운영 플랫폼으로 운영하던 보그(Borg)를 기반으로 하는 쿠버네티스를 오픈 소스화하고 2015년 7월 21일 쿠버네티스 버전 1.0을 출시했다. 구글은 리눅스 재단(Linux Foundation)과 파느터십을 맺고 클라우드 네이티브 컴퓨팅 재단(CNCF, Cloud Native Computing Foundation)을 설립했으며 쿠버네티스를 기초 기술(seed technology)로 제공했다.

<br/>

- 이를 통해 안정적인 쿠버네티스를 누구나 자유롭게 이용하게 되면서 컨테이너 인프라 환경을 좀 더 효율적으로 관리할 수 있게 됐다. 이후 여러 기능이 계속 추가되면서 쿠버네티스의 생태계가 풍부해졌고, 사실상 쿠버네티스는 컨테이너 인프라 관리 솔루션의 표준으로 자리 잡게 됐다.

<br/>

- 이제부터 쿠버네티스로 직접 실습해 보면서 컨테이너 인프라 환경을 전반적으로 이해하고 쿠버네티스가 어떤 강점이 있기에 컨테이너 인프라 환경에서 표준이 될 수 있었는지 알아보자.

![image](https://user-images.githubusercontent.com/61584142/161184715-10001847-ad78-42b5-9d68-107521cce414.png)

<br/><br/><br/><br/>

## 3.1 쿠버네티스 이해하기
- 쿠버네티스를 컨테이너 관리 도구라고 설명했지만, 실제로 쿠버네티스는 **컨테이너 오케스트레이션** 을 위한 솔루션이다. **오케스트레이션(Orchestration)** 이란 복잡한 단계를 관리하고 요소들의 유기적인 관계를 미리 정의해 손쉽게 사용하도록 서비스를 제공하는 것을 의미한다. 다수의 컨테이너를 유기적으로 연결, 실행, 종료할 뿐만 아니라 상태를 추적하고 보존하는 등 컨테이너를 안정적으로 사용할 수 있게 만들어주는 것이 컨테이너 오케스트레이션이다.

<br/><br/>

### 3.1.1 왜 쿠버네티스일까
- 컨테이너 오케스트레이션을 제공하는 대표적인 솔루션은 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161184928-6474bf17-3646-47a9-a06c-d8605fbb339b.png)

<br/>

#### 솔루션마다 어떤 장단점이 있는지 살펴보자.
##### 도커 스웜(Docker Swarm)
- 간단하게 설치할 수 있고 사용하기도 용이하다. 그러나 그만큼 기능이 다양하지 않아 대규모 환경에 적용하려면 사용자 환경을 변경해야 할 수 있다. 따라서 소규모 환경에서는 유용하지만 대규모 환경에서는 잘 사용하지 않는 편이다.

<br/>

##### 메소스(Mesos)
- 아파치(Apache)의 오픈 소스 프로젝트로 역사와 전통이 있는 클러스터 도구이며 트위터, 에어비앤비, 애플, 우버 등 다양한 곳에서 이미 검증된 솔루션이다. 메소스는 2016년 DC/OS(Data Center OS, 대규모 서버 환경에서 자원을 유연하게 공유하며 하나의 자원처럼 관리하는 도구)의 지원으로 매우 간결해졌다. 하지만 기능을 충분히 활용하려면 분산 관리 시스템과 연동해야 한다. 따라서 여러 가지 솔루션을 유기적으로 구성해야 하는 부담이 있다.

<br/>

##### 노매드(Nomad)
- 베이그런트를 만든 해시코프(HashiCorp)사의 컨테이너 오케스트레이션으로, 베이그런트처럼 간단한 구성으로 컨테이너 오케스트레이션 환경을 제공한다. 하지만 도커 스웜과 마찬가지로 기능이 부족하므로 복잡하게 여러 기능을 사용하는 환경이 아닌 가볍고 간단한 기능만 필요한 환경에서 사용하기를 권장한다. 해시코프의 Consul(서비스 검색, 구성 및 분할 기능 제공)과 Vault(암호화 저장소)와의 연동이 원할하므로 이런 도구에 대한 사용 성숙도가 높은 조직이라면 노매드 도입을 고려해볼 수 있다.

<br/>

##### 쿠버네티스
- 다른 오케스트레이션 솔루션보다는 시작하는 데 어려움이 있지만, 쉽게 사용할 수 있도록 도와주는 도구들이 있어서 설치가 쉬워지는 추세다. 또한 다양한 형태의 쿠버네티스가 지속적으로 계속 발전되고 있어서 컨테이너 오케스트레이션을 넘어 IT 인프라 자체를 컨테이너화하고, 컨테이너화된 인프라 제품군을 쿠버네티스 위에서 동작할 수 있게 만든다. 즉 거의 모든 벤더와 오픈 소스 진영 모두에서 쿠버네티스를 지원하고 그에 맞게 통합 개발하고 있다. 그러므로 컨테이너 오케이스트레이션을 학습하거나 도입하려고 한다면 쿠버네티스를 우선적으로 고려해야 한다.

<br/>

#### 각 솔루션의 기능을 표로 정리하면 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161185150-2c960ce1-e283-4f0c-a9e6-b71c0617a092.png)

<br/>

- 2021년을 기준으로 대부분 IT 기업에서는 쿠버네티스와 관련된 프로젝트를 진행하고 있거나 이미 자사 솔루션으로 흡수 및 통합했다. 이에 따라 다양한 종류의 솔루션이 쿠버네티스에 통합되고 있다. 그러므로 컨테이너 오케스트레이션을 한다면 쿠버네티스를 우선으로 고려해야 한다.

<br/>

#### k8s의 의미
- 쿠버네티스(Kubernetes)를 검색하다 보면 k8s이라는 표현을 종종 보게 된다. k8s는 쿠버네티스(Kubernetes)의 약어이다. 왜 k8s일까? 일반적으로 대부분의 약어는 두 단어 이상으로 이루어진 긴 단어에서 각 단어의 한 음절씩 뽑아서 만드는데, 쿠버네티스는 그 이름 자체가 하나의 긴 단어이기 때문에 문자 수를 표시하는 방법으로 약어를 만들었다. k8(ubernete, 8글자)s의 형식으로. 쿠버네티스와 k8s는 자주 혼용하니 여기서나 다른 자료에서 같은 단어로 보면 된다. 참고로 쿠버네티스는 그리스어로 도선사(pilot, 배를 수로로 안전하게 안내하는 사람)나 조타수(helmsman, 배의 키를 조정해 올바른 방향으로 나아가게 하는 사람)를 의미한다.

<br/><br/>

### 3.1.2 쿠버네티스 구성 방법
- 쿠버네티스를 구성하는 방법은 크게 3가지이다.

<br/>

1. 퍼블릭 클라우드 업체에서 제공하는 관리형 쿠버네티스인 EKS(Amazon Elastic Kubernetes Service), AKS(Azure Kubernetes Services), GKE(Google Kubernetes Engine) 등을 사용한다. 구성이 이미 다 갖춰져 있고 마스터 노드를 클라우드 업체에서 관리하기 때문에 학습용으로는 적합하지 않다.

![image](https://user-images.githubusercontent.com/61584142/161185428-55151abb-019d-4284-85aa-2abdac1ba011.png)

<br/>

2. 수세의 Rancher, 레드햇의 OpenShift와 같은 플랫폼에서 제공하는 설치형 쿠버네티스를 사용한다. 하지만 유료라 쉽게 접근하기 어렵다.

![image](https://user-images.githubusercontent.com/61584142/161185457-40808ddc-506c-4591-8e2d-05b44de496ae.png)

<br/>

3. 사용하는 시스템에 쿠버네티스 클러스터를 자동으로 구성해주는 솔루션을 사용한다. 주요 솔루션으로는 kubeadm, kops(Kubernetes Operations), KRIB(Kubernetes Rebar Integrated Bootstrap), kubespray가 있다. 4가지의 주요 솔루션 중에 kubeadm이 가장 널리 알려져 있다. kubeadm은 사용자가 변경하기도 수월하고, 온프레미스(On-Premises)와 클라우드를 모두 지원하며, 배우기도 쉽다. 이러한 솔루션들을 구성형 쿠버네티스라고 한다.

![image](https://user-images.githubusercontent.com/61584142/161185501-73ffafb2-6567-43c9-8be0-ff07b92147d1.png)

<br/>

#### 쿠버네티스 클러스터 구성 솔루션 비교

![image](https://user-images.githubusercontent.com/61584142/161185534-4b7aad7f-a9f1-4e13-9b51-ad516676ff34.png)

<br/><br/>

### 3.1.3 쿠버네티스 구성하기
- 여기서는 학습을 위해 사용자 설정이 가장 많이 필요한 kubeadm으로 쿠버네티스를 구성하겠다. 또한 쿠버네티스가 설치되는 서버 노드는 가상 머신을 이용해 실제 온프레미스에 가깝게 구성한다. 그리고 설치되는 과정을 베이그런트로 자동화해 필요하면 쿠버네티스 테스트 환경을 재구성할 수 있게 하겠다.

<br/>

- 이제 2장에서 사용했던 베이그런트를 이용해 쿠버네티스 테스트 환경을 구축해보자. 편의를 위해 미리 만들어진 베이그런트 스크립트 파일로 쿠버네티스 테스트 환경을 구축하겠다.

<br/>

1. 쿠버네티스 실습 환경을 만들어 줄 베이그런트 스크립트 파일과 실습에 사용할 소스 코드 파일들을 내려받는다. 해당 파일은 깃허브에서 제공한다. 웹 브라우저 주소 창에 `https://github.com/sysnet4admin/_Book_k8sInfra`를 입력해 깃허브 저장소(Github Repository)로 이동한다. 다음과 같은 화면이 보이면 우측 상단의 Code 버튼을 클릭한다. 내려받기 옵션 중에 Download ZIP을 눌러서 직접 호스트 시스템(현재 윈도)로 파일을 내려받는다.

![image](https://user-images.githubusercontent.com/61584142/161185758-abd8afb3-3ce8-4cbe-87dd-9309d8126a9f.png)

<br/>

2. 내려받은 파일`(_Book_k8sInfra-main.zip)`을 C:\HashiCorp 폴더로 옮겨 압축을 풀고 폴더 내용이 다음과 같은지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161185788-e1e6a9fc-a4e3-45ca-a61a-a765298f6249.png)

- 각 디렉터리에 담긴 파일들은 다음과 같다.
```
• app: 부록 실습에서 다루는 데 필요한 파일이 저장돼 있다.

• ch2: 2장에서 사용했던 파일이 저장돼 있다.

• ch3: 쿠버네티스 실습에 필요한 파일과 여러 가지 쿠버네티스를 효과적으로 체험할 수 있는 파일이 저장돼 있다.

• ch4: 도커 실습에 필요한 파일과 스크립트가 저장돼 있다.

• ch5: 젠킨스 실습 환경을 구축하는 데 필요한 파일과 효과적으로 실습할 수 있는 예제가 저장돼 있다.

• ch6: 프로메테우스와 그라파나를 구성하는 데 필요한 파일과 효과적으로 실습할 수 있는 예제가 저장돼 있다.
```

<br/>

3. `C:\HashiCorp/_Book_k8sInfra-main/ch3/3.1.3` 폴더로 가서 다음과 같이 실습에 필요한 파일들이 있는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161185889-42eb288a-2699-4c6d-bfa0-5f9ed7712502.png)

<br/>

**해당 디렉터리에 있는 파일은 가상 머신으로 쿠버네티스 실습 환경을 구축하는 데 필요한 파일이다. 각 파일이 어떤 역할을 하고 어떤 내용을 담고 있는지 살펴보자.

<br/>

#### Vagrantfile
- 베이그런트 프로비저닝을 위한 정보를 담고 있는 메인 파일이다. 
- 명령 프롬프트를 실행하고 Vagrantfile이 있는 경로에서 vagrant up 명령을 입력하면 현재 호스트 내부에 Vagrantfile에 정의된 가상 머신들을 생성하고 생성한 가상 머신에 쿠버네티스 클러스트를 구성하기 위한 파일들을 호출해 쿠버네티스 클러스터를 자동으로 구성한다.

```
# -*- mode: ruby -*-
# vi: set ft=ruby :
 
Vagrant.configure("2") do |config|
  N = 3 # max number of worker nodes 
  Ver = '1.18.4' # Kubernetes Version to install
 
  #=============#
  # Master Node #
  #=============#
 
    config.vm.define "m-k8s" do |cfg|
      cfg.vm.box = "sysnet4admin/CentOS-k8s"
      cfg.vm.provider "virtualbox" do |vb|
        vb.name = "m-k8s(github_SysNet4Admin)"
        vb.cpus = 2
        vb.memory = 3072
        vb.customize ["modifyvm", :id, "--groups", "/k8s-SgMST-1.13.1(github_ SysNet4Admin)"]
      end
      cfg.vm.host_name = "m-k8s"
      cfg.vm.network "private_network", ip: "192.168.1.10"
      cfg.vm.network "forwarded_port", guest: 22, host: 60010, auto_correct: true,  id: "ssh"
      cfg.vm.synced_folder "../data", "/vagrant", disabled: true 
      cfg.vm.provision "shell", path: "config.sh", args: N
      cfg.vm.provision "shell", path: "install_pkg.sh", args: [ Ver, "Main" ] 
      cfg.vm.provision "shell", path: "master_node.sh"
    end
 
  #==============#
  # Worker Nodes #
  #==============#
 
  (1..N).each do |i|
    config.vm.define "w#{i}-k8s" do |cfg|    
      cfg.vm.box = "sysnet4admin/CentOS-k8s"
      cfg.vm.provider "virtualbox" do |vb|
        vb.name = "w#{i}-k8s(github_SysNet4Admin)"
        vb.cpus = 1
        vb.memory = 2560
        vb.customize ["modifyvm", :id, "--groups", "/k8s-SgMST-1.13.1(github_ SysNet4Admin)"]
      end
      cfg.vm.host_name = "w#{i}-k8s"
      cfg.vm.network "private_network", ip: "192.168.1.10#{i}"
      cfg.vm.network "forwarded_port", guest: 22, host: "6010#{i}", auto_correct:  true, id: "ssh"
      cfg.vm.synced_folder "../data", "/vagrant", disabled: true
      cfg.vm.provision "shell", path: "config.sh", args: N
      cfg.vm.provision "shell", path: "install_pkg.sh", args: Ver
      cfg.vm.provision "shell", path: "work_nodes.sh"
    end
  end
 
end
```
```
• 5번째 줄: 쿠버네티스에서 작업을 수행할 워커 노드의 수를 변수(N = 3)로 받습니다. 그리고 해당 변수를 24번째 줄(args: N)과 46번째 줄(args: N)에서 config.sh로 넘깁니다. 이는 사용자가 워커 노드의 개수를 직접 조절할 수 있게 합니다.

• 6번째 줄: 쿠버네티스 버전을 사용자가 선택할 수 있도록 변수(Ver = '1.18.4')로 저장했습니다. 다른 쿠버네티스 버전을 사용하고 싶을 경우 해당 값을 변경하면 됩니다.

• 25번째 줄: args: [ Ver, "Main" ] 코드를 추가해 쿠버네티스 버전 정보(Ver)와 Main이라는 문자를 install_pkg.sh로 넘깁니다. Ver 변수는 각 노드에 해당 버전의 쿠버네티스 버전을 설치하게 합니다. 두 번째 인자인 Main 문자는 install_pkg.sh에서 조건문으로 처리해 마스터 노드에만 이 책의 전체 실행 코드를 내려받게 합니다.

• 26번째 줄/48번째 줄: 쿠버네티스 마스터 노드를 위한 master_node.sh와 워커 노드를 위한 work_nodes.sh 코드를 추가했습니다.
```

<br/>

#### config.sh
- kubeadm으로 쿠버네티스를 설치하기 위한 사전 조건을 설정하는 스크립트 파일이다. 
- 쿠버네티스의 노드가 되는 가상 머신에 어떤 값을 설정하는지 알아보자.

```
#!/usr/bin/env bash
 
# vim configuration 
echo 'alias vi=vim' >> /etc/profile
 
# swapoff -a to disable swapping
swapoff -a
# sed to comment the swap partition in /etc/fstab
sed -i.bak -r 's/(.+ swap .+)/ #\1/' /etc/fstab
 
# kubernetes repo
gg_pkg="packages.cloud.google.com/yum/doc" # Due to shorten addr for key
cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=https://${gg_pkg}/yum-key.gpg https://${gg_pkg}/rpm-package-key.gpg
EOF
 
# Set SELinux in permissive mode (effectively disabling it)
setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config
 
# RHEL/CentOS 7 have reported traffic issues being routed incorrectly due to iptables bypassed
cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
modprobe br_netfilter
 
# local small dns & vagrant cannot parse and delivery shell code.
echo "192.168.1.10 m-k8s" >> /etc/hosts
for (( i=1; i<=$1; i++  )); do echo "192.168.1.10$i w$i-k8s" >> /etc/hosts; done
 
# config DNS  
cat <<EOF > /etc/resolv.conf
nameserver 1.1.1.1 #cloudflare DNS
nameserver 8.8.8.8 #Google DNS
EOF
```
```
• 4번째 줄: vi를 호출하면 vim을 호출하도록 프로파일에 입력합니다. 이렇게 하면 코드에 하이라이트를 넣어 코드를 쉽게 구분할 수 있습니다.

• 7번째 줄: 쿠버네티스의 설치 요구 조건을 맞추기 위해 스왑되지 않도록 설정합니다.

• 9번째 줄: 시스템이 다시 시작되더라도 스왑되지 않도록 설정합니다.

• 12번째 줄: 쿠버네티스의 리포지터리를 설정하기 위한 경로가 너무 길어지지 않게 경로를 변수로 처리합니다.

• 13~21번째 줄: 쿠버네티스를 내려받을 리포지터리를 설정하는 구문입니다.

• 24~25번째 줄: selinux가 제한적으로 사용되지 않도록 permissive 모드로 변경합니다.

• 28~31번째 줄: 브리지 네트워크를 통과하는 IPv4와 IPv6의 패킷을 iptables가 관리하게 설정합니다. 파드(Pod, 쿠버네티스에서 실행되는 객체의 최소 단위로, 뒤에서 자세히 설명할 예정)의 통신을 iptables로 제어합니다. 필요에 따라 IPVS(IP Virtual Server) 같은 방식으로도 구성할 수도 있습니다.

• 32번째 줄: br_netfilter 커널 모듈을 사용해 브리지로 네트워크를 구성합니다. 이때 IP 마스커레이드(Masquerade)를 사용해 내부 네트워크와 외부 네트워크를 분리합니다. IP 마스커레이드는 쉽게 설명하면 커널에서 제공하는 NAT(Network Address Translation) 기능으로 이해하면 됩니다. 실제로는 br_netfilter를 적용함으로써 28~31번째 줄에서 적용한 iptables가 활성화됩니다.

• 35~36번째 줄: 쿠버네티스 안에서 노드 간 통신을 이름으로 할 수 있도록 각 노드의 호스트 이름과 IP를 /etc/hosts에 설정합니다. 이때 워커 노드는 Vagrantfile에서 넘겨받은 N 변수로 전달된 노드 수에 맞게 동적으로 생성합니다.

• 39~42번째 줄: 외부와 통신할 수 있게 DNS 서버를 지정합니다.
```

<br/>

#### Install_pkg.sh
- 클러스터를 구성하기 위해서 가상 머신에 설치돼야 하는 의존성 패키지를 명시한다. 
- 또한 실습에 필요한 소스 코드를 특정 가상 머신(m-k8s) 내부에 내려받도록 설정돼 있다.

```
#!/usr/bin/env bash
 
# install packages
yum install epel-release -y
yum install vim-enhanced -y
yum install git -y
 
# install docker
yum install docker -y && systemctl enable --now docker
 
# install kubernetes cluster
yum install kubectl-$1 kubelet-$1 kubeadm-$1 -y
systemctl enable --now kubelet
 
# git clone _Book_k8sInfra.git
if [ $2 = 'Main' ]; then
 git clone https://github.com/sysnet4admin/_Book_k8sInfra.git
 mv /home/vagrant/_Book_k8sInfra $HOME
 find $HOME/_Book_k8sInfra/ -regex ".*\.\(sh\)" -exec chmod 700 {} \;
fi
```
```
• 6번째 줄: 깃허브에서 코드를 내려받을 수 있게 깃(git)을 설치합니다.

• 9번째 줄: 쿠버네티스를 관리하는 컨테이너를 설치하기 위해 도커를 설치하고 구동합니다.

• 12~13번째 줄: 쿠버네티스를 구성하기 위해 첫 번째 변수($1=Ver='1.18.4')로 넘겨받은 1.18.4 버전의 kubectl, kubelet, kubeadm을 설치하고 kubelet을 시작합니다.

• 16~20번째 줄: 이 책의 전체 실행 코드를 마스터 노드에만 내려받도록 Vagrantfile에서 두 번째 변수($2 = 'Main')를 넘겨받습니다. 그리고 깃에서 코드를 내려받아 실습을 진행할 루트 홈디렉터리(/root)로 옮깁니다. 배시 스크립트(.sh)를 find로 찾아서 바로 실행 가능한 상태가 되도록 chmod 700으로 설정합니다.
```

<br/>

#### master_node.sh
- 1개의 가상 머신(m-k8s)을 쿠버네티스 마스터 노드로 구성하는 스크립트다. 
- 여기서 쿠버네티스 클러스터를 구성할 때 꼭 선택해야 하는 컨테이너 네트워크 인터페이스(CNI, Container Network Interface)도 함께 구성한다.
```
#!/usr/bin/env bash
 
# init kubernetes
kubeadm init --token 123456.1234567890123456 --token-ttl 0 \
--pod-network-cidr=172.16.0.0/16 --apiserver-advertise-address=192.168.1.10
 
# config for master node only
mkdir -p $HOME/.kube
cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
chown $(id -u):$(id -g) $HOME/.kube/config
 
# config for kubernetes's network
kubectl apply -f \
https://raw.githubusercontent.com/sysnet4admin/IaC/master/manifests/172.16_net_  calico.yaml
```
```
• 4~5번째 줄: kubeadm을 통해 쿠버네티스의 워커 노드를 받아들일 준비를 합니다. 먼저 토큰을 123456.1234567890123456으로 지정하고 ttl(time to live, 유지되는 시간)을 0으로 설정해서 기본값인 24시간 후에 토큰이 계속 유지되게 합니다. 그리고 워커 노드가 정해진 토큰으로 들어오게 합니다. 쿠버네티스가 자동으로 컨테이너에 부여하는 네트워크를 172.16.0.0/16(172.16.0.1~172.16.255.254)으로 제공하고, 워커 노드가 접속하는 API 서버의 IP를 192.168.1.10으로 지정해 워커 노드들이 자동으로 API 서버에 연결되게 합니다.

• 8~10번째 줄: 마스터 노드에서 현재 사용자가 쿠버네티스를 정상적으로 구동할 수 있게 설정 파일을 루트의 홈디렉터리(/root)에 복사하고 쿠버네티스를 이용할 사용자에게 권한을 줍니다.

• 13~14번째 줄: 컨테이너 네트워크 인터페이스(CNI)인 캘리코(Calico)의 설정을 적용해 쿠버네티스의 네트워크를 구성합니다.
```

<br/>

#### work_nodes.sh
- 3대의 가상 머신(w1-k8s, w2-k8s, w3-k8s)에 쿠버네티스 워커 노드를 구성하는 스크립트이다. 
- 마스터 노드에 구성된 클러스터에 조인이 필요한 정보가 모두 코드화돼 있어 스크립트를 실행하기만 하면 편하게 워커 노드로서 쿠버네티스 클러스터에 조인된다.

```
#!/usr/bin/env bash
 
# config for work_nodes only
kubeadm join --token 123456.1234567890123456 \
             --discovery-token-unsafe-skip-ca-verification 192.168.1.10:6443
```
```
• 4~5번째 줄: kubeadm을 이용해 쿠버네티스 마스터 노드에 접속합니다. 이때 연결에 필요한 토큰은 기존에 마스터 노드에서 생성한 123456.1234567890123456을 사용합니다. 간단하게 구성하기 위해 --discovery-token-unsafe-skip-ca-verification으로 인증을 무시하고, API 서버 주소인 192.168.1.10으로 기본 포트 번호인 6443번 포트에 접속하도록 설정합니다.
```

<br/>

4. 쿠버네티스를 구성하는 데 필요한 파일들을 살펴봤으니 다시 구성 과정으로 돌아가자. 명령프롬프트를 명령 창을 열고 `cd c:\HashiCorp/_Book_k8sInfra-main/ch3/3.1.3` 명령으로 쿠버네티스 설치 파일이 있는 디렉터리로 이동한다. vagrant up 명령을 실행한다. 지금까지 설명한 파일들로 쿠버네티스 클러스터가 자동으로 구성된다.

```
C:\Users\Hoon Jo - Pink>cd c:\HashiCorp/_Book_k8sInfra-main/ch3/3.1.3
C:\HashiCorp\_Book_k8sInfra-main\ch3\3.1.3> vagrant up
Bringing machine 'm-k8s' up with 'virtualbox' provider...
Bringing machine 'w1-k8s' up with 'virtualbox' provider...
Bringing machine 'w2-k8s' up with 'virtualbox' provider...
Bringing machine 'w3-k8s' up with 'virtualbox' provider...
==> m-k8s: Checking if box 'sysnet4admin/CentOS-k8s' version '0.7.0' is up to date...
==> m-k8s: Setting the name of the VM: m-k8s(github_SysNet4Admin)
==> m-k8s: Clearing any previously set network interfaces...
==> m-k8s: Preparing network interfaces based on configuration...
    m-k8s: Adapter 1: nat
    m-k8s: Adapter 2: hostonly
==> m-k8s: Forwarding ports...
    m-k8s: 22 (guest) => 60010 (host) (adapter 1)
==> m-k8s: Running 'pre-boot' VM customizations...
[생략]
```

<br/>

5. vagrant up 실행이 끝나면 슈퍼푸티를 연다. 2장에서 설정한 세션 창에서 m-k8s를 더블클릭해 터미널에 접속한다.

![image](https://user-images.githubusercontent.com/61584142/161186720-30ea62e6-c84c-40a4-9d05-031873906fe3.png)

<br/>

6. kubectl get nodes 명령으로 쿠버네티스 클러스터에 마스터 노드와 워커 노드들이 정상적으로 생성되고 연결됐는지 확인한다.

```
[root@m-k8s ~]# kubectl get nodes
NAME     STATUS   ROLES    AGE   VERSION
m-k8s    Ready    master   29m   v1.18.4
w1-k8s   Ready    <none>   24m   v1.18.4
w2-k8s   Ready    <none>   19m   v1.18.4
w3-k8s   Ready    <none>   15m   v1.18.4 
```

<br/>

**쿠버네티스 클러스터 구성이 끝났다. 이제 쿠버네티스를 구성하는 요소를 살펴보면서 쿠버네티스의 개념과 용어를 알아보.

<br/>

### 3.1.4 파드 배포를 중심으로 쿠버네티스 구성 요소 살펴보기
- 앞에 나온 kubectl, kubelet, API 서버, 캘리코 등은 모두 쿠버네티스 클러스터를 이루는 구성 요소이다. 그 외에도 etcd, 컨트롤러 매니저, 스케줄러, kube-proxy, 컨테이너 런타임, 파드 등이 있다. 이 요소들이 어떤 역할을 담당하는지 차근차근 알아보자.

<br/>

- 우선 설치된 쿠버네티스 구성 요소를 `kubectl get pods --all-namespaces` 명령으로 확인해 보자. 접속한 m-k8s에서 명령을 실행한다.
```
[root@m-k8s ~]#  kubectl get pods --all-namespaces
NAMESPACE     NAME                                       READY   STATUS    RESTARTS   AGE
kube-system   calico-kube-controllers-6bbf58546b-pmk78   1/1     Running   0          36m
kube-system   calico-node-bf486                          1/1     Running   0          31m
kube-system   calico-node-j9plc                          1/1     Running   0          22m
kube-system   calico-node-mnkgd                          1/1     Running   0          27m
kube-system   calico-node-xwxtc                          1/1     Running   0          36m
kube-system   coredns-5644d7b6d9-b4dz9                   1/1     Running   0          36m
kube-system   coredns-5644d7b6d9-jmsxh                   1/1     Running   0          36m
kube-system   etcd-m-k8s                                 1/1     Running   0          35m
kube-system   kube-apiserver-m-k8s                       1/1     Running   0          35m
kube-system   kube-controller-manager-m-k8s              1/1     Running   0          35m
kube-system   kube-proxy-5ltsx                           1/1     Running   0          22m
kube-system   kube-proxy-fzvsx                           1/1     Running   0          36m
kube-system   kube-proxy-gfsc8                           1/1     Running   0          31m
kube-system   kube-proxy-v8lxz                           1/1     Running   0          27m
kube-system   kube-scheduler-m-k8s                       1/1     Running   0          35m 
```

- --all-namespaces는 기본 네임스페이스인 default 외에 모든 것을 표시하겠다는 의미다. 따라서 모든 네임스페이스에서 파드를 수집해 보여준다. 쿠버네티스 클러스터를 이루는 구성 요소들은 파드 형태로 이루어져 있음을 알 수 있다.

<br/>

#### 쿠버네티스 구성 요소의 이름 생성 규칙
- 쿠버네티스의 구성 요소는 동시에 여러 개가 존재하는 경우 중복된 이름을 피하려고 뒤에 해시(hash) 코드가 삽입된다. 이떄 해시 코드는 무작위 문자열로 생성된다.

```
[root@m-k8s ~]# kubectl get pods --all-namespaces | grep kube-proxy
kube-system   kube-proxy-5ltsx                    1/1     Running   0          22m
kube-system   kube-proxy-fzvsx                    1/1     Running   0          36m
kube-system   kube-proxy-gfsc8                    1/1     Running   0          32m
kube-system   kube-proxy-v8lxz                    1/1     Running   0          27m 
```

<br/>

- 구성 요소의 이름을 직접 지정할 수도 있지만, 구성 요소는 언제라도 문제가 발견되면 다시 생성되는 특성을 가지는 파드로 이루어져 있어서 자동으로 이름을 지정하는 것이 관리하기 쉽다.

<br/>

- 그리고 coredns에는 중간에 5644d7b6d9라는 문자열이 하나 더 있는데, 이는 레플리카셋(ReplicaSet)을 무작위 문자열로 변형해 추가한 것이다. calico-kube-controllers도 같은 경우다. 

```
[root@m-k8s ~]# kubectl get pods --all-namespaces | grep coredns
kube-system   coredns-5644d7b6d9-b4dz9            1/1     Running   0          37m
kube-system   coredns-5644d7b6d9-jmsxh            1/1     Running   0          37m 
```

<br/>

#### 관리자나 개발자가 파드를 배포할 때
- 쿠버네티스의 구성 요소의 유기적인 연결 관계를 표현하면 다음과 같다. 그림에 나와 있는 숫자는 실제로 관리자나 개발자가 파드 배포 명령을 수행했을 때 실행되는 순서다.

![image](https://user-images.githubusercontent.com/61584142/161193709-5d339321-50e1-4d59-80ac-4fb79cf3a15d.png)

<br/>

**통신 순서가 있어서 흐름을 이해할 수 있지만, 각각의 기능을 파악하기는 어렵다. 파드를 배포하는 순서에 따라 요소들의 역할을 정리해 보자.

<br/>

**마스터노드

#### kubectl
- 쿠버네티스 클러스터에 명령을 내리는 역할을 한다. 다른 구성 요소들과 다르게 바로 실행되는 명령 형태인 바이너리(binary)로 배포되기 때문에 마스터 노드에 있을 필요는 없다. 하지만 통상적으로 API 서버와 주로 통신하므로 이 책에서는 API 서버가 위치한 마스터 노드에 구성했다.

<br/>

#### API 서버
- 쿠버네티스 클러스터의 중심 역할을 하는 통로다. 주로 상태 값을 저장하는 etcd와 통신하지만, 그 밖의 요소들 또한 API 서버를 중심에 두고 통신하므로 API 서버의 역할이 매우 중요하다. 회사에 비유하면 모든 직원과 상황을 관리하고 목표를 설정하는 관리자에 해당한다.

<br/>

#### etcd
- 구성 요소들의 상태 값이 모두 저장되는 곳이다. 회사의 관리자가 모든 보고 내용을 기록하는 노트라고 생각하면 된다. 실제로 etcd 외의 다른 구성 요소는 상태 값을 관리하지 않는다. 그러므로 etcd의 정보만 백업돼 있다면 긴급한 장애 상황에서도 쿠버네티스 클러스터는 복구할 수 있다. 또한 etcd는 분산 저장이 가능한 key-value 저장소이므로, 복제해 여러 곳에 저장해 두면 하나의 etcd에서 장애가 나더라도 시스템의 가용성을 확보할 수 있다.
- etcd(엣시디)를 약어로 오인하는 경우가 있다. etcd는 리눅스의 구성 정보를 주로 가지고 있는 etc 디렉터리와 distributed(퍼뜨렸다)의 합성어다. 따라서 etcd는 구성 정보를 퍼뜨려 저장하겠다는 의미다.

<br/>

#### 컨트롤러 매니저
- 컨트롤러 매니저는 쿠버네티스 클러스터의 오브젝트 상태를 관리한다. 예를 들어 워커 노드에서 통신이 되지 않는 경우, 상태 체크와 복구는 컨트롤러 매니저에 속한 노드 컨트롤러에서 이루어진다. 다른 예로 레플리카셋 컨트롤러는 레플리카셋에 요청받은 파드 개수대로 파드를 생성한다. 뒤에 나오는 서비스와 파드를 연결하는 역할을 하는 엔드포인트 컨트롤러 또한 컨트롤러 매니저다. 이와 같이 다양한 상태 값을 관리하는 주체들이 컨트롤러 매니저에 소속돼 각자의 역할을 수행한다.

<br/>

#### 스케줄러
- 노드의 상태와 자원, 레이블, 요구 조건 등을 고려해 파드를 어떤 워커 노드에 생성할 것인지를 결정하고 할당한다. 스케줄러라는 이름에 걸맞게 파드를 조건에 맞는 워커 노드에 지정하고, 파드가 워커 노드에 할당되는 일정을 관리하는 역할을 담당한다.

<br/>

**워커 노드

#### kubelet
- 파드의 구성 내용(PodSpec)을 받아서 컨테이너 런타임으로 전달하고, 파드 안의 컨테이너들이 정상적으로 작동하는지 모니터링한다.

<br/>

#### 컨테이너 런타임(CRI, Container Runtime Interface)
- 파드를 이루는 컨테이너의  실행을 담당한다. 파드 안에서 다양한 종류의 컨테이너가 문제 없이 작동하게 만드는 표준 인터페이스다.

<br/>

#### 파드(Pod)
- 한 개 이상의 컨테이너로 단일 목적의 일을 하기 위해서 모인 단위이다. 즉, 웹서버 역할을 할 수도 있고 로그나 데이터를 분석할 수도 있다. 여기서 중요한 것은 파드는 언제라도 죽을 수 있는 존재라는 점이다. 이것이 쿠버네티스를 처음 배울 때 가장 이해하기 어려운 부분이다. 가상 머신은 언제라도 죽을 수 있다고 가정하고 디자인하지 않지만, 파드는 언제라도 죽을 수 있다고 가정하고 설계됐기 때문에 쿠버네티스는 여러 대안을 디자인했다.

![image](https://user-images.githubusercontent.com/61584142/161194966-28837b64-626e-48ac-bdc8-2db7bc48fb2c.png)

<br/>

**선택 가능한 구성 요소
- 위의 요소는 기본 설정으로 배포된 쿠버네티스에서 이루어지는 통신 단계를 구분한 것이다. 이외에 선택적으로 배포하는 것들은 순서와 상관이 없다.

<br/>

#### 네트워크 플러그인
- 쿠버네티스 클러스터의 통신을 위해서 네트워크 플러그인을 선택하고 구성해야 한다. 네트워크 플러그인은 일반적으로 CNI로 구성하는데, 주로 사용하는 CNI에는 캘리코(Calico), 플래널(Flannel), 실리움(Cilium), 큐브 라우터(Kube-router), 로마나(Romana), 위브넷(WeaveNet), Canal이 있다. 여기서는 캘리코를 선택해 구성했다.

<br/>

#### CoreDNS
- 클라우드 네이티브 컴퓨팅 재단에서 보증하는 프로젝트로, 빠르고 유연한 DNS 서버다. 쿠버네티스 클러스터에서 도메인 이름을 이용해 통신하는 데 사용한다. 실무에서 쿠버네티스 클러스터를 구성하여 사용할 때는 IP보다 도메인 네임을 편리하게 관리해 주는 CoreDNS를 사용하는 것이 일반적이다. 해당 내용을 자세히 알아보려면 홈페이지(https://coredns.io)를 참조하면 된다.

<br/>

#### CNI
- CNI(Container Network Interface, 컨테이너 네트워크 인터페이스)는 클라우드 네이티브 컴퓨팅 재단의 프로젝트로, 컨테이너의 네트워크 안정성과 확장성을 보장하기 위해 개발됐다. CNI에 사용할 수 있는 네트워크 플러그인은 다양한데, 구성 방식과 지원하는 기능, 성능이 각기 다르므로 사용 목적에 맞게 선택하면 된다. 예를 들어 Calico는 L3로 컨테이너 네트워크를 구성하고, Flannel은 L2로 컨테이너 네트워크를 구성한다. 또한 네트워크 프로토콜인 BGP와 VXLAN의 지원, ACL(Access Control List) 지원, 보안 기능 제공 등을 살펴보고 필요한 조건을 가지고 있는 네트워크 플러그인을 선택할 수 있어서 설계 유연성이 매우 높다.

![image](https://user-images.githubusercontent.com/61584142/161195165-fd32be6b-f26b-441c-8c9d-fb23c433a87c.png)

<br/><br/>

#### 사용자가 배포된 파드에 접속할 때
- 이번에는 파드가 배포된 이후 사용자 입장에서 배포된 파드에 접속하는 과정을 살펴보자.

<br/>

#### 1. kube-proxy
- 쿠버네티스 클러스터는 파드가 위치한 노드에 kube-proxy를 통해 파드가 통신할 수 있는 네트워크를 설정한다. 이때 실제 통신은 br_netfilter와 iptables로 관리한다. 두 기능은 Vagrantfile에서 호출하는 config.sh 코드를 설명할 때 다뤘다.

<br/>

#### 2. 파드
- 이미 배포된 파드에 접속하고 필요한 내용을 전달받는다. 이때 대부분 사용자는 파드가 어느 워커 노드에 위치하는지 신경 쓰지 않아도 된다.

<br/>

**쿠버네티스의 각 구성 요소를 파드의 배포와 접속 관점에서 설명했지만, 이해하기는 쉽지 않다. 파드가 배포되는 과정을 살펴보며 쿠버네티스의 구성 요소를 좀 더 깊이 알아보자.

<br/><br/>

### 3.1.5 파드의 생명주기로 쿠버네티스 구성 요소 살펴보기
- 쿠버네티스의 구성 요소를 개별적으로 살펴봤으나 기능만 나열해서는 이해하기가 어렵다. 따라서 파드가 배포되는 과정을 하나하나 자세히 살펴보면서 쿠버네티스의 구성 요소들이 어떤 역할을 담당하는지 정리해 보자.

<br/>

- 쿠버네티스의 가장 큰 장점은 쿠버네티스의 구성 요소마다 하는 일이 명확하게 구분돼 각자의 역할만 충실하게 수행하면 클러스터 시스템이 안정적으로 운영된다는 점이다. 이렇게 각자의 역할이 명확하게 나뉘어진 것은 마이크로서비스 아키텍처(MSA) 구조와도 밀접하게 연관된다. 또한 역할이 나뉘어 있어서 문제가 발생했을 때 어느 부분에서 문제가 발생했는지 디버깅하기 쉽다.

<br/>

- 먼저 그림을 통해 파드의 생명주기를 살펴보자. 생명주기(life cycle)는 파드가 생성, 수정, 삭제되는 과정을 나타낸다.

![image](https://user-images.githubusercontent.com/61584142/161198047-9a365fef-b2cf-4031-bcd6-b3799943daa0.png)

1. kubectl을 통해 API 서버에 파드 생성을 요청한다.

2. (업데이트가 있을 때마다 매번) API 서버에 전달된 내용이 있으면 API 서버는 etcd에 전달된 내용을 모두 기록해 클러스터의 상태 값을 최신으로 유지한다. 따라서 각 요소가 상태를 업데이트할 때마다 모두 API 서버를 통해 etcd에 기록된다.

3. API 서버에 파드 생성이 요청된 것을 컨트롤러 매니저가 인지하면 컨트롤러 매니저는 파드를 생성하고, 이 상태를 API 서버에 전달한다. 참고로 아직 어떤 워커 노드에 파드를 적용할지는 결정되지 않은 상태로 파드만 생성됩니다. 

4. API 서버에 파드가 생성됐다는 정보를 스케줄러가 인지한다. 스케줄러는 생성된 파드를 어떤 워커 노드에 적용할지 조건을 고려해 결정하고 해당 워커 노드에 파드를 띄우도록 요청한다.

5. API 서버에 전달된 정보대로 지정한 워커 노드에 파드가 속해 있는지 스케줄러가 kubelet으로 확인한다.

6. kubelet에서 컨테이너 런타임으로 파드 생성을 요청한다.

7. 파드가 생성된다.

8. 파드가 사용 가능한 상태가 된다.

<br/>

**앞의 내용을 살펴보다가 ‘API 서버는 감시만 하는 걸까? 화살표가 반대로 그려져야 맞지 않을까?’라는 의문이 들었다면 내용을 제대로 봤다.
- 이 부분은 쿠버네티스를 이해하는 데 매우 중요한 부분이다. 쿠버네티스는 작업을 순서대로 진행하는 워크플로(workflow, 작업절차) 구조가 아니라 선언적인(declarative) 시스템 구조를 가지고 있다. 즉, 각 요소가 추구하는 상태(desired status)를 선언하면 현재 상태(current status)와 맞는지 점검하고 그것에 맞추려고 노력하는 구조로 돼 있다는 뜻이다.

<br/>

- 따라서 추구하는 상태를 API 서버에 선언하면 다른 요소들이 API 서버에 와서 현재 상태와 비교하고 그에 맞게 상태를 변경하려고 한다. 여기서 API는 현재 상태 값을 가지고 있는데, 이것을 보존해야 해서 etcd가 필요하다. API 서버와 etcd는 거의 한몸처럼 움직이도록 설계됐다. 다만, 여기서 워커노드는 워크플로 구조에 따라 설계됐다. 쿠버네티스가 kubelet과 컨테이너 런타임을 통해 파드를 새로 생성하고 제거해야 하는 구조여서 선언적인 방식으로 구조화하기에는 어려움이 있기 때문이다. 또한 명령이 절차적으로 전달되는 방식은 시스템의 성능을 높이는 데 효율적이다. 하지만 마스터 노드는 이미 생성된 파드들을 유기적으로 연결하므로 쿠버네티스 클러스터를 안정적으로 유지하려면 선언적인 시스템이 더 낫다.

![image](https://user-images.githubusercontent.com/61584142/161198354-8203e114-4dde-4b37-bd74-0819ad9ccab2.png)

<br/>

- 이렇듯 쿠버네티스는 굉장히 잘 설계된 시스템 구조를 가지고 있어서 구조적으로 이해하기 쉽고 문제가 생기면 이를 쉽게 파악하고 조치할 수 있다. 그러면 앞의 구성 요소 중에서 몇 가지를 검증해 실제로 어떻게 작동하는지 살펴보자.

<br/><br/>

### 3.1.6 쿠버네티스 구성 요소의 기능 검증하기
- 쿠버네티스의 구성 요소를 좀 더 이해하기 쉽게 시나이로를 작성해 구성 요소들의 역할과 의미를 확인해 보자.

<br/>

#### kubectl
- 앞에서 kubectl은 꼭 마스터 노드에 위치할 필요 없다고 했다. 실제로 쿠버네티스 클러스터의 외부에서 쿠버네티스 클러스터에 명령을 내릴 수도 있다. 어느 곳에서든지 kubectl을 실행하려면 어떤 부분이 필요한지 확인해 보자.

<br/>

1. 슈퍼푸티 세션 창에서 w3-k8s를 더블클릭해 터미널에 접속한다. 

![image](https://user-images.githubusercontent.com/61584142/161198772-01a7e3ae-33d6-49f1-af26-b326cc20a06f.png)

<br/>

2. kubectl get nodes를 실행한다.
```
[root@w3-k8s ~]# kubectl get nodes
The connection to the server localhost:8080 was refused - did you specify the right host or port?
```
- 명령을 실행해도 쿠버네티스의 노드들에 대한 정보가 표시되지 않는다. 이는 쿠버네티스 클러스터의 정보를 kubectl이 알지 못하기 때문이다. ‘3.1.5 파드 생명주기로 쿠버네티스 구성 요소 살펴보기’를 보면 kubectl은 API 서버를 통해 쿠버네티스에 명령을 내린다. 따라서 kubectl이 어디에 있더라도 API 서버의 접속 정보만 있다면 어느 곳에서든 쿠버네티스 클러스터에 명령을 내릴 수 있다.

<br/>

3. 쿠버네티스 클러스터의 정보(/etc/kubernetes/admin.conf)를 마스터 노드에서 scp(secure copy) 명령으로 w3-k8s의 현재 디렉터리(.)에 받아온다. 이때 접속 기록이 없기 때문에 known_hosts로 저장하도록 yes를 입력합니다. 마스터 노드의 접속 암호인 vagrant도 입력한다.
```
[root@w3-k8s ~]# scp root@192.168.1.10:/etc/kubernetes/admin.conf .
[root@w3-k8s ~]# scp root@192.168.1.10:/etc/kubernetes/admin.conf .
The authenticity of host '192.168.1.10 (192.168.1.10)' can't be established.
ECDSA key fingerprint is SHA256:l6XikZFgOibzSygqZ6+UYHUnEmjFEFhx7PpZw0I3WaM.
ECDSA key fingerprint is MD5:09:74:43:ef:38:3e:36:a1:7e:51:76:1a:ac:2d:7e:0c.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added '192.168.1.10' (ECDSA) to the list of known hosts.
root@192.168.1.10's password: vagrant
admin.conf                                     100% 5452     1.8MB/s   00:00
```

<br/>

4. kubectl get nodes 명령에 추가로 쿠버네티스 클러스터 정보를 입력받는 옵션(--kubeconfig)과 마스터 노드에서 받아온 admin.conf를 입력하고 실행한다.
```
[root@w3-k8s ~]# kubectl get nodes --kubeconfig admin.conf
NAME     STATUS   ROLES    AGE   VERSION
m-k8s    Ready    master   60m   v1.18.4
w1-k8s   Ready    <none>   55m   v1.18.4
w2-k8s   Ready    <none>   50m   v1.18.4
w3-k8s   Ready    <none>   46m   v1.18.4 
```
- 노드 정보가 정상적으로 표시된다. kubectl을 실행하려면 무엇이 필요한지 확인했다.

<br/><br/>

#### kubelet
- kubelet은 쿠버네티스에서 파드의 생성과 상태 관리 및 복구 등을 담당하는 매우 중요한 구성 요소다. 따라서 kubelet에 문제가 생기면 파드가 정상적으로 관리되지 않는다.

<br/>

1. 기능을 검증하려면 실제로 파드를 배포해야 한다. m-k8s(마스터 노드)에서 `kubectl create -f ~/_Book_k8sInfra/ch3/3.1.6/nginx-pod.yaml` 명령으로 nginx 웹 서버 파드를 배포한다. 여기서 -f 옵션은 일반적으로 쓰는 force가 아니라 filename을 의미한다. 즉, 파드의 구성 내용을 파일로 읽어 들여 1개의 파드를 임의의 워커 노드에 배포하는 것이다. 
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.1.6/nginx-pod.yaml
pod/nginx-pod created
```

<br/>

2. kubectl get pod 명령으로 배포된 파드가 정상적으로 배포된 상태(Running)인지 확인한다.
```
[root@m-k8s ~]# kubectl get pod
NAME        READY   STATUS    RESTARTS   AGE
nginx-pod   1/1     Running   0         67s 
```

<br/>

3. kubectl get pods -o wide 명령을 실행해 파드가 배포된 워커 노드를 확인한다. -o는 output의 약어로 출력을 특정 형식으로 해 주는 옵션이며, wide는 제공되는 출력 형식 중에서 출력 정보를 더 많이 표시해 주는 옵션이다.
```
[root@m-k8s ~]# kubectl get pods -o wide
NAME        READY   STATUS    RESTARTS   AGE      IP               NODE      …
nginx-pod   1/1     Running   0          94s      172.16.103.129   w2-k8s   …
```

<br/>

4. 배포된 노드인 w2-k8s에 접속해 systemctl stop kubelet으로 kubelet 서비스를 멈춘다. 스케줄러가 임의로 노드를 지정해 배포하므로 책과 다를 수 있다. 실습할 때는 앞의 결과에서 실제로 나온 노드에서 실행한다.
```
[root@w2-k8s ~]# systemctl stop kubelet
```

<br/>

5. m-k8s에서 kubectl get pod로 상태를 확인하고, kubectl delete pod nginx-pod 명령을 입력해 파드를 삭제한다.
```
[root@m-k8s ~]# kubectl get pod
NAME        READY   STATUS    RESTARTS   AGE
nginx-pod   1/1     Running   0          3m2s
[root@m-k8s ~]# kubectl delete pod nginx-pod
pod "nginx-pod" deleted
```

<br/>

6. 슈퍼푸티 명령 창에 아무런 변화가 없다면 Ctrl+C를 눌러 kubectl delete pod nginx-pod 명령을 중지한다.
```
[root@m-k8s ~]# kubectl delete pod nginx-pod
pod "nginx-pod" deleted
^C
```

<br/>

7. 다시 kubectl get pod 명령을 실행해 파드의 상태를 확인한다. 실행 결과를 보면 nginx-pod를 삭제(Terminating)하고 있다. 하지만 kubelet이 작동하지 않는 상태라 파드는 삭제되지 않는다.
```
[root@m-k8s ~]# kubectl get pod
NAME        READY   STATUS        RESTARTS   AGE
nginx-pod   1/1     Terminating  0          16m 
<none> 
```

<br/>

8. 내용을 확인했으니 w2-k8s에서 systemctl start kubelet을 실행해 kubelet을 복구한다.
```
[root@w2-k8s ~]# systemctl start kubelet
```

<br/>

9. 잠시 후에 m-k8s에서 kubelet get pod 명령을 실행해 nginx-pod가 삭제됐는지 확인한다.
```
[root@m-k8s ~]# kubectl get pod
No resources found in default namespace.
```
- kubelet에 문제가 생기면 파드가 제대로 관리되지 않음을 확인했다.

<br/><br/>

#### kube-proxy
- kubelet이 파드의 상태를 관리한다면 kube-proxy는 파드의 통신을 담당한다. 앞서 config.sh 파일에서 br_netfilter 커널 모듈을 적재하고 iptables를 거쳐 통신하도록 설정했다.
- config.sh의 kube-proxy 관련 부분
```
cat <<EOF > /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
modprobe br_netfilter
```

<br/>

- 그런데 이 설정이 정상적으로 작동하지 않는다면, 즉 kube-proxy에 문제가 생기면 어떻게 될까? 지금부터 확인해 보자.

<br/>

1. 테스트하기 위해 마스터 노드인 m-k8s에서 다시 파드를 배포한다.
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.1.6/nginx-pod.yaml
pod/nginx-pod created
```

<br/>


2. kubectl get pod -o wide 명령으로 파드의 IP와 워커 노드를 확인한다.
```
[root@m-k8s ~]# kubectl get pod -o wide
NAME        READY   STATUS    RESTARTS   AGE   IP               NODE     …
nginx-pod   1/1     Running   0          21s   172.16.103.130  w2-k8s   …
```

<br/>

3. curl(client URL)로 파드의 전 단계에서 확인한 파드의 IP로 nginx 웹 서버 메인 페이지 내용을 확인한다.
```
[root@m-k8s ~]# curl 172.16.103.130
<!DOCTYPE html>
<html>
<head>
<title>Welcome to nginx!</title>
```

<br/>

4. 이제 w2-k8s(실제로 앞의 배포 명령에 나온 노드로 접속)에 접속해 modprobe -r br_netfilter 명령으로 파드가 위치한 워커 노드에서 br_netfilter 모듈을 제거한다. 여기서 -r은 remove를 의미한다. 그리고 네트워크를 다시 시작해 변경된 내용을 적용한다. 이렇게 kube-proxy에 문제가 생기는 상황을 만든다.
```
[root@w2-k8s ~]# modprobe -r br_netfilter
[root@w2-k8s ~]# systemctl restart network
```

<br/>

5. m-k8s에서 다시 한 번 curl로 파드의 nginx 웹 서버 페이지 정보를 받아온다. 한참이 지나도 파드에서 정보를 받아오지 못했다면 Ctrl+C로 요청을 종료한다.
```
[root@m-k8s ~]# curl 172.16.103.130
curl: (7) Failed connect to 172.16.103.130:80; Connection timed out
^C 
```

<br/>

6. kubectl get pod -o wide를 실행해 파드 상태를 확인힌다.
```
[root@m-k8s ~]# kubectl get pod -o wide
NAME        READY   STATUS    RESTARTS   AGE     IP               NODE      …
nginx-pod   1/1     Running  0          9m59s   172.16.103.130   w2-k8s   …
```
- 파드의 노드 위치와 IP가 변경되지 않았는지, 작동 상태에 문제가 없는지 확인한다. kubelet을 통해 확인된 파드의 노드 위치와 IP는 그대로고, 상태도 작동 중(Running)으로 문제가 없는 것처럼 보인다. 하지만 kube-proxy가 이용하는 br_netfilter에 문제가 있어서 파드의 nginx 웹 서버와의 통신만이 정상적으로 이루어지지 않는(curl로 nginx 서버에 접속했으나 연결이 되지 않음, Connection timed out) 상태다.

<br/>

7. 정상적으로 파드의 nginx 웹 서버 페이지 정보를 받아올 수 있는 상태로 만들어 보자. 워커 노드에서 modprobe br_netfilter 명령을 실행해 br_netfilter를 커널에 적재하고 시스템을 다시 시작해 적용한다.
```
[root@w2-k8s ~]# modprobe br_netfilter
[root@w2-k8s ~]# reboot
```

<br/>

8. 일정 시간이 지난 후에 m-k8s에서 파드의 상태를 확인하면 파드가 1회 다시 시작했다는 의미로 RESTARTS가 1로 증가하고 IP가 변경된 것을 확인할 수 있다.
```
[root@m-k8s ~]# kubectl get pod -o wide
NAME        READY   STATUS    RESTARTS   AGE   IP                NODE     …
nginx-pod   1/1     Running   1         14m   172.16.103.131   w2-k8s   …
```

<br/>

9. 바뀐 IP로 curl 명령을 실행해 파드로부터 정보를 정상적으로 받아오는지 확인한다.
```
[root@m-k8s ~]# curl 172.16.103.131
<!DOCTYPE html>
<html>
<head>
<title>Welcome to nginx!</title>
[생략]
```

<br/>

10. 다음 내용을 진행하기 위해 배포한 파드를 삭제(delete)한다.
```
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.1.6/nginx-pod.yaml
pod "nginx-pod" deleted
```

<br/>

**쿠버네티스를 구성했으니 실제로 쿠버네티스를 이용해 어떤 일을 할 수 있는지 여러 가지 기능을 직접 실습하며 배워보자.

<br/><br/><br/><br/>

## 3.2 쿠버네티스 기본 사용법 배우기
- 이제부터 나오는 모든 실습 파일은 홈 디렉터리(~)에 `_Book_k8sInfra` 디렉터리 아래 각 장(ch)별로 위치하므로 해당 디렉터리에서 필요한 실습 파일을 찾아 진행한다.
```
[root@m-k8s ~]# ls ~/_Book_k8sInfra
app ch2 ch3 ch4 ch5 ch6
```

<br/>

### 3.2.1 파드를 생성하는 방법
- 쿠버네티스를 사용한다는 것은 결국 사용자에게 효과적으로 파드를 제공한다는 뜻이다. 따라서 가장 먼저 파드를 생성해 보자.

<br/>

- 사실 이미 구성 요소의 기능을 검증할 때 깃허브에서 내려받은 실습 파일을 통해 nginx 웹 서버 파드를 생성하고 삭제해 봤다. 그런데 방법이 조금 복잡했다. 파드를 더 간단하게 생성하는 방법은 없을까?

<br/>

- 당연히 있다. kubectl run 명령을 실행하면 쉽게 파드를 생성할 수 있다. 다음 명령에서 run 다음에 나오는 nginx는 파드의 이름이고, --image=nginx는 생성할 이미지의 이름이다.

```
[root@m-k8s ~]# kubectl run nginx-pod --image=nginx
pod/nginx-pod created
```

<br/>

- 파드가 잘 생성됐는지 kubectl get pod 명령으로 확인한다.
```
[root@m-k8s ~]# kubectl get pod
NAME READY STATUS RESTARTS AGE
nginx-pod 1/1 Running 0 35s
```

<br/>

- 이렇게 쉽게 파드를 생성할 수 있는데, 왜 그동안 어렵게 kubectl create라는 명령을 사용했을까?
- create로 파드를 생성해서 run 방식과 비교해 보자.

<br/>

- kubectl run과 동일하게 kubectl create로 파드를 생성한다.
```
[root@m-k8s ~]# kubectl create nginx --image=nginx
Error: unknown flag: --image
[생략]
```

<br/>

- --image라는 옵션이 없다는 에러 메시지만 나오고 파드는 생성되지 않았다. create로 파드를 생성하려면 kubectl create에 deployment를 추가해서 실행해야 한다. 이때 기존 파드 이름인 nginx와 중복을 피하고자 파드의 이름을 dpy-nginx로 지정해 생성한다.

```
[root@m-k8s ~]# kubectl create deployment dpy-nginx --image=nginx
deployment.apps/dpy-nginx created
```

<br/>

- 생성된 파드(dpy-nginx-7cd4d79cc9-xmv28)를 확인한다.

```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dpy-nginx-7cd4d79cc9-xmv28  1/1     Running   0          50s
nginx-pod                    1/1     Running   0          87s 
```

<br/>

- 이름에서 dpy-nginx를 제외한 나머지 부분은 무작위로 생성되므로 직접 실행했을 때는 이름이 다를 수 있다.

<br/>

- 두 가지 방식으로 생성한 파드가 모두 제대로 돌아가는지 확인해 보자. 먼저 kubectl get pods -o wide 명령으로 생성된 파드의 IP를 확인한다.

```
[root@m-k8s ~]# kubectl get pods -o wide
NAME                        READY   STATUS    RESTARTS   AGE     IP               NODE     NOMINATED NODE   READINESS GATES
dpy-nginx-7cd4d79cc9-xmv28  1/1     Running   0          72s     172.16.221.129  w1-k8s   <none>           <none>
nginx-pod                   1/1     Running   0          109s    172.16.103.132  w2-k8s   <none>           <none> 
```

<br/>

- 각 파드에서 curl 명령을 실행해 웹 페이지 정보를 받아오는지 확인합니다.
```
[root@m-k8s ~]# curl 172.16.221.129
<!DOCTYPE html>
<html>
<head>
<title>Welcome to nginx!</title>
[생략]

[root@m-k8s ~]# curl 172.16.103.132
<!DOCTYPE html>
<html>
<head>
<title>Welcome to nginx!</title>
[생략]
```

<br/>

- 두 파드의 nginx 웹 페이지가 정상적으로 작동하는 것을 확인했다. 그렇다면 run과 create deployment로 파드를 생성한 것은 무슨 차이가 있을까?

<br/>

- run으로 파드를 생성하면 단일 파드 1개만 생성되고 관리된다. 그리고 create deployment로 파드를 생성하면 디플로이먼트(Deployment)라는 관리 그룹 내에서 파드가 생성된다. 비유를 들자면, run으로 생성한 파드는 초코파이 1개이고, create deployment로 생성한 파드는 초코파이 상자에 들어 있는 초코파이 1개다.

![image](https://user-images.githubusercontent.com/61584142/161214323-2a04b3fa-6378-4682-bc98-653da345be68.png)

<br/>

**그럼 파드와 디플로이먼트가 실제로 어떻게 구성돼 있는지, 디플로이먼트는 어떻게 파드를 관리하는지 알아보자.

<br/>

#### 쿠버네티스 1.18 버전 이전에는 run이 어떻게 작동했을까?
- 쿠버네티스 1.18 이전 버전에서 run으로 생성되는 기본 파드는 디플로이먼트로 생성됐다. 하지만 run과 create로 생성한 결과에 차이가 없어서 최근에는 대부분 create로 파드를 생성하지만 간단한 테스트가 목적이라면 run으로 단순 파드를 생성할 수도 있다. 1.18 이전 버전에서도 run으로 파드를 생성하면 다음과 같이 DEPRECATED(더 이상 사용을 권고하지 않음)를 표시하며 run --generator=run-pod/v1이나 create를 사용하도록 권고하고 있다.
```
[root@m-k8s ~]# kubectl run nginx --image=nginx
kubectl run --generator=deployment/apps.v1 is DEPRECATED and will be removed in a future version. Use kubectl run --generator=run-pod/v1 or kubectl create instead.
deployment.apps/nginx created
```

<br/>

- 1.18 이전 버전에서 run 명령으로 파드를 생성하려면 --generator=run-pod/v1 옵션이 필요하다.
```
[root@m-k8s ~]# kubectl run nginx-run --image=nginx --generator=run-pod/v1
pod/nginx-run created
```

<br/><br/>

### 3.2.2 오브젝트란
- 쿠버네티스를 사용하는 관점에서 파드와 디플로이먼트는 스펙(spec)과 상태(status) 등의 값을 가지고 있다. 이러한 값을 가지고 있는 파드와 디플로이먼트를 개별 속성을 포함해 부르는 단위를 **오브젝트(Object)** 라고 한다. 쿠버네티스는 여러 유형의 오브젝트를 제공하는데, 먼저 기본 오브젝트부터 살펴보자.

<br/>

**기본 오브젝트
- 기본 오브젝트에는 다음 네 가지가 있다.

<br/>

#### 파드(Pod)
- 쿠버네티스에서 실행되는 최소 단위, 즉 웹 서비스를 구동하는 데 필요한 최소 단위다. 독립적인 공간과 사용 가능한 IP를 가지고 있다. 하나의 파드는 1개 이상의 컨테이너를 갖고 있기 때문에 여러 기능을 묶어 하나의 목적으로 사용할 수도 있다. 그러나 범용으로 사용할 때는 대부분 1개의 파드에 1개의 컨테이너를 적용한다(차이가 조금 있으나 우선 1개라고 이해하자)

<br/>

#### 네임스페이스(Namespaces)
- 쿠버네티스 클러스터에 사용되는 리소스들을 구분해 관리하는 그룹이다. 예를 들어 여기서는 3가지 네임스페이스를 사용한다. 특별히 지정하지 않으면 기본으로 할당되는 default, 쿠버네티스 시스템에서 사용되는 kube-system, 온프레미스에서 쿠버네티스를 사용할 경우 외부에서 쿠버네티스 클러스터 내부로 접속하게 도와주는 컨테이너들이 속해 있는 metallb-system이 있다.

<br/>

#### 볼륨(Volume)
- 파드가 생성될 때 파드에서 사용할 수 있는 디렉터리를 제공한다. 기본적으로 파드는 영속되는 개념이 아니라 제공되는 디렉터리도 임시로 사용한다. 하지만 파드가 사라지더라도 저장과 보존이 가능한 디렉터리를 볼륨 오브젝트를 통해 생성하고 사용할 수 있다.

<br/>

#### 서비스(Service)
- 파드는 클러스터 내에서 유동적이기 때문에 접속 정보가 고정일 수 없다. 따라서 파드 접속을 안정적으로 유지하도록 서비스를 통해 내/외부로 연결된다. 그래서 서비스는 새로 파드가 생성될 때 부여되는 새로운 IP를 기존에 제공하던 기능과 연결해준다. 쉽게 설명하면 쿠버네니트 외부에서 쿠버네티스 내부로 접속할 때 내부가 어떤 구조로 돼 있는지, 파드가 살았는지 죽었는지 신경쓰지 않아도 이를 논리적으로 연결하는 것이 서비스이다. 기존 인프라에서 로드밸런서, 게이트웨이와 비슷한 역할을 한다. 서비스라는 이름 때문에 처음에 개념을 이해하기가 매우 어렵다.

<br/>

#### 기본 오브젝트를 그림으로 표현

![image](https://user-images.githubusercontent.com/61584142/161370093-d374544e-3ca5-4391-8fb2-26672151e4fe.png)

<br/><br/>

**디플로이먼트
- 기본 오브젝트만으로도 쿠버네티스를 사용할 수 있다. 하지만 한계가 있어서 이를 좀 더 효율적으로 작동하도록 기능들을 조합하고 추가해 구현한 것이 디플로이먼트(Deployment)이다. 이외에도 데몬셋(DaemonSet), 컨피그맵(ConfigMap), 레플리카셋(ReplicaSet), PV(PersistentVolume), PVC(PersistentVolumeClaim), 스테이트풀셋(StatefulSet) 등이 있으며, 앞으로도 요구 사항에 따라 목적에 맞는 오브젝트들이 추가될 것이다.

<br/>

- 쿠버네티스에서 가장 많이 쓰이는 디플로이먼트 오브젝트는 파드에 기반을 두고 있으며, 레플리카셋 오브젝트를 합쳐 놓은 형태이다. 참고로 레플리카셋은 레플리케이션컨트롤러(ReplicationController)가 발전한 형태지만, 현재는 레플리카셋만 알면 된다. 

<br/>

#### 디플로이먼트 오브젝트의 계층 구조

![image](https://user-images.githubusercontent.com/61584142/161373056-9c80103b-9e2c-4cc8-bc8d-f44e3a15d003.png)

<br/>

- 실제로 API 서버와 컨트롤러 매너지는 단순히 파드가 생성되는 것을 감시하는 것이 아니라 디플로이먼트처럼 레플리카셋을 포함하는 오브젝트의 생성을 감시한다.

<br/>

#### API 서버와 컨트롤러 매니저의 통신

![image](https://user-images.githubusercontent.com/61584142/161373107-1fb278ad-5ec0-46e7-b7be-6fbad4b84e50.png)

<br/>

- 이처럼 쿠버네티스의 오브젝트는 다소 복잡하고 아직도 진화하고 있기 때문에 한 번에 모든 것을 이해하기는 매우 어렵다. 또한 쿠버네티스의 오브젝트는 생태계 변화에 따라 계속 변화하므로 모든 것을 외울 필요는 없다. 필요한 부분을 찾아 읽어보고 적재적소에 필요한 오브젝트를 사용하는 것이 현명하다.

<br/>

#### 쿠버네티스에서 사용하는 NGINX 이미지는 어디서 가져오나요?
- 컨테이너로 도커를 사용하므로 도커의 기본 저장소인 `도커 허브(https://hub.docker.com/_/nginx)`에서 이미지를 가지고 온다.

![image](https://user-images.githubusercontent.com/61584142/161373213-f5eb1a43-c989-476f-908d-60bad92b1bef.png)

<br/>

- 클라우드 서비스를 이용하고 있다면 기본 저장소 외에도 클라우드 서비스 업체에서 제공하는 저장소를 사용할 수도 있다. 구글의 GCR(Google Container Registry), 아마존의 ECR(Elastic Container Registry), 마이크로소프트의 ACR(Azure Container Registry) 등이 대표적이다. 또한 온프레미스는 내부 데이터 센터에 따로 저장소를 설정해 사용하는 방법도 있다.

<br/>

- 그러면 간단히 디플로이먼트를 생성하고 삭제해 보자. 먼저 저장소에서 필요한 이미지를 내려받아 디플로이먼트를 생성한다. 이미지 경로는 간단하게 sysnet4admin/echo-hname으로 지정하는데, 이때 sysnet4admin은 계정 이름이고, echo-hname은 이미지 이름이다.

```
[root@m-k8s ~]# kubectl create deployment dpy-hname --image=sysnet4admin/echo-hname
deployment.apps/dpy-hname created
```

<br/>

- kubectl get pods 명령으로 생성된 디플로이먼트(dpy-hname)를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dpy-hname-74c94fb7f6-ttvhm  1/1     Running   0          28s
dpy-nginx-7cd4d79cc9-xmv28   1/1     Running   0          3m17s
nginx-pod                    1/1     Running   0          3m54s 
```

<br/>

- create를 delete로 변경하고, --image 부분을 제외하면 생성했던 디플로이먼트(dpy-hname)가 삭제된다.
```
[root@m-k8s ~]# kubectl delete deployment dpy-hname
deployment.apps "dpy-hname" deleted
```

<br/>

- kubectl get pods 명령을 실행해 디플로이먼트(dpy-hname)가 삭제됐는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dpy-nginx-7cd4d79cc9-xmv28   1/1     Running   0          4m19s
nginx-pod                    1/1     Running   0          4m56s 
```

<br/>

- 디플로이먼트를 생성하고 삭제도 해봤지만, 디플로이먼트를 왜 생성하는지 잘 이해되지 않을 것이다. 그러면 디플로이먼트가 왜 필요한지 알아보자.

<br/><br/>

### 3.2.3 레플리카셋으로 파드 수 관리하기
- 많은 사용자를 대상으로 웹 서비스를 하려면 다수의 파드가 필요한데, 이를 하나씩 생성한다면 매우 비효율적이다. 그래서 쿠버네티스에서는 다수의 파드를 만드는 레플리카셋 오브젝트를 제공한다.

<br/>

- 예를 들어 파드를 3개 만들겠다고 레플리카셋에 선언하면 컨트롤러 매니저와 스케줄러가 워커 노드에 파드 3개를 만들도록 선언한다. 그러나 레플리카셋은 파드 수를 보장하는 기능만 제공하기 때문에 롤링 업데이트 기능 등이 추가된 디플로이먼트를 사용해 파드 수를 관리하기를 권장한다.

<br/>

#### 레플리카셋으로 파드 수를 관리하는 과정
- 레플리카셋으로 총 3개의 파드 상태로 변경됨

![image](https://user-images.githubusercontent.com/61584142/161373330-42987d1b-d706-4adf-b9c9-0dbc1ef8c921.png)

<br/>

- 그림에서 보듯이 레플리카셋은 파드의 개수를 지정한 대로 3개로 맞춰주는 역할을 한다. 설명만 봐서는 이해하기 어려우니 실제로 이 과정이 어떻게 이루어지는지 확인해 보자.

<br/>

1. 먼저 배포된 파드의 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dpy-nginx-7cd4d79cc9-xmv28   1/1     Running   0          5m15s
nginx-pod                    1/1     Running   0          5m52s 
```

<br/>

2. nginx-pod를 scale 명령으로 3개로 증가시킨다. 여기서 --replicas=3은 파드의 수를 3개로 맞추는 옵션이다.
```
[root@m-k8s ~]# kubectl scale pod nginx-pod --replicas=3
Error from server (NotFound): the server could not find the requested resource
```
- 실행해 보니 리소스를 찾을 수 없다는 에러 메시지가 나오면서 실행되지 않는다. nginx-pod는 파드로 생성됐기 때문에 디플로이먼트 오브젝트에 속하지 않는다. 그래서 리소스를 확인할 수 없다는 에러가 발생한 것이다.

<br/>

3. 이번에는 디플로이먼트로 생성된 dpy-nginx를 scale 명령과 --replicas=3 옵션으로 파드의 수를 3개로 만든다.
```
[root@m-k8s ~]# kubectl scale deployment dpy-nginx --replicas=3
deployment.apps/dpy-nginx scaled
```

<br/>

4. scale 명령으로 추가된 2개의 nginx 파드를 확인한다. 최근에 생성된 파드는 생성 시간(AGE)이 짧다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
dpy-nginx-7cd4d79cc9-xmv28   1/1     Running   0          7m19s
dpy-nginx-7cd4d79cc9-xdbvx  1/1     Running   0          11s
dpy-nginx-7cd4d79cc9-td8nk  1/1     Running   0          11s
nginx-pod                    1/1     Running   0          7m9s 
```

<br/>

5. dpy-nginx의 모든 파드가 정상적으로 워커 노드에 적용되고 IP가 부여됐는지 kubectl get pods -o wide 명령으로 확인한다.
```
[root@m-k8s ~]# kubectl get pods -o wide 
NAME                         READY   STATUS    …   AGE     IP              NODE   …
dpy-nginx-7cd4d79cc9-td8nk   1/1     Running   …   39s     172.16.132.3    w3-k8s …
dpy-nginx-7cd4d79cc9-xdbvx   1/1     Running   …   39s     172.16.103.134  w2-k8s …
dpy-nginx-7cd4d79cc9-xmv28   1/1     Running   …   7m47s   172.16.221.129  w1-k8s …
nginx-pod                    1/1     Running   …   8m24s   172.16.103.132  w2-k8s …
```

<br/>

6. 다음 진행을 위해 생성한 디플로이먼트 dpy-nginx를 삭제(delete)한다.
```
[root@m-k8s ~]# kubectl delete deployment dpy-nginx
deployment.apps "dpy-nginx" deleted
```

<br/>

7. 삭제한 후에 배포된 파드 또는 디플로이먼트의 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME        READY   STATUS    RESTARTS   AGE
nginx-pod   1/1     Running   0          10m
```

<br/>

#### 명령어의 단수와 복수 표현
- 명령어가 kubectl get pod에서 kubectl get pods로 바뀐 것을 알아챘는가? 이것은 실수가 아니라 pod와 pods 모두 똑같이 작동함을 보여주고자 일부러 바꿨다. 쿠버네티스는 사람이 실수한 부분도 alias(별칭)으로 처리해 유연하게 명령어를 사용할 수 있께 한다. 이것은 노드(node)에도 동일하게 적용된다. 다음 명령에서 노드가 복수(4개)임에도 node(단수)로 표시해도 문제없이 실행되는 것을 볼 수 있다.
```
[root@m-k8s ~]# kubectl get node
NAME     STATUS   ROLES    AGE    VERSION
m-k8s    Ready    master   110m   v1.18.4
w1-k8s   Ready    <none>   105m   v1.18.4
w2-k8s   Ready    <none>   100m   v1.18.4
```

- 사실 쿠버네티스는 클러스터 구조여서 단일 노드와 파드만 사용하는 경우는 흔하지 않다. 일반적으로 명령어를 복수형으로 사용해도 별 문제없다.

<br/><br/>

### 3.2.4 스펙을 지정해 오브젝트 생성하기
- kubectl create deployment 명령으로 디플로이먼트를 생성하긴 했지만, 1개의 파드만 만들어졌을 뿐이다. 디플로이먼트를 생서하면서 한꺼번에 여러 개의 파드를 만들 순 없을까? create에서는 replicas 옵션을 사용할 수 없고, scale은 이미 만들어진 디플로이먼트에서만 사용할 수 있다.

<br/>

- 이런 설정을 적용하려면 필요한 내용을 파일로 작성해야 한다. 이때 작성하는 파일을 오브젝트 스펙(spec)이라고 한다. 오브젝트 스펙은 일반적으로 야믈(YAML) 문법으로 작성한다. 최근 상용과 오픈소스 기술들은 스펙과 상태 값을 주로 야믈로 작성하므로 야믈 문법에 익숙해지는 것이 좋다.

<br/>

#### YAML
- YAML은 약어인데, 의미가 재밌다. 처음에는 '또 다른 마크업 언어(Yet Another Markup Language)'의 약어였다. 그러나 공식 사이트(http://www.yaml.org)에서 데이터의 내용을 쉽게 파악할 수 있는 표준이라고 설명하며 '야믈은 단순히 마크업 언어가 아니다(YAML Ain't Markup Language)'라고 다시 정의했다. 여기서 마크업(Markup)이란 문서나 데이터의 구조를 태그를 이용해 기술하는 것을 의미한다. 익히 알고 있는 HTML(HyperText Markup Language)이 가장 유명한 마크업 언어 중 하나이다.

<br/>

- 그러면 3개의 nginx 파드를 디플로이먼트 오브젝트로 만들어 보겠다. 명령어로는 3개의 파드를 가진 디플로이먼트를 만들 수 없으므로 오브젝트 스펙을 작성해 디플로이먼트를 만든다.

<br/>

- 디플로이먼트의 오브젝트 스펙을 처음부터 만들기는 어려우니 `~/_Book_k8sInfra/ch3/3.2.4 디렉터리의 예제 파일(echo-hname.yaml)`을 사용한다. 파일 내용은 다음과 같다.

```
apiVersion: apps/v1 # API 버전
kind: Deployment # 오브젝트 종류
metadata:
  name: echo-hname
  labels:
    app: nginx
spec:
  replicas: 3 # 몇 개의 파드를 생성할지 결정
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: echo-hname
        image: sysnet4admin/echo-hname # 사용되는 이미지
```

- apiVersion은 오브젝트를 포함하는 API 버전을 의미한다. 일반적으로 알파(alpht)와 베타(beta) 버전은 안정적이지 않다고 보지만, 그만큼 풍부한 기능을 갖고 있기도 하다. 여기서 사용하는 apss/v1은 여러 종류의 kind(오브젝트)를 가지고 있는데, 그중에서 Deployment를 선택해 레플리카셋을 생성한다. 레플리카셋은 몇 개의 파드를 생성할지 replicas로 결정한다. 이미지는 sysnet4admin/echo-hname을 사용한다.

<br/>

#### 사용 가능한 API 버전을 확인하려면?
- 쿠버네티스에서 사용 가능한 API 버전은 kubectl api-versions 명령으로 확인할 수 있다. 쿠버네티스 버전에 따라 사용 가능한 API 버전이 다르니 작성하기 전에 확인해야한다.
```
[root@m-k8s ~]# kubectl api-versions
admissionregistration.k8s.io/v1
admissionregistration.k8s.io/v1beta1
apiextensions.k8s.io/v1
apiextensions.k8s.io/v1beta1
apiregistration.k8s.io/v1
apiregistration.k8s.io/v1beta1
 
[중략]
 
node.k8s.io/v1beta1
policy/v1beta1
rbac.authorization.k8s.io/v1
rbac.authorization.k8s.io/v1beta1
scheduling.k8s.io/v1
scheduling.k8s.io/v1beta1
storage.k8s.io/v1
storage.k8s.io/v1beta1
v1
```

<br/>

#### echo-hname.yaml 파일의 구조

![image](https://user-images.githubusercontent.com/61584142/161374515-bfbb0dec-2014-4517-8375-ee86484e8ba5.png)

<br/>

- 파일 구조를 명확하게 파악하기 위해 앞에서 생성한 파드의 스펙과 비교해 보자. 이전에 배포한 nginx-pod.yaml 파일을 살펴보면 디플로이먼트인 echo-hname.yaml의 template 부분과 동일함을 알 수 있다. 즉, template 하위의 metadata와 spec이 nginx-pod.yaml에서 동일하게 사용된다.
- nginx-pod.yaml
```
apiVersion: v1
kind: Pod
metadata:
  name: nginx-pod
spec:
  containers:
  - name: container-name
    image: nginx
```

<br/>

- 위의 스펙을 정리하면 다음과 같다. (nginx-pod.yaml 파일의 구조)
![image](https://user-images.githubusercontent.com/61584142/161374550-e3962ccd-afed-49bb-a98f-69239c24241a.png)

<br/>

- 쿠버네티스 API 버전마다 포함되는 오브젝트(kind)도 다르고 요구하는 내용도 다르다. 그러므로 처음부터 모든 내용을 숙지하기보다는 기존에 만들어진 파일을 수정하면서 이해해보고 필요한 내용을 그때마다 정리하는 것이 좋다.

<br/>

1. echo-hname.yaml 파일을 이용해 디플로이먼트를 생성해 보자. 현재 디플로이먼트는 파드 3개를 생성하도록 replicas에 정의돼 있다. 이 부분은 ‘3.2.3 레플리카셋으로 파드 수 관리하기’에 설명돼 있으니 참고한다.
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.2.4/echo-hname.yaml
deployment.apps/echo-hname created
```

<br/>

2. 새로 생성된 echo-hname 파드가 3개인지 확인한다.
```
[root@m-k8s ~]# kubectl get pods 
NAME                         READY   STATUS    RESTARTS   AGE
echo-hname-5d754d565-7bzfs   1/1     Running   0          2m6s
echo-hname-5d754d565-g7tl5   1/1     Running   0          2m6s
echo-hname-5d754d565-lksqr   1/1     Running   0          2m6s
nginx-pod                    1/1     Running   0          19m
```

<br/>

3. 디플로이먼트를 생성했으니 이번에는 echo-hname.yaml 파일을 수정해 파드를 6개로 늘려보자. 파일에서 replicas의 값을 3에서 6으로 변경한다. 이때 사용하는 명령어는 sed(streamlined editor)다. 그 뒤에 몇 가지 옵션이 따라온다. -i는 --in-place의 약어로, 변경한 내용을 현재 파일에 바로 적용하겠다는 의미이며, s/는 주어진 패턴을 원하는 패턴으로 변경하겠다는 의미다. 여기서는 replicas: 3을 replicas: 6으로 변경한다. sed 사용이 어렵다면 Vim으로 직접 파일을 수정해도 된다.
```
[root@m-k8s ~]# sed -i 's/replicas: 3/replicas: 6/' ~/_Book_k8sInfra/ch3/3.2.4/echo-hname.yaml
```

<br/>

4. replicas의 값이 3에서 6으로 변경됐는지 확인한다.
```
[root@m-k8s ~]# cat ~/_Book_k8sInfra/ch3/3.2.4/echo-hname.yaml | grep replicas
replicas: 6
```

<br/>

5. 변경된 내용을 적용합니다.
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.2.4/echo-hname.yaml
Error from server (AlreadyExists): error when creating "echo-hname.yaml": deployments.apps "echo-hname" already exists
```

- ‘echo-hname이 이미 존재한다’는 에러 메시지가 나오면서 아무 일도 일어나지 않는다. 물론 scale 명령으로 파드 수를 늘릴 수 있지만, 파일로 디플로이먼트의 파드 수를 늘리는 것은 불가능할까? 배포된 오브젝트의 스펙을 변경하고 싶을 때는 어떻게 해야 할까? 지우고 다시 만드는 방법밖에 없을까? 바로 확인해 보자.

<br/><br/>

### 3.2.5 apply로 오브젝트 생성하고 관리하기
- run은 파드를 간단하게 생성하는 매우 편리한 방법이다. 하지만 run으로는 단일 파드만을 생성할 수 있다. 따라서 run을 모든 상황에 적용해 사용하기는 어렵다. 그렇다고 create로 디플로이먼트를 생성하면 앞에서 확인한 것처럼 파일의 변경 사항을 바로 적용할 수 없다는 단점이 있다. 이런 경우를 위해 쿠버네티스는 apply라는 명령어를 제공한다. 그러면 apply로 오브젝트를 관리해 보자.

<br/>

1. replicas를 6으로 수정한 echo-hname.yaml 파일을 kubectl apply 명령으로 적용한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.2.4/echo-hname.yaml
Warning: kubectl apply should be used on resource created by either kubectl create --save-config or kubectl apply
deployment.apps/echo-hname configured
```

- 오브젝트를 처음부터 apply로 생성한 것이 아니어서 경고가 뜬다. 경고가 떠도 작동에는 문제가 없지만 일관성에서 문제가 생길 수 있다. 이처럼 변경 사항이 발생할 가능성이 있는 오브젝트는 처음부터 apply로 생성하는 것이 좋다.

<br/>

2. 명령이 적용된 후에 echo-hname이 6개로 늘어났는지 확인함다. 특히 AGE를 확인해 최근에 추가된 파드 3개를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
echo-hname-5d754d565-7bzfs   1/1     Running   0          3m32s
echo-hname-5d754d565-8759n   1/1     Running   0          9s
echo-hname-5d754d565-dbt29   1/1     Running   0          9s
echo-hname-5d754d565-g7tl5   1/1     Running   0          3m32s
echo-hname-5d754d565-jl2c6   1/1     Running   0          9s
echo-hname-5d754d565-lksqr   1/1     Running   0          3m32s
nginx-pod                    1/1     Running   0          20m 
```

<br/>

- kubectl apply를 사용하면 파일의 변경 사항도 쉽게 적용할 수 있다는 것을 확인했다. 앞에서 봤듯이 명령 창명령 창 등에 직접 애드혹(ad-hoc, 일회적 사용)으로 오브젝트를 생성할 때는 create를 사용하고, 변경이 생길 가능성이 있는 복잡한 오브젝트는 파일로 작성한 후 apply로 적용하는 것이 좋다.

<br/>

#### 오브젝트 생성 명령어 비교

![image](https://user-images.githubusercontent.com/61584142/161374797-a0c6dcd1-e5a8-455b-a6f5-d6eff0b98fd3.png)

<br/><br/>

### 3.2.6 파드의 컨테이너 자동 복구 방법
- 지금까지 파드의 디플로이먼트, 오브젝트들에 관해 알아봤다. 이제 본격적으로 배운 내용을 사용해 보자.

<br/>

- 쿠버네티스는 거의 모든 부분이 자동 복구되도록 설계됐다. 특히 파드의 자동 복구 기술을 셀프 힐링(Self-Healing)이라고 하는데, 제대로 작동하지 않는 컨테이너를 다시 시작하거나 교체해 파드가 정상적으로 작동하게 한다. 그럼 셀프 힐링 기능을 체감할 수 있는 테스트를 진행해 보자.

<br/>

1. 파드에 접속하려면 파드의 IP를 알아야 한다. kubectl get pods -o wide 명령으로 접속할 파드의 IP를 확인한다.
```
[root@m-k8s ~]# kubectl get pods -o wide
NAME                        …  STATUS    RESTARTS   AGE     IP              NODE   …
echo-hname-5d754d565-7bzfs  …  Running   0          4m39s   172.16.221.131  w1-k8s … 
echo-hname-5d754d565-8759n  …  Running   0          76s     172.16.103.136  w2-k8s …
echo-hname-5d754d565-dbt29  …  Running   0          76s     172.16.132.5    w3-k8s …
echo-hname-5d754d565-g7tl5  …  Running   0          4m39s   172.16.132.4    w3-k8s …
echo-hname-5d754d565-jl2c6  …  Running   0          76s     172.16.221.132  w1-k8s …
echo-hname-5d754d565-lksqr  …  Running   0          4m39s   172.16.103.135  w2-k8s …
nginx-pod                   …  Running   0          21m     172.16.103.132  w2-k8s …
```

<br/>

2. kubectl exec 명령을 실행해 파드 컨테이너의 셸(shell)에 접속한다. 명령에서 exec는 execute(실행)를 의미하며, i 옵션은 stdin(standard input, 표준 입력)이고, t는 tty (teletypewriter)1를 뜻한다. 이 두 개를 합친 it는 표준 입력을 명령줄 인터페이스로 작성한다는 의미가 된다. 그리고 파드인 nginx-pod에 /bin/bash를 실행해 nginx-pod의 컨테이너에서 배시(bash) 셸에 접속한다.
```
[root@m-k8s ~]# kubectl exec -it nginx-pod -- /bin/bash
root@nginx-pod:/#
```

<br/>

#### kubectl exec에서 '- -'의 의미
- '--'는 exec에 대한 인자 값을 나누고 싶을 때 사용한다. 이해하기 쉽게 예제를 보자. nginx-pod에서 /run의 내용을 보고 싶다면 파드 이름 뒤에 ls /run을 입력하면 된다. '--'를 사용할 때는 보이지 않던 DEPRECATED 메시지가 함께 표시된다.
```
[root@m-k8s ~]# kubectl exec -it nginx-pod ls /run
kubectl exec [POD] [COMMAND] is DEPRECATED and will be removed in a future version. Use kubectl kubectl exec [POD] -- [COMMAND] instead.
lock nginx.pid secrets utmp
```

<br/>

- 이번에는 /run의 권한을 보고 싶다면 어떻게 할까? -l(long listing format) 옵션을 붙여 확인하면 될 것 같다. 하지만 실행하면 다음과 같이 에러가 발생한다. 이는 -l을 exec의 옵션으로 인식하기 때문에 그렇다.
```
[root@m-k8s ~]# kubectl exec -it nginx-pod ls -l /run
Error: unknown shorthand flag: 'l' in -l
See 'kubectl exec --help' for usage.
```

<br/>

- 이런 경우에 명령어를 구분해야 하는데, 이때 '--'를 사용한다.
```
[root@m-k8s ~]# kubectl exec -it nginx-pod -- ls -l /run
total 4
drwxrwxrwt. 2 root root  6 Aug  3 07:00 lock
-rw-r--r--. 1 root root  2 Aug 12 02:06 nginx.pid
drwxr-xr-x. 4 root root 39 Aug 12 02:06 secrets
```

<br/>

- 이처럼 필요하지 않아도 exec를 사용할 때 명시적으로 '--'를 사용하면 에러를 줄일 수 있다. 그래서 '--'을 사용하지 않고 바로 명령을 실행하면 DEPRECATED를 표시해 향후 버전에서는 사용하지 못하게 하면서 명령어에 일관성을 주려는 것이다.

<br/><br/>

3. 배시 셸에 접속하면 컨테이너에서 구동하는 nginx의 PID(Process ID, 프로세서 식별자)를 확인한다. nginx의 PID는 언제나 1이다.
```
root@nginx-pod:/# cat /run/nginx.pid
1
```

<br/>

4. ls -l 명령으로 프로세스가 생성된 시간을 확인한다.
```
root@nginx-pod:/# ls -l /run/nginx.pid
-rw-r--r--. 1 root root 2 Feb 2 11:30 /run/nginx.pid
```

<br/>

5. 슈퍼푸티에서 m-k8s의 터미널을 1개 더 띄우고 이 터미널 화면에서 nginx-pod의 IP (172.16.103.132)에서 돌아가는 웹 페이지를 1초마다 한 번씩 요청하는 스크립트를 실행한다. curl에서 요청한 값만 받도록 --silent 옵션을 추가한다. 이 스크립트로 nginx의 상태도 체크한다.
```
[root@m-k8s ~]# i=1; while true; do sleep 1; echo $((i++)) `curl --silent 172.16.103.132 | grep title` ; done
```

<br/>

6. 배시 셸에서 nginx 프로세서인 PID 1번을 kill 명령으로 종료한다.
```
root@nginx-pod:/# kill 1
root@nginx-pod:/# command terminated with exit code 137
```

<br/>

7. 추가한 터미널에서 1초마다 nginx 웹 페이지를 받아오는 스크립트가 잘 작동하는지 확인하고, 자동으로 다시 복구되는지도 함께 확인한다. 테스트 화면은 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161374995-98cc7cdf-76e9-4eac-a3cb-42442633f589.png)

<br/>

8. nginx 웹 페이지가 복구되는 것을 확인한 후에 다시 nginx-pod에 접속한다. ls -l을 실행한다. nginx.pid가 생성된 시간으로 새로 생성된 프로세스인지 확인한다. 그리고 다음 진행을 위해서 exit 명령을 수행해 다시 m-k8s의 배시 셸로 나온다.
```
[root@m-k8s ~]# kubectl exec -it nginx-pod -- /bin/bash
root@nginx-pod:/# ls -l /run/nginx.pid
-rw-r--r--. 1 root root 2 Feb 2 11:32 /run/nginx.pid
root@nginx-pod:/# exit
exit
[root@m-k8s ~]#
```

<br/>

- nginx 프로세스는 몇 초만에 종료되고 바로 다시 실행되므로 생성 시간을 확인하기가 어려울 수 있다. 만약 정확하게 확인하지 못했다면 원래 터미널 창에서 다시 한 번 kill 1을 실행해 시간을 확인해 보자.

<br/><br/>

### 3.2.7 파드의 동작 보증 기능
- 쿠버네티스는 파드 자체에 문제가 발생하면 파드를 자동 복구해서 파드가 항상 동작하도록 보장하는 기능도 있다. 사실 이미 앞에서 이 기능을 경험했다. 자세히 살펴보자.

<br/>

1. 파드에 문제가 발생하는 상황을 만들기 위해 앞에서 생성한 파드를 삭제하겠다. 현재 어떤 파드들이 있는지 먼저 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
echo-hname-5d754d565-7bzfs   1/1     Running   0          9m44s
echo-hname-5d754d565-8759n   1/1     Running   0          6m21s
echo-hname-5d754d565-dbt29   1/1     Running   0          6m21s
echo-hname-5d754d565-g7tl5   1/1     Running   0          9m44s
echo-hname-5d754d565-jl2c6   1/1     Running   0          6m21s
echo-hname-5d754d565-lksqr   1/1     Running   0          9m44s 
nginx-pod                    1/1     Running   0          26m 
```

<br/>

2. kubectl delete pods nginx-pod를 실행해 nginx-pod를 삭제한다.
```
[root@m-k8s ~]# kubectl delete pods nginx-pod
pod "nginx-pod" deleted
```

<br/>

3. 파드의 동작을 보증하려면 어떤 조건이 필요하다. 어떤 조건인지 확인하기 위해 다른 파드도 삭제해 서로 비교해 보자. 파드 목록 중에서 가장 위에 있던 echo-hname-5d754d565-7bzfs(환경마다 이름은 다를 수 있음)를 삭제한다. 삭제 명령을 실행하면 기존에 nginx-pod를 삭제할 때보다 더 오래 걸린다.
```
[root@m-k8s ~]# kubectl delete pods echo-hname-5d754d565-7bzfs
pod "echo-hname-5d754d565-7bzfs" deleted
```

<br/>

4. 삭제가 잘 됐는지 kubectl get pods로 확인한다. 어찌된 영문인지 아직도 6개의 파드가 살아 있으며 그중 하나는 AGE를 봤을 때 최근에 생성된 것으로 보인다. 또한 앞에서 삭제한 echo-hname-5d754d565-7bzfs는 목록에 없다.
```
[root@m-k8s ~]# kubectl get pods
NAME                         READY   STATUS    RESTARTS   AGE
echo-hname-5d754d565-8759n   1/1     Running   0          7m35s
echo-hname-5d754d565-9zcnn   1/1     Running   0          38s
echo-hname-5d754d565-dbt29   1/1     Running   0          7m35s
echo-hname-5d754d565-g7tl5   1/1     Running   0          10m
echo-hname-5d754d565-jl2c6   1/1     Running   0          7m35s
echo-hname-5d754d565-lksqr   1/1     Running   0          10m
```

<br/>

- 이렇게 된 이유를 알아보자. nginx-pod는 디플로이먼트에 속한 파드가 아니며 어떤 컨트롤러도 이 파드를 관리하지 않는다. 따라서 nginx-pod는 바로 삭제되고 다시 생성되지도 않는다.

![image](https://user-images.githubusercontent.com/61584142/161375111-d65e9867-8bd9-4694-880e-25c8be1b83fb.png)

<br/>

- echo-hname은 디플로이먼트에 속한 파드다. 그리고 앞에서 echo-hname에 속한 파드를 replicas에서 6개로 선언했다. replicas는 파드를 선언한 수대로 유지하도록 파드의 수를 항상 확인하고 부족하면 새로운 파드를 만들어낸다. 따라서 임의로 파드를 삭제하면 replicas가 삭제된 파드를 확인하고 파드의 총 개수를 6개로 맞추기 위해서 새로운 파드 1개를 생성한다. 디플로이먼트에 속한 파드가 삭제되고 다시 생성되는 과정은 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161375133-4f6c6eec-b645-4f3a-807e-b6a3cbc3914a.png)

<br/>

- 이와 같이 디플로이먼트로 생성하는 것이 파드의 동작을 보장하기 위한 조건이다.

<br/>

- 파드의 동작 보증 기능을 마무리하면서 이렇게 파드가 자동 복구가 되면 디플로이먼트에 속한 파드는 어떻게 삭제할까? 디플로이먼트에 속한 파드를 삭제하는 방법도 알아보자.

<br/>

5. 디플로이먼트에 속한 파드는 상위 디플로이먼트를 삭제해야 파드가 삭제된다. kubectl delete deployment echo-hname 명령으로 디플로이먼트를 삭제한다.
```
[root@m-k8s ~]# kubectl delete deployment echo-hname
deployment.apps "echo-hname" deleted
```

<br/>

6. 디플로이먼트를 삭제한 후에 배포된 파드가 남아 있는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods
No resources found in default namespace.
```

<br/><br/>

### 3.2.8 노드 자원 보호하기
- 여러 가지 상황에서도 쿠버네티스는 파드를 안정적으로 작동하도록 관리한다는 것을 알았다. 그렇다면 노드는 어떤 식으로 관리할까? 우선 노드의 목적을 명확히 해야 한다. 노드는 쿠버네티스 스케줄러에서 파드를 할당받고 처리하는 역할을 한다.

<br/>

- 그런데 최근에 몇 차례 문제가 생긴 노드에 파드를 할당하면 문제가 생길 가능성이 높다. 하지만 어쩔 수 없이 해당 노드를 사용해야 한다면 어떻게 해야 할까? 이런 경우에는 영향도가 적은 파드를 할당해 일정 기간 사용하면서 모니터링해야 한다. 즉, 노드에 문제가 생기더라도 파드의 문제를 최소화해야 한다. 하지만 쿠버네티스는 모든 노드에 균등하게 파드를 할당하려고 한다. 그렇다면 **어떻게 문제가 생길 가능성이 있는 노드** 라는 것을 쿠버네티스에 알려줄까?

<br/>

- 쿠버네티스에는 이런 경우에 cordon 기능을 사용한다. cordon으로 노드를 어떻게 관리하는지 알아보자.

<br/>

1. 현재 배포된 파드가 없기 때문에 echo-hname.yaml을 적용해(apply) 파드를 생성한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.2.8/echo-hname.yaml
deployment.apps/echo-hname created
```

<br/>

2. scale 명령으로 배포한 파드를 9개로 늘린다.
```
[root@m-k8s ~]# kubectl scale deployment echo-hname --replicas=9
deployment.apps/echo-hname scaled
```

<br/>

3. 배포된 9개의 파드가 제대로 작동하는지, IP 할당이 잘 됐는지, 각 노드로 공평하게 배분됐는지를 확인한다. 이때 kubectl get pods -o wide 대신에 kubectl get pods -o=custom-columns를 사용한다. -o는 output을 의미하고, custom-columns는 사용자가 임의로 구성할 수 있는 열을 의미한다. 명령에서 NAME, IP, STATUS, NODE는 열의 제목이고, 콜론(:) 뒤에 내용 값인 .metadata.name, .status.podIP, .status.phase, .spec.nodeName을 넣고 콤마(,)로 구분한다. 내용 값을 어떻게 확인하는지는 이어서 나오는 ‘배포된 파드의 세부 값을 확인하는 법’을 참고하자.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                         IP               STATUS    NODE
echo-hname-5d754d565-69wgw   172.16.103.139   Running   w2-k8s
echo-hname-5d754d565-9t9s8   172.16.221.134   Running   w1-k8s
echo-hname-5d754d565-jdzrt   172.16.132.6     Running   w3-k8s
echo-hname-5d754d565-khrrr   172.16.132.8     Running   w3-k8s
echo-hname-5d754d565-qlk6f   172.16.103.138   Running   w2-k8s
echo-hname-5d754d565-qzs9v   172.16.221.136   Running   w1-k8s
echo-hname-5d754d565-qzvkv   172.16.103.137   Running   w2-k8s
echo-hname-5d754d565-rd9cf   172.16.221.135   Running   w1-k8s
echo-hname-5d754d565-sz5nm   172.16.132.7     Running   w3-k8s
```

<br/>

#### 배포된 파드의 세부 값을 확인하는 법
- 여러 방법이 있지만, 가장 간단한 방법은 배포된 파드의 내용을 YAML 형식으로 받아 내용을 보는 것이다.

<br/>

1. 배포된 파드 중에 하나(echo-hname-5d754d565-69wgw)를 선택하고 -o yaml 옵션으로 배포된 파드의 내용을 pod.yaml에 저장한다.
```
[root@m-k8s ~]# kubectl get pod echo-hname-5d754d565-69wgw -o yaml > pod.yaml
```

<br/>

2. vi(vim이 alias돼 있음)로 pod.yaml의 내용을 살펴본다.
```
[root@m-k8s ~]# vi pod.yaml
```

<br/>

3. 배포된 파드에서 확인하고 싶은 값은 다음과 같다. 왼쪽 숫자는 줄 번호이며, 오른쪽은 pods.yaml에서 확인할 수 있는 값이다.

![image](https://user-images.githubusercontent.com/61584142/161375352-a3f4c306-6f0d-4f78-b7a4-9f668792718d.png)

<br/>

4. scale로 파드의 수를 3개로 줄인다.
```
[root@m-k8s ~]# kubectl scale deployment echo-hname --replicas=3
deployment.apps/echo-hname scaled
```

<br/>

5. 각 노드에 파드가 1개씩만 남았는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                         IP               STATUS    NODE
echo-hname-5d754d565-9t9s8   172.16.221.134   Running   w1-k8s
echo-hname-5d754d565-jdzrt   172.16.132.6     Running   w3-k8s
echo-hname-5d754d565-qzvkv   172.16.103.137   Running   w2-k8s
```

<br/>

6. 그런데 w3-k8s 노드에서 문제가 자주 발생해 현재 상태를 보존해야 한다. w3-k8s 노드에 cordon 명령을 실행한다.
```
[root@m-k8s ~]# kubectl cordon w3-k8s
node/w3-k8s cordoned
```

<br/>

7. kubectl get nodes 명령을 실행해 cordon 명령이 제대로 적용됐는지 확인한다.
```
[root@m-k8s ~]# kubectl get nodes
NAME     STATUS                     ROLES    AGE    VERSION
m-k8s    Ready                      master   131m   v1.18.4
w1-k8s   Ready                      <none>   127m   v1.18.4
w2-k8s   Ready                      <none>   122m   v1.18.4
w3-k8s   Ready,SchedulingDisabled  <none>   117m   v1.18.4 
```

- w3-k8s가 더 이상 파드가 할당되지 않는 상태로 변경됐다. 이처럼 cordon 명령을 실행하면 해당 노드에 파드가 할당되지 않게 스케줄되지 않는 상태(SchedulingDisabled)라는 표시를 한다.

<br/>

8. 이 상태에서 파드 수를 9개로 늘린다.
```
[root@m-k8s ~]# kubectl scale deployment echo-hname --replicas=9
deployment.apps/echo-hname scaled
```

<br/>

9. 노드에 배포된 파드를 확인한다. 특히 w3-k8s에 추가로 배포된 파드가 있는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                         IP               STATUS    NODE
echo-hname-5d754d565-9t9s8   172.16.221.134   Running   w1-k8s
echo-hname-5d754d565-cg5w6   172.16.103.140   Running   w2-k8s
echo-hname-5d754d565-f947n   172.16.221.137   Running   w1-k8s
echo-hname-5d754d565-fr5v6   172.16.103.141   Running   w2-k8s
echo-hname-5d754d565-jdzrt   172.16.132.6     Running   w3-k8s
echo-hname-5d754d565-mb9z5   172.16.103.142   Running   w2-k8s
echo-hname-5d754d565-mcm97   172.16.221.138   Running   w1-k8s
echo-hname-5d754d565-qzvkv   172.16.103.137   Running   w2-k8s
echo-hname-5d754d565-zdp4d   172.16.221.139   Running   w1-k8s
```

- 파드 수가 w1-k8s는 4개, w2-k8s는 4개지만 w3-k8s는 여전히 1개인 것을 볼 수 있다. 이때 노드와 파드 상태는 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161375506-bdb2b549-c453-43fb-afbc-4f9c819cd464.png)

<br/>

10. 이번에는 파드 수를 3개로 줄인다.
```
[root@m-k8s ~]# kubectl scale deployment echo-hname --replicas=3
deployment.apps/echo-hname scaled
```

<br/>

11. 각 노드에 할당된 파드 수가 공평하게 1개씩인지 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME IP STATUS NODE
echo-hname-5d754d565-9t9s8 172.16.221.134 Running w1-k8s
echo-hname-5d754d565-jdzrt 172.16.132.6 Running w3-k8s
echo-hname-5d754d565-qzvkv 172.16.103.137 Running w2-k8s
```

<br/>

12. uncordon 명령으로 w3-k8s에 파드가 할당되지 않게 설정했던 것을 해제한다.
```
[root@m-k8s ~]# kubectl uncordon w3-k8s
node/w3-k8s uncordoned
```

<br/>

13. w3-k8s에 uncordon이 적용됐는지 kubectl get nodes 명령으로 확인한다.
```
[root@m-k8s ~]# kubectl get nodes
NAME STATUS ROLES AGE VERSION
m-k8s Ready master 134m v1.18.4
w1-k8s Ready <none> 129m v1.18.4
w2-k8s Ready <none> 125m v1.18.4
w3-k8s Ready <none> 120m v1.18.4
```

<br/>

- cordon 기능으로 문제가 발생할 가능성이 있는 노드를 스케줄되지 않게 설정해 봤다. 그렇다면 노드의 커널을 업데이트하거나 노드의 메모리를 증설하는 등의 작업이 필요해서 노드를 꺼야 할 때는 어떻게 하면 좋을까?

<br/><br/>

### 3.2.9 노드 유지보수하기
- 쿠버네티스를 사용하다 보면 정기 또는 비정기적인 유지보수를 위해 노드를 꺼야 하는 상황이 발생한다. 이런 경우를 대비해 쿠버네티스는 drain 기능을 제공한다. drain은 지정된 노드의 파드를 전부 다른 곳으로 이동시켜 해당 노드를 유지보수할 수 있게 한다. drain 기능을 어떻게 사용하는지 살펴보자.

<br/>

1. kubectl drain 명령을 실행해 유지보수할 노드(w3-k8s)를 파드가 없는 상태로 만든다. 그런데 이 명령을 실행하면 w3-k8s에서 데몬셋을 지울 수 없어서 명령을 수행할 수 없다고 나온다.
```
[root@m-k8s ~]# kubectl drain w3-k8s
node/w3-k8s cordoned
error: unable to drain node "w3-k8s", aborting command...

There are pending nodes to be drained:
w3-k8s
error: cannot delete DaemonSet-managed Pods (use --ignore-daemonsets to ignore): kube-system/calico-node-j9plc, kube-system/kube-proxy-5ltsx
```

<br/>

- 여기서 drain이 어떻게 작동하는지 알 수 있다. drain은 실제로 파드를 옮기는 것이 아니라 노드에서 파드를 삭제하고 다른 곳에 다시 생성한다. 앞에서도 설명했지만 파드는 언제라도 삭제할 수 있기 때문에 쿠버네티스에서 대부분 이동은 파드를 지우고 다시 만드는 과정을 의미한다. 그런데 DaemonSet은 각 노드에 1개만 존재하는 파드라서 drain으로는 삭제할 수 없다(DaemonSet에 관한 자세한 설명은 ‘3.4.1 데몬셋’을 참고).

<br/>

2. 이번에는 drain 명령과 ignore-daemonsets 옵션을 함께 사용한다. 이 옵션을 사용하면 DaemonSet을 무시하고 진행한다. 경고가 발생하지만 모든 파드가 이동된다.
```
[root@m-k8s ~]# kubectl drain w3-k8s --ignore-daemonsets
node/w3-k8s already cordoned
WARNING: ignoring DaemonSet-managed Pods: kube-system/calico-node-j9plc, kube-system/kube-proxy-5ltsx
evicting pod " echo-hname-5d754d565-jdzrt"
pod/ echo-hname-5d754d565-jdzrt
node/w3-k8s evicted
```

<br/>

3. 노드 w3-k8s에 파드가 없는지 확인한다. 그리고 옮긴 노드에 파드가 새로 생성돼 파드 이름과 IP가 부여된 것도 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                          IP              STATUS   NODE
echo-hname-5d754d565-9t9s8    172.16.221.134  Running  w1-k8s
echo-hname-5d754d565-67gbr   172.16.221.140 Running  w1-k8s
echo-hname-5d754d565-qzvkv    172.16.103.137  Running  w2-k8s
```

<br/>

4. kubectl get nodes를 실행해 drain 명령이 수행된 w3-k8s 노드의 상태를 확인한다. cordon을 실행했을 때처럼 w3-k8s는 SchedulingDisabled 상태다.
```
[root@m-k8s ~]# kubectl get nodes
NAME   STATUS                     ROLES   AGE    VERSION
m-k8s  Ready                      master  145m   v1.18.4
w1-k8s Ready                      <none>  140m   v1.18.4
w2-k8s Ready                      <none>  136m   v1.18.4
w3-k8s Ready,SchedulingDisabled  <none>  131m   v1.18.4
```

<br/>

5. 유지보수가 끝났다고 가정하고 w3-k8s에 uncordon 명령을 실행해 스케줄을 받을 수 있는 상태로 복귀시킨다.
```
[root@m-k8s ~]# kubectl uncordon w3-k8s
node/w3-k8s uncordoned
```

<br/>

6. 다시 노드 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get nodes
NAME    STATUS  ROLES   AGE   VERSION
m-k8s   Ready   master  150m  v1.18.4
w1-k8s  Ready   <none>  145m  v1.18.4
w2-k8s  Ready   <none>  141m  v1.18.4
w3-k8s  Ready   <none>  136m  v1.18.4
```

<br/>

7. 다음 진행을 위해 배포한 echo-hname을 삭제한다.
```
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.2.8/echo-hname.yaml
deployment.apps "echo-hname" deleted
```

<br/>

8. kubectl get pods로 배포된 파드가 없음을 확인한다.
```
[root@m-k8s ~]# kubectl get pods
No resources found in default namespace.
```

<br/><br/>

### 3.2.10 파드 업데이트하고 복구하기 
- 파드를 운영하다 보면 컨테이너에 새로운 기능을 추가하거나 치명적인 버그가 발생해 버전을 업데이트해야 할 때가 있다. 또는 업데이트하는 도중 문제가 발생해 다시 기존 버전을 복구해야 하는 일도 발생한다. 이런 일은 어떻게 처리하는지 확인해 보자.

<br/>

#### 파드 업데이트하기

1. 다음 명령으로 컨테이너 버전 업데이트를 테스트하기 위한 파드를 배포한다. 여기서 --record는 매우 중요한 옵션으로, 배포한 정보의 히스토리를 기록한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml --record
deployment.apps/rollout-nginx created
```

- 적용한 코드 내용은 다음과 같다. 대부분은 이미 살펴본 내용이며, 여기서 중요한 부분은 버전을 정하는 image: nginx:1.15.12이다. 여기에 설치할 컨테이너 버전을 지정하고, 설치한 후에 단계별로 버전을 업데이트한다.

<br/>

##### rollout-nginx.yaml
```
01apiVersion: apps/v1
kind: Deployment
metadata:
  name: rollout-nginx
spec:
  replicas: 3
  selector:
    matchLabels:
      app: nginx
  template:
    metadata:
      labels:
        app: nginx
    spec:
      containers:
      - name: nginx
        image: nginx:1.15.12
```

![image](https://user-images.githubusercontent.com/61584142/161412941-30cb32fa-62ed-4506-a494-baf65a56dcd9.png)

<br/>

2. record 옵션으로 기록된 히스토리는 rollout history 명령을 실행해 확인할 수 있다.
```
[root@m-k8s ~]# kubectl rollout history deployment rollout-nginx
deployment.apps/rollout-nginx
REVISION  CHANGE-CAUSE
1         kubectl apply --filename=/root/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml --record=true
```

<br/>

3. 배포한 파드의 정보를 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                             IP               STATUS    NODE
rollout-nginx-5b7c85b5c9-g8x8x   172.16.103.143   Running   w2-k8s
rollout-nginx-5b7c85b5c9-xl5db   172.16.221.141   Running   w1-k8s
rollout-nginx-5b7c85b5c9-zwpgk   172.16.132.9     Running   w3-k8s 
```

<br/>

4. 배포된 파드에 속해 있는 nginx 컨테이너 버전을 curl -I(헤더 정보만 보여주는 옵션) 명령으로 확인한다.
```
[root@m-k8s ~]# curl -I --silent 172.16.103.143 | grep Server 
Server: nginx/1.15.12
```

<br/>

5. set image 명령으로 파드의 nginx 컨테이너 버전을 1.16.0으로 업데이트한다. 이번에도 --record를 명령에 포함해 실행한 명령을 기록한다.
```
[root@m-k8s ~]# kubectl set image deployment rollout-nginx nginx=nginx:1.16.0 --record
deployment.apps/rollout-nginx image updated
```

<br/>

6. 업데이트한 후에 파드의 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                             IP               STATUS    NODE
rollout-nginx-7598b44f45-cp9kk   172.16.132.10    Running   w3-k8s
rollout-nginx-7598b44f45-nscgk   172.16.103.144   Running   w2-k8s
rollout-nginx-7598b44f45-w6swb   172.16.221.142   Running   w1-k8s
```

<br/>

#### 결과를 보니 파드들의 이름과 IP가 변경됐다. 왜 이런 현상이 발생했을까?
- 여러 번 언급했듯이 파드는 언제라도 지우고 다시 만들 수 있다. 따라서 파드에 속한 nginx 컨테이너를 업데이트하는 가장 쉬운 방법은 파드를 관리하는 replicas의 수를 줄이고 늘려 파드를 새로 생성하는 것이다. 이때 시스템의 영향을 최소화하기 위해 replicas에 속한 파드를 모두 한 번에 지우는 것이 아니라 파드를 하나씩 순차적으로 지우고 생성한다. 이때 파드 수가 많으면 하나씩이 아니라 다수의 파드가 업데이트된다. 업데이트 기본값은 전체의 1/4(25%)개이며, 최솟값은 1개다.

<br/>

##### rollout으로 파드 업데이트 시 구성 변화
![image](https://user-images.githubusercontent.com/61584142/161412986-a659328a-5892-49d3-988c-de721744eb78.png)

<br/>

7. nginx 컨테이너가 1.16.0으로 모두 업데이트되면 Deployment의 상태를 확인한다.
```
[root@m-k8s ~]# kubectl rollout status deployment rollout-nginx
deployment "rollout-nginx" successfully rolled out
```

<br/>

8. rollout history 명령을 실행해 rollout-nginx에 적용된 명령들을 확인한다.
```
[root@m-k8s ~]# kubectl rollout history deployment rollout-nginx
deployment.apps/rollout-nginx
REVISION  CHANGE-CAUSE
1         kubectl apply --filename=/root/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml --record=true
2         kubectl set image deployment rollout-nginx nginx=nginx:1.16.0 --record=true 
```

<br/>

9. curl –I 명령으로 업데이트(1.16.0)가 제대로 이루어졌는지도 확인한다.
```
[root@m-k8s ~]# curl -I --silent 172.16.132.10 | grep Server
Server: nginx/1.16.0
```

<br/>

#### 업데이트 실패 시 파드 복구하기
- 업데이트할 때 실수로 잘못된 버전을 입력하면 어떻게 될까? 잘못된 컨테이너 버전을 입력하고 어떻게 되는지 확인해 보자.

<br/>

1. set image 명령으로 nginx 컨테이너 버전을 의도(1.17.2)와 다르게 1.17.23으로 입력한다.
```
[root@m-k8s ~]# kubectl set image deployment rollout-nginx nginx=nginx:1.17.23 --record
deployment.apps/rollout-nginx image updated
```

<br/>

2. 하지만 이번에는 한참을 쉬고 돌아와도 파드가 삭제되지 않고 pending(대기 중) 상태에서 넘어가지 않는다. 이제부터 그 이유를 살펴보자.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                             IP               STATUS    NODE
rollout-nginx-7598b44f45-cp9kk   172.16.132.10    Running   w3-k8s
rollout-nginx-7598b44f45-nscgk   172.16.103.144   Running   w2-k8s
rollout-nginx-7598b44f45-w6swb   172.16.221.142   Running   w1-k8s
rollout-nginx-7759875c65-wghcd   172.16.103.149   Pending  w2-k8s
```

<br/>

3. 어떤 문제인지를 확인하기 위해 rollout status를 실행한다. 새로운 replicas는 생성했으나(new replicas have been updated) 디플로이먼트를 배포하는 단계에서 대기 중(Waiting)으로 더 이상 진행되지 않은 것을 확인할 수 있다.
```
[root@m-k8s ~]# kubectl rollout status deployment rollout-nginx
Waiting for deployment "rollout-nginx" rollout to finish: 1 out of 3 new replicas have been updated...
```

<br/>

4. Deployment를 생성하려고 여러 번 시도했지만, 끝내 생성되지 않았다는 메시지가 출력된다.
```
[root@m-k8s ~]# kubectl rollout status deployment rollout-nginx
error: deployment "rollout-nginx" exceeded its progress deadline
```

<br/>

5. describe 명령으로 문제점을 좀 더 자세히 살펴보자. 이 명령은 쿠버네티스의 상태를 살펴볼 때 유용하다.
```
[root@m-k8s ~]# kubectl describe deployment rollout-nginx
Name:                   rollout-nginx
[중략]
  Containers:
   nginx:
    Image:        nginx:1.17.23
    Port:         <none>
    Host Port:    <none>
    Environment:  <none>
    Mounts:       <none>
  Volumes:        <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      True    MinimumReplicasAvailable
  Progressing    True    ReplicaSetUpdated
OldReplicaSets:  rollout-nginx-7598b44f45 (3/3 replicas created)
NewReplicaSet:   rollout-nginx-7759875c65 (1/1 replicas created) 
[생략]
```

- describe 명령으로 확인하니 replicas가 새로 생성되는 과정에서 멈춰 있다. 그 이유는 1.17.23 버전의 nginx 컨테이너가 없기 때문이다. 따라서 replicas가 생성을 시도했으나 컨테이너 이미지를 찾을 수 없어서 디플로이먼트가 배포되지 않았다. 실제로 배포할 때 이런 실수를 할 가능성이 충분히 있다. 이를 방지하고자 업데이트할 때 rollout을 사용하고 --record로 기록하는 것이다.

![image](https://user-images.githubusercontent.com/61584142/161413063-9691b7e1-cae1-457b-bc0b-4a61d920505b.png)

<br/>

6. 문제를 확인했으니 정상적인 상태로 복구하는 방법을 살펴보자. 업데이트할 때 사용했던 명령들을 rollout history로 확인한다.
```
[root@m-k8s ~]# kubectl rollout history deployment rollout-nginx
deployment.apps/rollout-nginx
REVISION  CHANGE-CAUSE
1         kubectl apply --filename=~/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml --record=true
2         kubectl set image deployment rollout-nginx nginx=nginx:1.16.0 --record=true
3         kubectl set image deployment rollout-nginx nginx=nginx:1.17.23 --record=true
```

<br/>

7. rollout undo로 명령 실행을 취소해 마지막 단계(revision 3)에서 전 단계(revision 2)로 상태를 되돌린다.
```
[root@m-k8s ~]# kubectl rollout undo deployment rollout-nginx
deployment.apps/rollout-nginx rolled back
```

<br/>

8. 파드 상태를 다시 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                             IP               STATUS    NODE
rollout-nginx-7598b44f45-cp9kk   172.16.132.10    Running   w3-k8s
rollout-nginx-7598b44f45-nscgk   172.16.103.144   Running   w2-k8s
rollout-nginx-7598b44f45-w6swb   172.16.221.142   Running   w1-k8s
```

<br/>

9. rollout history로 실행된 명령을 확인한다. revision 4가 추가되고 revision 2가 삭제됐다. 현재 상태를 revision 2로 되돌렸기 때문에 revision 2는 삭제되고 가장 최근 상태는 revision 4가 된다.
```
[root@m-k8s ~]# kubectl rollout history deployment rollout-nginx
deployment.apps/rollout-nginx
REVISION  CHANGE-CAUSE
1         kubectl apply --filename=/root/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml --record=true
3         kubectl set image deployment rollout-nginx nginx=nginx:1.17.23 --record=true
4         kubectl set image deployment rollout-nginx nginx=nginx:1.16.0 --record=true 
```

<br/>

#### 이해하기 쉽게 그림으로 표현하면 다음과 같다(파드를 업데이트했다 복구하는 과정)

![image](https://user-images.githubusercontent.com/61584142/161413107-855754c5-d989-4738-9ccc-a35c9c5aa026.png)

<br/>

10. 배포된 컨테이너의 nginx 버전을 curl -I로 확인한다. nginx의 버전이 1.16.0이므로 상태가 되돌려졌음을 알 수 있다.
```
[root@m-k8s ~]# curl -I --silent 172.16.132.10 | grep Server
Server: nginx/1.16.0
```

<br/>

11. rollout status 명령으로 변경이 정상적으로 적용됐는지 확인한다.
```
[root@m-k8s ~]# kubectl rollout status deployment rollout-nginx
deployment "rollout-nginx" successfully rolled out
```

<br/>

12. describe로 현재 디플로이먼트 상태도 세부적으로 점검하고 넘어간다.
```
[root@m-k8s ~]# kubectl describe deployment rollout-nginx
Name:                   rollout-nginx
[중략]
  Containers:
   nginx:
    Image:        nginx:1.16.0
    Port:         <none>
    Host Port:    <none>
    Environment:  <none>
    Mounts:       <none>
  Volumes:        <none>
Conditions:
  Type           Status  Reason
  ----           ------  ------
  Available      True    MinimumReplicasAvailable
  Progressing    True    NewReplicaSetAvailable
OldReplicaSets:  <none>
NewReplicaSet:   rollout-nginx-7598b44f45 (3/3 replicas created) 
[생략]
```

<br/>

#### 특정 시점으로 파드 복구하기
- 바로 전 상태가 아니라 특정 시점으로 돌아가고 싶다면 어떻게 할까? 이럴 때는 --to-revision 옵션을 사용한다.

<br/>

1. 처음 상태인 revision 1으로 돌아가 보자.
```
[root@m-k8s ~]# kubectl rollout undo deployment rollout-nginx --to-revision=1
deployment.apps/rollout-nginx rolled back
```

<br/>

2. 새로 생성된 파드들의 IP를 확인한다.
```
[root@m-k8s ~]# kubectl get pods \
-o=custom-columns=NAME:.metadata.name,IP:.status.podIP,STATUS:.status.phase,NODE:.spec.nodeName
NAME                             IP               STATUS    NODE
rollout-nginx-5b7c85b5c9-4k6c2   172.16.103.150   Running   w2-k8s
rollout-nginx-5b7c85b5c9-5cksb   172.16.221.143   Running   w1-k8s
rollout-nginx-5b7c85b5c9-qpqtv   172.16.132.11    Running   w3-k8s
```

<br/>

3. curl -I로 nginx 컨테이너의 버전을 확인한다. 1.15.12 버전이므로 처음 상태로 복구됐다.
```
[root@m-k8s ~]# curl -I --silent 172.16.103.150 | grep Server
Server: nginx/1.15.12
```

<br/>

4. 다음 단계 진행을 위해 배포한 rollout-nginx 디플로이먼트를 삭제(delete)한다.
```
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.2.10/rollout-nginx.yaml
deployment.apps "rollout-nginx" deleted
```

<br/>

5. 배포된 파드가 없는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods
No resources found in default namespace.
```

<br/>

- 지금까지 쿠버네티스의 파드를 통해서 오브젝트의 구성을 살펴보고, 파드를 효율적으로 사용할 수 있게 해 주는 디플로이먼트에 대해서 알아봤다. 또한 오브젝트를 생성하는 3가지 방법을 알아보고 각각의 사용 용도를 확인했다. 그리고 쿠버네티스의 가장 큰 강점 중의 하나인 안정적인 작동을 위해서 제공하는 기능들을 알아보고 유지보수, 업데이트 그리고 복구하는 방법도 살펴봤다.

<br/><br/><br/><br/>

## 3.3 쿠버네티스 연결을 담당하는 서비스
- 3.2절에서는 쿠버네티스 클러스터 내부에서 파드를 사용했다. 그런데 쿠버네티스 클러스터 내부에서만 파드를 이용하려고 쿠버네티스를 배우는걸까? 당연히 아니다. 이번에는 외부 사용자가 파드를 이용하는 방법을 알아보자.

<br/>

- 시작하기에 앞서 간단하지만 혼동되는 용어를 명확하게 짚고 넢어가자. 일반적으로 서비스라고 하면 웹 서비스나 네트워크 서비스처럼 운영 체제에 속한 서비스 데몬 또는 개발 중인 서비스 등을 떠올릴 것이다. 그런데 쿠버네티스에서는 외부에서 쿠버네티스 클러스터에 접속하는 방법을 서비스(service)라고 한다. 서비스를 '소비를 위한 도움을 제공한다'는 관점으로 바라본다면 쿠버네티스가 외부에서 쿠버네티스 클러스터에 접속하기 위한 '서비스'를 제공한다고 볼 수 있다.

<br/>

#### 3.3.1 가장 간단하게 연결하는 노드포트
- 외부에서 쿠버네티스 클러스터의 내부에 접속하는 가장 쉬운 방법은 **노드포트(NodePort)** 서비스를 이용하는 것이다. 노드포트 서비스를 설정하면 모든 워커 노드의 특정 포트(노드포트)를 열고 여기로 오는 모든 요청을 노드포트 서비스로 전달한다. 그리고 노드포트 서비스는 해당 업무를 처리할 수 있는 파드로 요청을 전달한다. 과정을 정리하면 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161413545-f5cf8ff0-edf0-4c3b-84d7-0b7c3e4e8672.png)

<br/>

#### 노드포트 서비스로 외부에서 접속하기

1. 디플로이먼트로 파드를 생성한다. 이때 이미지는 sysnet4admin 계정에 있는 echo-hname을 사용한다.
```
[root@m-k8s ~]# kubectl create deployment np-pods --image=sysnet4admin/echo-hname
deployment.apps/np-pods created
```

<br/>

2. 배포된 파드를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                       READY   STATUS    RESTARTS   AGE
np-pods-5767d54d4b-4pss2   1/1     Running   0          42s 
```

<br/>

3. kubectl create로 노드포트 서비스를 생성한다. 여기서는 편의를 위해 이미 정의한 오브젝트 스펙을 이용한다.
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.3.1/nodeport.yaml
service/np-svc created
```

<br/>

#### 사용하는 오브젝트 스펙은 다음과 같다.(nodeport.yaml)
```
apiVersion: v1
kind: Service
metadata:
  name: np-svc
spec:
  selector:
    app: np-pods 
  ports:
    - name: http
      protocol: TCP
      port: 80
      targetPort: 80
      nodePort: 30000
  type: NodePort
```

<br/>

#### 오브젝트 스펙은 다음과 같은 구조이다. (nodeport.yaml 파일의 구조)

![image](https://user-images.githubusercontent.com/61584142/161413580-2b588083-640e-4544-a2f6-03392fbe148d.png)

- 기존 파드 구조에서 kind가 Service로 바뀌었고, spec에 컨테이너에 대한 정보가 없다. 그리고 접속에 필요한 네트워크 관련 정보(protocol, port, targetPort, nodePort)와 서비스의 type을 NodePort로 지정했다.

<br/>

4. kubectl get services를 실행해 노드포트 서비스로 생성한 np-svc 서비스를 확인한다.
```
[root@m-k8s ~]# kubectl get services
NAME         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)        AGE
kubernetes   ClusterIP   10.96.0.1       <none>        443/TCP        87m
np-svc      NodePort   10.103.31.217   <none>        80:30000/TCP   18s 
```
- 노드포트의 포트 번호가 30000번으로 지정됐다. CLUSTER-IP(10.103.31.217)는 쿠버네티스 클러스터의 내부에서 사용하는 IP로, 자동으로 지정된다.

<br/>

5. 쿠버네티스 클러스터의 워커 노드 IP를 확인한다.
```
[root@m-k8s ~]# kubectl get nodes -o wide
NAME     STATUS   ROLES    AGE   VERSION   INTERNAL-IP     …  CONTAINER-RUNTIME
m-k8s    Ready    master   88m   v1.18.4   192.168.1.10    …  docker://1.13.1
w1-k8s   Ready    <none>   84m   v1.18.4   192.168.1.101  …  docker://1.13.1
w2-k8s   Ready    <none>   81m   v1.18.4   192.168.1.102  …  docker://1.13.1
w3-k8s   Ready    <none>   77m   v1.18.4   192.168.1.103  …  docker://1.13.1 
```

<br/>

6. 호스트 노트북(또는 PC)에서 웹 브라우저를 띄우고 192.168.1.101∼103(확인한 워커 노드의 IP)와 30000번(노드포트의 포트 번호)으로 접속해 외부에서 접속되는지 확인한다. 화면에 파드 이름이 표시되는지도 확인합니다. 이때 파드가 하나이므로 화면에 보이는 이름은 모두 동일하다.

![image](https://user-images.githubusercontent.com/61584142/161413630-fb210373-5b56-4824-9381-7a785e22e287.png)

<br/>

#### 부하 분산 테스트하기
- 조금 더 현실적인 시나리오로 작업해 보자. 디플로이먼트로 생성된 파드 1개에 접속하고 있는 중에 파드가 3개로 증가하면 접속이 어떻게 바뀔까? 즉, 부하가 분산되는지(로드밸런서 기능) 확인해 보자.

<br/>

1. 호스트 노트북(또는 PC)에서 파워셸(powershell) 명령 창을 띄우고 다음 명령을 실행한다. 이 명령은 반복적으로 192.168.1.101:30000에 접속해 접속한 파드 이름을 화면에 표시(Invoke-RestMethod)한다. 이렇게 하면 파드가 1개에서 3개로 늘어나는 시점을 관찰할 수 있다.
```
PS C:\Users\Hoon Jo - Pink> $i=0; while($true)
{
 % { $i++; write-host -NoNewline "$i $_" }
 (Invoke-RestMethod "http://192.168.1.101:30000")-replace '\n', " "
}
```

<br/>

- 명령을 실행하면 다음과 같이 현재 접속한 호스트 이름을 순서대로 출력한다.
![image](https://user-images.githubusercontent.com/61584142/161413650-bdfef96a-3082-46bb-9403-a558f332b2f5.png)

<br/>

2. 파워셸로 코드를 실행하고 나면 쿠버네티스 마스터 노드에서 scale을 실행해 파드를 3개로 증가시킨다.
```
[root@m-k8s ~]# kubectl scale deployment np-pods --replicas=3
deployment.apps/np-pods scaled
```

<br/>

3. 배포된 파드를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                       READY   STATUS    RESTARTS   AGE
np-pods-85ddc87668-jvcqq   1/1     Running   0          6m49s
np-pods-85ddc87668-p4h9x   1/1     Running   0          39s
np-pods-85ddc87668-pw56d   1/1     Running   0          39s 
```

<br/>

4. 파워셸 명령 창을 확인해 표시하는 파드 이름에 배포된 파드 3개가 돌아가면서 표시되는지 확인한다. 즉, 부하 분산이 제대로 되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161413668-f4a79e60-d3c2-4f23-b088-c27927ef06f5.png)

- 노드포트의 오브젝트 스펙에 적힌 np-pods와 디플로이먼트의 이름을 확인해 동일하면 같은 파드라고 잔주하여 추가된 파드를 외부에서 추적해 접속할 수 있다.

<br/><br/>

#### expose로 노드포트 서비스 생성하기
- 노드포트 서비스는 오브젝트 스펙 파일로만 생성할 수 있을까? 아니다. 노드포트 서비스는 expose 명령어로도 생성할 수 있다. 이번에는 expose로 노드포트 서비스를 생성하고 정상적으로 작동하는지 확인해 보자.

<br/>

1. expose 명령어를 사용해 서비스로 내보낼 디플로이먼트를 np-pods로 지정한다. 해당 서비스의 이름은 np-svc-v2로, 타입은 NodePort로 지정한다(이때 서비스 타입은 반드시 대소문자를 구분해야 한다). 마지막으로 서비스가 파드로 보내줄 연결 포트를 80번으로 지정한다.
```
[root@m-k8s ~]# kubectl expose deployment np-pods --type=NodePort --name=np-svc-v2 --port=80
service/np-svc-v2 exposed
```

<br/>

2. kubectl get services를 실행해 생성된 서비스를 확인한다. 오브젝트 스펙으로 생성할 때는 노드포트 포트 번호를 30000번으로 지정했으나 expose를 사용하면 노드포트의 포트 번호를 지정할 수 없다. 포트 번호는 30000~32767에서 임의로 지정되므로 여러분이 생성한 노드포트의 포트 번호는 다를 수 있다.
```
[root@m-k8s ~]# kubectl get services
NAME         TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)        AGE
kubernetes   ClusterIP   10.96.0.1       <none>        443/TCP        92m
np-svc       NodePort    10.102.202.92   <none>        80:30000/TCP   7m13s
np-svc-v2    NodePort    10.108.152.33   <none>        80:32122/TCP  9s 
```

<br/>

3. 호스트 노트북(또는 PC)에서 웹 브라우저를 띄우고 192.168.1.101:32122(무작위로 생성된 포트 번호)에 접속한다. 배포된 파드 중 하나의 이름이 웹 브라우저에 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161413736-7ab9e0b1-e598-404c-8405-f00fb7128924.png)

<br/>

4. 노드포트로 쿠버네티스 클러스터 내부에 접속하는 방법을 알아봤다. 다음 실습 진행을 위해 배포한 디플로이먼트와 서비스 2개를 모두 삭제한다.
```
[root@m-k8s ~]# kubectl delete deployment np-pods
deployment.apps "np-pods" deleted
[root@m-k8s ~]# kubectl delete services np-svc
service "np-svc" deleted
[root@m-k8s ~]# kubectl delete services np-svc-v2
service "np-svc-v2" deleted
```

<br/><br/>

### 3.3.2 사용 목적별로 연결하는 인그레스
- 노드포트 서비스는 포트를 중복 사용할 수 없어서 1개의 노드포트에 1개의 디플로이먼트만 적용된다. 그렇다면 여러 개의 디플로이먼트가 있을 때 그 수만큼 노드포트 서비스를 구동해야 할까? 쿠버네티스에서는 이런 경우에 인그레스를 사용한다. **인그레스(Ingress)** 는 고유한 주소를 제공해 사용 목적에 따라 다른 응답을 제공할 수 있고, 트래픽에 대한 L4/L7 로드밸런서와 보안 인증서를 처리하는 기능을 제공한다.

<br/>

- 인그레스를 사용하려면 인그레스 컨트롤러가 필요하다. 다양한 인그레스 컨트롤러가 있지만, 여기서는 쿠버네티스에서 지원하는 **NGINX 인그레스 컨트롤러(NGINX Ingress controller)** 로 구성해 보자. 여기서는 NGINX 인그레스 컨트롤러가 다음 단계로 작동한다.

<br/>

1. 사용자는 노드마다 설정된 노드포트를 통해 노드포트 서비스로 접속한다. 이때 노드포트 서비스를 NGINX 인그레스 컨트롤러로 구성한다.
2. NGINX 인그레스 컨트롤러는 사용자의 접속 경로에 따라 적합한 클러스터 IP 서비스로 경로를 제공한다.
3. 클러스터 IP 서비스는 사용자를 해당 파드로 연결해 준다.

<br/>

**인그레스 컨트롤러는 파드와 직접 통신할 수 없어서 노드포트 또는 로드밸런서 서비스와 연동되어야 한다. 따라서 노드포트로 이를 연동했다.

<br/>

- 구성하려는 NGINX 인그레스 컨트롤러는 다음과 같다. 다소 복잡해 보이지만 인그레스 컨트롤러의 궁극적인 목적은 사용자가 접속하는 경로에 따라 다른 결괏값을 제공하는 것이다. 실습하면서 확인해 보자.

![image](https://user-images.githubusercontent.com/61584142/161414265-b9f5bebd-44da-467e-bbc0-cd2a827c3919.png)

<br/>

1. 테스트용으로 디플로이먼트 2개(in-hname-pod, in-ip-pod)를 배포한다.
```
[root@m-k8s ~]# kubectl create deployment in-hname-pod --image=sysnet4admin/echo-hname
deployment.apps/in-hname-pod created
[root@m-k8s ~]# kubectl create deployment in-ip-pod --image=sysnet4admin/echo-ip
deployment.apps/in-ip-pod created
```

<br/>

2. 배포된 파드의 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                            READY   STATUS    RESTARTS   AGE
in-hname-pod-69779f5566-88q6z   1/1     Running   0          32s
in-ip-pod-55c9fb7456-9p8fw      1/1     Running   0          21s 
```

<br/>

3. NGINX 인그레스 컨트롤러를 설치한다. 여기에는 많은 종류의 오브젝트 스펙이 포함된다. 설치되는 요소들은 NGINX 인그레스 컨트롤러 서비스를 제공하기 위해 미리 지정돼 있다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.3.2/ingress-nginx.yaml 
namespace/ingress-nginx created
configmap/nginx-configuration created
configmap/tcp-services created
configmap/udp-services created
serviceaccount/nginx-ingress-serviceaccount created
clusterrole.rbac.authorization.k8s.io/nginx-ingress-clusterrole created
role.rbac.authorization.k8s.io/nginx-ingress-role created
rolebinding.rbac.authorization.k8s.io/nginx-ingress-role-nisa-binding created
clusterrolebinding.rbac.authorization.k8s.io/nginx-ingress-clusterrole-nisa-binding created
deployment.apps/nginx-ingress-controller created
limitrange/ingress-nginx created 
```

<br/>

4. NGINX 인그레스 컨트롤러의 파드가 배포됐는지 확인한다. NGINX 인그레스 컨트롤러는 default 네임스페이스가 아닌 ingress-nginx 네임스페이스에 속하므로 -n ingress-nginx 옵션을 추가해야 한다. 여기서 -n은 namespace의 약어로, default 외의 네임스페이스를 확인할 때 사용하는 옵션이다. 파드뿐만 아니라 서비스를 확인할 때도 동일한 옵션을 준다.
```
[root@m-k8s ~]# kubectl get pods -n ingress-nginx
NAME                                       READY   STATUS    RESTARTS   AGE
nginx-ingress-controller-5bb8fb4bb6-qn8lw  1/1     Running   0          102s
```

<br/>

5. 인그레스를 사용자 요구 사항에 맞게 설정하려면 경로와 작동을 정의해야 한다. 파일로도 설정할 수 있으므로 다음 경로로 실행해서 미리 정의해 둔 설정을 적용한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.3.2/ingress-config.yaml
ingress.networking.k8s.io/ingress-nginx created
```

<br/>

- 인그레스를 위한 설정 파일은 다음과 같다. 이 파일은 들어오는 주소 값과 포트에 따라 노출된 서비스를 연결하는 역할을 설정한다. 외부에서 주소 값과 노드포트를 가지고 들어오는 것은 hname-svc-default 서비스와 연결된 파드로 넘기고, 외부에서 들어오는 주소 값, 노드포트와 함께 뒤에 /ip를 추가한 주소 값은 ip-svc 서비스와 연결된 파드로 접속하게 설정했다.
- ingress-config.yaml
```
apiVersion: networking.k8s.io/v1beta1
kind: Ingress
metadata:
  name: ingress-nginx
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - http:
      paths:
      - path:
        backend:
          serviceName: hname-svc-default
          servicePort: 80
      - path: /ip
        backend:
          serviceName: ip-svc
          servicePort: 80
      - path: /your-directory
        backend:
          serviceName: your-svc
          servicePort: 80
```

<br/>

#### 구조를 그림으로 표현하면 다음과 같다.(ingress-config.yaml) 파일의 구조

![image](https://user-images.githubusercontent.com/61584142/161414321-581f5ea7-3f2d-4067-a097-8143c6067e2a.png)

<br/>

6. 인그레스 설정 파일이 제대로 등록됐는지 kubectl get ingress로 확인한다.
```
[root@m-k8s ~]# kubectl get ingress
NAME            CLASS    HOSTS   ADDRESS   PORTS   AGE
ingress-nginx   <none>   *                 80      4s
```

<br/>

7. kubectl get ingress -o yaml을 실행해 인그레스에 요청한 내용이 확실하게 적용됐는지 확인한다. 이 명령은 인그레스에 적용된 내용을 야믈 형식으로 출력해 적용된 내용을 확인할 수 있다. 우리가 적용한 내용 외에 시스템에서 자동으로 생성하는 것까지 모두 확인할 수 있으므로 이 명령을 응용하면 오브젝트 스펙 파일을 만드는 데 도움이 된다.
```
[root@m-k8s ~]# kubectl get ingress -o yaml
apiVersion: v1
items:
- apiVersion: extensions/v1beta1
  kind: Ingress
  metadata:
    annotations:
      kubectl.kubernetes.io/last-applied-configuration: |
[생략]        
```

<br/>

8. NGINX 인그레스 컨트롤러 생성과 인그레스 설정을 완료했다. 이제 외부에서 NGINX 인그레스 컨트롤러에 접속할 수 있게 노드포트 서비스로 NGINX 인그레스 컨트롤러를 외부에 노출한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.3.2/ingress.yaml 
service/nginx-ingress-controller created
```

<br/>

- 적용하는 코드는 다음과 같다. 기존 노드포트와 달리 http를 처리하기 위해 30100번 포트로 들어온 요청을 80번 포트로 넘기고, https를 처리하기 위해 30101번 포트로 들어온 것을 443번 포트로 넘긴다. 그리고 NGINX 인그레스 컨트롤러가 위치하는 네임스페이스를 ingress-nginx로 지정하고 NGINX 인그레스 컨트롤러의 요구 사항에 따라 셀렉터를 ingress-nginx로 지정했다.
- ingress.yaml
```
piVersion: v1
kind: Service
metadata:
  name: nginx-ingress-controller
  namespace: ingress-nginx
spec:
  ports:
  - name: http
    protocol: TCP
    port: 80
    targetPort: 80
    nodePort: 30100
  - name: https
    protocol: TCP
    port: 443
    targetPort: 443
    nodePort: 30101
  selector:
    app.kubernetes.io/name: ingress-nginx
  type: NodePort
```

<br/>

#### 이 파일 구조를 그림으로 표현하면 다음과 같다.(ingress.yaml 파일의 구조)

![image](https://user-images.githubusercontent.com/61584142/161414363-d1e726b1-5a42-49dd-bf3e-858158375c22.png)

<br/>

9. 노드포트 서비스로 생성된 NGINX 인그레스 컨트롤러(nginx-ingress-controller)를 확인한다. 이때도 -n ingress-nginx로 네임스페이스를 지정해야만 내용을 확인할 수 있다.
```
[root@m-k8s ~]# kubectl get services -n ingress-nginx
NAME                      TYPE      CLUSTER-IP      …  PORT(S)                    …  
nginx-ingress-controller  NodePort  10.108.212.241  …  80:30100/TCP,443:30101/TCP …  
```

<br/>

10. expose 명령으로 디플로이먼트(in-hname-pod, in-ip-pod)도 서비스로 노출한다. 외부와 통신하기 위해 클러스터 내부에서만 사용하는 파드를 클러스터 외부에 노출할 수 있는 구역으로 옮기는 것이다. 내부와 외부 네트워크를 분리해 관리하는 DMZ(DeMilitarized Zone, 비무장지대)와 유사한 기능이다. 비유적으로 표현하면 각 방에 있는 물건을 외부로 내보내기 전에 공용 공간인 거실로 모두 옮기는 것과 같다.
```
[root@m-k8s ~]# kubectl expose deployment in-hname-pod --name=hname-svc-default --port=80,443
service/hname-svc-default exposed
[root@m-k8s ~]# kubectl expose deployment in-ip-pod --name=ip-svc --port=80,443
service/ip-svc exposed
```

<br/>

11. 생성된 서비스를 점검해 디플로이먼트들이 서비스에 정상적으로 노출되는지 확인한다. 새로 생성된 서비스는 default 네임스페이스에 있으므로 -n 옵션으로 네임스페이스를 지정하지 않아도 된다.
```
[root@m-k8s ~]# kubectl get services
NAME                TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
hname-svc-default  ClusterIP   10.99.235.72   <none>        80/TCP,443/TCP   37s
ip-svc             ClusterIP   10.99.131.1    <none>        80/TCP,443/TCP   25s
kubernetes          ClusterIP   10.96.0.1      <none>        443/TCP          156m
```

<br/>

12. 자, 이제 모든 준비가 끝났다. 호스트 노트북(또는 PC)에서 웹 브라우저를 띄우고 192.168.1.101:30100에 접속해 외부에서 접속되는 경로에 따라 다르게 작동하는지 확인한다. 이때 워커 노드 IP는 192.168.1.101이 아닌 102 또는 103을 사용해도 무방하다. 파드 이름이 웹 브라우저에 표시되는지도 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414394-40beb71f-4c82-41d4-ad0f-7ea988b8f5fd.png)

<br/>

13. 이번에는 경로를 바꿔서 192.168.1.101:30100 뒤에 /ip를 추가한다. 요청 방법과 파드의 ip(CIDR로 임의 생성되므로 다를 수 있습니다)가 반환되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414415-08e92452-073b-4bc3-9947-b11632e371c9.png)

<br/>

14. https://192.168.1.101:30101으로 접속해 HTTP 연결이 아닌 HTTPS 연결도 정상적으로 작동하는지 확인한다. 30101은 HTTPS의 포트인 443번으로 변환해 접속된다. 단, 브라우저에 따라 경고 메시지가 뜰 수도 있다. 화면에 보이는 고급 > 주소(안전하지 않음)(으)로 이동을 클릭하면 접속된다. 파드 이름이 브라우저에 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414422-3463ab23-5ae8-4316-91f6-924c83811c40.png)

<br/>

15. https://192.168.1.101:30101/ip를 입력해 마찬가지로 요청 방법과 파드의 IP 주소가 웹 브라우저에 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414427-eb14c175-9c61-4372-82f1-a1835c2724ea.png)

<br/>

16. NGINX 인그레스 컨트롤러 구성과 테스트가 끝났다. 역시 다음 실습 진행을 위해 배포한 디플로이먼트와 모든 서비스를 삭제한다.
```
[root@m-k8s ~]# kubectl delete deployment in-hname-pod
deployment.apps "in-hname-pod" deleted
[root@m-k8s ~]# kubectl delete deployment in-ip-pod
deployment.apps "in-ip-pod" deleted
[root@m-k8s ~]# kubectl delete services hname-svc-default
service "hname-svc-default" deleted
[root@m-k8s ~]# kubectl delete services ip-svc
service "ip-svc" deleted
```

<br/>

17. NGINX 인그레스 컨트롤러와 관련된 내용도 모두 삭제한다. 여러 가지 내용이 혼합됐으므로 설치 파일을 이용해 삭제하기를 권장한다.
```
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.3.2/ingress-nginx.yaml
namespace "ingress-nginx" deleted
configmap "nginx-configuration" deleted
configmap "tcp-services" deleted
configmap "udp-services" deleted
serviceaccount "nginx-ingress-serviceaccount" deleted
clusterrole.rbac.authorization.k8s.io "nginx-ingress-clusterrole" deleted
role.rbac.authorization.k8s.io "nginx-ingress-role" deleted
rolebinding.rbac.authorization.k8s.io "nginx-ingress-role-nisa-binding" deleted
clusterrolebinding.rbac.authorization.k8s.io "nginx-ingress-clusterrole-nisa-binding" deleted
deployment.apps "nginx-ingress-controller" deleted
limitrange "ingress-nginx" deleted
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.3.2/ingress-config.yaml
ingress.networking.k8s.io "ingress-nginx" deleted
```

<br/><br/>

### 3.3.3 클라우드에서 쉽게 구성 가능한 로드밸런서
- 앞에서 배운 연결 방식은 들어오는 요청을 모두 워커 노드의 노드포트를 통해 노드포트 서비스로 이동하고 이를 다시 쿠버네티스의 파드로 보내는 구조였다. 이 방식은 매우 비효율적이다. 그래서 쿠버네티스에서는 로드밸런서(LoadBalancer)라는 서비스 타입을 제공해 다음 그림과 같은 간단한 구조로 파드를 외부에 노출하고 부하를 분산한다.

![image](https://user-images.githubusercontent.com/61584142/161414472-a1f3317e-0f2a-40f0-b8d1-af6accbaa997.png)

<br/>

- 그런데 왜 지금까지 로드밸런서를 사용하지 않았을까? 로드밸런서를 사용하려면 로드밸런서를 이미 구현해 둔 서비스업체의 도움을 받아 쿠버네티스 클러스터 외부에 구현해야 하기 때문이다. 클라우드에서 제공하는 쿠버네티스를 사용하고 있다면 다음과 같이 선언만 하면 된다. 그러면 쿠버네티스 클러스터에 로드밸런서 서비스가 생성돼 외부와 통신할 수 있는 IP(EXTERNAL-IP)가 부여되고 외부와 통신할 수 있으며 부하도 분산된다.
```
[admin@Cloud_CMD ~]# kubectl expose deployment ex-lb --type=LoadBalancer --name=ex-svc 
service/ex-svc exposed
[admin@Cloud_CMD ~]# kubectl get services ex-svc
NAME     TYPE           CLUSTER-IP     EXTERNAL-IP     PORT(S)    AGE
ex-svc   LoadBalancer   10.1.215.117   102.19.21.103   8080/TCP   95s
```

<br/>

- 그렇다면 우리가 만든 테스트 가상 환경(온프레미스)에서는 로드밸런서를 사용하는 것은 불가능할까? 지금부터 대안을 알아보자.

<br/><br/>

### 3.3.4 온프레미스에서 로드밸런서를 제공하는 MetalLB
- 온프레미스에서 로드밸런서를 사용하려면 내부에 로드밸런서 서비스를 받아주는 구성이 필요한데, 이를 지원하는 것이 MetalLB이다. MetalLB는 베어메탈(bare metal, 운영 체제가 설치되지 않은 하드웨어)로 구성된 쿠버네티스에서도 로드밸런서를 사용할 수 있게 고안된 프로젝트다. MetalLB는 특별한 네트워크 설정이나 구성이 있는 것이 아니라 기존의 L2 네트워크(ARP/NDP)와 L3 네트워크(BGP)로 로드밸런서를 구현한다. 그러므로 네트워크를 새로 배워야 할 부담이 없으며 연동하기도 매우 쉽다.

<br/>

- 여기서는 MetalLB의 L2 네트워크로 로드밸런서를 구현하고, 네트워크 경로는 다음과 같이 구성한다. 그림에서 알 수 있듯이 기존의 로드밸런서와 거의 동일한 경로로 통신하며, 테스트 목적으로 두 개의 MetalLB 로드밸런서 서비스를 구현한다.

![image](https://user-images.githubusercontent.com/61584142/161414497-808cdd4e-a167-42b2-9f78-4467c9996a29.png)

<br/>

- MetalLB 컨트롤러는 작동 방식(Protocol, 프로토콜)을 정의하고 EXTERNAL-IP를 부여해 관리한다. MetalLB 스피커(speaker)는 정해진 작동 방식(L2/ARP, L3/BGP)에 따라 경로를 만들 수 있도록 네트워크 정보를 광고하고 수집해 각 파드의 경로를 제공한다. 이때 L2는 스피커 중에서 리더를 선출해 경로 제공을 총괄하게 한다.

<br/>

- 구성도를 확인했으니 MetalLB로 온프레미스 쿠버네티스 환경에서 로드밸런서 서비스를 사용하도록 구성해 보자.

<br/>

1. 디플로이먼트를 이용해 2종류(lb-hname-pods, lb-ip-pods)의 파드를 생성한다. 그리고 scale 명령으로 파드를 3개로 늘려 노드당 1개씩 파드가 배포되게 한다.
```
[root@m-k8s ~]# kubectl create deployment lb-hname-pods --image=sysnet4admin/echo-hname
deployment.apps/lb-hname-pods created
[root@m-k8s ~]# kubectl scale deployment lb-hname-pods --replicas=3
deployment.apps/lb-hname-pods scaled
[root@m-k8s ~]# kubectl create deployment lb-ip-pods --image=sysnet4admin/echo-ip
deployment.apps/lb-ip-pods created
[root@m-k8s ~]# kubectl scale deployment lb-ip-pods --replicas=3
deployment.apps/lb-ip-pods scaled
```

<br/>

2. 2종류의 파드가 3개씩 총 6개가 배포됐는지 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                             READY   STATUS    RESTARTS   AGE 
lb-hname-pods-79b95c7c7b-7lplh   1/1     Running   0          98s
lb-hname-pods-79b95c7c7b-7lplh   1/1     Running   0          105s
lb-hname-pods-79b95c7c7b-tx45r   1/1     Running   0          98s
lb-ip-pods-6c6bb59b4-4759t       1/1     Running   0          72s
lb-ip-pods-6c6bb59b4-f6fpl       1/1     Running   0          72s
lb-ip-pods-6c6bb59b4-l4wmt       1/1     Running   0          80s 
```

<br/>

3. 인그레스와 마찬가지로 사전에 정의된 오브젝트 스펙으로 MetalLB를 구성한다. 이렇게 하면 MetalLB에 필요한 요소가 모두 설치되고 독립적인 네임스페이스(metallb-system)도 함께 만들어진다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.3.4/metallb.yaml
namespace/metallb-system created
podsecuritypolicy.policy/speaker created
serviceaccount/controller created
serviceaccount/speaker created
clusterrole.rbac.authorization.k8s.io/metallb-system:controller created
clusterrole.rbac.authorization.k8s.io/metallb-system:speaker created
role.rbac.authorization.k8s.io/config-watcher created
clusterrolebinding.rbac.authorization.k8s.io/metallb-system:controller created
clusterrolebinding.rbac.authorization.k8s.io/metallb-system:speaker created
rolebinding.rbac.authorization.k8s.io/config-watcher created
daemonset.apps/speaker created
deployment.apps/controller created
```

<br/>

4. 배포된 MetalLB의 파드가 5개(controller 1개, speaker 4개)인지 확인하고, IP와 상태도 확인한다.
```
[root@m-k8s ~]# kubectl get pods -n metallb-system -o wide
NAME                         …  STATUS    RESTARTS   AGE   IP               NODE   …  
controller-65895b47d4-b845q  …  Running   0          38s   172.16.103.133   w2-k8s … 
speaker-hzfmz                …  Running   0          38s   192.168.1.10     m-k8s  …
speaker-kqcxf                …  Running   0          38s   192.168.1.101    w1-k8s …
speaker-m7fxr                …  Running   0          38s   192.168.1.103    w3-k8s …
speaker-tsczn                …  Running   0          38s   192.168.1.102    w2-k8s …
```

<br/>

5. 인그레스와 마찬가지로 MetalLB도 설정을 적용해야 하는데, 다음 방법으로 적용한다. 이때 오브젝트는 ConfigMap을 사용한다. ConfigMap은 설정이 정의된 포맷이라고 생각하면 된다. ConfigMap에 관한 자세한 설명은 ‘3.4.2 컨피그맵’을 참조한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.3.4/metallb-l2config.yaml
configmap/config created
```

<br/>

#### 파일 구성은 다음과 같다.(metallb-l2config.yaml)
```
apiVersion: v1
kind: ConfigMap
metadata:
  namespace: metallb-system
  name: config
data:
  config: |
    address-pools:
    - name: nginx-ip-range
      protocol: layer2
      addresses:
      - 192.168.1.11-192.168.1.13
```

<br/>

#### 파일 구조를 그림으로 표현하면 다음과 같다.(metallb-l2config.yaml의 구조)

![image](https://user-images.githubusercontent.com/61584142/161414548-b7b9b59d-2f90-4aa4-a67e-e5955c463a75.png)

<br/>

6. ConfigMap이 생성됐는지 kubectl get configmap -n metallb-system 명령으로 확인한다.
```
[root@m-k8s ~]# kubectl get configmap -n metallb-system
NAME     DATA   AGE
config   1      19s
```

<br/>

7. -o yaml 옵션을 주고 다시 실행해 MetalLB의 설정이 올바르게 적용됐는지 확인한다.
```
[root@m-k8s ~]# kubectl get configmap -n metallb-system -o yaml
apiVersion: v1
items:
- apiVersion: v1
  data:
    config: |
      address-pools:
      - name: nginx-ip-range
        protocol: layer2
        addresses:
        - 192.168.1.11-192.168.1.13
  kind: ConfigMap
[생략]
```

<br/>

8. 모든 설정이 완료됐으니 이제 각 디플로이먼트(lb-hname-pods, lb-ip-pods)를 로드밸런서 서비스로 노출한다.
```
[root@m-k8s ~]# kubectl expose deployment lb-hname-pods --type=LoadBalancer --name=lb-hname-svc --port=80
service/lb-hname-svc exposed
[root@m-k8s ~]# kubectl expose deployment lb-ip-pods --type=LoadBalancer --name=lb-ip-svc --port=80
service/lb-ip-svc exposed
```

<br/>

9. 생성된 로드밸런서 서비스별로 CLUSTER-IP와 EXTERNAL-IP가 잘 적용됐는지 확인한다. 특히 EXTERNAL-IP에 ConfigMap을 통해 부여한 IP를 확인한다.
```
NAME           TYPE           CLUSTER-IP     EXTERNAL-IP    PORT(S)        AGE
kubernetes     ClusterIP      10.96.0.1      <none>         443/TCP        171m
lb-hname-svc   LoadBalancer   10.99.213.3    192.168.1.11  80:32491/TCP   74s
lb-ip-svc      LoadBalancer   10.96.81.219   192.168.1.12  80:31751/TCP   60s
```

<br/>

10. EXTERNAL-IP가 잘 작동하는지도 확인해 보자. 호스트 노트북(또는 PC)에서 브라우저를 띄우고 192.168.1.11로 접속한다. 배포된 파드 중 하나의 이름이 브라우저에 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414605-3f95206f-6031-4e6c-b94f-a4b693bf90a8.png)

<br/>

11. 192.168.1.12를 접속해 파드에 요청 방법과 IP가 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414610-072a82b8-fbaa-4adc-9205-c61f60a39962.png)

<br/>

12. 파워셸 명령 창을 띄우고 셸 스크립트를 실행한다. 로드밸런서 기능이 정상적으로 작동하면 192.168.1.11(EXTERNAL-IP)에서 반복적으로 결괏값을 가지고 온다.
```
PS C:\Users\Hoon Jo - Pink>  $i=0; while($true)
{
  % { $i++; write-host -NoNewline "$i $_" }
  (Invoke-RestMethod "http://192.168.1.11")-replace '\n', " "
}
```

<br/>

13. scale 명령으로 파드를 6개로 늘린다.
```
[root@m-k8s ~]# kubectl scale deployment lb-hname-pods --replicas=6
deployment.apps/lb-ip-pods scaled
```

<br/>

14. 늘어난 파드 6개도 EXTERNAL-IP를 통해 접근되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414630-0ce3fba5-b174-4f40-880f-67159319f1bd.png)

<br/>

15. 온프레미스에서도 로드밸런서를 사용할 수 있게 하는 MetalLB를 구성해 봤다. 다음 실습을 진행하기 전에 배포한 Deployment와 서비스는 삭제한다. 단, MetalLB 설정은 계속 사용하므로 삭제하지 않는다.
```
[root@m-k8s ~]# kubectl delete deployment lb-hname-pods
deployment.apps "lb-hname-pods" deleted
[root@m-k8s ~]# kubectl delete deployment lb-ip-pods
deployment.apps "lb-ip-pods" deleted
[root@m-k8s ~]# kubectl delete service lb-hname-svc
service "lb-hname-svc" deleted
[root@m-k8s ~]# kubectl delete service lb-ip-svc
service "lb-ip-svc" deleted
```

<br/><br/>

### 3.3.5 부하에 따라 자동으로 파드 수를 조절하는 HPA
- 지금까지는 사용자 1명이 파드에 접근하는 방법을 알아봤다. 그런데 사용자가 갑자기 늘어난다면 어떻게 될까? 파드가 더 이상 감당할 수 없어서 서비스 불가(여기서 서비스는 쿠버네티스의 서비스가 아니다)라는 결과를 초래할 수도 있다. 쿠버네티스는 이런 경우를 대비해 부하량에 따라 디플로이먼트의 파드 수를 유동적으로 관리하는 기능을 제공한다. 이를 HPA(Horizontal Pod Autoscaler)라고 한다. 이번에는 HPA를 어떻게 설정하고 사용하는지 알아보자.

<br/>

1. 디플로이먼트 1개를 hpa-hname-pods라는 이름으로 생성한다.
```
[root@m-k8s ~]# kubectl create deployment hpa-hname-pods --image=sysnet4admin/echo-hname
deployment.apps/hpa-hname-pods created
```

<br/>

2. 앞에서 MetalLB를 구성했으므로 expose를 실행해 hpa-hname-pods를 로드밸런서 서비스로 바로 설정할 수 있다.
```
[root@m-k8s ~]# kubectl expose deployment hpa-hname-pods --type=LoadBalancer --name=hpa-hname-svc --port=80
service/hpa-hname-svc exposed
```

<br/>

3. 설정된 로드밸런서 서비스와 부여된 IP를 확인한다.
```
[root@m-k8s ~]# kubectl get services
NAME            TYPE           CLUSTER-IP      EXTERNAL-IP    PORT(S)        AGE
hpa-hname-svc   LoadBalancer  10.108.60.165   192.168.1.11  80:30304/TCP   2m28s
kubernetes      ClusterIP      10.96.0.1       <none>         443/TCP        95m
```

<br/>

4. HPA가 작동하려면 파드의 자원이 어느 정도 사용되는지 파악해야 한다. 부하를 확인하는 명령은 리눅스의 top(table of processes)과 비슷한 kubectl top pods다.
```
[root@m-k8s ~]# kubectl top pods
Error from server (NotFound): the server could not find the requested resource (get services http:heapster:)
```

<br/>

**자원을 요청하는 설정이 없다며 에러가 생기고 진행되지 않는다. 왜 에러가 발생하는지 HPA가 작동하는 구조를 간단하게 살펴보자.

![image](https://user-images.githubusercontent.com/61584142/161414718-cbbc72df-055d-46a2-93b8-a7b8d4bc8e5f.png)

- 그림을 보면 HPA가 자원을 요청할 때 메트릭 서버(Metrics-Server)를 통해 계측값을 전달받는다. 그런데 우리에게는 현재 메트릭 서버가 없기 때문에 에러가 발생하는 것이다. 따라서 계측값을 수집하고 전달해 주는 메트릭 서버를 설정해야 한다.
- 에러의 내용을 보면 서비스를 확인(get services http:heapster)하도록 요청했다. 여기서 나온 힙스터(heapster)는 쿠버네티스 1.13 이전 버전에서 사용하던 모니터링 도구이다. 1.13 버전부터는 메트릭 서버를 모니터링 도구로 추천한다.

<br/>

5. 서비스에서와 마찬가지로 메트릭 서버도 오브젝트 스펙 파일로 설치할 수 있다. 그러나 그림처럼 오브젝트 스펙 파일이 여러 개라서 git clone 이후에 디렉터리에 있는 파일들을 다시 실행해야 하는 번거로움이 있다. 또한 실습에서 사용하려면 몇 가지 추가 설정이 필요하다. 그래서 쿠버네티스 메트릭 서버의 원본 소스(https://github.com/kubernetes-sigs/metrics-server)를 sysnet4admin 계정으로 옮겨 메트릭 서버를 생성하자.
```
[root@m-k8s ~]# kubectl create -f ~/_Book_k8sInfra/ch3/3.3.5/metrics-server.yaml
clusterrole.rbac.authorization.k8s.io/system:aggregated-metrics-reader created
clusterrolebinding.rbac.authorization.k8s.io/metrics-server:system:auth-delegator created
rolebinding.rbac.authorization.k8s.io/metrics-server-auth-reader created
apiservice.apiregistration.k8s.io/v1beta1.metrics.k8s.io created
serviceaccount/metrics-server created
deployment.apps/metrics-server created
service/metrics-server created
clusterrole.rbac.authorization.k8s.io/system:metrics-server created
clusterrolebinding.rbac.authorization.k8s.io/system:metrics-server created
```

![image](https://user-images.githubusercontent.com/61584142/161414762-4ba6b468-e5f8-4fc1-b55b-1c28160f1f66.png)

<br/>

**metrics-server.yaml 파일 일부(기존 코드에서 변경된 부분)
```
[중략]
      containers:
      - name: metrics-server
        image: k8s.gcr.io/metrics-server-amd64:v0.3.6
        args:
        # Manually Add for lab env(Sysnet4admin/k8s)
        # skip tls internal usage purpose
          - --kubelet-insecure-tls
        # kubelet could use internalIP communication 
          - --kubelet-preferred-address-types=InternalIP
          - --cert-dir=/tmp
          - --secure-port=4443
 [생략]
```
- 기존 코드에서 변경된 내용은 다음과 같다.
    - 102번째 줄: TLS(Transport Layer Security) 인증을 무시하게 한다.
    - 104~106번째 줄: kubelet이 내부 주소를 우선 사용하게 한다.

<br/>

- 만약 쿠버네티스 메트릭 서버의 소스를 그대로 내려받아 실행하면 앞의 설정이 적용되지 않아 다음과 같은 에러가 발생한다.
```
[root@m-k8s ~]# kubectl top pods
W0213 11:02:19.015510 19244 top_pod.go:266] Metrics not available for pod default/hpa-hname-pods-9b7b5d789-bjktm, age: 13m55.01548433s
error: Metrics not available for pod default/hpa-hname-pods-5c844d6487-d6fmp, age: 13m55.01548433s
```

<br/>

6. 메트릭 서버를 설정하고 나면 kubectl top pods 명령의 결과를 제대로 확인할 수 있다. 파드의 top 값을 확인한다. 현재는 아무런 부하가 없으므로 CPU와 MEMORY 값이 매우 낮게 나온다.
```
[root@m-k8s ~]# kubectl top pods
NAME                             CPU(cores)   MEMORY(bytes)
hpa-hname-pods-9b7b5d789-lwx79   0m           1Mi
```
- 현재는 scale 기준 값이 설정돼 있지 않아서 파드 증설 시점을 알 수가 없다. 따라서 파드에 부하가 걸리기 전에 scale이 실행되게 디플로이먼트에 기준 값을 기록한다. 이때 Deployment를 새로 배포하기보다는 기존에 배포한 디플로이먼트 내용을 edit 명령으로 직접 수정한다.

<br/>

7. edit 명령을 실행해 배포된 디플로이먼트 내용을 확인한다. 40번째 줄에 resources: {} 부분에서 {}를 생략하고 그 아래에 다음과 같이 requests, limits 항목과 그 값을 추가한다. 이때 추가한 값은 파드마다 주어진 부하량을 결정하는 기준이 된다. 여기서 사용한 단위 m은 milliunits의 약어로 1000m은 1개의 CPU가 된다. 따라서 10m은 파드의 CPU 0.01 사용을 기준으로 파드를 증설하게 설정한 것이다. 또한 순간적으로 한쪽 파드로 부하가 몰릴 경우를 대비해 CPU 사용 제한을 0.05로 주었다. 추가가 끝나면 Vim과 동일하게 :wq를 입력해 저장하고 나온다.

```
[root@m-k8s ~]# kubectl edit deployment hpa-hname-pods
[중략]
     35     spec:
     36       containers:
     37       - image: sysnet4admin/echo-hname
     38         imagePullPolicy: Always
     39         name: echo-hname
     40         resources:
                  requests:
                    cpu: "10m"
                  limits:
                    cpu: "50m"
     41         terminationMessagePath: /dev/termination-log
     42         terminationMessagePolicy: File
 [생략]
:wq
deployment.apps/hpa-hname-pods edited
```

<br/>

- limits 조건에 따라 CPU 50m 이상 사용되지 않는 경우

![image](https://user-images.githubusercontent.com/61584142/161414843-afef2d01-dc1e-4b46-9a58-63d670655431.png)

<br/>

8. 일정 시간이 지난 후 kubectl top pods를 실행하면 스펙이 변경돼 새로운 파드가 생성된 것을 확인할 수 있다.
```
[root@m-k8s ~]# kubectl top pods
NAME                              CPU(cores)   MEMORY(bytes)
hpa-hname-pods-7f69fb65b9-4d9x9   0m           1Mi
```

<br/>

9. hpa-hname-pods에 autoscale을 설정해서 특정 조건이 만족되는 경우에 자동으로 scale 명령이 수행되도록 하겠다. 여기서 min은 최소 파드의 수, max는 최대 파드의 수이다. cpu-percent는 CPU 사용량이 50%를 넘게 되면 autoscale하겠다는 뜻이다.
```
[root@m-k8s ~]# kubectl autoscale deployment hpa-hname-pods --min=1 --max=30 --cpu-percent=50
horizontalpodautoscaler.autoscaling/hpa-hname-pods autoscaled
```

<br/>

#### HPA를 통해 늘어나는 파드 수 계산 방법
- HPA는 다음과 같은 방법으로 파드의 증가 또는 감소를 조절한다. 디플로이먼트 스펙에서 resources의 CPU를 10m으로 설정하고, autoscale에서 cpu-percent를 50%로 했다고 가정하자.

<br/>

- kubectl top pods로 확인된 파드의 메트릭(CPU, MEMORY) 값이 다음과 같다고 해보자.
```
[root@m-k8s ~]# kubectl top pods
NAME                   CPU(cores)   MEMORY(bytes)
hpa-79fc78897f-2qv58   29m          1Mi
```

<br/>

- 파드는 29m이라는 부하를 받고 있다. 1개의 파드가 처리할 수 있는 부하는 10m이고, CPU 부하량이 50%가 넘으면 추가 파드를 생성해야 하므로 부하가 5m이 넘으면 파드를 증설하게 돼 있다. 따라서 29m/5를 하고 올림하면 6이라는 숫자가 나온다. 결국 증가하는 파드의 수는 6이다. 이때 부하 총량을 가지고 HPA가 작동하기 때문에 일부 파드는 5m을 넘을 수도 있다.
```
[root@m-k8s ~]# kubectl top pods
NAME                   CPU(cores)   MEMORY(bytes)
hpa-79fc78897f-2qv58  7m           1Mi
hpa-79fc78897f-cl7zv   4m           1Mi
hpa-79fc78897f-gwngb   3m           1Mi
hpa-79fc78897f-lqm2m   5m           1Mi
hpa-79fc78897f-thvjs   4m           1Mi
hpa-79fc78897f-ase3p   6m           1Mi
```

<br/>

- 예를 들어, 1개의 파드에서만 다음과 같이 부하가 발생한다면 해당 부하는 분산되지 않는다. 따라서 부하 분산을 위해서는 쿠버네티스 서비스를 통해 파드 그룹인 디플로이먼트에 도달해야 한다.
```
[root@m-k8s ~]# kubectl top pods
NAME                   CPU(cores)   MEMORY(bytes)
hpa-79fc78897f-2qv58   24m          1Mi
hpa-79fc78897f-cl7zv   0m           1Mi
hpa-79fc78897f-gwngb   0m           1Mi
hpa-79fc78897f-lqm2m   0m           1Mi
hpa-79fc78897f-thvjs   0m           1Mi
```

<br/>

- kubectl get hpa를 실행하면 HPA의 현재 상태를 요약해서 보여준다.
```
[root@m-k8s ~]# kubectl get hpa    
NAME  REFERENCE        TARGETS   MINPODS   MAXPODS   REPLICAS   AGE
hpa   Deployment/hpa   48%/50%   1         30        6          9m35s
```

<br/>

10. 테스트를 위해 화면을 다음과 같이 구성한다. 왼쪽에 마스터 노드 창 두 개를 띄운다. 오른쪽에는 파워셸 창을 띄운다. 여기에 호스트 컴퓨터에서 제공하는 부하가 출력된다. 왼쪽 상단 창에서는 watch kubectl top pods를, 왼쪽 하단 창에서는 watch kubectl get pods를 실행한다. 여기서 watch를 사용한 이유는 2초에 한 번씩 자동으로 상태를 확인하기 위해서이다.

![image](https://user-images.githubusercontent.com/61584142/161414921-ac1dd5f3-32af-4344-a02e-1e51a30d795b.png)

<br/>

11. HPA를 테스트하기 위해 오른쪽에 있는 파워셸 창에서 반복문을 실행한다. 부하를 주는 명령은 로드밸런서를 테스트했던 코드와 동일하다. 왼쪽 상단 창에서 부하량을 감지하는지 확인한다.
```
PS C:\Users\Hoon Jo - Pink>  $i=0; while($true)
{
  % { $i++; write-host -NoNewline "$i $_" }
  (Invoke-RestMethod "http://192.168.1.11")-replace '\n', " "
}
```

![image](https://user-images.githubusercontent.com/61584142/161414927-896d7fc8-c25b-4850-b1fe-21d5820f1644.png)

<br/>

12. 부하량이 늘어남에 따라 왼쪽 하단 창에서 파드가 새로 생성되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414936-7b177aa1-c95e-45d9-9b05-5587517a801c.png)

<br/>

13. 부하 분산으로 생성된 파드의 부하량이 증가하는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161414937-1dc4c465-1027-42a3-b220-1604c58a1a7d.png)

<br/>

14. 더 이상 파드가 새로 생성되지 않는 안정적인 상태가 되는 것을 확인하고, 부하를 생성하는 오른쪽 파워셸 창을 종료한다.

![image](https://user-images.githubusercontent.com/61584142/161414940-891ca301-70cc-452e-8a4b-aae350194116.png)

<br/>

15. 일정 시간이 지난 후 더 이상 부하가 없으면 autoscale의 최소 조건인 파드 1개의 상태로 돌아가기 위해 파드가 종료되는 것을 확인한다. 이번에는 시간이 좀 더 걸린다.

![image](https://user-images.githubusercontent.com/61584142/161414948-e94d86de-8979-4d4b-aef4-94d9db5bb30f.png)

<br/>

16. 사용하지 않는 파드는 모두 종료되고 1개만 남는다.

![image](https://user-images.githubusercontent.com/61584142/161414952-ed5ddcda-21fd-44f6-b103-117834749d66.png)

<br/>

17. 부하 테스트가 끝났다. 파드 부하량에 따라 HPA가 자동으로 파드 수를 조절하는 것을 확인했다. HPA를 잘 활용하면 자원의 사용을 극대화하면서 서비스 가동률을 높일 수 있다. 앞에서와 마찬가지로 생성한 디플로이먼트, 서비스, 메트릭 서버를 삭제한다. MetalLB는 계속 사용하므로 삭제하지 않는다.
```
[root@m-k8s ~]# kubectl delete deployment hpa-hname-pods
deployment.apps "hpa-hname-pods" deleted
[root@m-k8s ~]# kubectl delete hpa hpa-hname-pods
horizontalpodautoscaler.autoscaling "hpa-hname-pods" deleted
[root@m-k8s ~]# kubectl delete service hpa-hname-svc
service "hpa-hname-svc" deleted
[root@m-k8s ~]# kubectl delete -f ~/_Book_k8sInfra/ch3/3.3.5/metrics-server.yaml
clusterrole.rbac.authorization.k8s.io "system:aggregated-metrics-reader" deleted
clusterrolebinding.rbac.authorization.k8s.io "metrics-server:system:auth-delegator" deleted
rolebinding.rbac.authorization.k8s.io "metrics-server-auth-reader" deleted
apiservice.apiregistration.k8s.io "v1beta1.metrics.k8s.io" deleted
serviceaccount "metrics-server" deleted
deployment.apps "metrics-server" deleted
service "metrics-server" deleted
clusterrole.rbac.authorization.k8s.io "system:metrics-server" deleted
clusterrolebinding.rbac.authorization.k8s.io "system:metrics-server" deleted
```

<br/>

- 쿠버네티스에서 파드를 생성한 후에 실제로 쿠버네티스 외부의 사용자들이 쿠버네티스 내부에 있는 파드에 접속할 수 있도록 경로를 만들어주는 여러 가지 종류의 서비스들을 살펴봤다. 다음 절에서는 마지막으로 디플로이먼트 외에 다른 오브젝트를 사용해 보자.

<br/><br/><br/><br/>

## 3.4 알아두면 쓸모 있는 쿠버네티스 오브젝트
- 지금까지 파드를 안정적으로 사용하는 방법을 배우며 파드를 관리하는 여러 가지 기능이 포함된 디플로이먼트 오브젝트를 사용해 봤다. 디플로이먼트 외에도 용도에 따라 사용할 수 있는 다양한 오브젝트가 이미 정의돼 있다. 예를 들면 데몬셋, 컨피그맵, PV, PVC, 스테이트풀셋 등이 있다. 쿠버네티스가 발전함에 따라 사용되는 오브젝트는 계속 변하겠지만, 현존하는 다양한 오브젝트를 알아둔다면 쿠버네티스를 활용하고 추가로 개발되는 오브젝트에도 쉽게 적응할 수 있을 것이다. 마지막으로 몇 가지 오브젝트의 종류와 목적, 작동방식을 확인해 보자.

<br/><br/>

### 3.4.1 데몬셋
- 가장 먼저 살펴볼 것은 데몬셋(DaemonSet)이다. 데몬셋은 디플로이먼트의 replicas가 노드 수만큼 정해져 있는 형태라고 할 수 있는데, 노드 하나당 파드 한 개만을 생성한다.

<br/>

- 데몬셋은 언제 사용할까? 사실 데몬셋은 이미 여러 번 사용했다. Calico 네트워크 플러그인과 kube-proxy를 생성할 때 사용했고, MetalLB의 스피커에서도 사용했다. 이들의 공통점은 노드의 단일 접속 지점으로 노드 외부와 통신하는 것이다. 따라서 파드가 1개 이상 필요하지 않다. 결국 노드를 관리하는 파드라면 데몬셋으로 만드는 게 가장 효율적이다.

<br/>

**데몬셋을 만들어 보면서 데몬셋의 작동 원리를 확인해 보자.

<br/>

1. kubectl get pods -n metallb-system -o wide를 실행해 현재 MetalLB의 스피커가 각 노드에 분포돼 있는 상태를 확인한다.
```
[root@m-k8s ~]# kubectl get pods -n metallb-system -o wide
NAME                         …  STATUS    RESTARTS   AGE   IP               NODE   …
controller-65895b47d4-b845q  …  Running   0          47m   172.16.103.133   w2-k8s …
speaker-hzfmz                …  Running   0          47m   192.168.1.10     m-k8s  …
speaker-kqcxf                …  Running   0          47m   192.168.1.101    w1-k8s …
speaker-m7fxr                …  Running   0          47m   192.168.1.103    w3-k8s …
speaker-tsczn                …  Running   0          47m   192.168.1.102    w2-k8s …
```

<br/>

2. 워커 노드를 1개 늘린다. 호스트 컴퓨터의 C:\HashiCorp\_Book_k8sInfra-main\ch3\3.1.3 경로로 이동해 Vagrantfile의 5번째 줄에 있는 N 인자의 값을 3에서 4로 수정하면 된다.
- Vagrantfile 수정
```
# -*- mode: ruby -*-
# vi: set ft=ruby :
 
Vagrant.configure("2") do |config|
  N = 4 # max number of worker nodes 
  Ver = '1.18.4' # Kubernetes Version to install
 
  #=============#
  # Master Node #
  #=============#
       [생략]
```

<br/>

3. 호스트 컴퓨터의 명령 창에서 C:\HashiCorp\_Book_k8sInfra-main\ch3\3.1.3 경로로 이동한 다음 vagrant up w4-k8s를 실행한다. 새로운 워커 노드(w4-k8s)를 추가하는 명령이다.
```
C:\Users\Hoon Jo - Pink>cd C:\HashiCorp\_Book_k8sInfra-main\ch3\3.1.3
C:\HashiCorp\_Book_k8sInfra-main\ch3\3.1.3>vagrant up w4-k8s
Bringing machine 'w4-k8s' up with 'virtualbox' provider...
==> w4-k8s: Importing base box 'sysnet4admin/CentOS-k8s'...
==> w4-k8s: Matching MAC address for NAT networking...
[생략]
```

<br/>

4. w4-k8s이 추가되면 m-k8s에서 kubectl get pods -n metallb-system -o wide -w를 수행한다. 여기서 -w는 watch의 약어로 오브젝트 상태에 변화가 감지되면 해당 변화를 출력한다. 리눅스에서 tail -f와 비슷한 역할을 한다. 변화를 모두 확인했다면 Ctrl+C를 눌러 명령을 중지한다.
```
[root@m-k8s ~]# kubectl get pods -n metallb-system -o wide -w
NAME                 …  STATUS              RESTARTS  …  IP               NODE   …
controller-…-b845q   …  Running             0         …  172.16.103.133   w2-k8s …
speaker-hzfmz        …  Running             0         …  192.168.1.10     m-k8s  …
speaker-kqcxf        …  Running             0         …  192.168.1.101    w1-k8s …
speaker-m7fxr        …  Running             0         …  192.168.1.103    w3-k8s …
speaker-tsczn        …  Running             0         …  192.168.1.102    w2-k8s …
# 추가된 워커 노드에 daemonset인 speaker가 설치됨 
speaker-vnc2k        …  Pending             0         …  <none>           <none> …
speaker-vnc2k        …  Pending             0         …  <none>           w4-k8s …
speaker-vnc2k        …  ContainerCreating   0         …  192.168.1.104    w4-k8s …
speaker-vnc2k        …  Running             0         …  192.168.1.104    w4-k8s …
```

<br/>

5. 자동으로 추가된 노드에 설치된 스피커가 데몬셋이 맞는지 kubectl get pods speaker-vnc2k -o yaml -n metallb-system을 실행해 확인한다. 스피커 이름(speaker-vnc2k)은 각자 생성된 이름으로 넣으면 된다.
```
[root@m-k8s ~]# kubectl get pods speaker-vnc2k -o yaml -n metallb-system
apiVersion: v1
kind: Pod
metadata:
  annotations:
    prometheus.io/port: "7472"
    prometheus.io/scrape: "true"
  creationTimestamp: "2020-02-23T13:05:31Z"
  generateName: speaker-
  labels:
    app: metallb
    component: speaker
    controller-revision-hash: f6cf9fd9f
    pod-template-generation: "1"
  name: speaker-vnc2k
  namespace: metallb-system
  ownerReferences:
  - apiVersion: apps/v1
    blockOwnerDeletion: true
    controller: true
    kind: DaemonSet
    name: speaker
    uid: aa82a626-c398-4643-a2e4-e918de4519ae
  resourceVersion: "12316" 
[생략]
```

<br/>

- 추가된 워커 노드에 데몬셋이 정상적으로 설치되고 작동하는 것을 확인해 봤다.

<br/><br/>

### 3.4.2 컨피그맵
- 컨피그맵(ConfigMap)은 이름 그대로 설정(config)을 목적으로 사용하는 오브젝트다. MetalLB를 구성할 때 컨피그맵을 사용해 봤다. 인그레스에서는 설정을 위해 오브젝트를 인그레스로 선언했는데, 왜 MetalLB에서는 컨피그맵을 사용했을까? 명확하게 규정하기는 어려운데 인그레스는 오브젝트가 인그레스로 지정돼 있지만, MetalLB는 프로젝트 타입으로 정해진 오브젝트가 없어서 범용 설정으로 사용되는 컨피그맵을 지정했다.

<br/>

**컨피그맵으로 작성된 MetalLB의 IP 설정을 변경해 보자.

<br/>

1. 테스트용 디플로이먼트를 cfgmap이라는 이름으로 생성한다.
```
[root@m-k8s ~]# kubectl create deployment cfgmap --image=sysnet4admin/echo-hname
deployment.apps/cfgmap created
```

<br/>

2. cfgmap을 로드밸런서(MetalLB)를 통해 노출하고 이름은 cfgmap-svc로 지정한다.
```
[root@m-k8s ~]# kubectl expose deployment cfgmap --type=LoadBalancer --name=cfgmap-svc --port=80
service/cfgmap-svc exposed
```

<br/>

3. 생성된 서비스의 IP(192.168.1.11)를 확인한다.
```
[root@m-k8s ~]# kubectl get services
NAME         TYPE           CLUSTER-IP      EXTERNAL-IP    PORT(S)        AGE
cfgmap-svc   LoadBalancer   10.100.199.95   192.168.1.11  80:31463/TCP   2m5s
kubernetes   ClusterIP      10.96.0.1       <none>         443/TCP        4h13m
```

<br/>

4. 사전에 구성돼 있는 컨피그맵의 기존 IP(192.168.1.11~192.168.1.13)를 sed 명령을 사용해 192.168.1.21~192.168.1.23으로 변경한다.
```
[root@m-k8s ~]# cat ~/_Book_k8sInfra/ch3/3.4.2/metallb-l2config.yaml | grep 192.
      - 192.168.1.11-192.168.1.13 
[root@m-k8s ~]# sed -i 's/11/21/;s/13/23/' ~/_Book_k8sInfra/ch3/3.4.2/metallb-l2config.yaml 
[root@m-k8s ~]# cat ~/_Book_k8sInfra/ch3/3.4.2/metallb-l2config.yaml | grep 192.
      - 192.168.1.21-192.168.1.23
```

<br/>

5. 컨피그맵 설정 파일(metallb-l2config.yaml)에 apply를 실행해 변경된 설정을 적용한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.2/metallb-l2config.yaml
configmap/config configured
```

<br/>

6. MetalLB와 관련된 모든 파드를 삭제한다. 삭제하고 나면 kubelet에서 해당 파드를 자동으로 모두 다시 생성한다. --all은 파드를 모두 삭제하는 옵션이다.
```
[root@m-k8s ~]# kubectl delete pods --all -n metallb-system
pod "controller-65895b47d4-b845q" deleted
pod "speaker-hzfmz" deleted
pod "speaker-kqcxf" deleted
pod "speaker-m7fxr" deleted
pod "speaker-tsczn" deleted
pod "speaker-vnc2k" deleted
```

<br/>

7. 새로 생성된 MetalLB의 파드들을 확인한다.
```
[root@m-k8s ~]# kubectl get pods -n metallb-system
NAME                          READY   STATUS    RESTARTS   AGE
controller-65895b47d4-br55j   1/1     Running   0          19s
speaker-c82jh                 1/1     Running   0          18s
speaker-fx5g2                 1/1     Running   0          18s
speaker-pz9cz                 1/1     Running   0          17s
speaker-sknhk                 1/1     Running   0          18s
speaker-wglxt                 1/1     Running   0          17s
```

<br/>

8. 기존에 노출한 MetalLB 서비스(cfgmap-svc)를 삭제(delete)하고 동일한 이름으로 다시 생성해 새로운 컨피그맵을 적용한 서비스가 올라오게 한다.
```
[root@m-k8s ~]# kubectl delete service cfgmap-svc
service "cfgmap-svc" deleted
[root@m-k8s ~]# kubectl expose deployment cfgmap --type=LoadBalancer --name=cfgmap-svc --port=80
service/cfgmap-svc exposed
```

<br/>

9. 변경된 설정이 적용돼 새로운 MetalLB 서비스의 IP가 192.168.1.21로 바뀌었는지 확인한다.
```
[root@m-k8s ~]# kubectl get services
NAME         TYPE           CLUSTER-IP       EXTERNAL-IP    PORT(S)        AGE
cfgmap-svc   LoadBalancer   10.103.110.132   192.168.1.21  80:32632/TCP   41s 
kubernetes   ClusterIP      10.96.0.1        <none>         443/TCP        124m 
```

<br/>

10. 호스트 컴퓨터의 브라우저에서 192.168.1.21로 접속해 파드의 이름이 화면에 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161415642-1c0a9520-6c3c-4bf2-b44e-4fd69ef4477c.png)

<br/>

11. 이름이 표시되므로 설정 변경이 성공했다. 다음 테스트를 위해 생성한 디플로이먼트와 서비스를 삭제한다.
```
[root@m-k8s ~]# kubectl delete deployment cfgmap
deployment.apps "cfgmap" deleted
[root@m-k8s ~]# kubectl delete service cfgmap-svc
service "cfgmap-svc" deleted
```

<br/><br/>

### 3.4.3 PV와 PVC
- 이제 파드가 언제라도 생성되고 지워진다는 것을 충분히 알았을 것이다. 쿠버네티스에서 의도적으로 이렇게 구현했다. 그런데 때때로 파드에서 생성한 내용을 기록하고 보관하거나 모든 파드가 동일한 설정 값을 유지하고 관리하기 위해 공유된 볼륨으로부터 공통된 설정을 가지고 올 수 있도록 설계해야 할 때도 있다.

<br/>

**쿠버네티스는 이런 경우를 위해 다음과 같은 목적으로 다양한 형태의 볼륨을 제공한다.
- 임시: emptyDir
- 로컬: host Path, local
- 원격: persistentVolumeClaim, cephfs, cinder, csi, fc(fibre channel), flexVolume, flocker, glusterfs, iscsi, nfs, portworxVolume, quobyte, rbd, scaleIO, storageos, vsphereVolume
- 특수 목적: downwardAPI, configMap, secret, azureFile, projected
- 클라우드: awsElasticBlockStore, azureDisk, gcePersistentDisk

<br/>

- 다양한 쿠버네티스 볼륨 스토리지 중에서 PV와 PVC를 설명하겠다. PV와 PVC의 관계를 이해한다면 다른 볼륨 스토리지도 쉽게 이해할 수 있다.

<br/>

- 쿠버네티스는 필요할 때 **PVC(PersistentVolumeClaim, 지속적으로 사용 가능한 볼륨 요청)** 를 요청해 사용한다. PVC를 사용하려면 **(PersistentVolume, 지속적으로 사용 가능한 볼륨)** 볼륨을 선언해야 한다. 간단하게 PV는 볼륨을 사용할 수 있게 준비하는 단계이고, PVC는 준비된 볼륨에서 일정 공간을 할당받는 것이다. 비유하면 PV는 요리사(관리자)가 피자를 굽는 것이고, PVC는 손님(사용자)가 원하는 만큼의 피자를 접시에 담아 가져오는 것이다.

<br/>

**PV로 볼륨을 선언할 수 있는 타입은 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161415702-b4ca7f8e-47fd-4143-9d82-e91998fe1cbd.png)

<br/>

- 그러면 가장 구현하기 쉬운 NFS 볼륨 타입으로 PV와 PVC를 생성하고 파드에 마운트해 보면서 실제로 어떻게 작동하는지 확인해 보자.

![image](https://user-images.githubusercontent.com/61584142/161415711-a8aa2aae-6867-4aa1-ba33-5ff58bd45b06.png)

<br/>

**NFS 볼륨에 PV/PVC를 만들고 파드에 연결하기

<br/>

1. PV로 선언할 볼륨을 만들기 위해 NFS 서버를 마스터 노드에 구성한다. 공유되는 디렉터리는 /nfs_shared로 생성하고, 해당 디렉터리를 NFS로 받아들일 IP 영역은 192.168.1.0/24로 정한다. 옵션을 적용해 /etc/exports에 기록한다. 옵션에서 rw는 읽기/쓰기, sync는 쓰기 작업 동기화, no_root_squash는 root 계정 사용을 의미한다. 이때 nfs-utils.x86_64는 현재 CentOS에 이미 설치돼 있으므로 설치하지 않아도 된다.
```
[root@m-k8s ~]# mkdir /nfs_shared
[root@m-k8s ~]# echo '/nfs_shared 192.168.1.0/24(rw,sync,no_root_squash)' >> /etc/exports
```

<br/>

2. 해당 내용을 시스템에 적용해 NFS 서버를 활성화하고 다음에 시작할 때도 자동으로 적용되도록 systemctl enable --now nfs 명령을 실행한다.
```
[root@m-k8s ~]# systemctl enable --now nfs
Created symlink from /etc/systemd/system/multi-user.target.wants/nfs-server.service to /usr/lib/systemd/system/nfs-server.service.
```

<br/>

3. 다음 경로에 있는 오브젝트 스펙을 실행해 PV를 생성한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-pv.yaml
persistentvolume/nfs-pv created
```

<br/>

- 오브젝트 스펙은 다음과 같다. 이제 파일 구조에 익숙할 테니 새로 나온 몇 가지만 설명하겠다.
- nfs-pv.yaml
```
apiVersion: v1
kind: PersistentVolume
metadata:
 name: nfs-pv
spec:
 capacity:
 storage: 100Mi
 accessModes:
 - ReadWriteMany
 persistentVolumeReclaimPolicy: Retain
 nfs:
 server: 192.168.1.10
 path: /nfs_shared
```
- 6~7번째 줄: storage는 실제로 사용하는 용량을 제한하는 것이 아니라 쓸 수 있는 양을 레이블로 붙이는 것과 같다. 이는 현재 스토리지가 단순히 NFS로 설정돼서 그렇다. 용량을 제한하는 방법은 ‘볼륨 용량을 제한하는 방법’에 자세히 나와 있다.
- 8~9번째 줄: PV를 어떤 방식으로 사용할지를 정의한 부분이다. ReadWriteMany는 여러 개의 노드가 읽고 쓸 수 있도록 마운트하는 옵션이다. 이외에도 ReadWriteOnce(하나의 노드에서만 볼륨을 읽고 쓸 수 있게 마운트)와 ReadOnlyMany(여러 개의 노드가 읽도록 마운트) 옵션이 있다.
- 10번째 줄: persistentVolumeReclaimPolicy는 PV가 제거됐을 때 작동하는 방법을 정의하는 것으로, 여기서는 유지하는 Retain을 사용한다. 그 외에 Delete(삭제)와 Recycle(재활용, Deprecated) 옵션이 있다.
- 11~13번째 줄: NFS 서버의 연결 위치에 대한 설정이다.

<br/>

4. kubectl get pv를 실행해 생성된 PV의 상태가 Available(사용 가능)임을 확인한다.
```
[root@m-k8s ~]# kubectl get pv
NAME     CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS      …    AGE
nfs-pv   100Mi      RWX            Retain           Available  …    80s
```

<br/>

5. 다음 경로에서 오브젝트 스펙을 실행해 PVC를 생성한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-pvc.yaml
persistentvolumeclaim/nfs-pvc created
```

<br/>

- 해당 오브젝트 스펙은 다음과 같다.
- nfs-pvc.yaml
```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: nfs-pvc  
spec:
  accessModes:
    - ReadWriteMany
  resources:
    requests:
      storage: 10Mi
```

<br/>

- PVC는 PV와 구성이 거의 동일하다. 하지만 PV는 사용자가 요청할 볼륨 공간을 관리자가 만들고, PVC는 사용자(개발자)간 볼륨을 요청하는 데 사용한다는 점에서 차이가 있다. 여기서 요청하는 storage: 10Mi는 동적 볼륨이 아닌 경우에는 레이블 정도의 의미를 가진다. 모든 설정이 완료되고 파드에 마운트된 볼륨에서 용량을 확인하면 그 의미를 좀 더 확실하게 알 수 있다.

<br/>

#### PV와 PVC의 관계도

![image](https://user-images.githubusercontent.com/61584142/161415808-b2ba70e2-301a-45cf-a341-972ffba70253.png)

<br/>

6. 생성된 PVC를 kubectl get pvc로 확인한다. 여기서 두 가지를 살펴봐야 한다. 첫 번째는 상태가 Bound(묶여짐)로 변경됐다는 것이다. 이는 PV와 PVC가 연결됐음을 의미한다. 두 번째로 용량이 설정한 10Mi가 아닌 100Mi라는 것이다. 사실 용량은 동적으로 PVC를 따로 요청해 생성하는 경우가 아니면 큰 의미가 없다. 따라서 Bound만 확인하면 된다.
```
[root@m-k8s ~]# kubectl get pvc
NAME      STATUS   VOLUME   CAPACITY   ACCESS MODES   STORAGECLASS   AGE
nfs-pvc   Bound   nfs-pv   100Mi     RWX                           39s
```

<br/>

7. PV의 상태도 Bound로 바뀌었음을 kubectl get pv로 확인한다.
```
[root@m-k8s ~]# kubectl get pv
NAME     CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS   …  AGE
nfs-pv   100Mi      RWX            Retain           Bound   …  4m59s
```

<br/>

8. 생성한 PVC를 볼륨으로 사용하는 디플로이먼트 오브젝트 스펙을 배포한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-pvc-deploy.yaml
deployment.apps/nfs-pvc-deploy created
```

<br/>

- 배포한 스펙은 다음과 같다.
- nfs-pvc-deploy.yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nfs-pvc-deploy
spec:
  replicas: 4
  selector:
    matchLabels:
      app: nfs-pvc-deploy
  template:
    metadata:
      labels:
        app: nfs-pvc-deploy
    spec:
      containers:
      - name: audit-trail
        image: sysnet4admin/audit-trail
        volumeMounts:
        - name: nfs-vol
          mountPath: /audit
      volumes:
      - name: nfs-vol
        persistentVolumeClaim:
          claimName: nfs-pvc
```

- 15~17번째 줄: audit-trail 이미지를 가지고 온다. 해당 컨테이너 이미지는 요청을 처리할 때마다 접속 정보를 로그로 기록한다.
- 18~20번째 줄: 볼륨이 마운트될 위치(/audit)를 지정한다.
- 21~24번째 줄: PVC로 생성된 볼륨을 마운트하기 위해서 nfs-pvc라는 이름을 사용한다.

<br/>

9. 생성된 파드를 확인한다.
```
[root@m-k8s ~]# kubectl get pods        
NAME                              READY   STATUS    RESTARTS   AGE
nfs-pvc-deploy-7888b77964-69c8n   1/1     Running   0          2m55s
nfs-pvc-deploy-7888b77964-mj6mt   1/1     Running   0          2m55s
nfs-pvc-deploy-7888b77964-q2gjw   1/1     Running   0          2m55s
nfs-pvc-deploy-7888b77964-qwwsm   1/1     Running   0          2m55s
```

<br/>

10. 생성한 파드 중 하나에 exec로 접속한다.
```
[root@m-k8s ~]# kubectl exec -it nfs-pvc-deploy-7888b77964-69c8n -- /bin/bash
root@nfs-pvc-deploy-7888b77964-69c8n:/#
```

<br/>

11. df -h를 실행해 PVC의 마운트 상태를 확인한다. 용량이 100Mi가 아닌 NFS 서버의 용량이 37G임을 확인한다. PVC 요청에 맞게 용량을 사용할 수 있는 방법은 나중에 살펴보겠다.
```
root@nfs-pvc-deploy-7888b77964-69c8n:/# df -h
Filesystem                   Size  Used Avail Use% Mounted on
overlay                       37G  2.6G   35G   7% /
tmpfs                        496M     0  496M   0% /dev
tmpfs                        496M     0  496M   0% /sys/fs/cgroup
192.168.1.10:/nfs_shared     37G  3.2G   34G   9% /audit
/dev/mapper/centos_k8s-root   37G  2.6G   35G   7% /etc/hosts
shm                           64M     0   64M   0% /dev/shm
tmpfs                        496M   12K  496M   1% /run/secrets/kubernetes.io/serviceaccount
tmpfs                        496M     0  496M   0% /proc/acpi
tmpfs                        496M     0  496M   0% /proc/scsi
tmpfs                        496M     0  496M   0% /sys/firmware 
```

<br/>

12. 오른쪽에 m-k8s 명령 창을 1개 더 열고 audit-trail 컨테이너의 기능을 테스트한다. 외부에서 파드(nfs-pv-deploy)에 접속할 수 있도록 expose로 로드밸런서 서비스를 생성한다.
```
[root@m-k8s ~]# kubectl expose deployment nfs-pvc-deploy --type=LoadBalancer --name=nfs-pvc-deploy-svc --port=80
service/nfs-pvc-deploy-svc exposed
```

<br/>

13. 생성한 로드밸런서 서비스의 IP를 확인한다.
```
[root@m-k8s ~]# kubectl get services
NAME                 TYPE           CLUSTER-IP      EXTERNAL-IP    PORT(S)        AGE
kubernetes           ClusterIP      10.96.0.1       <none>         443/TCP        7d4h
nfs-pvc-deploy-svc   LoadBalancer   10.105.87.182   192.168.1.21  80:30840/TCP   9s
```

<br/>

14. 호스트 컴퓨터에서 브라우저를 연다. 192.168.1.21에 접속해 파드 이름과 IP가 표시되는지 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161415899-ae178d40-f8bb-4f38-a759-342241565cbd.png)

<br/>

15. exec를 통해 접속한 파드에서 ls /audit 명령을 실행해 접속 기록 파일이 남았는지 확인한다. cat으로 해당 파일의 내용도 함께 확인한다.
```
root@nfs-pvc-deploy-7888b77964-69c8n:/# ls /audit
audit_nfs-pvc-deploy-7888b77964-qwwsm.log
root@nfs-pvc-deploy-7888b77964-69c8n:/# cat /audit/audit_nfs-pvc-deploy-7888b77964-qwwsm.log
03/Mar/2020:20:25:00 +0900 172.16.221.144 GET
```

<br/>

16. 마스터 노드(m-k8s)에서 scale 명령으로 파드를 4개에서 8개로 증가시킨다.
```
[root@m-k8s ~]# kubectl scale deployment nfs-pvc-deploy --replicas=8
deployment.apps/nfs-pvc-deploy scaled
```

<br/>

17. 생성된 파드를 확인한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                              READY   STATUS    RESTARTS   AGE
nfs-pvc-deploy-7888b77964-69c8n   1/1     Running   0          8m27s
nfs-pvc-deploy-7888b77964-c6nrp   1/1     Running   0          13s
nfs-pvc-deploy-7888b77964-knb92   1/1     Running   0          13s
nfs-pvc-deploy-7888b77964-mj6mt   1/1     Running   0          8m27s
nfs-pvc-deploy-7888b77964-q2gjw   1/1     Running   0          8m27s
nfs-pvc-deploy-7888b77964-qwwsm   1/1     Running   0          8m27s
nfs-pvc-deploy-7888b77964-v7h6w   1/1     Running   0          13s
nfs-pvc-deploy-7888b77964-wpj5c   1/1     Running   0          13s 
```

<br/>

18. 최근에 증가한 4개의 파드 중 1개를 선택해 exec로 접속하고 기록된 audit 로그가 동일한지 확인한다.
```
[root@m-k8s ~]# kubectl exec -it nfs-pvc-deploy-7888b77964-c6nrp -- /bin/bash
root@nfs-pvc-deploy-7888b77964-c6nrp:/# cat /audit/audit_nfs-pvc-deploy-7888b77964-qwwsm.log
03/Mar/2020:20:25:00 +0900 172.16.221.144 GET
```

<br/>

19. 다른 브라우저를 열고 192.168.1.21로 접속해 다른 파드 이름과 IP가 표시되는지를 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161415926-4eeef921-a208-4234-9c04-6bc1836860e0.png)

<br/>

20. exec로 접속한 파드에서 ls /audit을 실행해 새로 추가된 audit 로그를 확인한다. 그리고 cat으로 기록된 내용도 함께 확인한다.
```
root@nfs-pvc-deploy-7888b77964-c6nrp:/# ls /audit
audit_nfs-pvc-deploy-7888b77964-mj6mt.log audit_nfs-pvc-deploy-7888b77964-qwwsm.log
root@nfs-pvc-deploy-7888b77964-c6nrp:/# cat /audit/audit_nfs-pvc-deploy-7888b77964-mj6mt.log
03/Mar/2020:20:29:19 +0900 172.16.103.142 GET
```

<br/>

21. 기존에 접속한 파드에서도 동일한 로그가 audit에 기록돼 있는지 확인한다.
```
root@nfs-pvc-deploy-7888b77964-69c8n:/# ls /audit
audit_nfs-pvc-deploy-7888b77964-mj6mt.log audit_nfs-pvc-deploy-7888b77964-qwwsm.log
```

<br/><br/>

#### NFS 볼륨을 파드에 직접 마운트하기

<br/>

1. 사용자가 관리자와 동일한 단일 시스템이라면 PV와 PVC를 사용할 필요가 없다. 따라서 단순히 볼륨을 마운트하는지 확인하고 넘어가겠다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-ip.yaml
deployment.apps/nfs-ip created
```

<br/>

- 코드를 살펴보면 21~25번째 줄에서 PV와 PVC를 거치지 않고 바로 NFS 서버로 접속하는 것을 확인할 수 있다.
- nfs-ip.yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: nfs-ip
spec:
  replicas: 4
  selector:
    matchLabels:
      app: nfs-ip
  template:
    metadata:
      labels:
        app: nfs-ip
    spec:
      containers:
      - name: audit-trail
        image: sysnet4admin/audit-trail
        volumeMounts:
        - name: nfs-vol
          mountPath: /audit
      volumes:
      - name: nfs-vol
        nfs:
          server: 192.168.1.10
          path: /nfs_shared
```

<br/>

2. 새로 배포된 파드를 확인하고 그중 하나에 exec로 접속한다.
```
[root@m-k8s ~]# kubectl get pods
NAME                              READY   STATUS    RESTARTS   AGE
nfs-ip-84fd4d6f69-475vb           1/1     Running   0          20s
nfs-ip-84fd4d6f69-59xsv           1/1     Running   0          20s
nfs-ip-84fd4d6f69-7nrp6           1/1     Running   0          20s
nfs-ip-84fd4d6f69-h56qc           1/1     Running   0          20s 
[생략]
[root@m-k8s ~]# kubectl exec -it nfs-ip-84fd4d6f69-475vb -- /bin/bash
root@nfs-ip-84fd4d6f69-475vb:/# 
```

<br/>

3. 접속한 파드에서 ls /audit를 실행해 동일한 NFS 볼륨을 바라보고 있음을 확인한다.
```
root@nfs-ip-84fd4d6f69-475vb:/# ls /audit
audit_nfs-pvc-deploy-7888b77964-mj6mt.log audit_nfs-pvc-deploy-7888b77964-qwwsm.log
```

<br/>

4. 다음 진행을 위해 설치한 PV와 PVC를 제외한 나머지인 파드와 서비스를 삭제한다.
```
[root@m-k8s ~]# kubectl delete deployment nfs-pvc-deploy
deployment.apps "nfs-pvc-deploy" deleted
[root@m-k8s ~]# kubectl delete deployment nfs-ip
deployment.apps "nfs-ip" deleted
[root@m-k8s ~]# kubectl delete service nfs-pvc-deploy-svc
service "nfs-pvc-deploy-svc" deleted
```

<br/>

- 실제로 PV와 PVC를 구성해서 PV와 PVC를 구성하는 주체가 관리자와 사용자로 나뉜다는 것을 확인했다. 또한 관리자와 사용자가 나뉘어 있지 않다면 굳이 PV와 PVC를 통하지 않고 바로 파드에 공유가 가능한 NFS 볼륨을 마운트할 수 있음을 알았다.

<br/><br/>

#### 볼륨 용량을 제한하는 방법
- 볼륨 용량을 제한하는 방법은 크게 두 가지가 있다. 첫 번째는 PVC로 PV에 요청되는 용량을 제한하는 것이고, 두 번째는 스토리지 리소스에 대한 사용량을 제한하는 것이다.

<br/>

**먼저 PVC로 PV에 요청되는 용량을 제한하는 방법을 살펴보자.

<br/>

1. PVC로 PV를 요청할 때 용량을 제한하는 오브젝트 스펙을 가져와 적용한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/limits-pvc.yaml
limitrange/storagelimits created
```

<br/>

- 다음 코드를 적용하면 PVC를 통해 PV를 요청할 때 최소 1Mi에서 최대 5Mi로 용량을 제한한다.
- limits-pvc.yaml
```
apiVersion: v1
kind: LimitRange
metadata:
 name: storagelimits
spec:
 limits:
 - type: PersistentVolumeClaim
 max:
   storage: 5Mi
 min:
   storage: 1Mi
```

<br/>

2. PV와 PVC를 새로 생성하고 PVC가 최대 용량 제한(5Mi)에 걸려 수행되지 못하는지 확인한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-pv.yaml
persistentvolume/nfs-pv created
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/nfs-pvc.yaml
Error from server (Forbidden): error when creating "/root/_Book_k8sInfra/ch3/3.4.3/nfs-pvc.yaml": persistentvolumeclaims "nfs-pvc" is forbidden: maximum storage usage per PersistentVolumeClaim is 5Mi, but request is 10Mi
```

<br/>

3. 용량 제한 설정을 삭제한다.
```
[root@m-k8s ~]# kubectl delete limitranges storagelimits
limitrange "storagelimits" deleted
```

<br/>

**두 번째 방법인 스토리지 리소스에 대한 총 용량을 제한하는 방법도 살펴보자.

<br/>

1. 총 누적 사용량을 제한하기 위해 다음 오브젝트 스펙을 적용한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.3/quota-pvc.yaml
resourcequota/storagequota created
```

<br/>

- 해당 코드는 PVC는 5개, 용량은 25Mi가 넘지 않도록 제한한다.
- quota-pvc.yaml
```
apiVersion: v1
kind: ResourceQuota
metadata:
 name: storagequota
spec:
 hard:
   persistentvolumeclaims: "5"
   requests.storage: "25Mi"
```

<br/>

2. 지금까지 배운 내용을 활용해 PV 3개((100Mi)의 상태를 만들고 오브젝트 스펙을 작성한다. 그런 다음 PVC 3개(10Mi)를 요청해 25Mi 제한으로 더 이상 PVC가 수행되지 못하는지 확인한다.
```
[root@m-k8s ~]# kubectl get pv
NAME      CAPACITY   ACCESS MODES   RECLAIM POLICY   STATUS       …    AGE
nfs-pv    100Mi      RWX            Retain           Available    …    2s
nfs-pv1   100Mi      RWX            Retain           Available    …    2m4s
nfs-pv2   100Mi      RWX            Retain           Available    …    2m1s
[root@m-k8s ~]# kubectl apply -f nfs-pvc.yaml
persistentvolumeclaim/nfs-pvc created
[root@m-k8s ~]# kubectl apply -f nfs-pvc1.yaml
persistentvolumeclaim/nfs-pvc1 created
[root@m-k8s ~]# kubectl apply -f nfs-pvc2.yaml
Error from server (Forbidden): error when creating "nfs-pvc2.yaml": persistentvolumeclaims "nfs-pvc2" is forbidden: exceeded quota: storagequota, requested: requests.storage=10Mi, used: requests.storage=20Mi, limited: requests.storage=25Mi
```

<br/>

3. PVC를 생성하기 위해 설정한 리소스 제한을 삭제한다.
```
[root@m-k8s ~]# kubectl delete resourcequotas storagequota
resourcequota "storagequota" deleted
```

<br/>

4. 과도하게 생성한 PV(nfs-pv1, nfs-pv2)와 PVC(nfs-pvc1)를 삭제한다. 이때 Bound(PV와 PVC가 연결된 대상)의 상대를 잘 보고 삭제해야 한다. Bound는 기본적으로 생성된 시간에 맞춰 연결된다.
```
[root@m-k8s ~]# kubectl delete pvc nfs-pvc1
persistentvolumeclaim "nfs-pvc1" deleted
[root@m-k8s ~]# kubectl delete pv nfs-pv2
persistentvolume "nfs-pv2" deleted
[root@m-k8s ~]# kubectl delete pv nfs-pv1
persistentvolume "nfs-pv1" deleted
```

<br/><br/>

### 3.4.4 스테이트풀셋
- 지금까지는 파드가 replicas에 선언된 만큼 무작위로 생성될 뿐이었다. 그런데 파드가 만들어지는 이름과 순서를 예측해야 할 때가 있다. 주로 레디스(Redis), 주키퍼(Zookeper), 카산드라(Cassandra), 몽고DB(MongoDB) 등의 마스터-슬레이브 구조 시스템에서 필요하다.

<br/>

**스테이트풀렛(StatefulSet)** 을 사용한다. 스테이트풀셋은 volumeClaimTemplates 기능을 사용해 PVC를 자동으로 생성할 수 있고, 각 파드가 순서대로 생성되기 때문에 고정된 이름, 볼륨, 설정 등을 가질 수 있다. 그래서 StatefulSet(이전 상태를 기억하는 세트)이라는 이름을 사용한다. 다만, 효율성 면에서 좋은 구조가 아니므로 요구 사항에 맞게 적절히 사용하는 것이 좋다.

<br/>

- 스테이트풀셋을 직접 만들어 보면서 생성 과정을 살펴보고 어떤 형태의 고정 값을 가지는지 알아보자. 참고로 스테이트풀셋은 디플로이먼트와 형제나 다름없는 구조라 디플로이먼트에서 오브젝트 종류를 변경하면 바로 실습할 수 있다.

<br/>

1. PV와 PVC는 앞에서 이미 생성했으므로 바로 스테이트풀셋을 다음 명령으로 생성한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.4/nfs-pvc-sts.yaml
statefulset.apps/nfs-pvc-sts created
```

<br/>

- 7번째 줄에 serviceName이 추가된 것 외에는 앞의 nfs-pvc-deploy.yaml 코드와 동일하다.
- nfs-pvc-sts.yaml
```
apiVersion: apps/v1
kind: StatefulSet
metadata:
  name: nfs-pvc-sts
spec:
  replicas: 4
  serviceName: sts-svc-domain #statefulset need it
  selector:
    matchLabels:
      app: nfs-pvc-sts
  template:
    metadata:
      labels:
        app: nfs-pvc-sts
    spec:
      containers:
      - name: audit-trail
        image: sysnet4admin/audit-trail
        volumeMounts:
        - name: nfs-vol
          mountPath: /audit
      volumes:
      - name: nfs-vol
        persistentVolumeClaim:
          claimName: nfs-pvc
```

<br/>

2. 앞의 명령을 실행한 후에 파드가 생성되는지는 kubectl get pods -w 명령으로 확인한다. 다음과 같이 순서대로 하나씩 생성하는 것을 볼 수 있다.
```
[root@m-k8s ~]# kubectl get pods -w
NAME            READY   STATUS              RESTARTS   AGE
nfs-pvc-sts-0   0/1     ContainerCreating   0          3s
nfs-pvc-sts-0   1/1     Running             0          9s
nfs-pvc-sts-1   0/1     Pending             0          0s
nfs-pvc-sts-1   0/1     Pending             0          0s
nfs-pvc-sts-1   0/1     ContainerCreating   0          0s
nfs-pvc-sts-1   0/1     ContainerCreating   0          1s
nfs-pvc-sts-1   1/1     Running             0          5s
nfs-pvc-sts-2   0/1     Pending             0          0s
nfs-pvc-sts-2   0/1     Pending             0          0s
nfs-pvc-sts-2   0/1     ContainerCreating   0          0s
nfs-pvc-sts-2   0/1     ContainerCreating   0          1s
nfs-pvc-sts-2   1/1     Running             0          6s
nfs-pvc-sts-3   0/1     Pending             0          0s
nfs-pvc-sts-3   0/1     Pending             0          0s
nfs-pvc-sts-3   0/1     ContainerCreating   0          0s
nfs-pvc-sts-3   0/1     ContainerCreating   0          1s
nfs-pvc-sts-3   1/1     Running             0          6s
```

<br/>

3. 생성한 스테이트풀셋에 expose를 실행한다. 그런데 에러가 발생한다. 이는 expose 명령이 스테이트풀셋을 지원하지 않기 때문이다. 해결하려면 파일로 로드밸런서 서비스를 작성, 실행해야 한다.
```
[root@m-k8s ~]# kubectl expose statefulset nfs-pvc-sts --type=LoadBalancer --name=nfs-pvc-sts-svc --port=80
error: cannot expose a StatefulSet.apps
```

- expose 명령으로 서비스를 생성할수 있는 오브젝트는 디플로이먼트, 파드, 레플리카셋, 레플리케이션 컨트롤러다.

<br/>

4. 다음 경로를 적용해 스테이트풀셋을 노출하기 위한 서비스를 생성하고, kubectl get service 명령으로 생성한 로드밸런서 서비스를 확인한다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.4/nfs-pvc-sts-svc.yaml
service/nfs-pvc-sts-svc created
[root@m-k8s ~]# kubectl get services
NAME              TYPE           CLUSTER-IP      EXTERNAL-IP    PORT(S)        AGE
kubernetes        ClusterIP      10.96.0.1       <none>         443/TCP        8d
nfs-pvc-sts-svc   LoadBalancer   10.100.83.174   192.168.1.21   80:32125/TCP   59s
```

<br/>

- 해당 코드는 다음과 같다.
- nfs-pvc-sts-svc.yaml
```
apiVersion: v1
kind: Service
metadata:
  name: nfs-pvc-sts-svc
spec:
  selector:
    app: nfs-pvc-sts
  ports:
    - port: 80
  type: LoadBalancer
```

<br/>

5. 호스트 컴퓨터에서 브라우저를 연다. 192.168.1.21에 접속해 파드 이름과 IP가 표시되는지를 확인한다.

![image](https://user-images.githubusercontent.com/61584142/161416150-3d425d6c-4e88-4704-b713-550811fad869.png)

<br/>

6. exec로 파드에 접속한 후에 ls /audit -l로 새로 접속한 파드의 정보가 추가됐는지 확인한다. 정보를 확인하고 나면 exit로 파드를 빠져나온다.
```
[root@m-k8s ~]# kubectl exec -it nfs-pvc-sts-0 -- /bin/bash
root@nfs-pvc-sts-0:/# ls -l /audit
total 12
-rw-r--r--. 1 root root 48 Mar 3 20:29 audit_nfs-pvc-deploy-7888b77964-mj6mt.log
-rw-r--r--. 1 root root 96 Mar 3 20:25 audit_nfs-pvc-deploy-7888b77964-qwwsm.log
-rw-r--r--. 1 root root 96 Mar 3 20:39 audit_nfs-pvc-sts-3.log
root@nfs-pvc-sts-0:/# exit
exit
command terminated with exit code 130
[root@m-k8s ~]#
```

<br/>

#### 스테이트풀셋은 헤드리스(Headless) 서비스로 노출한다고 하던데?
- 그렇다, 일반적으로는 맞다. 헤드리스 서비스는 IP를 가지지 않는 서비스 타입으로 중요한 자원인 IP를 절약할 수 있을 뿐만 아니라, 스테이트풀셋과 같은 상태를 가지고 있는 오브젝트를 모두 노출하지 않고 상태 값을 외부에 알리고 싶은 것만 선택적으로 노출하게 할 수 있다. 따라서 일반적으로는 스테이트풀셋은 헤드리스 서비스로 노출하나, IT에는 정답이 없듯 고정된 이름을 사용하면서 외부에 모든 스테이트풀셋을 노출하고자 하는 경우에는 노드포트나 로드밸런서 서비스로 노출할 수 있다. 현재의 구성에서 헤드리스 서비스로 노출하고자 하는 경우에는 다음 코드를 사용해 노출할 수 있다.

<br/>

- sts-svc-domain.yaml
```
apiVersion: v1
kind: Service
metadata:
  name: sts-svc-domain
spec:
  selector:
    app: nfs-pvc-sts
  ports:
    - port: 80
  clusterIP: None
```

<br/>

- 이를 실행하면 다음과 같이 IP가 할당되지 않는 형태로 노출된 것을 확인할 수 있다.
```
[root@m-k8s ~]# kubectl apply -f ~/_Book_k8sInfra/ch3/3.4.4/sts-svc-domain.yaml
service/sts-svc-domain created
[root@m-k8s ~]# kubectl get services
NAME              TYPE            CLUSTER-IP     EXTERNAL-IP    PORT(S)          AGE
kubernetes        ClusterIP       10.96.0.1      <none>         443/TCP          8d
nfs-pvc-sts-svc   LoadBalancer    0.100.83.174   192.168.1.21   80:32125/TCP     7m
sts-svc-domain    ClusterIP       None           <none>         80/TCP           7s
```

<br/>

- 노출된 IP는 없지만 내부적으로 각 파드의 이름과 노출된 서비스 이름등을 조합한 도메인 이름으로 아래와 같이 쿠버네티스 클러스터 내에서 통신할 수 있는 상태가 된다. 이는 쿠버네티스 내에서 도메인 이름을 제공하는 CoreDNS가 가능하게 해준다. 할당된 도메인 이름과 IP가 확인되었다면, 다음 실습을 위해 헤드리스 서비스를 삭제해 준다.
```
[root@m-k8s ~]# kubectl run net --image=sysnet4admin/net-tools --restart=Never --rm -it -- nslookup nfs-pvc-sts-0.sts-svc-domain
Server:         10.96.0.10
Address:        10.96.0.10#53
 
Name:   nfs-pvc-sts-0.sts-svc-domain.default.svc.cluster.local
Address: 172.16.103.163
 
pod "net" deleted
[root@m-k8s ~]# kubectl delete services sts-svc-domain
```

<br/>

7. kubectl delete statefulset nfs-pvc-sts를 실행해 스테이트풀셋의 파드가 삭제한다. 파드는 생성된 순서의 역순으로 삭제되는데, kubectl get pods -w를 실행하면 삭제되는 과정을 볼 수 있다.
```
[root@m-k8s ~]# kubectl delete statefulset nfs-pvc-sts
statefulset.apps "nfs-pvc-sts" deleted
[root@m-k8s ~]# kubectl get pods -w
NAME            READY   STATUS        RESTARTS   AGE
nfs-pvc-sts-0   0/1     Terminating   0          13m
nfs-pvc-sts-1   0/1     Terminating   0          13m
nfs-pvc-sts-2   0/1     Terminating   0          13m
nfs-pvc-sts-3   0/1     Terminating   0          13m
nfs-pvc-sts-3   0/1     Terminating   0          13m
nfs-pvc-sts-3   0/1     Terminating   0          13m
nfs-pvc-sts-1   0/1     Terminating   0          13m
nfs-pvc-sts-1   0/1     Terminating   0          13m
nfs-pvc-sts-2   0/1     Terminating   0          13m
nfs-pvc-sts-2   0/1     Terminating   0          13m
nfs-pvc-sts-0   0/1     Terminating   0          13m
nfs-pvc-sts-0   0/1     Terminating   0          13m
```

<br/>

- 일반적으로 스테이트풀셋은 volumeClaimTemplates를 이용해 자동으로 각 파드에 독립적인 스토리지를 할당해 구성할 수 있다.
- 동적으로 저장 공간을 할당할 수 있는 스토리지 타입

![image](https://user-images.githubusercontent.com/61584142/161416245-513b2de7-f8b9-4257-9a1c-1443030e9bf5.png)

<br/>

#### 클라우드 스토리지에서 PV와 PVC가 동적으로 할당되는 예제
- 클라우드의 스토리지와 오브젝트 형태의 스토리지는 동적으로 PVC를 요청을 받아서 처리할 수 있도록 구현돼 있다. 이때 오브젝트는 kind: StorageClass를 사용하고, PV와 PVC가 오브젝트를 호출하는 구조다. 여기서는 standard.yaml과 같이 StorageClass를 선언한다. 그리고 메타데이터로 지정한 standard로 호출이 들어오면 동적으로 스토리지를 제공한다.

<br/>

- standard.yaml
```
apiVersion: storage.k8s.io/v1
kind: StorageClass
metadata:
  name: standard 
provisioner: kubernetes.io/gce-pd
parameters:
  type: pd-standard
  replication-type: none
```

<br/>

**현재 시스템에서는 실습하기 어려우므로 작동하는 방식만 나열해 보겠다.

<br/>

1. dynamic-pvc.yaml을 적용해 PVC를 100Gi만큼 요청한다. 동적으로 설정된 PV는 PVC의 요청에 따라 생성된다. ‘PV와 PVC의 관계도’를 다시 한 번 보고 오면 이해하기가 쉽다.
```
admin@dynamic-pvc$ kubectl apply -f \
https://raw.githubusercontent.com/sysnet4admin/_Book_k8sInfra/main/ch3/3.4.4/dynamic-pvc.yaml
persistentvolumeclaim/dynamic-pvc created
```

<br/>

- 코드는 다음과 같이 거의 비슷하지만, 제공자에 따라 storageClassName을 작성해야 한다. 여기서는 번거로움을 피하기 위해서 storageClassName 추가하지 않고 공란으로 둡니다. 공란으로 두면 기본값(standard)을 사용한다.
- dynamic-pvc.yaml
```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: dynamic-pvc
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 100Gi
# storageClassName: <기본값 사용>
```

<br/>

- 제공 업체별 storageClassName의 기본값은 다음과 같다.

![image](https://user-images.githubusercontent.com/61584142/161416306-94974185-64bd-4073-9170-ef1221ca5592.png)

<br/>

2. 생성된 PVC와 PVC 요청에 따라 생성된 PV를 함께 확인한다.
```
admin@dynamic-pvc$ kubectl get pvc
NAME         STATUS  VOLUME               CAPACITY  ACCESS MODES  STORAGECLASS  AGE
dynamic-pvc  Bound   pvc-…-42010ab20015  100Gi     RWX           standard      13s
admin@dynamic-pvc$ kubectl get pv
NAME                                      CAPACITY  ACCESS MODES  STORAGECLASS  …  STATUS   …       AGE
                  pvc-…-42010ab20015     100Gi     RWX           standard      …  Bound    …       4s
```

<br/>

3. 해당 PVC를 사용할 파드들을 생성한다.
```
admin@dynamic-pvc$ kubectl apply -f \
https://github.com/sysnet4admin/_Book_k8sInfra/blob/main/ch3/3.4.4/dynamic-pvc-deploy.yaml
deployment.apps/dynamic-pvc-deploy created
```

<br/>

- dynamic-pvc를 사용하도록 이름을 변경한 것 외에는 dynamic-pvc.yaml과 모두 동일하다.
- dynamic-pvc-deploy.yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dynamic-pvc-deploy
spec:
  replicas: 3
  selector:
    matchLabels:
      app: dynamic-pvc-deploy
  template:
    metadata:
      labels:
        app: dynamic-pvc-deploy
    spec:
      containers:
      - name: audit-trail
        image: sysnet4admin/audit-trail
        volumeMounts:
        - name: dynamic-vol
          mountPath: /audit
      volumes:
      - name: dynamic-vol
        persistentVolumeClaim:
          claimName: dynamic-pvc
```

<br/>

4. 배포된 파드를 확인한다.
```
admin@dynamic-pvc$ kubectl get pods
NAME                                  READY   STATUS    RESTARTS   AGE
dynamic-pvc-deploy-78fc9c89c5-72nv6   1/1     Running   0          3m19s
dynamic-pvc-deploy-78fc9c89c5-lg4zr   1/1     Running   0          3m19s
dynamic-pvc-deploy-78fc9c89c5-xh45v   1/1     Running   0          3m19s
```

<br/>

5. 배포된 파드 중 1개에 exec로 접속해 df -h로 마운트된 볼륨을 확인한다. 그런 다음 /audit에 설정한 것과 같이 100Gi(98G) 용량이 마운트된 것을 확인할 수 있다.
```
admin@dynamic-pvc$ kubectl exec -it dynamic-pvc-deploy-78fc9c89c5-72nv6 -- /bin/bash
root@dynamic-pvc-deploy-78fc9c89c5-72nv6:/# df -h
Filesystem   Size    Used   Avail  Use%   Mounted on
overlay       95G    2.9G     92G    4%   /
tmpfs         64M       0     64M    0%   /dev
tmpfs        1.9G       0    1.9G    0%   /sys/fs/cgroup
/dev/sdb      98G    61M     98G    1%   /audit
/dev/sda1     95G    2.9G     92G    4%   /etc/hosts
shm           64M       0     64M    0%   /dev/shm
tmpfs        1.9G     12K    1.9G    1%   /run/secrets/kubernetes.io/serviceaccount
tmpfs        1.9G       0    1.9G    0%   /proc/acpi
tmpfs        1.9G       0    1.9G    0%   /proc/scsi
tmpfs        1.9G       0    1.9G    0%   /sys/firmware
```

<br/>

- 지금까지 쿠버네티스의 전반적인 개념을 배우고 직접 실습하며 어떻게 사용되는지 눈으로 확인해 봤다. 단순히 하나를 배우고 그 다음을 배우는 계단식 구성이 아니라, 한 번에 알아야 할 것들이 매우 많은 기술이기 때문에 전체를 여러 번 반복해서 실습하길 권장한다. 실습하면서 조금씩 변형해 보면 오랫동안 기억할 수 있다.
