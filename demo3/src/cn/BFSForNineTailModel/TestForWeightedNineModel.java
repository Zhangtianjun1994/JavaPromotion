package cn.BFSForNineTailModel;

import java.util.List;

public class TestForWeightedNineModel {
	public static void main(String args[]){
		WeightedNineTailModel nine = new WeightedNineTailModel();
		//char node1[] = nine.getNode(488);
		List<Integer> path = nine.getShortestPath(488);
		for(int i=0;i<path.size();i++){
			char node[] = nine.getNode(path.get(i));
			nine.printNode(node);
			//System.out.println(path.get(i));
			System.out.println("----------------");
		}
	}

}
