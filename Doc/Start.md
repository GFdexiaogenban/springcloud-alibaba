## 依赖

springcloud官网上的en-us改成zh-cn就能将官网转化为中文

springcloud的pom依赖：https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-dependencies

由于springcloud是依赖于springboot的，所以，也需要导入对应版本的springboot的依赖：https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-dependencies

springcloud和spingboot的版本详细对应：https://start.spring.io/actuator/info

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ckj</groupId>
    <artifactId>cloudstudy</artifactId>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>provider-payment8001</module>
        <module>Consumer</module>
        <module>provider-payment8002</module>
        <module>eureka-server7001</module>
        <module>Consumer83</module>
        <module>Consumer3377</module>
        <module>sentinel-service8401</module>
        <module>Consumer84</module>
        <module>Consumer-feign-order85</module>
        <module>seata-storage-service2002</module>
        <module>seata-business-service2003</module>
        <module>seata-order-service2004</module>
        <module>gateway9527</module>
        <module>provider-payment8003</module>
        <module>all-api</module>
    </modules>
    <packaging>pom</packaging>
    <name>cloud-study</name>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>

        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>4.13.2</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <druid.version>1.2.8</druid.version>
        <mysql.version>8.0.28</mysql.version>
        <springboot.version>2.6.3</springboot.version>
        <springcloud.alibaba.version>2021.0.1.0</springcloud.alibaba.version>
        <springcloud.version>2021.0.1</springcloud.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${springboot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${springcloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
                <version>${springboot.version}</version>
            </dependency>

            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${springcloud.alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>

            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.version}</version>
            </dependency>

            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>2.2.2</version>
            </dependency>

            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
                <scope>test</scope>
            </dependency>

            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>1.18.22</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>2.6.4</version>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```