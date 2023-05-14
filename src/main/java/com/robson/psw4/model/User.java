package com.robson.psw4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UserId;
    @Column(nullable = false, unique = true)
    private String userName;
    private String  password;
    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;
    private String lastName;
    @Email
    private String email;
    @DateTimeFormat
    private String created;
}
