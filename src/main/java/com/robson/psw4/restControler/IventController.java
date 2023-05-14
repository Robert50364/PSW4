package com.robson.psw4.restControler;

import com.robson.psw4.model.Ivent;
import com.robson.psw4.service.IventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IventController {

    private final IventService service;

    public IventController(IventService service) {
        this.service = service;
    }

    @GetMapping("/ivents")
    public List<Ivent> getIvents(){
       return service.getIvents();
    }

    @GetMapping("/ivents/{id}")
    public Ivent getInvet(@PathVariable long id){
        return service.getIvent(id);
    }

    @PostMapping("/ivents")
    public Ivent addIvent(@RequestBody Ivent ivent){
        return service.addIvent(ivent);
    }
    @PutMapping("/ivents")
    public Ivent editIvent(@RequestBody Ivent ivent){
        return service.editIvent(ivent);
    }
    @DeleteMapping ("/ivents/{id}")
    public void deleteIvent(@PathVariable long id){
        service.deleteIvent(id);
    }
}
