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

this [blog](https://dzone.com/articles/how-configure-slf4j-different) is helpful. 

# 2016-12-26
[difference between class path and build path](http://stackoverflow.com/questions/3529459/what-is-the-difference-between-class-path-and-build-path)

The build path is used for building your application. It contains all of your source files and all Java libraries that are required to compile the application.
The classpath is used for executing the application. This includes all java classes and libraries that are needed to run the java application. A Classpath is mandatory, the default path is . which is used if the java virtual machine can't find a user defined path. (CLASSPATH environment variable, -cp flag or Class-Path: attribute in a jar manifest)

The classpath is the conventional way to tell the Java compiler and the Java runtime where to find compiled classes. It is typically a sequence of JAR file names and directory names. The classpath used by the compiler and the runtime system don't have to be the same, but they typically "should be*, especially for a small project.
Buildpath is not standard Java terminology. It is the term for the richer way that a typical IDE specifies the relationship between the "modules" or "projects" that make up an application. The IDE uses this to figure out the classpath and sourcepath for compiling the Java code, and the classpath for running it. The IDE also uses the build path to figure out how to package up your code and its dependencies as (for example) a WAR file.
For example, an Eclipse build path for a project includes the other projects that it depends on, and lists any additional library JARs that the project contains / relies on. It also lists the packages in the current project that downstream projects can depend on.
(If you are using Maven for your project, the IDE buildpath mechanism is secondary to the dependencies declared in the POM files. For example, using Eclipse with the m2eclipse, the buildpath is synthesized from the POM files.)

# 2017-01-01
[slf4j的包使用说明](http://hanhongke123.blog.163.com/blog/static/62223494201241631644433/)

[slf4j和log4j配置 ](http://blog.csdn.net/xuanjiewu/article/details/7587586)