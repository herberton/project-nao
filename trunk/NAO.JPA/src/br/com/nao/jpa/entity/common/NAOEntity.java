package br.com.nao.jpa.entity.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.annotation.Audited;
import br.com.nao.annotation.Display;
import br.com.nao.contract.ClassInformer;
import br.com.nao.enumerator.Status;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.ObjectHelper;
import br.com.nao.jpa.el.AuditEL;
import br.com.nao.jpa.entity.AuditEntity;
import br.com.nao.jpa.entity.UserEntity;
import br.com.nao.to.common.NAOTO;

@Audited
@MappedSuperclass
@EntityListeners({AuditEL.class})
public class NAOEntity<T extends NAOEntity<T>> 
	extends 
		NAOTO<NAOEntity<T>> 
	implements 
		Serializable, 
		Comparable<T>,
		ClassInformer
{

	
	private static final long serialVersionUID = 1873055400152243177L;

	
	@Getter
	@Setter
	@Display
	@Id
	@GeneratedValue
	private long id;
	@Getter
	@Setter
	@Column(nullable=false)
	@Enumerated
	private Status status;
	@Getter
	@Setter
	@OneToOne(optional=true, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private AuditEntity audit;
	
	@Getter
	@Setter
	@Transient
	private UserEntity loggedUser;
	
	
	public NAOEntity() { super(); }
	
	
	public boolean haveId() {
		return this.getId() > 0L;
	}
	
	public Map<String, Object> toParameterMap() throws NAOException {
		
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		if (this.haveId()) {
			parameterMap.put("id", this.getId());
			return parameterMap;
		}
		
		List<Field> fieldList = this.getPublicFieldList();
		
		for (Field field : fieldList) {
			
			Object value = null;
			
			value = this.get(field.getName());
			
			if (ObjectHelper.isNullOrEmpty(value) || value instanceof Collection) {
				continue;
			}
			
			if (value instanceof NAOEntity) {
				
				@SuppressWarnings("unchecked")
				NAOEntity<? extends NAOEntity<? extends NAOEntity<?>>> child = 
					(NAOEntity<? extends NAOEntity<? extends NAOEntity<?>>>)value;
				
				Map<String, Object> subParameterMap = child.toParameterMap();
				
				for (String key : subParameterMap.keySet()) {
					parameterMap.put(field.getName().concat(".").concat(key), subParameterMap.get(key));
				}
				
				continue;
			}
			
			parameterMap.put(field.getName(), value);
		}
		
		return parameterMap;
	}
	
	public boolean isAudited() {
		return 
			this.getClass().isAnnotationPresent(Audited.class) && 
			this.getClass().getAnnotation(Audited.class).value();
	}
	
	@Override
	public int compareTo(T other) {
		return 0;
	}
	
	@Override
	public boolean isValidClass(Class<?> clazz) {
		return 
			clazz != null &&
			clazz.isAnnotationPresent(Entity.class) ||
			clazz.isAnnotationPresent(MappedSuperclass.class);
	}
}
