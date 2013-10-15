package br.com.nao.ejb.sb.bo;

import java.util.List;

import javax.ejb.Remote;

import br.com.nao.ejb.sb.bo.common.NAOBORemote;
import br.com.nao.exception.common.NAOException;
import br.com.nao.jpa.entity.MenuEntity;

@Remote
public interface SystemBORemote extends NAOBORemote {
	List<MenuEntity> getMenuList(final boolean create) throws NAOException;
}
