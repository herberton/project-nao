package br.com.nao.ejb.sb.bo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.nao.ejb.sb.bo.crud.common.NAOBOCRUD;
import br.com.nao.enumerator.Status;
import br.com.nao.exception.common.NAOException;
import br.com.nao.jpa.entity.UserEntity;

@Stateless
@LocalBean
public class UserBO extends NAOBOCRUD<UserEntity> implements UserBORemote {

   private static final long serialVersionUID = -3434597631856835762L;

   public UserBO() { super(); }

   public String test(String number) {
	   
	   try {
		   
		   UserEntity user = new UserEntity();
		   
		   user.setName("teste");
		   user.setStatus(Status.ACTIVE);
		   
		   this.save(user);
		   
			System.out.println("count is " + this.count(new UserEntity()));
			
	   } catch (NAOException e) {
		   e.printStackTrace();
	   }
	   
	   return "number is " + number;
   }
}
