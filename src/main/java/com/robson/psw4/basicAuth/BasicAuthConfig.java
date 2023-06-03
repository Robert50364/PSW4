package com.robson.psw4.basicAuth;

import com.robson.psw4.JWT.JwtAuthenticationFilter;
import com.robson.psw4.repozitory.UserRepozitory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class BasicAuthConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserRepozitory repozitory;
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repozitory.findUserByUsername(username).orElseThrow();
    }

    private static final String[] AUTH_BLACKLIST = {
            "/ivents",
    };

    private static final String[] AUTH_ADMINLIST = {
            "/showUsersList/**",
            "/showUsersList",
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();

        http.authorizeHttpRequests()
                .requestMatchers(AUTH_BLACKLIST).hasAuthority("ADMIN")
                //.requestMatchers(AUTH_ADMINLIST).hasAuthority("ADMIN")
                .anyRequest().permitAll()
                //Uwaga JWT
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .and().headers().frameOptions().disable();
                //Koniec JWT

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

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
