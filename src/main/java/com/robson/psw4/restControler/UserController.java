package com.robson.psw4.restControler;

import com.robson.psw4.dtos.UserDto;
import com.robson.psw4.model.User;
import com.robson.psw4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/users{id}")
    public User getUser(@PathVariable long id){
        return service.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody UserDto user){
        return service.createUser(user);
    }

    @PutMapping("/users")
    public User editUser(@RequestBody User user){return service.editUser(user);}

    @DeleteMapping("/users{id}")
    public void deleteUser(@PathVariable long id){service.deleteUser(id);}
}
