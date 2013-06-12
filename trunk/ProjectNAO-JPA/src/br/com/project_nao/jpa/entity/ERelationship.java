package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class ERelationship extends AEntityND<ERelationship> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@OneToOne(mappedBy="relationship")
	private EField field;
	@ManyToOne
	private EField targetField;
	
	
	public ERelationship() {
		super();
	}
   
	
	public EField getField() {
		return field;
	}
	public void setField(EField field) {
		this.field = field;
	}
	public EField getTargetField() {
		return targetField;
	}
	public void setTargetField(EField targetField) {
		this.targetField = targetField;
	}
}