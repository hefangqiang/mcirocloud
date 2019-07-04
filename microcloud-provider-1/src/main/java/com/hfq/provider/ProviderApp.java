package com.hfq.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.hfq.provider.dao")
@Import(cn.hfq.config.WebSecurityConfiguration.class)
@EnableEurekaClient
public class ProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApp.class, args);
	}

}
