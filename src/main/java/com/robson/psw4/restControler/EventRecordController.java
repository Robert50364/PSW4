package com.robson.psw4.restControler;

import com.robson.psw4.dtos.EventRecordFormDto;
import com.robson.psw4.model.EventRecord;
import com.robson.psw4.service.EventRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class EventRecordController {

    private final EventRecordService service;

    @GetMapping("/eventRecords")
    public List<EventRecord> getEventRecords(){
        return service.getEventRecords();
    }

    @GetMapping("/eventRecords/{id}")
    public EventRecord getEventRecord(@PathVariable long id){
        return service.getEventRecordById(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/eventRecords")
    public EventRecord addEventRecord(@RequestBody EventRecordFormDto eventRecord) {
        return service.addEventRecord(eventRecord);
    }

    @PutMapping("/eventRecords")
    public EventRecord editEventRecord(@RequestBody EventRecord eventRecord){
        return service.editEventRecord(eventRecord);
    }
}
