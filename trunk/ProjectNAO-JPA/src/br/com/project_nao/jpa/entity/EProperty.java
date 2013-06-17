package br.com.project_nao.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.project_nao.jpa.entity.common.AEntityND;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class EProperty extends AEntityND<EProperty> implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
		
	@ManyToOne
	private EEntity entity;
	@ManyToOne
	private EPropertyType type;
	@OneToOne(optional=true)
	private ERelationship relationship;
	@OneToMany(mappedBy="property")
	private List<EField> fieldList;
	@OneToMany(mappedBy="property")
	private List<EValue<?>> valueList;

	
	public EProperty() {
		super();
	}
	
	
	public EEntity getEntity() {
		return entity;
	}
	public void setEntity(EEntity entity) {
		this.entity = entity;
	}
	public EPropertyType getType() {
		return type;
	}
	public void setType(EPropertyType type) {
		this.type = type;
	}
	public ERelationship getRelationship() {
		return relationship;
	}
	public void setRelationship(ERelationship relationship) {
		this.relationship = relationship;
	}
	public List<EField> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<EField> fieldList) {
		this.fieldList = fieldList;
	}
	public List<EValue<?>> getValueList() {
		return valueList;
	}
	public void setValueList(List<EValue<?>> valueList) {
		this.valueList = valueList;
	}
}
