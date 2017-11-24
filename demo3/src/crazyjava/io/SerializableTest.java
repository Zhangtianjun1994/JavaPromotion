package crazyjava.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject("zhagnxuelong");
		oos.writeObject("successssssss");
		
		//∑¥–Ú¡–ªØ
		byte []bs = out.toByteArray();
		InputStream in = new ByteArrayInputStream(bs);
		ObjectInputStream ois = new ObjectInputStream(in);
		String s1 = (String)ois.readObject();
		String s2 = (String)ois.readObject();
		System.out.println(s1 + "  "+s2);

	}

}
