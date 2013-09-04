package br.com.nao.to.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.contract.PublicFieldListDelegate;
import br.com.nao.helper.ReflectionHelper;
import br.com.nao.helper.StringHelper;

public class NAOTO<T extends NAOTO<? extends T>> 
	implements 
		Serializable,
		PublicFieldListDelegate
{

	private static final long serialVersionUID = -6638017139073613384L;
	
	@Getter
	@Setter
	private Class<T> clazz;
	
	
	public NAOTO(Class<T> clazz) {
		this.setClazz(clazz);
	}

	public Object get(String fieldName) {
		return ReflectionHelper.executeMethod(this, ReflectionHelper.findMethod(this.getClazz(), StringHelper.getGetter(fieldName)));
	}
	public void set(String fieldName, Object value) {
		ReflectionHelper.executeMethod(this, ReflectionHelper.findMethod(this.getClazz(), StringHelper.getSetter(fieldName)), value);
	}
	public List<Field> getPublicFieldList() {
		return this.getPublicFieldList(this);
	}
	public List<Field> getPublicFieldList(PublicFieldListDelegate delegate) {
		
		Class<?> clazz = this.getClazz();
		
		List<Field> fieldList = new ArrayList<Field>();
		
		while (clazz != null) {
	
			for (Field field : clazz.getDeclaredFields()) {
				
				Method method = ReflectionHelper.findMethod(clazz, StringHelper.getGetter(field.getName()));
				
				if (method == null) {
					continue;
				}
				
				if (!Modifier.isPublic(method.getModifiers())) {
					continue;
				}
				
				fieldList.add(field);
			}
			
			if (delegate == null) {
				clazz = clazz.getSuperclass();
				continue;
			}
			
			if (delegate.isValidSuperClass(clazz.getSuperclass())) {
				clazz = clazz.getSuperclass();
				continue;
			}
			
			clazz = null;
		}
		
		return fieldList;
	}

	@Override
	public boolean isValidSuperClass(Class<?> superClass) {
		return superClass.equals(Object.class);
	}
}
