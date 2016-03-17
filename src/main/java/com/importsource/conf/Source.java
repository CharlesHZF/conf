package com.importsource.conf;

import java.io.File;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 数据源
 * 
 * @author Hezf
 * @version 1.0.0
 */
public abstract  class Source {
	protected static final Logger logger = LogManager.getLogger(Source.class);
	private static File file;

	private Source() {
	}

	public static File getFile(String path)  {
		if (file == null) {
			ClassLoader classLoader =Source.class.getClassLoader();
			URL url=classLoader.getResource(path);
			if(null==url){
				logger.warn("The Source Can't found!");
			}else{
				file = new File(url.getFile());
			}
			
		}
		return file;
	}
}
