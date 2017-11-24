package crazyjava.io;

import java.io.FileInputStream;
import java.io.IOException;

public class MyClass {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		try{
			fis = new FileInputStream("D:\\user.txt");
			byte []b= new byte[24];
			int hasRead = 0;
			while((hasRead=fis.read(b)) > 0){
				System.out.println(hasRead);
				System.out.println(new String(b,0,hasRead));
			}
		}catch(IOException e ){
			e.printStackTrace();
		}finally{
			if(fis == null)
				fis.close();
		}

	}

}
