package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EEntity extends AEntityND<EEntity> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy="entity")
	private List<EField> fieldList;
	
	
	public EEntity() {
		super();
	}
	
	
	public List<EField> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<EField> fieldList) {
		this.fieldList = fieldList;
	}
}
