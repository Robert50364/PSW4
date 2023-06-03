package com.robson.psw4.service;

import com.robson.psw4.dtos.EventRecordFormDto;
import com.robson.psw4.model.EventRecord;
import com.robson.psw4.repozitory.EventRecordRepo;
import com.robson.psw4.repozitory.UserRepozitory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventRecordService {

    private final EventRecordRepo repository;
    private final UserRepozitory userRepozitory;

    public List<EventRecord> getEventRecords(){
        return repository.findAll();
    }

    public EventRecord getEventRecordById(long id){
        return repository.findById(id).orElseThrow();
    }

    public EventRecord addEventRecord(EventRecordFormDto eventRecord){
        EventRecord eventRecord1 = new EventRecord();
        eventRecord1.setUser(userRepozitory.findUserByUsername(eventRecord.getUser()).orElseThrow());
        eventRecord1.setIvent(eventRecord.getEvent());
        eventRecord1.setParticipationType(eventRecord.getParticipationType());
        eventRecord1.setFoodReference(eventRecord.getFoodReference());
        eventRecord1.setAccepted(false);
        return repository.save(eventRecord1);
    }

    public void deleteEventRecord(long id){
        repository.deleteById(id);
    }

    @Transactional
    public EventRecord editEventRecord(EventRecord eventRecord){
        EventRecord editedRecord = repository.findById(eventRecord.getEventRecordId()).orElseThrow();
        editedRecord.setUser(eventRecord.getUser());
        editedRecord.setIvent(eventRecord.getIvent());
        editedRecord.setFoodReference(eventRecord.getFoodReference());
        editedRecord.setParticipationType(eventRecord.getParticipationType());
        editedRecord.setAccepted(editedRecord.getAccepted());
        return repository.save(editedRecord);
    }
}
