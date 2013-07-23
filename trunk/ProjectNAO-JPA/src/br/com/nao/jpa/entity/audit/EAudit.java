package br.com.nao.jpa.entity.audit;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.nao.helper.enumerator.EAuditAction;
import br.com.nao.jpa.entity.EUser;
import br.com.nao.jpa.entity.EView;
import br.com.nao.jpa.entity.common.AEntity;

@Entity
public class EAudit<T extends AEntity<? extends AEntity<?>>> extends AEntity<EAudit<T>> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private Class<T> type;
	@Column(nullable=false)
	private T entity;
	@Enumerated(EnumType.STRING)
	private EAuditAction action;
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	@OneToOne(optional=false)
	private EUser user;
	@OneToOne(optional=false)
	private EView view;
	@OneToMany(targetEntity=EAuditField.class, cascade=CascadeType.ALL, mappedBy="audit")
	private List<EAuditField<?>> affectedFieldList;
	
	public EAudit() {
		super();
	}
	
	public Class<T> getType() {
		return this.type;
	}
	public void setType(Class<T> type) {
		this.type = type;
	}
	public T getEntity() {
		return this.entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public EAuditAction getAction() {
		return this.action;
	}
	public void setAction(EAuditAction action) {
		this.action = action;
	}
	public Calendar getDate() {
		return this.date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public EUser getUser() {
		return this.user;
	}
	public void setUser(EUser user) {
		this.user = user;
	}
	public EView getView() {
		return this.view;
	}
	public void setView(EView view) {
		this.view = view;
	}
	public List<EAuditField<?>> getAffectedFieldList() {
		return this.affectedFieldList;
	}
	public void setAffectedFieldList(List<EAuditField<?>> affectedFieldList) {
		this.affectedFieldList = affectedFieldList;
	}
}
