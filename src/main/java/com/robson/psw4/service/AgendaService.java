package com.robson.psw4.service;

import com.robson.psw4.model.Agenda;
import com.robson.psw4.repozitory.AgendaRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepo agendaRepo;

    public AgendaService(AgendaRepo agendaRepo) {
        this.agendaRepo = agendaRepo;
    }

    //----------------------------- Methods ------------------------------------
    public List<Agenda> getAgendas() {
        return agendaRepo.findAll();
    }

    public Agenda getAgenda(long id){
        return agendaRepo.findById(id).orElseThrow();
    }

    public Agenda addAgenda(Agenda agenda) {
        return agendaRepo.save(agenda);
    }

    @Transactional
    public Agenda editAgenda(Agenda agenda) {
        Agenda agendaEdited = agendaRepo.findById(agenda.getAgendaId()).orElseThrow();
        agendaEdited.setName(agenda.getName());
        return agendaRepo.save(agendaEdited);
    }

    public void deleteAgenda(long id) {
        agendaRepo.deleteById(id);
    }
}
