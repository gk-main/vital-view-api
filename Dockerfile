# 사용할 자바베이스 이미지 (프로젝트 Java 버전에 맞춤)
FROM eclipse-temurin:21-jre-jammy

# JAR 파일 경로 변수
ARG JAR_FILE=build/libs/*.jar

# 생성될 이미지만큼 복사
COPY ${JAR_FILE} app.jar

# 컨테이너 실행 시 실행될 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]

