package br.com.nao.ejb.sb.bo;

import java.util.List;

import br.com.nao.ejb.sb.bo.common.NAOBO;
import br.com.nao.exception.common.NAOException;
import br.com.nao.jpa.entity.MenuEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SystemBO extends NAOBO implements SystemBORemote {
       
    private static final long serialVersionUID = 121260125226042695L;

	public SystemBO() {
        super();
    }

	@Override
	public List<MenuEntity> getMenuList(final boolean create) throws NAOException {
		
		if (create) {
			// TODO: Criar lista de menus
		}
		
		// TODO: Retornar lista de menus
		return null;
	}

}
