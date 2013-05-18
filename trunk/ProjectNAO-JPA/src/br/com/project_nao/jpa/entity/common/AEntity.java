package br.com.project_nao.jpa.entity.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import br.com.project_nao.helper.da.AuditedEntityDA;
import br.com.project_nao.helper.da.AuditedFieldDA;
import br.com.project_nao.helper.enumerator.EAuditAction;
import br.com.project_nao.jpa.entity.UserEntity;
import br.com.project_nao.jpa.listener.audit.AuditingListener;

@MappedSuperclass
@EntityListeners({AuditingListener.class})
public abstract class AEntity<T extends AEntity<T>> implements Serializable, Comparable<T> {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@AuditedFieldDA
	private Long id;
	
	
	@Transient
	private UserEntity loggedUser;
	
	
	public AEntity() {
		super();
	}
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public UserEntity getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(UserEntity loggedUser) {
		this.loggedUser = loggedUser;
	}
	
	
	public boolean hasId() {
		return 
			this.getId() != null && 
			this.getId() != 0;
	}
	private boolean isColumnField(Field field) {
		return !field.isAnnotationPresent(Transient.class);
	}
	public boolean isAuditedEntity() {
		return this.getClass().isAnnotationPresent(AuditedEntityDA.class);
	}
	public boolean isAuditedFieldDA(Field field) {
		return field.isAnnotationPresent(AuditedFieldDA.class);
	}
	public boolean isAuditedActionPresent(EAuditAction auditAction) {
		if (this.isAuditedEntity()) {
			for (EAuditAction action : this.getAuditedEntityDA().actions()) {
				if (action.equals(auditAction)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public AuditedEntityDA getAuditedEntityDA() {
		return this.getClass().getAnnotation(AuditedEntityDA.class);
	}
	public AuditedFieldDA getAuditedFieldDA(Field field) {
		return field.getAnnotation(AuditedFieldDA.class);
	}
	public List<Field> getDeclaredFieldList() {
		
		List<Field> fieldList = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Class<?> clazz = ((T)this).getClass();
		while (clazz != null) {
			Collections.addAll(fieldList, clazz.getDeclaredFields());
			if (clazz.isAnnotationPresent(MappedSuperclass.class) || clazz.isAnnotationPresent(Entity.class)) {
				clazz = this.getClass().getSuperclass();
			}
		}
		
		return fieldList;
	}
	public List<Field> getColumnFieldList() {
		
		List<Field> fieldList = this.getDeclaredFieldList();
		
		Iterator<Field> iterator = fieldList.iterator();
		while (iterator.hasNext()) {
			
			Field field = iterator.next();
			
			if (!this.isColumnField(field)) {
				iterator.remove();
			}
		}
		return fieldList;
	}
	public List<Field> getAuditedFieldList() {
		
		if (this.isAuditedEntity()) {
			
			List<Field> fieldList = this.getColumnFieldList();
			
			Iterator<Field> iterator = fieldList.iterator();
			while (iterator.hasNext()) {
				
				Field field = iterator.next();
				
				if (!this.isAuditedFieldDA(field)) {	
					iterator.remove();
				}
			}
			
			return fieldList;
		}
		return null;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
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
		if (!this.hasId() || !other.hasId()) {
			return false;
		} 
		
		if (this.hasId() && !other.hasId()) {
			return false;
		}

		return this.getId().equals(other.getId());
	}
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public int compareTo(T other) {
		return 
			this.hasId() ?
				this.getId().compareTo(other.getId()) :
				this.toString().compareTo(other.toString());
	}
}