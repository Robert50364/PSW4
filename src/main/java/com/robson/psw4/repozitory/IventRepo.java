package com.robson.psw4.repozitory;

import com.robson.psw4.model.Ivent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IventRepo extends JpaRepository<Ivent, Long> {
}
