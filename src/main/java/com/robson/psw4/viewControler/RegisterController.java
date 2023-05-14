package com.robson.psw4.viewControler;

import com.robson.psw4.dtos.UserDto;
import com.robson.psw4.model.User;
import com.robson.psw4.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final UserService service;

    @GetMapping("/")
    public String showRegisterPage(WebRequest request, Model model){
        model.addAttribute("user", new UserDto());
        return "register.html";
    }

    @PostMapping("/process")
    public ModelAndView registerUser(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request, Error error){

        service.createUser(userDto);
        return new ModelAndView("home.html", "user", userDto);
    }
}
