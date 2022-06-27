package com.sostraik1903.distroprofes_v3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("daniel").password("{noop}danielpuchuri").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("karen").password("{noop}karen123").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests()
            .antMatchers("/**/listar").permitAll()
            .antMatchers("/**/registrar").access("hasRole('ADMIN')")
            .antMatchers("/**/buscar/*").access("hasRole('ADMIN')")
            .anyRequest()
            .authenticated();

        http.authorizeRequests().and()
                .csrf().disable();

        http.authorizeRequests().and()
                .httpBasic();

        /*
        http.authorizeRequests()
                .antMatchers("/api/v1/profesores/listar").access("hasRole('USER')");



         */
    }
}
