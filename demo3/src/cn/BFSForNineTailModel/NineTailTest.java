package cn.BFSForNineTailModel;

import java.util.List;

public class NineTailTest {

	public static void main(String[] args) {
		System.out.println("¿ªÊ¼²âÊÔ³ÌÐò£º");
		NineTailModel nine = new NineTailModel();
		List<Integer> path = nine.getShortestPath(488);
		for(int j=0;j<path.size();j++){
			int index = path.get(j);
			char node[] = nine.getNode(index);
			nine.printNode(node);
			System.out.println("-------------");
		}

	}

}
