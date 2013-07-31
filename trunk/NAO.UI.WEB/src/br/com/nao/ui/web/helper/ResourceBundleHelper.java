package br.com.nao.ui.web.helper;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.nao.helper.ConfigurationHelper;
import br.com.nao.helper.LocaleHelper;

public class ResourceBundleHelper implements Serializable {

	private static final long serialVersionUID = 1000445796467032107L;

	public static String getMessageBundle(String propertyFile, Locale locale, String propertyName){
		try {
			locale = locale != null ? locale : new Locale("pt_BR");
			ResourceBundle resourceBundle = ResourceBundle.getBundle(ConfigurationHelper.UI_WEB_PACKAGE_I18N_PROPERTIES_BASE_NAME, locale);
			return resourceBundle.getString(propertyName);
		} catch(Exception e){
			return "msgkey: " + propertyName + " locale: " + locale;
		}
	}
	
	public static String getMessageBundle(String propertyFile, LocaleHelper localeHelper, String propertyName){
		Locale locale = localeHelper != null ?  localeHelper.getLocale() : new Locale("pt_BR");
		return ResourceBundleHelper.getMessageBundle(propertyFile, locale, propertyName);
	}
	
	public static String getMessageBundle(String propertyName){
		return ResourceBundleHelper.getMessageBundle(JSFHelper.getPropertiesFile(), JSFHelper.getLocale(), propertyName);
	}
}
