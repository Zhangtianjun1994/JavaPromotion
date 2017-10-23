package cn.graph.weightedgraph;

import cn.graph.weightedgraph.WeightedGraph;

public class TestWeightedGraph {
	public static void mian(String args[]){
		int [][]edges = {
				{0,1,10},{0,2,8},{0,3,5},{1,2,3},{1,4,5},{1,5,20},{1,6,12},{2,6,13},
				{2,7,14},{3,7,21}
		};
		String vertices[] = {"zzz","xxx","lll","ddd","ssss","gggg","GGGG","hahaha"};
		WeightedGraph<String> graph1 = new WeightedGraph(vertices,edges);
		System.out.println("图的顶点数量："+graph1.getSize());
		
		System.out.println("0的相邻顶点："+graph1.getVertex(0));
		
		System.out.println("lll的index是："+graph1.getIndex("lll"));
		
		System.out.println("输出图的边：");
	}

}
