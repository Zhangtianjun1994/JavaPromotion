package crazyjava.tenth;

public class QueneTest {

	public static void main(String[] args) {
		SequenceQuene< String> quene = new SequenceQuene<String>();
		quene.add("zhang");
		quene.add("zue");
		quene.add("long");
		quene.add("zhang");
		quene.add("zue");
		quene.add("long");
		quene.add("zhang");

		System.out.println(quene);
		
		quene.remove();
		quene.add("zue");
		quene.add("long");
		quene.add("zhang");
		quene.add("zue");
		System.out.println(quene);
		System.out.println(quene.length());
	}

}
