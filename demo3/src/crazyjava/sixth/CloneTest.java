package crazyjava.sixth;

public class CloneTest {

	public static void main(String[] args) {
		Dog dog= new Dog("hah",23.0);
		System.out.println("创建对象完成");
		Dog dog2 = null;
		dog2 = (Dog)dog.clone();

		System.out.println(dog == dog2);
		System.out.println(dog.equals(dog2));
	}

}
