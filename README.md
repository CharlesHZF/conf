# conf
conf

conf是一个遵循hadoop配置文件规则的xml解析读取组件。

##只需要像这下面这样两行代码就可以使用了。

```java
    com.importsource.conf.Properties p = com.importsource.conf.Properties.newInstance("conf.xml");
		driverClassName = PropertiesTools.get(p, "dbcp.driverClassName", null);
```


