@echo off
echo ###################################### Spring 3.2 Project Demo ###################################### 
echo URL : http://localhost:8080/Spring3.2-Demo/
echo ###################################### Gradle Build ######################################
set WAR_NAME=Spring3.2-Demo
set WORKSPACE_DIR=F:\Workspace_Spring_Samples\VickySpring3.2
set TOMCAT_HOME=F:\Softwares\apache-tomcat-7.0.94

set CATALINA_HOME=%TOMCAT_HOME%

rem rmdir /s /q %TOMCAT_HOME%\work\Catalina\localhost\%WAR_NAME%
rem rmdir /s /q %TOMCAT_HOME%\webapps\%WAR_NAME%
rem del %TOMCAT_HOME%\webapps\%WAR_NAME%.war

cd %WORKSPACE_DIR%
call gradle clean
call gradle clean build war deploy


echo ###################################### Starting Tomcat ######################################
call %TOMCAT_HOME%/bin/catalina.bat run