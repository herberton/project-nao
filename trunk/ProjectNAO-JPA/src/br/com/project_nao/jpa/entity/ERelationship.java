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
	private EProperty property;
	@ManyToOne
	private EProperty targetProperty;
	
	
	public ERelationship() {
		super();
	}
   
	
	public EProperty getProperty() {
		return property;
	}
	public void setProperty(EProperty property) {
		this.property = property;
	}
	public EProperty getTargetProperty() {
		return targetProperty;
	}
	public void setTargetProperty(EProperty targetProperty) {
		this.targetProperty = targetProperty;
	}
}