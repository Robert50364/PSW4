package com.robson.psw4.service;

import com.robson.psw4.dtos.UserDto;
import com.robson.psw4.model.Role;
import com.robson.psw4.model.User;
import com.robson.psw4.repozitory.UserRepozitory;
import jakarta.annotation.PostConstruct;
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
                .userName("admin")
                .password(passwordEncoder.encode("admin"))
                .firstName("admin")
                .lastName("admin")
                .email("admin@admin.admin")
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
    public User createUser(UserDto userDto){

        User user = User.builder()
                .userName(userDto.getUserName())
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
        System.out.println("Zarejestrowano: " + user.getUserName());
        return user;
    }

    @Transactional
    public User editUser(User user){
        User editedUser = repozitory.findById(user.getUserId()).orElseThrow();
        editedUser.setUserName((user.getUserName()!= null)? user.getUserName() : editedUser.getUserName());
        editedUser.setPassword((user.getPassword()!= null)? passwordEncoder.encode(user.getPassword()) : editedUser.getPassword());
        editedUser.setEmail((user.getEmail()!= null)? user.getEmail() : editedUser.getEmail());
        editedUser.setFirstName((user.getFirstName() != null)? user.getFirstName(): editedUser.getFirstName());
        editedUser.setLastName((user.getLastName() != null)? user.getLastName() : editedUser.getLastName());
        editedUser.setRole((user.getRole()!= null)? user.getRole() : editedUser.getRole());
        return repozitory.save(editedUser);
    }

    public void deleteUser(long id){repozitory.deleteById(id);}
}
