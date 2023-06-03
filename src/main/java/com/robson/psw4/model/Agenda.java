package com.robson.psw4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long agendaId;
    private String name;

}
