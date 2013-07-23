package br.com.nao.jpa.entity;

import br.com.nao.jpa.entity.common.AEntity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class EValue<T> extends AEntity<EValue<T>> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Column
	private T value;
	
	@ManyToOne
	private EInstance instance;
	@ManyToOne
	private EProperty property;
	
	
	public EValue() {
		super();
	}
	public EValue(T value) {
		this();
		this.setValue(value);
	}

	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}

	public EInstance getInstance() {
		return instance;
	}
	public void setInstance(EInstance instance) {
		this.instance = instance;
	}
	public EProperty getProperty() {
		return property;
	}
	public void setProperty(EProperty property) {
		this.property = property;
	}
}
