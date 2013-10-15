package br.com.nao.ejb.sb.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import br.com.nao.exception.common.NAOException;
import br.com.nao.jpa.entity.common.NAOEntity;
import br.com.nao.to.OrderByTO;

@Local
public interface NAODAOLocal<T extends NAOEntity<? extends NAOEntity<?>>> extends Serializable {
	
	T insert(T entity) throws NAOException;
	
	T update(T entity) throws NAOException;
	
	void delete(T entity) throws NAOException;
	
	void remove(T entity) throws NAOException;
	
	List<T> selectList(Class<T> clazz, Map<String, Object> parameterMap, Integer firstResult, Integer maxResult, OrderByTO orderBy) throws NAOException;
	
	int count(Class<T> clazz, Map<String, Object> parameterMap) throws NAOException;
}
