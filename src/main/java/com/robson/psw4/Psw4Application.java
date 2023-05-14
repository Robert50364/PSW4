package com.robson.psw4;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SecurityScheme(name = "basicAuth", scheme = "basic", type = SecuritySchemeType.HTTP)
public class Psw4Application {

    public static void main(String[] args) {
        SpringApplication.run(Psw4Application.class, args);
    }


}
