package br.com.project_nao.helper.da;

import br.com.project_nao.helper.enumerator.EAuditAction;

public @interface AuditedEntityDA {
	EAuditAction[] actions() default { EAuditAction.CREATE, EAuditAction.UPDATE, EAuditAction.DELETE };
}