package br.com.nao.helper.da;

import br.com.nao.helper.enumerator.EAuditAction;

public @interface AuditedEntityDA {
	EAuditAction[] actions() default { EAuditAction.CREATE, EAuditAction.UPDATE, EAuditAction.DELETE };
}