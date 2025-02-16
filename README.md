
# MONO(Multi module) BE Example

## 모듈
- module-common
- module-service1
- module-service2

---

### test 환경 내용

module-common : msds db 붙어있으며, chemical 가져오는 service 있음
<br><br>

module-service1 : test api 있으며, module-common 서비스 호출 <br>
(호출 시 profile 설정에 service1 넣을 것) <br><br>

module-service2 : 현재 기능 없음

### 실행
-> module-service1 을 빌드 후, module-service1 를 실행 <br>
(호출 시 profile 설정에 service1 넣을 것)