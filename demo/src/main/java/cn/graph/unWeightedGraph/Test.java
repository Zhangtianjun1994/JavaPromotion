package cn.graph.unWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]){
		int [][]edges = {
				{0,1},{0,2},{0,3},{1,2},{1,4},{1,5},{1,6},{2,6},{2,7},{3,7}
		};
		String vertices[] = {"zzz","xxx","lll","ddd","ssss","gggg","GGGG","hahaha"};
		UnWeightedGraph<String> graph1 = new UnWeightedGraph(vertices,edges);
		System.out.println("ͼ�Ķ���������"+graph1.getSize());
		
		System.out.println("0�����ڶ��㣺"+graph1.getVertex(0));
		
		System.out.println("lll��index�ǣ�"+graph1.getIndex("lll"));
		
		System.out.println("���ͼ�ıߣ�");
		graph1.printEdges();
		
		graph1.dfs(0).printTree();
		
		graph1.bfs(0).printTree();
		
		graph1.dfs(0).printPath(7);
		
		System.out.println("-----------------------------------------");
		
		List<Edge> edge= new ArrayList<Edge>();
		
		String vertice[] = {"sss","sddd","hhhh"};
		Edge edge1 = new Edge(0,1);
		Edge edge2 = new Edge(0,2);
		Edge edge3 = new Edge(1,2);
		edge.add(edge1);edge.add(edge2);edge.add(edge3);
		UnWeightedGraph<String> graph2 = new UnWeightedGraph<String>(edge,3);
		System.out.println("���ͼ�ı�");
		graph2.printEdges();
		
	}

}
