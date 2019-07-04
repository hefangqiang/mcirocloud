package cn.hfq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 配置权限和用户信息
     * */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password(new BCryptPasswordEncoder().encode("123456")).roles("USER").
                and()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("root")).roles("USER", "ADMIN");
    }

    /**
     * 配置安全信息
     * - 禁用csrf攻击功能
     * - 开启所有请求需要验证并且使用http basic进行认证
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http身份验证
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests().anyRequest()
                .fullyAuthenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 设置为无状态

        //页面验证
//        http.formLogin()               //  定义当需要提交表单进行用户登录时候，转到的登录页面。
//                .and()
//                .authorizeRequests()   // 定义哪些URL需要被保护、哪些不需要被保护
//                .anyRequest()          // 任何请求,登录后可以访问
//                .authenticated()
//                .and().csrf().disable();   // 关闭csrf防护


    }

}