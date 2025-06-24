# Vincenzo Skeleton JDK17 Kotlin

Spring Boot 3.x + Kotlin + JDK 17 샘플 프로젝트입니다.

## 기술 스택

- **JDK**: 17 이상
- **언어**: Kotlin
- **프레임워크**: Spring Boot 3.3.1
- **빌드 도구**: Gradle (Kotlin DSL)
- **데이터베이스**: MySQL 8.0 (Docker Compose로 구성)
- **ORM**: Spring Data JPA
- **API 문서화**: Swagger (SpringDoc OpenAPI)

## 프로젝트 구조

```
src/
├── main/
│   ├── kotlin/
│   │   └── com/vincenzo/skeleton/
│   │       ├── SkeletonApplication.kt          # 메인 애플리케이션
│   │       ├── config/                         # 설정 클래스
│   │       │   └── SwaggerConfig.kt
│   │       ├── controller/                     # REST 컨트롤러
│   │       │   └── UserController.kt
│   │       ├── domain/                         # 도메인 계층
│   │       │   ├── entity/
│   │       │   │   └── User.kt
│   │       │   └── repository/
│   │       │       └── UserRepository.kt
│   │       ├── dto/                            # DTO 클래스
│   │       │   └── UserDto.kt
│   │       ├── exception/                      # 예외 처리
│   │       │   ├── BusinessException.kt
│   │       │   └── GlobalExceptionHandler.kt
│   │       └── service/                        # 서비스 계층
│   │           └── UserService.kt
│   └── resources/
│       └── application.yml                     # 애플리케이션 설정
└── test/
```

## 시작하기

### 1. 필수 요구사항

- JDK 17 이상
- Docker & Docker Compose
- Git

### 2. 프로젝트 클론

```bash
git clone https://github.com/vincenzo-dev-82/vincenzo-skeleton-jdk17-kotlin.git
cd vincenzo-skeleton-jdk17-kotlin
```

### 3. MySQL 데이터베이스 실행

```bash
docker-compose up -d
```

### 4. 애플리케이션 실행

```bash
./gradlew bootRun
```

또는 IDE에서 `SkeletonApplication.kt` 파일을 실행합니다.

### 5. API 문서 확인

애플리케이션 실행 후 다음 URL로 접속:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## API 엔드포인트

### User API

- `GET /api/users` - 사용자 목록 조회 (페이징)
- `GET /api/users/{id}` - 사용자 상세 조회
- `POST /api/users` - 사용자 생성
- `PUT /api/users/{id}` - 사용자 수정
- `DELETE /api/users/{id}` - 사용자 삭제

## 빌드

```bash
./gradlew clean build
```

빌드된 JAR 파일은 `build/libs/` 디렉토리에 생성됩니다.

## 테스트

```bash
./gradlew test
```

## Docker Compose 설정

`docker-compose.yml` 파일에 MySQL 8.0이 설정되어 있습니다:

- **포트**: 3306
- **데이터베이스명**: skeleton_db
- **사용자**: root
- **비밀번호**: rootpassword

## 주요 기능

1. **RESTful API**: User CRUD 기능 구현
2. **JPA Integration**: Spring Data JPA를 사용한 데이터 접근
3. **Validation**: Bean Validation을 사용한 입력값 검증
4. **Exception Handling**: 전역 예외 처리
5. **Swagger Documentation**: API 자동 문서화
6. **Docker Support**: MySQL 데이터베이스 컨테이너화

## 개발 팁

1. **Hot Reload**: 개발 시 `spring-boot-devtools`를 추가하면 자동 재시작 기능을 사용할 수 있습니다.
2. **데이터베이스 초기화**: `application.yml`의 `spring.jpa.hibernate.ddl-auto` 값을 변경하여 테이블 생성 전략을 조정할 수 있습니다.
3. **로깅 레벨**: `application.yml`에서 로깅 레벨을 조정하여 디버깅에 활용할 수 있습니다.

## 라이센스

MIT License