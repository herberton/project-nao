package br.com.nao.contract;

import br.com.nao.exception.common.NAOException;

public interface Converter<T> {
	T convert() throws NAOException;
}