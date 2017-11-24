package crazyjava.ThirdChapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @description ʹ��transient�ؼ��ֲ����л�ĳ������
 *        ע���ȡ��ʱ�򣬶�ȡ���ݵ�˳��һ��Ҫ�ʹ�����ݵ�˳�򱣳�һ��
 *        
 * @author Alexia
 * @date  2013-10-15
 */
    
public class TransientTest {

	    public static void main(String[] args) {
	        
	        User user = new User();
	        user.setUsername("Alexia");
	        user.setPasswd("123456");
	        
	        System.out.println("read before Serializable: ");
	        System.out.println("username: " + user.getUsername());
	        System.err.println("password: " + user.getPasswd());
	        
	        try {
	            ObjectOutputStream os = new ObjectOutputStream(
	                    new FileOutputStream("D:/user.txt"));
	            os.writeObject(user); // ��User����д���ļ�
	            os.flush();
	            os.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        try {
	            // �ڷ����л�֮ǰ�ı�username��ֵ
	            User.username = "jmwang";
	            
	            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
	                    "D:/user.txt"));
	            user = (User) is.readObject(); // �����ж�ȡUser������
	            is.close();
	            
	            System.out.println("\nread after Serializable: ");
	            System.out.println("username: " + user.getUsername());
	            System.err.println("password: " + user.getPasswd());
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

}
