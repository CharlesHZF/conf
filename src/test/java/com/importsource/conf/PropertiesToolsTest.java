package com.importsource.conf;

import org.junit.Test;

/**
 *
 * @author Hezf
 *
 */
public class PropertiesToolsTest {
	@Test
	public void testGet() {
		Properties p = Properties.newInstance("conf.xml");
		String dir = PropertiesTools.get(p, "hadoop.tmp.dir", null);

		System.out.println(dir);

		String dir1 = PropertiesTools.get(p, "hadoop.tmp.dir", null);

		System.out.println(dir1);
		
		String dir2 = PropertiesTools.get(p, "hadoop.tmp.dir", null);

		System.out.println(dir2);
		
		String dir3 = PropertiesTools.get(p, "hadoop.tmp.dir", null);

		System.out.println(dir3);
		
		String dir4 = PropertiesTools.get(p, "dfs.name.dir", null);

		System.out.println(dir4);
		
		String dir5 = PropertiesTools.get(p, "dfs.name.dir", "sdfsdf");

		System.out.println(dir5);
	}
}
