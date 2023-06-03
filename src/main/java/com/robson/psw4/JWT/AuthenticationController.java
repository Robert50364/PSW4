package com.robson.psw4.JWT;

import com.robson.psw4.dtos.LoginDto;
import com.robson.psw4.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Kontroler odpowiedzialny za rejestrację i logowanie użytkownika
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto){
        return ResponseEntity.ok(service.register(userDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> auhtenticate(
            @RequestBody LoginDto loginDto
            ){
        return ResponseEntity.ok(service.authenticate(loginDto));
    }

}
