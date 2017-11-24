package crazyjava.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;


public class ObjectStreamTest {

	public static void writeObject1(){
		OutputStream outputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try{
			outputStream = new FileOutputStream("D:\\a.bin");
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
			objectOutputStream.writeObject(new Person("zhagn",23));
			objectOutputStream.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void readObject1() throws ClassNotFoundException{
		try{
			InputStream in = new FileInputStream("D:\\a.bin");
			BufferedInputStream bin = new BufferedInputStream(in);
			ObjectInputStream oin = new ObjectInputStream(bin);
			Person person = (Person) oin.readObject();
			System.out.println(person.toString());
			oin.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		writeObject1();
		readObject1();

	}

}
