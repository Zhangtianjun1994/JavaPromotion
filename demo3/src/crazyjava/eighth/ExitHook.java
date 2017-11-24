package crazyjava.eighth;

import java.io.FileOutputStream;

public class ExitHook {
	public static void main(String args[]) throws Exception{
		final FileOutputStream fos;
		fos = new FileOutputStream("a.bin");
		System.out.println("打开物力资源");
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
						System.out.println("物力资源关闭");
					}
				});		
		System.exit(0);
	}

}
