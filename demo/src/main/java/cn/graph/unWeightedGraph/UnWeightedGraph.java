package cn.graph.unWeightedGraph;

import java.util.List;

public class UnWeightedGraph<V> extends AbstractGraph<V>{
	public UnWeightedGraph(){}
	
	public UnWeightedGraph(V[] vertices,int [][]edges){
		super(vertices,edges);
	}
	
	public UnWeightedGraph(List<V> vertices,List<Edge> edges){
		super(vertices,edges);
	}
	
	public UnWeightedGraph(List<Edge> edges,int numberOfvertices){
		super(edges,numberOfvertices);
	}
	
	public UnWeightedGraph(int [][]edges,int numberOfvertices){
		super(edges,numberOfvertices);
	}

}
