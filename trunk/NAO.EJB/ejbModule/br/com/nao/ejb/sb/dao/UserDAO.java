package br.com.nao.ejb.sb.dao;

import br.com.nao.ejb.sb.dao.common.NAODAO;
import br.com.nao.jpa.entity.UserEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO extends NAODAO<UserEntity> implements UserDAOLocal {
       
	private static final long serialVersionUID = 4181463477034236592L;

	public UserDAO() { super(); }

}
