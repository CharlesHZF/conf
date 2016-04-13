package com.importsource.conf;

/**
 * 配置源找不到异常
 * 
 * @author Hezf
 */
public class SourceNotFoundException extends RuntimeException {

	public SourceNotFoundException() {
	} 

	public SourceNotFoundException(String message) {
		super(message); 
	}
}
