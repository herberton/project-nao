package br.com.nao.helper;

import br.com.nao.exception.EmptyParameterException;
import br.com.nao.exception.common.NAOException;

public class ValidateHelper {
	
	public static <X> void validateFilling(String name, X parameter) throws NAOException {
		if (StringHelper.isNullOrEmpty(name) && parameter == null) {
			throw new EmptyParameterException();
		}
		
		if (parameter == null) {
			throw new EmptyParameterException(name);
		}
	}
	
	public static <X> void validateFilling(X parameter) throws NAOException {
		ValidateHelper.validateFilling("", parameter);
	}

	public static <X> void validateFilling(Class<X> clazz, X parameter) throws NAOException {
		if (clazz == null) {
			ValidateHelper.validateFilling(parameter); 
		}
		ValidateHelper.validateFilling(StringHelper.getI18N(clazz), parameter);
	}
}
