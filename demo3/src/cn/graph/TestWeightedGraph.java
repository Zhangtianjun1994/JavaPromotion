package cn.graph;

public class TestWeightedGraph {
	public static void main(String args[]){
		int [][]edges = {
				{0,1,10},{0,2,8},{0,3,5},{1,2,3},{1,4,5},{1,5,20},{1,6,12},{2,6,13},
				{2,7,14},{3,7,21}
		};
		String vertices[] = {"zzz","xxx","lll","ddd","ssss","gggg","GGGG","hahaha"};
		WeightedGraph<String> graph1 = new WeightedGraph(vertices,edges);
//		System.out.println("ͼ�Ķ���������"+graph1.getSize());
//		
//		System.out.println("0�����ڶ��㣺"+graph1.getVertex(0));
//		
//		System.out.println("lll��index�ǣ�"+graph1.getIndex("lll"));
//		
//		System.out.println("���ͼ�ıߣ�");
//		graph1.printWeightedEdges();
		graph1.getMinimumSpanningTree(0).printTree();
		//graph1.getMinimumSpanningTree(0).getShortestPath(2).getCost(2);
		graph1.getShortestPath(0).printAllPaths();
	}
	
}
