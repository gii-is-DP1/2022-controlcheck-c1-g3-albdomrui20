package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recoveryroom")
public class RecoveryRoom  extends BaseEntity{
 
	@NotBlank
    @Size(min = 3, max=50)
    @Column(name = "name")
    String name;
	
	@NotNull
    @PositiveOrZero
    double size;
	
	@NotNull
    boolean secure;
    
	@NotNull
	@ManyToOne(optional=false)
	@JoinColumn(name ="recoveryroom_type")
    RecoveryRoomType roomType;
}
