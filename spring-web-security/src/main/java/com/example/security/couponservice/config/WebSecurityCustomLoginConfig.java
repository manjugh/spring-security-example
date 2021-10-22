package com.example.security.couponservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("customlogin")
public class WebSecurityCustomLoginConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin();
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/api/coupon", "/", "/index").hasAnyRole("USER", "ADMIN")
                .mvcMatchers(HttpMethod.GET, "/createCoupon", "/createResponse", "/showCouponPage").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/api/coupons", "/saveCoupon", "/fetchCoupon").hasRole("ADMIN")
                .mvcMatchers("/login", "/authenticate","/logout").permitAll().anyRequest().denyAll()
                .and().csrf().disable()
                .logout().logoutSuccessUrl("/");

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
