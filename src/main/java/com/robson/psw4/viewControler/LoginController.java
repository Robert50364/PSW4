package com.robson.psw4.viewControler;

import com.robson.psw4.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public String showLoginForm(Model model){
        model.addAttribute("user", new User());
        return "loginForm.html";
    }

    @PostMapping("/processLogin")
    public String processLogin(@ModelAttribute("user") @Valid User user, BindingResult result, RedirectAttributes redirectAttributes){

        //System.out.println(user.getUserName());
        //System.out.println(user.getPassword());
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "Niepoprawne dane logowania");
            return "redirect:/login/";
        }
        redirectAttributes.addFlashAttribute("success", "Zalogowano pomyślnie.");
        return "redirect:/home"; //TODO zrobić zwrotę po zalogowaniu
    }
}
