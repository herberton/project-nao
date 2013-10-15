package br.com.nao.ejb.sb.dao;

import javax.ejb.Local;

import br.com.nao.ejb.sb.dao.common.NAODAOLocal;
import br.com.nao.jpa.entity.UserEntity;

@Local
public interface UserDAOLocal extends NAODAOLocal<UserEntity> {

}
