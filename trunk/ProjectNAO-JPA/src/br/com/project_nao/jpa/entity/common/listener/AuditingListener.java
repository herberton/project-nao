package br.com.project_nao.jpa.entity.common.listener;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.project_nao.jpa.entity.common.AEntity;
import br.com.project_nao.jpa.entity.common.EAuditAction;

public class AuditingListener  implements Serializable {

	private static final long serialVersionUID = 8950099979913014205L;

	@PrePersist
	public <T extends AEntity<? extends AEntity<?>>> void prePersist(T entity) {
		if (entity.isAuditActionPresent(EAuditAction.CREATE)) {
			// TODO GRAVAR AUDITORIA PARA CRIAÇÃO
			System.out.println(entity.getLoggedUser());
		}
	}

	@PreUpdate
	public <T extends AEntity<? extends AEntity<?>>> void preUpdate(T entity) {
		if (entity.isAuditActionPresent(EAuditAction.UPDATE)) {
			// TODO GRAVAR AUDITORIA PARA MODIFICAÇÃO
			System.out.println(entity.getLoggedUser());
		}
	}
	
	@PreDestroy
	public <T extends AEntity<? extends AEntity<?>>> void preDestroy(T entity) {
		if (entity.isAuditActionPresent(EAuditAction.DELETE)) {
			// TODO GRAVAR AUDITORIA PARA EXCLUSÃO
			System.out.println(entity.getLoggedUser());
		}
	}
}
