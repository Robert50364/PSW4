package com.robson.psw4.viewControler;

import com.robson.psw4.model.User;
import com.robson.psw4.repozitory.UserRepozitory;
import com.robson.psw4.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/showUsersList")
public class UsersPageController {

    private final UserService service;
    @GetMapping("/")
    public String showUserListPage(Model model){
        model.addAttribute("users", service.getUsers());
        model.addAttribute("editUser", new User());
        return "showUsers.html";
    }

    @PostMapping("/edit")
    public String editUser(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes){

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("error", "Wystąpił błąd podczas edycji użytkownika");
            return "redirect:/showUsersList/";
        }
        service.editUser(user);
        redirectAttributes.addFlashAttribute("success", "Użytkownik został zedytowany.");
        return "redirect:/showUsersList/";
    }
}
