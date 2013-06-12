package br.com.project_nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EField extends AEntityND<EField> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Column
	private Integer order;
	
	@ManyToOne
	private EFormulary formulary;
	@ManyToOne
	private EComponent component;
	@ManyToOne
	private EProperty property;
	
	
	public EField() {
		super();
	}

	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public EFormulary getFormulary() {
		return formulary;
	}
	public void setFormulary(EFormulary formulary) {
		this.formulary = formulary;
	}
	public EComponent getComponent() {
		return component;
	}
	public void setComponent(EComponent component) {
		this.component = component;
	}
	public EProperty getProperty() {
		return property;
	}
	public void setProperty(EProperty property) {
		this.property = property;
	}
}
