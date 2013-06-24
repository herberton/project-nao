package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EField extends AEntityND<EField> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Column
	private Integer order;
	
	@ManyToOne
	private EField parentField;
	@OneToMany(mappedBy="parentField")
	private List<EField> childFieldList;
	
	@ManyToOne
	private EFormulary formulary;
	@ManyToOne
	private EComponent component;
	@ManyToOne(optional=true)
	private EProperty property;
	@OneToMany
	private List<EConfiguration> configurationList;
	
	
	public EField() {
		super();
	}

	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public EField getParentField() {
		return parentField;
	}
	public void setParentField(EField parentField) {
		this.parentField = parentField;
	}
	public List<EField> getChildFieldList() {
		return childFieldList;
	}
	public void setChildFieldList(List<EField> childFieldList) {
		this.childFieldList = childFieldList;
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
	public List<EConfiguration> getConfigurationList() {
		return configurationList;
	}
	public void setConfigurationList(List<EConfiguration> configurationList) {
		this.configurationList = configurationList;
	}
}
