package crazyjava.io;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String args[]){
//		File file = new File("D:"+File.separator+"test.txt");
//		if(file.exists())
//			file.delete();
//		else{
//			file.createNewFile();
//		}
//		
//		System.out.println(file.getParentFile());
//		System.out.println(file.getPath());
//		System.out.println(file.getName());
//		file.renameTo(new File("D:\\ttt.txt"));
		
		int b;
		try{
			System.out.print("please input:");
			while((b=System.in.read()) != -1){
				System.out.println((char)b);
				if(b == 'c')
					System.exit(1);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
