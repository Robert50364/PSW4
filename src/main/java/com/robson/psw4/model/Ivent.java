package com.robson.psw4.model;

import jakarta.persistence.*;

@Entity
public class Ivent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iventId;
    private String iventName;
    private String date;
    private String agenda;


    //--------------------------------- Getters & Setters ---------------------------------
    public long getIventId() {
        return iventId;
    }

    public void setIventId(long iventId) {
        this.iventId = iventId;
    }

    public String getIventName() {
        return iventName;
    }

    public void setIventName(String iventName) {
        this.iventName = iventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
}
