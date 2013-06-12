package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EEntity extends AEntityND<EEntity> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@OneToMany
	private List<EField> fieldList;
	@OneToMany(mappedBy="entity")
	private List<EInstance> instanceList;
	
	
	public EEntity() {
		super();
	}
	
	
	public List<EField> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<EField> fieldList) {
		this.fieldList = fieldList;
	}
	public List<EInstance> getInstanceList() {
		return instanceList;
	}
	public void setInstanceList(List<EInstance> instanceList) {
		this.instanceList = instanceList;
	}
}
