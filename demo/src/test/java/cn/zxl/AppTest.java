package cn.zxl;

import java.util.Comparator;

public class AppTest implements Comparator<Ractangle>{
	
	public static void main(String args[]){
		AppTest app = new AppTest();
		Ractangle rac1 = new Ractangle(2,3);
		Ractangle rac2 = new Ractangle(3,4);
		System.out.println(app.compare(rac1,rac2));
	}

	public int compare(Ractangle o1, Ractangle o2) {
		// TODO Auto-generated method stub
		if(o1.getArea()>o2.getArea())
		return 1;
		else if(o1.getArea()< o2.getArea())
			return -1;
		else return 0;
	}

}
