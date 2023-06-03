package com.robson.psw4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ivent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iventId;
    private String iventName;
    private String date;

    @ManyToOne
    @JoinColumn(name = "agendaId")
    private Agenda agenda;
}
