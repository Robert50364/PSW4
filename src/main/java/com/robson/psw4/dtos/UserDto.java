package com.robson.psw4.dtos;

import com.robson.psw4.model.Role;
import com.robson.psw4.validators.PasswordMatches;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String firstName;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    private String confirmPassword;

}
