package com.importsource.conf;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
 * 提供了获取配置文件中value的一级支持
 * @author Hezf
 *
 */
public class Properties {
	/**
	 * a logger of log4j
	 */
	protected static final Logger logger = LogManager.getLogger(Properties.class);
	/**
	 * 增加缓存能力
	 */
	private static final HashMap<String, String> propertiesMap = new HashMap<String,String>();
	
	/**
	 * 默认文件路径
	 */
	protected static String path="conf.xml";
	
	/**
	 * 如果使用这个构造函数，那么就是用默认路径
	 */
	private Properties(){
		
	}
	
	/**
	 * 可以定制目录
	 * @param path  客户端指定的目录
	 */
	private Properties(String path){
		this.path=path;
	}
	
	private static Properties properties;


	public static Properties newInstance(String path) {
		if (properties == null) {
			properties = new Properties(path);
		}
		return properties;
	}

	public static String get(String name, String defaultValue) {
		String value =getFromCache(name);
		if(value==null){
			//没在缓存里边拿
			logger.info("缓存里没有");
			value=defaultValue;
			File myXML = Source.getFile(path);
			SAXReader sr = new SAXReader();
			try {
				Document doc = sr.read(myXML);
				Element root = doc.getRootElement();
				for (Iterator<Element> fathers = (Iterator<Element>) root.elementIterator(); fathers.hasNext();) {

					Element father = (Element) fathers.next();
					Iterator<Element> childs = (Iterator<Element>) father.elementIterator();
					Element nameElement = null;
					Element valueElement = null;
					if (childs.hasNext()) {
						nameElement = (Element) childs.next();
					}
					if (childs.hasNext()) {
						valueElement = (Element) childs.next();
					}

					if (nameElement.getText().equals(name)) {
						value = valueElement.getText();
					}
					
					propertiesMap.put(name, value);

				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}else{
			logger.info("缓存里取得");
		}
		
		
		return value;
	}

	protected static String getFromCache(String name) {
		return propertiesMap.get(name);
	}

	protected File getSource() {
		File myXML = new File("wc.xml");
		return myXML;
	}

}
