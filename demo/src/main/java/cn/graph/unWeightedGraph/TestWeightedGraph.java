package cn.graph.unWeightedGraph;

import cn.graph.unWeightedGraph.UnWeightedGraph;

public class TestWeightedGraph {
	public static void mian(String args[]){
		int [][]edges = {
				{0,1},{0,2},{0,3},{1,2},{1,4},{1,5},{1,6},{2,6},{2,7},{3,7}
		};
		String vertices[] = {"zzz","xxx","lll","ddd","ssss","gggg","GGGG","hahaha"};
		UnWeightedGraph<String> graph1 = new UnWeightedGraph(vertices,edges);
		System.out.println("ͼ�Ķ���������"+graph1.getSize());
		
		System.out.println("0�����ڶ��㣺"+graph1.getVertex(0));
		
		System.out.println("lll��index�ǣ�"+graph1.getIndex("lll"));
		
		System.out.println("���ͼ�ıߣ�");
	}

}
