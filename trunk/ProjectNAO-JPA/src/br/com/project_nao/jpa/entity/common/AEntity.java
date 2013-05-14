package br.com.project_nao.jpa.entity.common;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.project_nao.helper.da.AuditedEntityDA;
import br.com.project_nao.helper.enumerator.EAuditAction;
import br.com.project_nao.jpa.entity.UserEntity;
import br.com.project_nao.jpa.listener.audit.AuditingListener;
import br.com.project_nao.jpa.pk.common.PK;

@MappedSuperclass
@EntityListeners({AuditingListener.class})
public abstract class AEntity<T extends AEntity<T>> implements Serializable, Comparable<T> {
	
	
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private PK pk;
	
	
	@Transient
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
		if (this.getClass().isAnnotationPresent(AuditedEntityDA.class)) {
			for (EAuditAction action : this.getClass().getAnnotation(AuditedEntityDA.class).actions()) {
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