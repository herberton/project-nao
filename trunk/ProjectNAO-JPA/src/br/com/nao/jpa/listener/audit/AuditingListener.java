package br.com.nao.jpa.listener.audit;

import java.io.Serializable;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import br.com.nao.helper.enumerator.EAuditAction;
import br.com.nao.jpa.entity.common.AEntity;

public class AuditingListener  implements Serializable {

	private static final long serialVersionUID = 8950099979913014205L;

	@PrePersist
	public <T extends AEntity<? extends AEntity<?>>> void prePersist(T entity) {
		if (entity.isAuditedActionPresent(EAuditAction.CREATE)) {
			// TODO GRAVAR AUDITORIA PARA CRIAÇÃO
			System.out.println(entity.getLoggedUser());
		}
	}

	@PreUpdate
	public <T extends AEntity<? extends AEntity<?>>> void preUpdate(T entity) {
		if (entity.isAuditedActionPresent(EAuditAction.UPDATE)) {
			// TODO GRAVAR AUDITORIA PARA MODIFICAÇÃO
			System.out.println(entity.getLoggedUser());
		}
	}
	
	@PreRemove
	public <T extends AEntity<? extends AEntity<?>>> void preDestroy(T entity) {
		if (entity.isAuditedActionPresent(EAuditAction.DELETE)) {
			// TODO GRAVAR AUDITORIA PARA EXCLUSÃO
			System.out.println(entity.getLoggedUser());
		}
	}
}
