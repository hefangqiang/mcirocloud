package com.hfq.consumerfeign.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description： feign配置
 * @author： Mr.He
 * @date： 2019-07-05 14:47
 **/
@Configuration
public class FeignClientConfig {

    //http basic安全认证
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","123456");
    }
}
