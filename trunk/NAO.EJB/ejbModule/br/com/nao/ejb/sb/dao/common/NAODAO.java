package br.com.nao.ejb.sb.dao.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import lombok.Getter;
import br.com.nao.enumerator.Status;
import br.com.nao.exception.CountException;
import br.com.nao.exception.DeleteException;
import br.com.nao.exception.InsertException;
import br.com.nao.exception.RemoveException;
import br.com.nao.exception.SelectException;
import br.com.nao.exception.UpdateException;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.JPQLHelper;
import br.com.nao.helper.StringHelper;
import br.com.nao.helper.ValidateHelper;
import br.com.nao.jpa.entity.common.NAOEntity;
import br.com.nao.to.OrderByTO;


@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class NAODAO<T extends NAOEntity<? extends NAOEntity<?>>> implements NAODAOLocal<T> {

	private static final long serialVersionUID = 6836058369612935358L;
	
	
	@Getter
	@PersistenceContext
	private EntityManager entityManager;
	
	
    public NAODAO() { super(); }

	
   	@Override
	public T insert(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		try {
			
			this.getEntityManager().persist(entity);
			return entity;
			
		} catch (Exception e) {
			throw new InsertException(StringHelper.getI18N(entity.getClass()), e);
		}
	}

	@Override
	public T update(T entity) throws NAOException {

		ValidateHelper.validateFilling("entity", entity);
		
		try {
			
			entity.setStatus(Status.ACTIVE);
			
			return this.getEntityManager().merge(entity);
			
		} catch (Exception e) {
			throw new UpdateException(StringHelper.getI18N(entity.getClass()), e);
		}
	}

	@Override
	public void delete(T entity) throws NAOException {

		ValidateHelper.validateFilling("entity", entity);
		
		try {
			
			if (entity.getStatus().isActive()) {
				entity.setStatus(Status.INACTIVE);
			}
			
			this.getEntityManager().merge(entity);
			
		} catch (Exception e) {
			throw new DeleteException(StringHelper.getI18N(entity.getClass()), e);
		}

	}
	
	@Override
	public void remove(T entity) throws NAOException {
		
		ValidateHelper.validateFilling("entity", entity);
		
		try {
			this.getEntityManager().remove(entity);
		} catch (Exception e) {
			throw new RemoveException(StringHelper.getI18N(entity.getClass()), e);
		}
		
	}
	
	@Override
	public List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException {
		
		ValidateHelper.validateFilling("clazz", clazz);
		ValidateHelper.validateFilling("parameterMap", parameterMap);
		
		try {
			
			parameterMap.put("status", Status.ACTIVE);
			
			String jpql = JPQLHelper.getSelect(clazz, parameterMap, orderBy);

			List<T> list = this.createTypedQuery(clazz, parameterMap, jpql, firstResult, maxResult).getResultList();
			
			if (list == null) {
				list = new ArrayList<>();
			}
			
			return list;
			
		} catch (Exception e) {
			throw new SelectException(StringHelper.getI18N(clazz), e);
		}
	}
	
	@Override
	public int count(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException {
		
		try {
			
			parameterMap.put("status", Status.ACTIVE);
			
			String jpql = JPQLHelper.getSelectCount(clazz, parameterMap);
			
			return ((Long) this.createQuery(clazz, parameterMap, jpql).getSingleResult()).intValue();
			
		} catch (Exception e) {
			throw new CountException(StringHelper.getI18N(clazz), e);
		}
	}
	
	protected <X extends NAOEntity<? extends NAOEntity<?>>> TypedQuery<X> createTypedQuery(Class<X> clazz, Map<String, Object> parameterMap, String jpql)  throws NAOException {
		return this.createTypedQuery(clazz, parameterMap, jpql, 0, -1);
	}
	@SuppressWarnings("unchecked")
	protected <X extends NAOEntity<? extends NAOEntity<?>>> TypedQuery<X> createTypedQuery(Class<X> clazz, Map<String, Object> parameterMap, String jpql, Integer firstResult, Integer maxResult)  throws NAOException {
		return (TypedQuery<X>) this.createQuery(clazz, parameterMap, jpql, firstResult, maxResult);
	}
	
	protected <X extends NAOEntity<? extends NAOEntity<?>>> Query createQuery(Class<X> clazz, Map<String, Object> parameterMap, String jpql)  throws NAOException {
		return this.createQuery(clazz, parameterMap, jpql, 0, -1);
	}
	protected <X extends NAOEntity<? extends NAOEntity<?>>> Query createQuery(Class<X> clazz, Map<String, Object> parameterMap, String jpql, Integer firstResult, Integer maxResult) throws NAOException {
		
		JPQLHelper.println(jpql, parameterMap);
		
		Query query = JPQLHelper.bindParameter(this.getEntityManager().createQuery(jpql, clazz), parameterMap);
			
		if (firstResult != null && firstResult > -1) {
			query.setFirstResult(firstResult);	
		}
		
		if(maxResult != null && maxResult > 0) {
			query.setMaxResults(maxResult);
		}
		
		return query;
	}
}
