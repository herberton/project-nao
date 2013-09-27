package br.com.nao.ejb.sb.bo.crud.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import br.com.nao.exception.common.NAOException;
import br.com.nao.jpa.entity.common.NAOEntity;
import br.com.nao.to.OrderByTO;

@Remote
public interface NAOBOCRUDRemote<T extends NAOEntity<T>> 
	extends
		Serializable 
{
	
	T save(T entity) throws NAOException;
	T save(T entity, boolean isCommitTransaction) throws NAOException;
	
	void delete(T entity) throws NAOException;
	void delete(T entity, boolean isCommitTransaction) throws NAOException;
	
	void remove(T entity) throws NAOException;
	void remove(T entity, boolean isCommitTransaction) throws NAOException;
	
	T select(T entity) throws NAOException;
	T select(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException;
	
	List<T> selectList(T entity) throws NAOException;
	List<T> selectList(T entity, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException;
	List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException;
	List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException;
	
	int count(T entity) throws NAOException;
	int count(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException;

}
