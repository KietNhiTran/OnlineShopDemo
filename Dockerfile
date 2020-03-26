FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=target/lib
ARG CLASSESDIR=target/classes
COPY ${DEPENDENCY} /app/lib
COPY ${CLASSESDIR} /app
ENTRYPOINT ["java","-cp","app:app/lib/*","org.demo.shopping.productmanagement.ProductManagementApplication"]