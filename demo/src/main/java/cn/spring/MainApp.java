package cn.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


@SuppressWarnings("deprecation")
public class MainApp {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext
                ("Beans.xml");

		HelloWorld world = (HelloWorld)factory.getBean("helloWorld");
		world.getMessage();
		
	      HelloChina obj1 = (HelloChina) factory.getBean("helloChina");
	      obj1.getMessage();
	      obj1.getMessage1();
	      factory.registerShutdownHook();
	   }
}
