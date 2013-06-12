package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EType extends AEntityND<EType> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Column
	private Class<?> type;
	
	@OneToMany(mappedBy="fieldType")
	private List<EValidation> validationList;
	
	
	public EType() {
		super();
	}

	
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	
	public List<EValidation> getValidationList() {
		return validationList;
	}
	public void setValidationList(List<EValidation> validationList) {
		this.validationList = validationList;
	}
}
