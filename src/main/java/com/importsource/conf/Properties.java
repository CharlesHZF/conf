package com.importsource.conf;

import java.io.File;
import java.util.Iterator;

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
	
	protected String path;
	
	public Properties(String path){
		this.path=path;
	}

	public String get(String name, String defaultValue) {
		String value = defaultValue;
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

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return value;
	}

	protected File getSource() {
		File myXML = new File("wc.xml");
		return myXML;
	}

}
