package br.com.nao.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.nao.jpa.entity.common.AEntity;

@Entity
public class EConfiguration extends AEntity<EConfiguration> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@Column
	private String value;
	
	@ManyToOne
	private EOption option;
	
	
	public EConfiguration() {
		super();
	}
   
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public EOption getOption() {
		return option;
	}
	public void setOption(EOption option) {
		this.option = option;
	}
}
