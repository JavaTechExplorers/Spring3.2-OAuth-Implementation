1. Project built using Spring 4.0.3 Release
2. MySQL Database: 

	<beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close">
		<beans:property name="driverClassName" value="com.mysql.jdbc.Driver" />
		<beans:property name="url"
			value="jdbc:mysql://localhost:3306/spring_app" />
		<beans:property name="username" value="root" />
		<beans:property name="password" value="password" />
	</beans:bean>
	
3. Embedded Tomcat configured which reads WAR from  F:\Workspace_Spring_Samples\VickySpring3.2\build\libs\spring3.2-demo.war
4. Build gradle and run Tomcat usinf the below command

https://github.com/bmuschko/gradle-tomcat-plugin

F:\Workspace_Spring_Samples\VickySpring3.2>gradle clean compileJava build war tomcatRunWar

5. Open the below URL
	http://localhost:8080/VickySpring3.2/persons
	

	