# Spring Boot Monorepo Project

## 📖 개요

이 프로젝트는 Gradle 멀티 모듈 설정을 활용하여 구성된 스프링 부트 모노레포(Monorepo) 예제입니다. 하나의 저장소에서 여러 개의 독립적인 서비스를 관리하는 방법을 보여주며, 공통 모듈을 통해 코드 재사용성을 높이는 구조를 가지고 있습니다.

## ✨ 주요 특징

- **모노레포 아키텍처**: 모든 소스 코드를 단일 저장소에서 관리하여 일관성을 유지하고 의존성 관리를 용이하게 합니다.
- **모듈화된 설계**: `module-common`, `module-service1`, `module-service2`로 역할을 분리하여 각 서비스의 독립성을 보장합니다.
- **공통 코드 관리**: `module-common`을 통해 여러 서비스에서 공통으로 사용되는 설정, 유틸리티, 엔티티 등을 효율적으로 관리합니다.
- **독립적인 서비스**: 각 서비스 모듈은 독립적으로 실행 및 배포가 가능한 마이크로서비스 형태로 구성할 수 있습니다.

## 🛠️ 기술 스택

- **Framework**: Spring Boot
- **Language**: Java 17
- **Build Tool**: Gradle
- **API Documentation**: Springdoc OpenAPI (Swagger)
- **Security**: Spring Security

## 📂 프로젝트 구조

```
.
├── build.gradle
├── settings.gradle
├── module-common/      # 여러 서비스에서 공유하는 공통 모듈
│   ├── build.gradle
│   └── src/
├── module-service1/    # 독립적인 기능을 수행하는 서비스 1
│   ├── build.gradle
│   └── src/
└── module-service2/    # 독립적인 기능을 수행하는 서비스 2
    ├── build.gradle
    └── src/
```

- **`module-common`**: 공통 도메인 모델, 유틸리티 클래스, 보안 설정 등 여러 모듈에서 함께 사용하는 코드를 포함합니다.
- **`module-service1`**: `module-common`에 의존하며, 특정 비즈니스 로직을 처리하는 독립적인 서비스입니다.
- **`module-service2`**: `module-common`에 의존하며, 또 다른 비즈니스 로직을 처리하는 독립적인 서비스입니다.

## 🚀 빌드 및 실행 방법

### 사전 준비 사항

- Java 17 이상
- Gradle

### 전체 프로젝트 빌드

아래 명령어를 실행하여 모든 모듈을 빌드합니다.

```bash
./gradlew clean build
```

### 각 서비스 실행

실행하고자 하는 서비스 모듈에 대해 아래 명령어를 실행합니다.

**Service 1 실행:**

```bash
./gradlew :module-service1:bootRun
```

**Service 2 실행:**

```bash
./gradlew :module-service2:bootRun
```