package br.com.nao.to.common;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import br.com.nao.contract.ClassInformer;
import br.com.nao.contract.ClassValidator;
import br.com.nao.helper.ReflectionHelper;
import br.com.nao.helper.StringHelper;

public class NAOTO<T extends NAOTO<T>> 
	implements 
		Serializable,
		ClassInformer
{

	private static final long serialVersionUID = -6638017139073613384L;
	
	
	public NAOTO() { super(); }

	
	public Object get(String fieldName) {
		return ReflectionHelper.executeMethod(this, ReflectionHelper.findMethod(this.getClass(), StringHelper.getGetter(fieldName)));
	}
	
	public void set(String fieldName, Object value) {
		ReflectionHelper.executeMethod(this, ReflectionHelper.findMethod(this.getClass(), StringHelper.getSetter(fieldName)), value);
	}
	
	@Override
	public List<Field> getPublicFieldList() {
		return this.getPublicFieldList(this);
	}
	@Override
	public List<Field> getPublicFieldList(ClassValidator validator) {
		
		Class<?> clazz = this.getClass();
		
		List<Field> fieldList = new ArrayList<Field>();
		
		do {
			
			
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
			
			
			clazz = clazz.getSuperclass();
			
			
		} while(validator == null || clazz == null ? clazz != null : validator.isValidClass(clazz));
		
		
		return fieldList;
	}
	
	@Override
	public boolean isValidClass(Class<?> clazz) {
		return 
			clazz!= null && 
			clazz.equals(Object.class);
	}
}
