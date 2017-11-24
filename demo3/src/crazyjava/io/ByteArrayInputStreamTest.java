package crazyjava.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) throws IOException {
		InputStream in = new ByteArrayInputStream("abcdefghijklmnopqrstuvwxyz".getBytes());//�õ��ֽ�����
		//�ж��Ƿ�֧�ֱ��
		in.markSupported();
		in.skip(2);
		System.out.println((char)in.read());
		in.reset();
		System.out.println((char)in.read());
		in.mark(2);
		in.skip(4);
		System.out.println((char)in.read());//������4����ָ��ָ�������ġ�Ϊk
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
