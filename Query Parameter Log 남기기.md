# 쿼리 파라미터 로그 남기기

### JPA에서 쿼리가 날아가는 날아가는 시점을 알기위한 로그를 설정하는 방법

1. 첫번째 방법 .yml파일에서 설정 추가
```
logging:
  level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace // 이 부분 추가
```

* 로그 결과
```
2020-02-16 11:25:49.928 DEBUG 1491 --- [    Test worker] org.hibernate.SQL                        : 
    insert 
    into
        member
        (username, id) 
    values
        (?, ?)
2020-02-16 11:25:49.931 TRACE 1491 --- [    Test worker] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [VARCHAR] - [memberA]
2020-02-16 11:25:49.931 TRACE 1491 --- [    Test worker] o.h.type.descriptor.sql.BasicBinder      : binding parameter [2] as [BIGINT] - [1]
```

2. 서드파티 라이브러리 사용
* P6Spy를 gradle에 추가하고 build를 refresh해줌
```
implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.6.1'
```

* 로그결과
```
2020-02-16 12:08:57.993 DEBUG 1547 --- [    Test worker] org.hibernate.SQL                        : 
    insert 
    into
        member
        (username, id) 
    values
        (?, ?)
2020-02-16 12:08:57.994  INFO 1547 --- [    Test worker] p6spy                                    : #1581822537994 | took 0ms | statement | connection 3| url jdbc:h2:tcp://localhost/~/jpashop
insert into member (username, id) values (?, ?)
insert into member (username, id) values ('memberA', 1);
```

참고 : https://github.com/gavlyukovskiy/spring-boot-data-source-decorator
