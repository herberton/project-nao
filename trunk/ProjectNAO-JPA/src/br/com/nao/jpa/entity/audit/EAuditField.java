package br.com.nao.jpa.entity.audit;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.nao.jpa.entity.common.AEntity;

@Entity
public class EAuditField<T> extends AEntity<EAuditField<T>> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private Class<T> type;
	@Column(nullable=false)
	private String name;
	@Column(nullable=true)
	private T oldValue;
	@Column(nullable=false)
	private T newValue;
	
	@ManyToOne(targetEntity=EAudit.class, optional=false)
	private EAudit<? extends AEntity<? extends AEntity<?>>> audit;
	
	public EAuditField() {
		super();
	}
   
	public Class<T> getType() {
		return this.type;
	}
	public void setType(Class<T> type) {
		this.type = type;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getOldValue() {
		return this.oldValue;
	}
	public void setOldValue(T oldValue) {
		this.oldValue = oldValue;
	}
	public T getNewValue() {
		return this.newValue;
	}
	public void setNewValue(T newValue) {
		this.newValue = newValue;
	}
	
	public EAudit<? extends AEntity<? extends AEntity<?>>> getAudit() {
		return this.audit;
	}
	public void setAudit(EAudit<? extends AEntity<? extends AEntity<?>>> audit) {
		this.audit = audit;
	}
}
