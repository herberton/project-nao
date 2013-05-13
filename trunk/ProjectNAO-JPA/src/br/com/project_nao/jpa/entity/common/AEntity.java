package br.com.project_nao.jpa.entity.common;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import br.com.project_nao.jpa.entity.common.ai.AuditedEntityAI;
import br.com.project_nao.jpa.entity.common.listener.AuditingListener;
import br.com.project_nao.jpa.entity.common.pk.PK;

@MappedSuperclass
@EntityListeners({AuditingListener.class})
public abstract class AEntity<T extends AEntity<T>> implements Serializable, Comparable<T> {
	
	
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private PK pk;
	
	
	@OneToOne(optional=false, orphanRemoval=true)
	private UserEntity loggedUser;
	
	
	public AEntity() {
		super();
	}
	
	
	public PK getPk() {
		return pk;
	}
	public void setPk(PK pk) {
		this.pk = pk;
	}

	
	public UserEntity getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(UserEntity loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	
	public boolean havePk() {
		return this.getPk() != null;
	}
	public boolean isAuditActionPresent(EAuditAction auditAction) {
		if (this.getClass().isAnnotationPresent(AuditedEntityAI.class)) {
			for (EAuditAction action : this.getClass().getAnnotation(AuditedEntityAI.class).actions()) {
				if (action.equals(auditAction)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getPk() == null) ? 0 : this.getPk().hashCode());
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
		
		@SuppressWarnings("unchecked")
		AEntity<T> other = (AEntity<T>)object;
		if (this.getPk() == null && other.getPk() != null) {
			return false;
		} 

		return this.getPk().equals(other.getPk());
	}
	@Override
	public int compareTo(T other) {
		return this.getPk().compareTo(other.getPk());
	}
}