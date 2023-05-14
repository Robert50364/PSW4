package com.robson.psw4.restControler;

import com.robson.psw4.model.Agenda;
import com.robson.psw4.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping("/agendas")
    public List<Agenda> getAgendas() {
        return agendaService.getAgendas();
    }

    @GetMapping("/agendas/{id}")
    public Agenda getAgenda(@PathVariable long id) {
        return agendaService.getAgenda(id);
    }

    @PostMapping("/agendas")
    public Agenda addAgenda(@RequestBody Agenda agenda){
        return agendaService.addAgenda(agenda);
    }

    @PutMapping("/agendas")
    public Agenda editAgenda(@RequestBody Agenda agenda){
        return agendaService.editAgenda(agenda);
    }

    @DeleteMapping("/agendas/{id}")
    public void deleteAgenda(@PathVariable long id){
        agendaService.deleteAgenda(id);
    }
}
