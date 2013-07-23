package br.com.nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.nao.jpa.entity.common.AEntityN;

@Entity
public class EValidation extends AEntityN<EValidation> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private EPropertyType type;
	
	
	public EValidation() {
		super();
	}
   
	
	public EPropertyType getType() {
		return type;
	}
	public void setType(EPropertyType type) {
		this.type = type;
	}
}
