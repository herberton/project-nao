package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class EField extends AEntityND<EField> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
		
	@ManyToOne
	private EEntity entity;
	@ManyToOne
	private EType fieldType;
	@OneToOne
	private ERelationship relationship;
	
	
	public EField() {
		super();
	}
	
	
	public EEntity getEntity() {
		return entity;
	}
	public void setEntity(EEntity entity) {
		this.entity = entity;
	}
	public EType getFieldType() {
		return fieldType;
	}
	public void setFieldType(EType fieldType) {
		this.fieldType = fieldType;
	}
	public ERelationship getRelationship() {
		return relationship;
	}
	public void setRelationship(ERelationship relationship) {
		this.relationship = relationship;
	}
}
