package com.robson.psw4.basicAuth;

import com.robson.psw4.model.Role;
import com.robson.psw4.model.User;
import com.robson.psw4.service.UserInfoDetailsService;
import com.robson.psw4.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicAuthConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        return new UserInfoDetailsService();
    }

    private static final String[] AUTH_BLACKLIST = {
            "/ivents",
    };

    private static final String[] AUTH_ADMINLIST = {
            "/showUsersList"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.authorizeHttpRequests()
                .requestMatchers(AUTH_BLACKLIST).authenticated()
                .requestMatchers(AUTH_ADMINLIST).hasAuthority("ADMIN")
                .anyRequest().permitAll()
                .and().headers().frameOptions().disable()
                //.and().formLogin();
                .and().formLogin(form -> form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/login/")
                        //.failureUrl("/login?fail")
                        .loginProcessingUrl("/login/processLogin")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }

}
