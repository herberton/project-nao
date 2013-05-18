package br.com.project_nao.jpa.entity.audit;

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

import br.com.project_nao.helper.enumerator.EAuditAction;
import br.com.project_nao.jpa.entity.UserEntity;
import br.com.project_nao.jpa.entity.ViewEntity;
import br.com.project_nao.jpa.entity.common.AEntity;

@Entity
public class AuditEntity<T extends AEntity<? extends AEntity<?>>> extends AEntity<AuditEntity<T>> implements Serializable {

	private static final long serialVersionUID = -7937334565322577384L;
	
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
	private UserEntity user;
	@OneToOne(optional=false)
	private ViewEntity view;
	@OneToMany(targetEntity=AuditFieldEntity.class, cascade=CascadeType.ALL, mappedBy="audit")
	private List<AuditFieldEntity<?>> affectedFieldList;
	
	public AuditEntity() {
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
	
	public UserEntity getUser() {
		return this.user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public ViewEntity getView() {
		return this.view;
	}
	public void setView(ViewEntity view) {
		this.view = view;
	}
	public List<AuditFieldEntity<?>> getAffectedFieldList() {
		return this.affectedFieldList;
	}
	public void setAffectedFieldList(List<AuditFieldEntity<?>> affectedFieldList) {
		this.affectedFieldList = affectedFieldList;
	}
}
