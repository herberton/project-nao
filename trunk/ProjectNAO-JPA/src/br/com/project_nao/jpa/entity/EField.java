package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import br.com.project_nao.jpa.entity.common.AEntityNDV;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class EField extends AEntityNDV<EField> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
		
	@ManyToOne
	private EEntity entity;
	@ManyToOne
	private EFieldType fieldType;
	
	
	public EField() {
		super();
	}
	
	
	public EEntity getEntity() {
		return entity;
	}
	public void setEntity(EEntity entity) {
		this.entity = entity;
	}
	public EFieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(EFieldType fieldType) {
		this.fieldType = fieldType;
	}
}
