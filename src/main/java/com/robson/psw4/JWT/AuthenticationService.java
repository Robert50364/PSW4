package com.robson.psw4.JWT;

import com.robson.psw4.dtos.LoginDto;
import com.robson.psw4.dtos.UserDto;
import com.robson.psw4.model.Role;
import com.robson.psw4.model.User;
import com.robson.psw4.repozitory.UserRepozitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepozitory repozitory;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Metoda dodaje użytkownika z reqesta do bazy i generuje token JWT
     * @param userDto obiekt pobrany z reqesta
     * @return zwaracamy Respons z JWT
     */
    public AuthenticationResponse register(UserDto userDto) {
        var user = User.builder()
                .username(userDto.getUserName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(Role.USER)
                .build();
        repozitory.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Metoda sprawdza czy użytkownik przesłany z reqesta jest w bazie
     * @param loginDto przesyłant reqest
     * @return zwracamy Response z JWT
     */
    public AuthenticationResponse authenticate(LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getLogin(),
                        loginDto.getPassword()
                )
        );
        var user = repozitory.findUserByUsername(loginDto.getLogin()).orElseThrow();
        System.out.println("User: " + user.getUsername());
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
