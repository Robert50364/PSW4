package com.robson.psw4.service;

import com.robson.psw4.model.Ivent;
import com.robson.psw4.repozitory.IventRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IventService {

    private final IventRepo iventRepo;

    public IventService(IventRepo iventRepo) {
        this.iventRepo = iventRepo;
    }



    //----------------------------- Methods ------------------------------------
    public List<Ivent> getIvents(){
        return iventRepo.findAll();
    }

    public Ivent getIvent(long id){
        return iventRepo.findById(id).orElseThrow();
    }

    public Ivent addIvent(Ivent ivent) {
        return iventRepo.save(ivent);
    }

    @Transactional
    public Ivent editIvent(Ivent ivent) {
        Ivent iventEdited = iventRepo.findById(ivent.getIventId()).orElseThrow();
        iventEdited.setIventName(ivent.getIventName());
        iventEdited.setDate(ivent.getDate());
        iventEdited.setAgenda(ivent.getAgenda());
        return iventRepo.save(iventEdited);
    }
    public void deleteIvent(long id) {
        iventRepo.deleteById(id);
    }


}
