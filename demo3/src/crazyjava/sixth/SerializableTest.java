package crazyjava.sixth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

	public static void main(String[] args) throws Exception{
		//Wolf wolf = new Wolf("huitailang");
		System.out.println("创建对象完成");
		Wolf w2 = null;
		ObjectOutputStream os = null;
		ObjectInputStream is = null;
		try{
			os = new ObjectOutputStream(new FileOutputStream("b.bin"));
			is = new ObjectInputStream(new FileInputStream("b.bin"));
			//os.writeObject(wolf);
			os.flush();
			w2 = (Wolf) is.readObject();
			//System.out.println(wolf.equals(w2));
//			System.out.println(wolf == w2);
//			System.out.println(wolf +"  "+w2);
			
		}finally{
			if(is != null)
				is.close();
			if(os != null)
				os.close();
		}

	}

}
