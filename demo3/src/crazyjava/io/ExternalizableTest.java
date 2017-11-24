package crazyjava.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest implements Externalizable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ExternalizableTest test = new ExternalizableTest("zhang",12);
		//序列化
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(test);
		oos.close();
		
		byte []bs = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(bs);
		ObjectInputStream ois = new ObjectInputStream(in);
		ExternalizableTest tt = (ExternalizableTest) ois.readObject();
		System.out.println(tt);
		ois.close();

	}
	

	private String str;
	private int i;
	
	public ExternalizableTest() {
		System.out.println("无参数的构造器");
	}
	public ExternalizableTest(String str,int i){
		System.out.println("有参构造器");
		this.str = str;
		this.i = i;
	}
	
	public String toString(){
		return str+i;
	}
	
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(this.str);
		out.writeInt(this.i);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.str = (String)in.readObject();
		this.i = in.readInt();
	}

}
