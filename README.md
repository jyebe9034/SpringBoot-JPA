# 웹 어플리케이션 개발 단계
1. 프로젝트 환경 설정
2. 요구사항 분석
3. 도메인과 테이블 설계
4. 아키텍쳐 구성
5. 핵심 비지니스 로직 개발(회원, 상품, 주문)
6. 테스트
7. 웹 계층 개발

### 프로젝트 환경 설정
* Dependancies 추가 및 H2 DB연결
* Test코드로 접속 상태 확인
* 필요한 엔티티 생성 및 설정 추가

### 요구사항 분석
* 회원 기능
  - 회원 등록
  - 회원 조회
* 상품 기능
  - 상품 득록
  - 상품 목록
* 주무 기능
  - 상품 주문
  - 주문 내역

### 아키텍처 구성
* 계층형 구조 사용
  - controller, web : 웹계층
  - service : 비지니스 로직, 트랜잭션 처리
  - repository : JPA를 직접 사용하는 계층, 엔티티 매니저 사용
  - domain : 엔티티가 모여있는 계층, 모든 계층에서 사용
  
* 패키지 구조
  - jpabook.jpashop
    + domain
    + exception
    + repository
    + service
    + web
    
* 개발 순서 : 서비스, 리포지토리 계층을 먼저 개발하고, 테스트 케이스를 작성해서 검증하고 마지막에 웹 계층 구현

### 핵심 비지니스 로직 개발

##### 도메인 모델 패턴 : 대부분의 비지니스 로직을 엔티티에 만들어 두고 사용하는 것. 이 패턴은 객체지향의 특성을 적극 활용한다. 서비스 계층은 단순히 엔티티에 필요하 요청을 위임하는 역할을 한다.
##### 트랜잭션 스크립트 패턴 : 도메인 모델 패턴과 반대로 엔티티에는 비지니스 로직이 거의 없고, 서비스 계층에서 대부분의 비지니스 로직을 처리하는 패턴.

* 회원 도메인 개발
  - 회원 등록
  - 회원 목록 조회
  
* 회원 기능 테스트
  - 회원가입을 성공해야 한다.
  - 회원가입 시 같은 이름이 있으면 예외 발생해야 한다.
  
* 상품 도메인 개발
  - 상품 등록
  - 상품 목록 조회
  - 상품 수정

* 주문 도메인 개발
  - 상품 주문
    + Order의 멤버필드 중 CascadeType.All 옵션이 걸려있는 필드는 Order가 persist될 때, 같이 persist된다.
    + cascade를 사용하는 범위는 Order가 Delivery를 관리하고 OrderItem을 관리하는 관계 정도에서만 사용하는 것이 좋다. private honor이 경우에 사용하는 것이 좋다.
  - 주문 내역 조회
  - 주문 취소

* 주문 검색 기능 개발
  - 주문 검색 조회
    + JPA에 '동적 쿼리'를 어떻게 해결해야 하는가?
    
* 웹 계층 개발
    - 회원 등록 및 목록 화면 구현
    - 상품 등록 및 목록, 수정 화면 구현
    - 주문 등록 및 주문 목록과 취소 화면 구현
    - 주문 검색 기능 구현

##### 변경감지와 병합(merge)

* 준영속 엔티티란? 
영속성 컨텍스트가 더 이상 관리하지 않는 엔티티.

* 준영속 엔티티를 수정하는 2가지 방법
    - 변경 감지(dirty checking) 사용
        + 영속성 컨텍스트에서 엔티티를 다시 조회한 후에 데이터를 수정하는 방법(트랜잭션에 의해 커밋되는 시점에서 자동 업데이트(flush) 됨)
    - 병합(merge) 사용
        + 병합은 준영속상태의 엔티티를 영속상태로 변경할 때 사용하는 기능
        + EntityManager.merge();
        + 병합 시 주의사항 : 변경감지와 다르게 병합은 모든 속성이 변경된다. 병합시 값이 없으면 null로 업데이트 된다..
        + 실무에서는 엔티티를 변경할 땐 꼭 변경감지를 사용 할 것.
        
