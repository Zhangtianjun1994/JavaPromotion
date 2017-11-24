package crazyjava.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) throws IOException {
		InputStream in = new ByteArrayInputStream("abcdefghijklmnopqrstuvwxyz".getBytes());//得到字节数组
		//判断是否支持标记
		in.markSupported();
		in.skip(2);
		System.out.println((char)in.read());
		in.reset();
		System.out.println((char)in.read());
		in.mark(2);
		in.skip(4);
		System.out.println((char)in.read());//跳过了4个，指针指向第五个的、为k
		in.reset();
		System.out.println((char)in.read());
		in.skip(4);
		System.out.println((char)in.read());
		in.reset();
		System.out.println((char)in.read());
		byte []b = new byte[10];
		in.read(b, 5, 4);
	}

}
