package com.robson.psw4.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDto {

    private Long userId;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
