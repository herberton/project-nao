package br.com.nao.ejb.sb.bo;

import javax.ejb.Remote;

import br.com.nao.ejb.sb.bo.crud.common.NAOBOCRUDRemote;
import br.com.nao.jpa.entity.UserEntity;

@Remote
public interface UserBORemote extends NAOBOCRUDRemote<UserEntity> {
	String test(String number);
}
