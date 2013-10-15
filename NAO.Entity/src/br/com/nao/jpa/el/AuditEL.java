package br.com.nao.jpa.el;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.nao.enumerator.Status;
import br.com.nao.jpa.entity.AuditEntity;
import br.com.nao.jpa.entity.common.NAOEntity;

public class AuditEL implements Serializable {

	private static final long serialVersionUID = 6772878854812949940L;

	
	@PrePersist
	public <T extends NAOEntity<T>> void prePersist(T entity) {
		this.println(entity, "prePersist");
		entity.setStatus(Status.ACTIVE);
		if (entity.isAudited()) {
			entity.setAudit(new AuditEntity());
			entity.getAudit().setUserCreation(entity.getLoggedUser());
			entity.getAudit().setCreationAt(Calendar.getInstance());
		}
	}

	@PreUpdate
	public <T extends NAOEntity<T>> void preUpdate(T entity) {
		this.println(entity, "preUpdate");
		if (entity.isAudited()) {
			entity.getAudit().setUserModification(entity.getLoggedUser());
			entity.getAudit().setModificationAt(Calendar.getInstance());
		}
	}
	
	private <T extends NAOEntity<T>> void println(T entity, String eventName) {
		if (entity == null) { return; }
		System.out.println(String.format("%s - AuditEL.%s", entity.getClass(), eventName));
	}
}
