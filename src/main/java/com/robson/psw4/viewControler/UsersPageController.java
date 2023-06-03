package com.robson.psw4.viewControler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/showUsersList")
public class UsersPageController {

    /*
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
    */
}
