package com.robson.psw4.viewControler;

import com.robson.psw4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final UserService service;

    @GetMapping("/home")
    public String showLoggedUser(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null)
        {
            model.addAttribute("loggedUser", auth);
        }
        return "home.html";
    }
}
