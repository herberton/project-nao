package br.com.nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.nao.jpa.entity.common.AEntityN;

@Entity
public class EComponent extends AEntityN<EComponent> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@OneToOne
	private EComponentType type;
		
	public EComponent() {
		super();
	}
   
	
	public EComponentType getType() {
		return type;
	}
	public void setType(EComponentType type) {
		this.type = type;
	}
}
