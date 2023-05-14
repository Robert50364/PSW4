package com.robson.psw4.model;

import jakarta.persistence.*;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agendaId;
    private String name;



    //------------------------------------ Getters & Setters --------------------------------------
    public long getAgendaId() {
        return agendaId;
    }

    public void setAgendaId(long agendaId) {
        this.agendaId = agendaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
