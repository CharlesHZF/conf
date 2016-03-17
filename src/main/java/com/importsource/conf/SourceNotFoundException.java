package com.importsource.conf;

/**
 * 配置源找不到异常
 * 
 * @author Hezf
 */
public class SourceNotFoundException extends Exception {
	private static final long serialVersionUID = 8410520286876737936L;

	public SourceNotFoundException() {
	} 

	public SourceNotFoundException(String message) {
		super(message); 
	}
}
