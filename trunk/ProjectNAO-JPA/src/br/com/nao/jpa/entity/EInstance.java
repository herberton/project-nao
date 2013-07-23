package br.com.nao.jpa.entity;

import br.com.nao.jpa.entity.common.AEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class EInstance extends AEntity<EInstance> implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private EEntity entity;
	@OneToMany(mappedBy="instance")
	private List<EValue<?>> valueList;
	
	
	public EInstance() {
		super();
	}
   
	
	public EEntity getEntity() {
		return entity;
	}
	public void setEntity(EEntity entity) {
		this.entity = entity;
	}
	public List<EValue<?>> getValueList() {
		return valueList;
	}
	public void setValueList(List<EValue<?>> valueList) {
		this.valueList = valueList;
	}
}
