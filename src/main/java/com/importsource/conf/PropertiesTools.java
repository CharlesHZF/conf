package com.importsource.conf;

/**
 * 这个是提供给客户端使用的。直接通过name获取的value。
 * 
 * 这个里边的方法参数是不能变的
 * 
 * <h5>用户场景：</h5>
 *   <p>
 *   开发人员直接通过此类就可以搞定。需要构建一个Properties。这时候需要指定一个路径。
 *   <p>
 *   增加缓存能力，这个很重要。如果不增加缓存，那么每次都要解析节点。这个是性能底下的表现。可以把
 *   <p>
 *   
 *   
 * @author Hezf
 *
 */
public class PropertiesTools {
	public static String get(Properties props,String name,String defaultValue){
		return props.get(name, defaultValue);
	}
}
