package com.sostraik1903.distroprofes_v3.security;

import com.sostraik1903.distroprofes_v3.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userServiceImpl);

    /*
        auth.inMemoryAuthentication().withUser("encargado").password("{noop}qweasd").roles("ENCARGADO");
        auth.inMemoryAuthentication().withUser("profesor").password("{noop}qweasd").roles("PROFESOR");
        auth.inMemoryAuthentication().withUser("alumno").password("{noop}qweasd").roles("ALUMNO");
    */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests()
            .antMatchers("/**/registrar").access("hasRole('ENCARGADO')")
            .antMatchers("/**/buscar/*").access("hasRole('ENCARGADO')")
            .antMatchers("/**/editar/*").access("hasRole('ENCARGADO')");

        http
            .httpBasic(Customizer.withDefaults())
            .authorizeRequests()
            .antMatchers("/profesores/listar").access("hasRole('ENCARGADO')  or hasRole('PROFESOR')")
            .antMatchers("/cursos/listar").access("hasRole('ENCARGADO')  or hasRole('ALUMNO')")
            .anyRequest()
            .authenticated();

        http.authorizeRequests().and()
                .csrf().disable();

        http.authorizeRequests().and()
                .httpBasic();

        http.authorizeRequests().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
