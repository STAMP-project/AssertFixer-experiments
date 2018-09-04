FROM jtim/maven-non-root:3.5.4-jdk-8-alpine
WORKDIR /home/maven
COPY pom.xml ./
RUN mvn install clean --fail-never -B -DfailIfNoTests=false
COPY . ./
