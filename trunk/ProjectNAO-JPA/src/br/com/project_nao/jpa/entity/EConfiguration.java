package br.com.project_nao.jpa.entity;

import br.com.project_nao.jpa.entity.common.AEntity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class EConfiguration extends AEntity<EConfiguration> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column
	private String key;
	@Column
	private String value;
	
	
	public EConfiguration() {
		super();
	}
   
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
