<br/>
<br/>

# 1. Project Overview (프로젝트 개요)

- 프로젝트 이름: 일정 관리
- 프로젝트 설명: Spring 프레임워크 와 JPA 를 이용하여 간단한 일정 관리를 만듬.

## API 명세서

https://documenter.getpostman.com/view/43187382/2sB2cU9Mnd

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


- **Todo 항목 생성**
    - 사용자는 새로운 Todo 항목을 생성할 수 있으며, 제목과 내용을 입력하여 저장함..


- **Todo 항목 조회**
    - 사용자는 ID로 특정 Todo 항목을 조회할 수 있으며, TodoResponseDto 형식으로 항목 정보를 제공함.


- **Todo 항목 수정**
    - 사용자는 기존의 Todo 항목을 수정할 수 있으며, 새로운 제목과 내용을 입력하여 업데이트함.


- **Todo 항목 삭제**
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

# 4. Development Workflow (개발 워크플로우)

## 브랜치 전략 (Branch Strategy)

적절한 클래스 사용과 다양한 메소드 활용이 주목적이기에 빠르게 수정 가능한
직접적인 Main Branch을 바로 사용했습니다.

## 블록 구문

한 줄짜리 블록일 경우라도 {}를 생략하지 않고, 명확히 줄 바꿈 하여 사용한다

```
if (session != null) {
     session.invalidate();
}
```

<br/>
<br/>   
카멜 표기법을 이용하여 가독성을 향상시켰다.

```
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

```

<br/>

## 메소드 네이밍

메소드 작성 시 아래 네이밍 규칙을 준수하여 의미 전달을 명확하게 한다.<br/>
메소드명이 길어지더라도 의미 전달의 명확성에 목적을 두어 작성한다.<br/>

```
public class PasswordEqualsCheckException extends RuntimeException
```

# 5. 트러블 슈팅

https://computerreport.tistory.com/86

# 6. 수행 결과

## 1.Todo 항목 생성

```
POST /todos
Body: {
    "title":"할일 제목",
    "contents":"할일 내용"
}
```

<br/>

## 2.Todo 전체 항목 조회

```
GET /todos/{id}
```

<br/>

## 3.Todo 선택 조회

```
GET /todos/{ID}
```

<br/>

## 4.Todo 수정

```
PATCH /todos/{id}
Body: {
    "title":"수정",
    "contents":"수정 내용"
}
```

<br/>

## 5.Todo 항목 삭제

```
DELETE /todos/{id}
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
PATCH /users/{id}
Body:{
    "title":"제목 수정"
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
POST /session-login
Body:{
    "email" : "kob882333@naver.com",
    "password" : "12345678"
}
```

<br/>

## 12.로그아웃

```
POST /session-logout
```

<br/>

## 13.이메일 중복확인

```
GET /check?email={email}
```

