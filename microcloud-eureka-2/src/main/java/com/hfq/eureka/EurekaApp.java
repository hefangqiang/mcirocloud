package com.hfq.eureka;

import cn.hfq.config.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaServer
@Import(WebSecurityConfiguration.class) //security安全认证
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class, args);
    }

}
