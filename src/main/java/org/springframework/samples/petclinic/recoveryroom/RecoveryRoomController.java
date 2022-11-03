package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
	
	
	private RecoveryRoomService rrs;
	private static final String VIEWS_RECOVERYROOM_CREATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService rrs) {
		this.rrs=rrs;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("types")
    public List<RecoveryRoomType> populateRecoveryRoomTypes() {
        return this.rrs.getAllRecoveryRoomTypes();
    }
	
	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(Map<String, Object> model) {
		RecoveryRoom recoveryroom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryroom);
		return VIEWS_RECOVERYROOM_CREATE_FORM;
	}
	
	 @PostMapping(value = "/recoveryroom/create")
		public String processCreationForm(@Valid RecoveryRoom recoveryroom, BindingResult result, ModelMap model) {
			if (result.hasErrors()) {
				return VIEWS_RECOVERYROOM_CREATE_FORM;
			}
			else {
				this.rrs.save(recoveryroom);
				return "welcome";
			}
		}   
	
    
}
