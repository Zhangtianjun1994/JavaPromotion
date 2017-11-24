package reflect.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client {
	public static void main(String[] args)
    {
        //    ����Ҫ�������ʵ����
        Subject realSubject = new RealSubject();

        //    ����Ҫ�����ĸ���ʵ���󣬾ͽ��ö��󴫽�ȥ�������ͨ������ʵ�����������䷽����
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * ͨ��Proxy��newProxyInstance�������������ǵĴ��������������������������
         * ��һ������ handler.getClass().getClassLoader() ����������ʹ��handler������ClassLoader�������������ǵĴ������
         * �ڶ�������realSubject.getClass().getInterfaces()����������Ϊ��������ṩ�Ľӿ�����ʵ������ʵ�еĽӿڣ���ʾ��Ҫ������Ǹ���ʵ���������Ҿ��ܵ�������ӿ��еķ�����
         * ����������handler�� �������ｫ������������������Ϸ��� InvocationHandler ���������
         */
        Subject subject = (Subject)Proxy.newProxyInstance(Subject.class.getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        
        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.say("world",2018);
    }
	
	 public static void createProxyClassFile()   
	  {   
	    String name = "ProxySubject";   
	  //  byte[] data = ProxyGenerator.generateProxyClass( name, new Class[] { Subject.class } );   
	    try  
	    {   
	      FileOutputStream out = new FileOutputStream( name + ".class" );   
	      //out.write( data );   
	      out.close();   
	    }   
	    catch( Exception e )   
	    {   
	      e.printStackTrace();   
	    }   
	  }   
}
