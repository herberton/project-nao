package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
public class EComponentType extends AEntityND<EComponentType> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private EComponentType parentType;
	@OneToMany(mappedBy="parentType")
	private List<EComponentType> childTypeList;
	
	
	public EComponentType() {
		super();
	}
   
	
	public EComponentType getParentType() {
		return parentType;
	}
	public void setParentType(EComponentType parentType) {
		this.parentType = parentType;
	}
	public List<EComponentType> getChildTypeList() {
		return childTypeList;
	}
	public void setChildTypeList(List<EComponentType> childTypeList) {
		this.childTypeList = childTypeList;
	}
}