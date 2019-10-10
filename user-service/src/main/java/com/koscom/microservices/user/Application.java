package com.koscom.microservices.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 유레카를 통해 서비스가 등록되도록 하기 위한 어노테이
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
