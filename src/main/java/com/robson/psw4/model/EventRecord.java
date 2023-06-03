package com.robson.psw4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EventRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventRecordId;

    @ManyToOne
    @JoinColumn(name = "iventId")
    private Ivent ivent;


    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    private String participationType;
    private String foodReference;
    private boolean accepted;

    public boolean getAccepted(){return accepted;}

}
