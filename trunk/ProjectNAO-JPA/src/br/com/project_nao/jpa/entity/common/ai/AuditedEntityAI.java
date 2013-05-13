package br.com.project_nao.jpa.entity.common.ai;

import br.com.project_nao.jpa.entity.common.EAuditAction;

public @interface AuditedEntityAI {
	EAuditAction[] actions() default { EAuditAction.CREATE, EAuditAction.UPDATE, EAuditAction.DELETE };
}