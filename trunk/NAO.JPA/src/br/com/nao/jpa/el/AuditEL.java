package br.com.nao.jpa.el;

import java.io.Serializable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.nao.jpa.entity.common.NAOEntity;

public class AuditEL implements Serializable {

	private static final long serialVersionUID = 6772878854812949940L;

	@PrePersist
	public <T extends NAOEntity<T>> void prePersist(T entity) {
		System.out.println("AuditEL.prePersist");
	}

	@PreUpdate
	public <T extends NAOEntity<T>> void preUpdate(T entity) {
		System.out.println("AuditEL.preUpdate");
	}

}
