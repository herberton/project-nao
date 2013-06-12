package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.project_nao.jpa.entity.common.AEntityNDV;

@Entity
public class EValidation extends AEntityNDV<EValidation> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private EFieldType fieldType;
	
	
	public EValidation() {
		super();
	}
   
	
	public EFieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(EFieldType fieldType) {
		this.fieldType = fieldType;
	}
}
