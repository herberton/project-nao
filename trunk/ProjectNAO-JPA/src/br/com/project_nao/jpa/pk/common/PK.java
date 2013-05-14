package br.com.project_nao.jpa.pk.common;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PK implements Serializable, Comparable<PK> {

	private static final long serialVersionUID = 6633528398632153041L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	public PK() { super(); 	}
	public PK(Long id) { 
		this();
		this.setId(id);
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public boolean haveId(){
		return
			this.getId() !=  null && 
			this.getId() != 0;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object object) {
		
		if (this == object){
			return true;
		}
		
		if (object == null) {
			return false;
		}
		
		if (!this.getClass().equals(object.getClass())) {
			return false;
		}
		
		PK other = (PK)object;
		if (this.getId() == null && other.getId() != null) {
			return false;
		} 

		return this.getId().equals(other.getId());
	}
	@Override
	public int compareTo(PK other) {
		return 
			this.haveId() ? 
				this.getId().compareTo(other.getId()) : 
				0;
	}
}
