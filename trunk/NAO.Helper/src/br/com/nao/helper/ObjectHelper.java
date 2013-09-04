package br.com.nao.helper;


public class ObjectHelper {
	
	public static boolean isNullOrEmpty(Object object) {
		return object == null || object.equals(0) || object.equals("");
	}
}
