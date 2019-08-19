package com.demo.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <h1>
 *     1、只需要使用@EnableEurekaServer可以使应用成为Eureka Server
 *     2、pom文件中对应到spring-cloud-starter-netflix-eureka-server
 * </h1>
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class, args);
    }
}
