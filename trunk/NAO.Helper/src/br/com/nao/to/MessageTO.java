package br.com.nao.to;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.nao.exception.common.NAOException;
import br.com.nao.helper.StringHelper;
import br.com.nao.to.common.NAOTO;

public class MessageTO extends NAOTO<MessageTO> {
	
	
	private static final long serialVersionUID = -7411047647290080089L;
	
	
	@Getter
	@Setter
	private String text;
	@Setter
	private List<ParameterTO<String>> parameterList;
	
	
	public List<ParameterTO<String>> getParameterList() {
		if (this.parameterList == null) {
			this.setParameterList(new ArrayList<ParameterTO<String>>());
		}
		return this.parameterList;
	}
	
	
	public MessageTO() {
		super(MessageTO.class);
	}
	public MessageTO(String text) {
		this();
		this.setText(text);
	}
	public MessageTO(String text, List<ParameterTO<String>> parameterList) {
		this(text);
		this.setParameterList(parameterList);
	}
	public MessageTO(Throwable throwable) throws NAOException {
		this();
		if (throwable instanceof NAOException) {
			NAOException naoException = (NAOException)throwable;
			this.setText(naoException.convert().getText());
			this.setParameterList(naoException.convert().getParameterList());
		}
		this.setText(StringHelper.getI18N(throwable.getClass()));
	}
}
