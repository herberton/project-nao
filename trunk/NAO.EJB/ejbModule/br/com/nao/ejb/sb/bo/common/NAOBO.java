package br.com.nao.ejb.sb.bo.common;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

import lombok.AccessLevel;
import lombok.Getter;
import br.com.nao.ejb.sb.dao.common.NAODAOLocal;
import br.com.nao.exception.BeginTransactionException;
import br.com.nao.exception.CommitTransactionException;
import br.com.nao.exception.GetDAOException;
import br.com.nao.exception.RollbackTransactionException;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.EJBHelper;
import br.com.nao.helper.StringHelper;
import br.com.nao.helper.ValidateHelper;
import br.com.nao.jpa.entity.common.NAOEntity;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class NAOBO implements NAOBORemote {

	private static final long serialVersionUID = -8263350772481901387L;
	
	
	@Getter(value=AccessLevel.PROTECTED)
    @Resource
	private UserTransaction userTransaction;
	
	
    public NAOBO() { super(); }

    
    protected void beginTransaction() throws NAOException {
		
		try {
			
			if (this.getUserTransaction().getStatus() == Status.STATUS_NO_TRANSACTION) {
				
				this.println();
				this.getUserTransaction().begin();
				
			}
			
		} catch (Exception e) {
			
			throw new BeginTransactionException(e);
			
		}
		
	}
    protected void commitTransaction() throws NAOException {
    	
		try {
			
			if (this.getUserTransaction().getStatus() != Status.STATUS_NO_TRANSACTION) {
				
				this.println();
				this.getUserTransaction().commit();
				
			}
			
		} catch (Exception e) {
			
			this.rollbackTransaction();
			
			throw new CommitTransactionException(e);
		}
		
	}
	protected void rollbackTransaction() throws NAOException {
		try {
			
			if (this.getUserTransaction().getStatus() != Status.STATUS_NO_TRANSACTION) {
				
				this.println();
				this.getUserTransaction().rollback();
			
			}
			
		} catch (Exception e) {
			throw new RollbackTransactionException(e);
		}
	}
    
	@SuppressWarnings("unchecked")
	protected <T extends NAOEntity<? extends NAOEntity<?>>> NAODAOLocal<T> getDAO(Class<T> entityClazz) throws NAOException {
		
		ValidateHelper.validateFilling("entityClazz", entityClazz);
		
		try {
			
			return (NAODAOLocal<T>) 
				new InitialContext()
					.lookup(
						EJBHelper
							.getJNDIForLookup(
								this.getDAOName(entityClazz, true), 
								this.getDAOName(entityClazz, false)
							)
					);
			
		} catch (Exception e) {
			throw new GetDAOException(StringHelper.getI18N(entityClazz), e);
		}
	}
	
	
	private <T extends NAOEntity<? extends NAOEntity<?>>> String getDAOName(Class<T> entityClazz, boolean isGetSimpleName) throws NAOException {
		ValidateHelper.validateFilling("entityClazz", entityClazz);
		String daoName = isGetSimpleName ? entityClazz.getSimpleName() : entityClazz.getName();
		return daoName.replace("br.com.nao.jpa.entity", "br.com.nao.ejb.sb.dao").replace("Entity", "DAO");
	}	
	private String getUserTransactionStatus() throws NAOException {
		
    	try {
    		
			switch (this.getUserTransaction().getStatus()) {
				case Status.STATUS_ACTIVE: return "STATUS_ACTIVE";
				case Status.STATUS_COMMITTED: return "STATUS_COMMITTED";
				case Status.STATUS_COMMITTING: return "STATUS_COMMITTING";
				case Status.STATUS_MARKED_ROLLBACK: return "STATUS_MARKED_ROLLBACK";
				case Status.STATUS_NO_TRANSACTION: return "STATUS_NO_TRANSACTION";
				case Status.STATUS_PREPARED: return "STATUS_PREPARED";
				case Status.STATUS_PREPARING: return "STATUS_PREPARING";
				case Status.STATUS_ROLLEDBACK: return "STATUS_ROLLEDBACK";
				case Status.STATUS_ROLLING_BACK: return "STATUS_ROLLING_BACK";
				case Status.STATUS_UNKNOWN: return "STATUS_UNKNOWN";
				default: return "-";
			}
			
		} catch (Exception e) {
			throw new NAOException(NAOException.class, e);
		}
    	
    }
	private void println() throws NAOException {
		System.out.println("NAO.Transaction:\t" + this.getUserTransactionStatus());
	}
}
