package br.com.project_nao.helper.string;

import java.io.Serializable;

public class StringHelper implements Serializable {

	private static final long serialVersionUID = -2953215246300514360L;

	public static <T> String getDefaultPropertyNameFrom(Class<T> clazz){
		return clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().subSequence(1, clazz.getSimpleName().length());
	}

	public static boolean isNullOrEmpty(String string) {
		return string == null || string.isEmpty();
	}
}
