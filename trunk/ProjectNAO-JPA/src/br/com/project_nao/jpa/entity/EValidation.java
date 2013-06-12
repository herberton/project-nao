package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.project_nao.jpa.entity.common.AEntityN;

@Entity
public class EValidation extends AEntityN<EValidation> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private EType fieldType;
	
	
	public EValidation() {
		super();
	}
   
	
	public EType getFieldType() {
		return fieldType;
	}
	public void setFieldType(EType fieldType) {
		this.fieldType = fieldType;
	}
}
