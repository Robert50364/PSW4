package com.robson.psw4.repozitory;

import com.robson.psw4.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepo extends JpaRepository<Agenda, Long> {
}
