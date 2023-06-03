package com.robson.psw4.repozitory;

import com.robson.psw4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepozitory extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);
}
