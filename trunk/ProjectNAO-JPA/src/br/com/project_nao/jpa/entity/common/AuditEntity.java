package br.com.project_nao.jpa.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AuditEntity<T extends AEntity<T>> extends AEntity<AuditEntity<T>> implements Serializable {

	private static final long serialVersionUID = -7937334565322577384L;

	@Column(nullable=false)
	private Class<T> clazz;
	
	@Column(nullable=false)
	private T value;
	
	
	public AuditEntity() {
		super();
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
