package com.importsource.conf;


public class PropertiesTools {
	public static String get(Properties props,String name,String defaultValue){
		return props.get(name, defaultValue);
	}
}
