package br.com.nao.ejb.sb.bo.crud.common;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.nao.ejb.sb.bo.common.NAOBO;
import br.com.nao.exception.EntityNotFoundException;
import br.com.nao.exception.SaveException;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.StringHelper;
import br.com.nao.helper.ValidateHelper;
import br.com.nao.jpa.entity.common.NAOEntity;
import br.com.nao.to.OrderByTO;

@Stateless
@LocalBean
public class NAOBOCRUD<T extends NAOEntity<? extends NAOEntity<?>>> 
	extends 
		NAOBO 
	implements 
		NAOBOCRUDRemote<T> 
{

    private static final long serialVersionUID = 7682571187985486249L;

    
    public NAOBOCRUD() { super(); }

   
	@SuppressWarnings("unchecked")
	@Override
	public T save(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		this.beginTransaction();
		
		try {
			
			if (entity.haveId()) {
				
				if (this.select(entity) == null) {
					throw new EntityNotFoundException(StringHelper.getI18N(entity.getClass()));
				}
				
				entity = (T) this.getDAO(entity.getClass()).update(entity);
			}
			
			entity = (T) this.getDAO(entity.getClass()).insert(entity);
			
			this.commitTransaction();
			
			return entity;
			
		} catch (Exception e) {
			
			this.rollbackTransaction();
			
			throw new SaveException(StringHelper.getI18N(entity.getClass()));
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		this.getDAO(entity.getClass()).delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		this.getDAO(entity.getClass()).remove(this.select(entity));
	}

	@Override
	public T select(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		
		List<T> list = this.selectList(entity);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}
	@Override
	public T select(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException {
		
		ValidateHelper.validateFilling("clazz", clazz);
		ValidateHelper.validateFilling("parameterMap", parameterMap);
		
		List<T> list = this.selectList(clazz, parameterMap);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public List<T> selectList(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		return this.selectList(entity, 0, null, null);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectList(T entity, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		return this.selectList((Class<T>)entity.getClass(), entity.toParameterMap(), firstResult, maxResult, orderBy);
	}
	@Override
	public List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException {
		
		ValidateHelper.validateFilling("clazz", clazz);
		ValidateHelper.validateFilling("parameterMap", parameterMap);
		
		return this.selectList(clazz, parameterMap, 0, null, null);
	}
	@Override
	public List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException {
		
		ValidateHelper.validateFilling("clazz", clazz);
		ValidateHelper.validateFilling("parameterMap", parameterMap);
		
		return this.getDAO(clazz).selectList(clazz, parameterMap, firstResult, maxResult, orderBy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int count(T entity) throws NAOException {

		ValidateHelper.validateFilling("entity", entity);

		return this.count((Class<T>)entity.getClass(), entity.toParameterMap());
	}
	@Override
	public int count(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException {
		
		ValidateHelper.validateFilling("clazz", clazz);
		ValidateHelper.validateFilling("parameterMap", parameterMap);
		
		return this.getDAO(clazz).count(clazz, parameterMap);
	}
}
