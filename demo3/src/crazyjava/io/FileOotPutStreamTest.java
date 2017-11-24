package crazyjava.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOotPutStreamTest {

	public static void main(String[] args) throws IOException{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream("D:\\user.txt");
			fos = new FileOutputStream("D:\\new.txt");
			byte []b = new byte[24];
			int hasRead = 0;
			while((hasRead = fis.read(b)) > 0){
				fos.write(b,0,hasRead);
				System.out.println(hasRead);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			fis.close();
			fos.close();
		}

	}

}
