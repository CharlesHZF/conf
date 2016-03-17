package com.importsource.conf;

import org.junit.Test;

public class PropertiesToolsTest {
	@Test
	public void testGet() {
		Properties p=new Properties("wc.xml");
		String dir=PropertiesTools.get(p,"hadoop.tmp.dir",null);
		System.out.println(dir);
	}
}
