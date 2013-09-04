package br.com.nao.exception.common;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.contract.Converter;
import br.com.nao.helper.StringHelper;
import br.com.nao.to.MessageTO;
import br.com.nao.to.ParameterTO;

public class NAOException 
	extends 
		Exception 
	implements 
		Converter<MessageTO>
{
	
	
	private static final long serialVersionUID = -6010950482595141978L;
	
	
	@Getter
	@Setter
	private MessageTO detail;
	@Getter
	@Setter
	private Class<? extends NAOException> clazz;
	@Setter
	private List<ParameterTO<String>> parameterList; 
	
	
	public List<ParameterTO<String>> getParameterList() {
		if (this.parameterList == null) {
			this.setParameterList(new ArrayList<ParameterTO<String>>());
		}
		return parameterList;
	}
	
	
	public NAOException(Class<? extends NAOException> clazz) {
		super();
		this.setClazz(clazz);
		this.printStackTrace();
	}
	public NAOException(Class<? extends NAOException> clazz, String message) {
		super(message);
		this.setClazz(clazz);
		this.setDetail(new MessageTO(message));
		this.printStackTrace();
	}
	public NAOException(Class<? extends NAOException> clazz, Throwable cause) throws NAOException {
		super(cause);
		this.setClazz(clazz);
		this.setDetail(new MessageTO(cause));
		this.printStackTrace();
	}
	
	
	@Override
	public MessageTO convert() throws NAOException {
		return new MessageTO(StringHelper.getI18N(this.getClazz()), this.getParameterList());
	}
}
