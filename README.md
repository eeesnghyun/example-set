# Example-set

> Java 기반 예제 모음집입니다. 
>

------

## ⚙ 환경

- Eclipse 2019-06
- Java 8
- Spring 4
- Maven
- MyBatis
- Tomcat 9



#### 테스트

1. 프로젝트 import

2. project facets 설정(Dynamic web module, Java, Javascript)

3. config 설정

   1. java : default output folder : example-set/target/classes
   2. web module
      - context-root : /
      - content directory : src/main/webapp

4. webapp/config/config.properties 파일 추가

   > spring.datasource.driverClassname=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
   >
   > spring.datasource.url=jdbc:log4jdbc:mysql://127.0.0.1:3306/DB스키마
   >
   > spring.datasource.username=아이디
   >
   > spring.datasource.password=패스워드

------

## Content

1.[Apache POI Example](#1apache-poi-example)

2.[Exception Handler Example](#2exception-handler-example)

3.[XSS Filter Example](#3xss-filter-example)

4.[Transaction Example](#4transaction-example)

---



## 1.Apache POI Example

- EX01. Apache POI Excel 데이터 쓰기
- EX02. Apache POI Excel 데이터 읽기(서버단)
- EX03. Apache POI Excel 데이터 읽기(클라이언트단)
- Ex04. Apache POI Word 데이터 쓰기

:page_facing_up: Excel 포스팅 : [https://shxrecord.tistory.com/209](https://shxrecord.tistory.com/209)

:page_facing_up: Word 포스팅 : [https://shxrecord.tistory.com/246](https://shxrecord.tistory.com/246)

<br>

## 2.Exception Handler Example

* EX01. @RestControllerAdvice - Get
* EX02. @RestControllerAdvice - Post

:page_facing_up: 포스팅 : [https://shxrecord.tistory.com/210](https://shxrecord.tistory.com/210)

<br>

## 3.XSS Filter Example

* EX01. Lucy-xss-servlet-filter 적용
* EX02. Lucy-xss-servlet-filter 필터 규칙사용
* EX03. Lucy-xss-servlet-filter JSON 데이터는?

:page_facing_up: 포스팅 : https://shxrecord.tistory.com/212

<br>

## 4.Transaction Example

* EX01. 선언적 트랜잭션
* EX02. AOP 기반 트랜잭션 관리

:page_facing_up: 포스팅 : https://shxrecord.tistory.com/213

<br>



