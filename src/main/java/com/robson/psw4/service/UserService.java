package com.robson.psw4.service;

import com.robson.psw4.dtos.UserDto;
import com.robson.psw4.dtos.UserEditDto;
import com.robson.psw4.model.Role;
import com.robson.psw4.model.User;
import com.robson.psw4.repozitory.UserRepozitory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepozitory repozitory;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public void init(){
        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .firstName("admin")
                .lastName("admin")
                .email("admin@domain.admin")
                .role(Role.ADMIN)
                .build();
        repozitory.save(admin);
    }

    public List<User> getUsers(){
        return repozitory.findAll();
    }

    public User getUser(long id){
        return repozitory.findById(id).orElseThrow();
    }

    public User getUserByUsername(String username){return repozitory.findUserByUsername(username).orElseThrow();}
    public User createUser(UserDto userDto){

        User user = User.builder()
                .username(userDto.getUserName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .created(LocalDate.now().toString())
                .build();
        if(user.getRole() == null){
            user.setRole(Role.USER);
        }
        repozitory.save(user);
        System.out.println("Zarejestrowano: " + user.getUsername());
        return user;
    }

    @Transactional
    public User editUser(UserEditDto user){
        User editedUser = repozitory.findById(user.getUserId()).orElseThrow();
        editedUser.setUsername(user.getUsername());
        editedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        editedUser.setEmail(user.getEmail());
        editedUser.setFirstName(user.getFirstname());
        editedUser.setLastName(user.getLastname());
        return repozitory.save(editedUser);
    }

    public void deleteUser(long id){repozitory.deleteById(id);}
}
