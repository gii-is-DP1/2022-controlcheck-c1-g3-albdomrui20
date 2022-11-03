package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	private RecoveryRoomRepository rrr;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository rrr) {
		this.rrr=rrr;
	}
	
    public List<RecoveryRoom> getAll(){
        return rrr.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return rrr.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return rrr.getRecoveryRoomType(typeName);
    }

    
    public RecoveryRoom save(RecoveryRoom p) {
        return rrr.save(p);       
    }

    
}
