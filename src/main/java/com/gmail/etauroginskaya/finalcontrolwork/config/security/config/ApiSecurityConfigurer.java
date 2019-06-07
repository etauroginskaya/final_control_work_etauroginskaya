package com.gmail.etauroginskaya.finalcontrolwork.config.security.config;

import com.gmail.etauroginskaya.finalcontrolwork.config.security.handler.ApiAccessDeniedHandler;
import com.gmail.etauroginskaya.finalcontrolwork.repository.model.RoleEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNTS_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_ADD_URL;
import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DISCOUNT_URL;

@Configuration
public class ApiSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public ApiSecurityConfigurer(@Lazy PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(API_DISCOUNT_ADD_URL, API_DISCOUNT_URL).hasAuthority(RoleEnum.SUPER_USER.name())
                .antMatchers(API_DISCOUNTS_URL).hasAuthority(RoleEnum.CUSTOMER_USER.name())
                .and()
                .httpBasic()
                .and()
                .exceptionHandling().accessDeniedHandler(apiAccessDeniedHandler())
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public AccessDeniedHandler apiAccessDeniedHandler() {
        return new ApiAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }
}
