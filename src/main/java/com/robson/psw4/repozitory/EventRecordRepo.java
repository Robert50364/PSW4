package com.robson.psw4.repozitory;

import com.robson.psw4.model.EventRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRecordRepo extends JpaRepository<EventRecord, Long> {
}
