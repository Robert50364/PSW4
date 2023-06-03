package com.robson.psw4.viewControler;

import com.robson.psw4.dtos.EventRecordFormDto;
import com.robson.psw4.model.Role;
import com.robson.psw4.service.EventRecordService;
import com.robson.psw4.service.IventService;
import com.robson.psw4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/iventsPage")
public class IventsViewContorller {

    private final IventService service;
    private final UserService userService;
    private final EventRecordService eventRecordService;
    @GetMapping("/")
    public String showIventsPage(Authentication auth, Model model){

        boolean isAdmin = false;

        if(auth!= null){
            if(userService.getUserByUsername(auth.getName()).getRole().equals(Role.ADMIN)){isAdmin=true;}
        }

        model.addAttribute("ivents" , service.getIvents());
        model.addAttribute("eventRecord", new EventRecordFormDto());
        model.addAttribute("isAdmin", isAdmin);
        return "iventsPage.html";
    }

    /*
    @PostMapping("/joinToEvent")
    public String joinToEvent(@RequestParam("ivent") long id, Authentication auth, EventRecordFormDto eventRecord,
                              BindingResult result, RedirectAttributes redirectAttributes){

        if(auth != null) {
            eventRecord.setUser(userService.getUserByUsername(auth.getName()));
        }

        eventRecord.setEvent(service.getIvent(id));
        if(result.hasErrors() || eventRecord.getEvent()== null){
            redirectAttributes.addFlashAttribute("error", "Wystąpił błąd podczas zapisu na wydarzenie");
            return "redirect:/iventsPage/";
        }
        eventRecordService.addEventRecord(eventRecord);
        redirectAttributes.addFlashAttribute("success", "Zapisano na wydarzenie.");
        return "redirect:/iventsPage/";
    }

     */
}
