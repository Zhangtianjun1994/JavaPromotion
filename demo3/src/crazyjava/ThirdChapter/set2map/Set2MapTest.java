package crazyjava.ThirdChapter.set2map;

public class Set2MapTest {
	public static void main(String args[]){
		Set2Map< String, Integer> scores = new Set2Map<String ,Integer>();
		scores.put("math", 90);
		scores.put("english", 78);
		System.out.println(scores);
		scores.removeEntry("english");
		System.out.println(scores);
	}

}
