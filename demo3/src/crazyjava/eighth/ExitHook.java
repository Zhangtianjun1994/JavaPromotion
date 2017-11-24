package crazyjava.eighth;

import java.io.FileOutputStream;

public class ExitHook {
	public static void main(String args[]) throws Exception{
		final FileOutputStream fos;
		fos = new FileOutputStream("a.bin");
		System.out.println("��������Դ");
		Runtime.getRuntime().addShutdownHook(
				new Thread(){
					public void run(){
						if(fos != null){
							try{
								fos.close();
							}catch(Exception e){
								e.printStackTrace();
							}
							
						}
						System.out.println("������Դ�ر�");
					}
				});		
		System.exit(0);
	}

}
