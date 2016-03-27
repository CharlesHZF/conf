package com.importsource.conf;
/**
 * @author hezf
 */
public interface Configurable {
	/**
	 * 根据环境变量配置
	 * 
	 * @param p 环境变量
	 * @throws BaseException
	 */
	public void configure(Properties p);
}