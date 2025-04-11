<br/>
<br/>

# 1. Project Overview (프로젝트 개요)

- 프로젝트 이름: 일정 관리
- 프로젝트 설명: Spring 프레임워크 와 JPA 를 이용하여 간단한 일정 관리를 만듬.

## API 명세서

> https://www.notion.so/API-1c72e791318280ca887ff79ca1adeffb

## ERD

<img width="920" alt="schedules ERD" src="https://github.com/user-attachments/assets/6249c5d5-2618-4586-a51d-ae4431e31460" />

# 2. Key Features (주요 기능)

- **사용자 등록**
    - 사용자는 새로운 계정을 생성할 수 있으며, 이메일과 비밀번호를 입력하여 등록함.


- **사용자 로그인**
    - 사용자는 등록된 이메일과 비밀번호로 로그인할 수 있으며, 로그인 성공 시 사용자 정보를 반환함.


- **사용자 정보 조회**
    - 사용자는 자신의 ID로 정보 조회가 가능하며, UserResponseDto 형식으로 사용자 정보를 제공함.


- **사용자 정보 수정**
    - 사용자는 자신의 사용자 이름과 이메일을 수정할 수 있으며, 수정된 정보가 반환됨.


- **사용자 삭제**
    - 사용자는 자신의 계정을 삭제할 수 있으며, 해당 ID로 사용자를 찾아 삭제를 수행함.


- **schedule 항목 생성**
    - 사용자는 새로운 Todo 항목을 생성할 수 있으며, 제목과 내용을 입력하여 저장함..


- **schedule 항목 조회**
    - 사용자는 ID로 특정 Todo 항목을 조회할 수 있으며, TodoResponseDto 형식으로 항목 정보를 제공함.


- **schedule 항목 수정**
    - 사용자는 기존의 Todo 항목을 수정할 수 있으며, 새로운 제목과 내용을 입력하여 업데이트함.


- **schedule 항목 삭제**
    - 사용자는 ID로 특정 Todo 항목을 삭제할 수 있으며, 해당 ID로 Todo를 찾아 삭제를 수행함.

# 3. Technology Stack (기술 스택)

## Language

|        |                                                                                                                  |
|--------|------------------------------------------------------------------------------------------------------------------|
| Java   | <img src="https://github.com/jihwanprogramer/calulators/blob/main/img/Java.jpg?raw=true" alt="Java" width="200"> | 
| Spring | Spring Framework를 사용하여 RESTful API 구현                                                                            |
| JPA    | 데이터베이스와의 연결 및 CRUD 작업을 위한 JPA 사용                                                                                 |

## Version Control

|     |                                                                                                   |
|-----|---------------------------------------------------------------------------------------------------|
| Git | <img src="https://github.com/jihwanprogramer/Kiosk/blob/main/image/GIT.jpg?raw=true" width="200"> |

## JDK Version

|        |                                                                                                                  |
|--------|------------------------------------------------------------------------------------------------------------------|
| JDK 17 | <img src="https://github.com/jihwanprogramer/Kiosk/blob/main/image/JDK23.jpg?raw=true" alt="JDK 11" width="180"> |

|

<br/>


<br/>


# 4. 트러블 슈팅

[https://computerreport.tistory.com/86](https://velog.io/@w0729/%EC%9D%BC%EC%A0%95%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85)

# 6. 수행 결과

## 1.Todo 항목 생성

```
POST /schedules
Body: {
    "title":"할일 제목",
    "contents":"할일 내용"
}
```

<br/>

## 2.Todo 전체 항목 조회

```
GET /schedules
```

<br/>

## 3.Todo 선택 조회

```
GET /schedules/{id}
```

<br/>

## 4.Todo 수정

```
PUT /schedules/{id}
Body: {
    "title":"수정",
    "contents":"수정 내용"
}
```

<br/>

## 5.Todo 항목 삭제

```
DELETE /schedules/{id}
```

<br/>

## 6.유저 생성

```
POST /users/signup
Body: {
    "userName":"유저명",
    "email":"kob882333@naver.com",
    "password":"12345678"
}
```

<br/>

## 7.전체 유저 조회

```
GET /users
```

<br/>

## 8.유저 상세 조회

```
GET /users/{id}
```

<br/>

## 9.유저 수정

```
PUT /users/{id}
Body:{
    "name":"이름 수정"
    "password":"비밀번호"
    "email":"이메일 수정"
}
```

<br/>

## 10.유저 삭제

```
DELETE /users/{id}
```

<br/>

## 11.로그인

```
POST /users/login
Body:{
    "email" : "kob882333@naver.com",
    "password" : "12345678"
}
```

<br/>

## 12.로그아웃

```
POST /users/logout
```

