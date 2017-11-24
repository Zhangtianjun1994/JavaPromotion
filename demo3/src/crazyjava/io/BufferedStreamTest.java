package crazyjava.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedStreamTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			fis = new FileInputStream("D:\\user.txt");
			fos = new FileOutputStream("D:\\new.txt");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte []b = new byte[24];
			int hasRead = 0;
			while((hasRead = bis.read(b)) > 0){
				bos.write(b,0,hasRead);
				System.out.println(hasRead);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			bos.close();
			bis.close();
//			fos.close();
//			fis.close();
		}

	}

}
