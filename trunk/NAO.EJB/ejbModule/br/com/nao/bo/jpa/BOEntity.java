package br.com.nao.bo.jpa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.nao.bo.BO;

@Stateless
@LocalBean
public class BOEntity extends BO implements BOEntityRemote {

    public BOEntity() {
        
    }

}
