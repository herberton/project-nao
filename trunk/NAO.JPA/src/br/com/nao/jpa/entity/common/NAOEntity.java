package br.com.nao.jpa.entity.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.annotation.Display;
import br.com.nao.enumerator.Status;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.ObjectHelper;
import br.com.nao.jpa.el.AuditEL;
import br.com.nao.to.common.NAOTO;

@MappedSuperclass
@EntityListeners({AuditEL.class})
public class NAOEntity<T extends NAOEntity<T>> 
	extends 
		NAOTO<NAOEntity<T>> 
	implements 
		Serializable, 
		Comparable<T>
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
	@Enumerated
	private Status status;
	
	
	@SuppressWarnings("unchecked")
	public NAOEntity() {
		super((Class<NAOEntity<T>>)(Class<?>)NAOEntity.class);
	}
	
	
	public boolean haveId() {
		return this.getId() != 0;
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
	
	
	@Override
	public int compareTo(T other) {
		return 0;
	}
	@Override
	public boolean isValidSuperClass(Class<?> superClass) {
		return 
			superClass.isAnnotationPresent(Entity.class) ||
			superClass.isAnnotationPresent(MappedSuperclass.class);
	}
}
