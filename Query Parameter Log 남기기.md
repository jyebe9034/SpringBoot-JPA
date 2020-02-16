# 쿼리 파라미터 로그 남기기

### JPA에서 쿼리가 날아가는 날아가는 시점을 알기위한 로그를 설정하는 방법

1. 첫번째 방법 .yml파일에서 설정해주기
```
logging:
  level:
    org.hibernate.SQL: debug
    org.hibernate.type: trace // 이 부분 추가
```
