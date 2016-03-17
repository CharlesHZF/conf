package com.importsource.conf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 需求，其他应用程序能够方便的使用这个lib读取指定的配置文件
 * 
 * 每个应用都有自己的配置文件。这个需要写在自己的一个单独的类中来记录和读取
 * 
 * 然后里边的属性是固定好的。
 * 
 * 
 * <configuration> <property> <name>hadoop.tmp.dir</name>
 * <value>/hadoop</value> </property> <property> <name>fs.default.name</name>
 * <value>hdfs://master:9000</value> </property>
 * <property> <name>dfs.name.dir</name> <value>/hadoop/name</value> </property>
 * 
 * </configuration>
 *
 */
public class App {
	public void createXML() {
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("root");
		Element father = root.addElement("father");
		Element child = father.addElement("child");
		Element name = child.addElement("name");
		name.setText("十六笔画");
		Element sex = child.addElement("sex");
		sex.setText("男");
		try {
			PrintWriter pw = new PrintWriter("wc.xml");
			XMLWriter xw = new XMLWriter(pw);
			xw.write(doc);
			xw.flush();
			xw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Over");
		}
	}

	public void parseXML() {
		File myXML = new File("wc.xml");
		SAXReader sr = new SAXReader();
		try {
			Document doc = sr.read(myXML);
			Element root = doc.getRootElement();
			for (Iterator fathers = root.elementIterator(); fathers.hasNext();) {

				Element father = (Element) fathers.next();
				for (Iterator childs = father.elementIterator(); childs.hasNext();) {
					Element child = (Element) childs.next();
					System.out.println(child.getName() + "-----" + child.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String get(String name) {
		File myXML = new File("wc.xml");
		SAXReader sr = new SAXReader();
		try {
			Document doc = sr.read(myXML);
			Element root = doc.getRootElement();
			for (Iterator fathers = root.elementIterator(); fathers.hasNext();) {

				Element father = (Element) fathers.next();
				Iterator childs = father.elementIterator();
				Element nameElement = null;
				Element valueElement = null;
				if (childs.hasNext()) {
					nameElement = (Element) childs.next();
				}
				if (childs.hasNext()) {
					valueElement = (Element) childs.next();
				}

				if (nameElement.getText().equals(name)) {
					return valueElement.getText();
				}

			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}
