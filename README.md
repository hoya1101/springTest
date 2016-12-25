# Collect Jerry's Spring study

# How to test

* http://localhost:9098/MavenSandbox/

* http://localhost:9098/MavenSandbox/mvc, expected to see error page: Resource Not Found Error Occured, please contact support

* http://localhost:9098/MavenSandbox/mvc/test1: expected to see hello page

* 192.168.9.106:9098/MavenSandbox/ will not work

# 2016-12-24 10:18PM
once I add log related artifacts in pom.xml, the related jar are automatically downloaded. 
![image](https://cloud.githubusercontent.com/assets/5669954/21467415/83950698-ca27-11e6-81ba-74fff8867587.png)

log4j:WARN No appenders could be found for logger (org.springframework.core.env.StandardEnvironment).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.

## solution
This occurs when the default configuration files log4j.properties and log4j.xml can not be found and the application performs no explicit configuration. log4j uses Thread.getContextClassLoader().getResource() to locate the default configuration files and does not directly check the file system. Knowing the appropriate location to place log4j.properties or log4j.xml requires understanding the search strategy of the class loader in use. log4j does not provide a default configuration since output to the console or to the file system may be prohibited in some environments. Also see FAQ: Why can't log4j find my properties in a J2EE or WAR application?.

solution see [here](http://stackoverflow.com/questions/16726457/log4jwarn-no-appenders-could-be-found-for-logger-using-slf4j-log4j12)

# 2016-12-25 12:30PM
其实slf4j原理很简单，他只提供一个核心slf4j api(就是slf4j-api.jar包)，这个包只有日志的接口，并没有实现，
所以如果要使用就得再给它提供一个实现了些接口的日志包，比 如：log4j,common logging,jdk log日志实现包等，

