package br.com.nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.nao.jpa.entity.common.AEntityND;

@Entity
public class EEntity extends AEntityND<EEntity> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@OneToMany(mappedBy="entity")
	private List<EProperty> propertyList;
	@OneToMany(mappedBy="entity")
	private List<EInstance> instanceList;
	
	
	public EEntity() {
		super();
	}
	
	
	public List<EProperty> getPropertyList() {
		return propertyList;
	}
	public void setPropertyList(List<EProperty> propertyList) {
		this.propertyList = propertyList;
	}
	public List<EInstance> getInstanceList() {
		return instanceList;
	}
	public void setInstanceList(List<EInstance> instanceList) {
		this.instanceList = instanceList;
	}
}
