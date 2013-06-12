package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EFieldType extends AEntityND<EFieldType> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy="fieldType")
	private List<EValidation> validationList;
	
	
	public EFieldType() {
		super();
	}

	
	public List<EValidation> getValidationList() {
		return validationList;
	}
	public void setValidationList(List<EValidation> validationList) {
		this.validationList = validationList;
	}
}
