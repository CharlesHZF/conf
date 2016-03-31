# conf

conf是一个遵循hadoop配置文件规则的xml解析读取组件。大部分的keyvalue配置都可以使用该组件轻松实现配置和读取操作。

###只需要像这下面这样两行代码就可以使用了。

```java
Properties p = com.importsource.conf.Properties.newInstance("conf.xml");
String minIdle = PropertiesTools.get(p, "dbcp.minIdle", null);
```


###你的配置文件必须像下面这样子：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<property>
		<name>dbcp.minIdle</name>
		<value>5</value>
	</property>
	<property>
		<name>dbcp.maxWait</name>
		<value>1000</value>
	</property>
</configuration>
```

###maven依赖方式
```xml

<dependency>
	<groupId>com.importsource.conf</groupId>
	<artifactId>importsource-conf</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>

```


