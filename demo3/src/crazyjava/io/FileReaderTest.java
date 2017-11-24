package crazyjava.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fis = null;
		try{
			
			fis = new FileReader("D:\\user.txt");
			char []b = new char[24];
			int hasRead = 0;
			while((hasRead = fis.read(b)) > 0){
				System.out.println(hasRead);
				System.out.println(new String(b,0,hasRead));
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
			fis.close();
			}catch(IOException e ){
				e.printStackTrace();
			}
		}

	}

}
