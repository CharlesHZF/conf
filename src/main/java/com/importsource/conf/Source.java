package com.importsource.conf;

import java.io.File;
import java.net.URL;



/**
 * 数据源
 * 
 * @author Hezf
 * @version 1.0.0
 */
public abstract  class Source {
	private static File file;

	private Source() {
	}

	public static File getFile(String path){
		if (file == null) {
			ClassLoader classLoader =Source.class.getClassLoader();
			URL url=classLoader.getResource(path);
			if(null==url){
				throw new SourceNotFoundException("The Source Can't found!");
			}else{
				file = new File(url.getFile());
			}
			
		}
		return file;
	}
}
