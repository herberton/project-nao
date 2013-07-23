package br.com.nao.ui.web.common.helper;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.nao.ui.web.common.i18n.locale.SupportedLocale;

public class ResourceBundleHelper implements Serializable {
	
	private static final long serialVersionUID = -2735630406436226996L;

	public static String getMessageBundle(String propertyFile, Locale locale, String propertyName){
		try {
			locale = locale != null ? locale : new Locale("pt_BR");
			ResourceBundle resourceBundle = ResourceBundle.getBundle("br.com.b4l.ui.web.common.i18n.application", locale);
			return resourceBundle.getString(propertyName);
		} catch(Exception e){
			return "msgkey: " + propertyName + " locale: " + locale;
		}
	}
	
	public static String getMessageBundle(String propertyFile, SupportedLocale supportedLocale, String propertyName){
		Locale locale = supportedLocale != null ?  supportedLocale.getLocale() : new Locale("pt_BR");
		return ResourceBundleHelper.getMessageBundle(propertyFile, locale, propertyName);
	}
	
	public static String getMessageBundle(String propertyName){
		return ResourceBundleHelper.getMessageBundle(JSFHelper.getPropertiesFile(), JSFHelper.getLocale(), propertyName);
	}
}

