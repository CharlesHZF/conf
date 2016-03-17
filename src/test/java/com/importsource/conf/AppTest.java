package com.importsource.conf;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void testDome4j() {
		App app = new App();
		//app.createXML();
		app.parseXML();
		
		String dir=app.get("hadoop.tmp.dir");
		System.out.println(dir);
	}
}

