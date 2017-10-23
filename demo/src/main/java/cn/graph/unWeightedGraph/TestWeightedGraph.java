package cn.graph.unWeightedGraph;

import cn.graph.unWeightedGraph.UnWeightedGraph;

public class TestWeightedGraph {
	public static void mian(String args[]){
		int [][]edges = {
				{0,1},{0,2},{0,3},{1,2},{1,4},{1,5},{1,6},{2,6},{2,7},{3,7}
		};
		String vertices[] = {"zzz","xxx","lll","ddd","ssss","gggg","GGGG","hahaha"};
		UnWeightedGraph<String> graph1 = new UnWeightedGraph(vertices,edges);
		System.out.println("图的顶点数量："+graph1.getSize());
		
		System.out.println("0的相邻顶点："+graph1.getVertex(0));
		
		System.out.println("lll的index是："+graph1.getIndex("lll"));
		
		System.out.println("输出图的边：");
	}

}
