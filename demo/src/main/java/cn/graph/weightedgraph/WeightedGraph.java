package cn.graph.weightedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WeightedGraph<V> extends AbstractGraph<V> {
	
	public WeightedGraph(){}
	
	public WeightedGraph(V []vertices,int [][]edges){
		
		createWeightedGraph(Arrays.asList(vertices),edges);
	}
	
	public WeightedGraph(int [][]edges,int numberOfVertices){
		List<V> vertices = new ArrayList<V>();
		for(int i=0;i<numberOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		
		createWeightedGraph(vertices, edges);
	}
	
	public WeightedGraph(List<V> vertices,List<WeightedEdge> edges){
		createWeightedGraph(vertices, edges);
	}
	
	public WeightedGraph(List<WeightedEdge> edges,int numberOfVertices){
		List<V> vertices = new ArrayList<V>();
		for(int i=0;i<numberOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		createWeightedGraph(vertices, edges);
	}
	
	private void createWeightedGraph(List<V> vertices, List<WeightedEdge> edges) {
		this.vertices = vertices;
		
		for(int i=0;i<vertices.size();i++){
			neighbors.add(new ArrayList<Edge>());
		}
		
		for(WeightedEdge edge:edges){
			neighbors.get(edge.u).add(edge);
		}
		
	}

	private void createWeightedGraph(List<V> vertices,int[][] edges){
		this.vertices = vertices;
		
		for(int i=0;i<vertices.size();i++){
			neighbors.add(new ArrayList<Edge>());
		}
		
		for(int i=0;i<edges.length;i++){
			neighbors.get(edges[i][0]).add(new WeightedEdge(edges[i][0],edges[i][1],edges[i][2]));
		}
	}
	
	public double getWeight(int u,int v) throws Exception{
		for(Edge edge:neighbors.get(u)){
			if(edge.v == v)
				return ((WeightedEdge)edge).weight;
		}
		throw new Exception("edge doesn't exist");
	}
	
	public void printWeightedEdges(){
		for(int i=0;i<getSize();i++){
			System.out.print(vertices.get(i)+"("+i+")");
			
			for(Edge edge:neighbors.get(i)){
				System.out.print("("+edge.u+","+edge.v+","+((WeightedEdge)edge).weight+")");
			}
			System.out.println();
		}
	}
	
	public int getSize(){
		return vertices.size();
	}
	
	public boolean addEdge(int u,int v,double weight){
		return addEdge(new WeightedEdge(u, v, weight));
	}
	
	//��С������
	public MST getMinimumSpanningTree(){
		return getMinimumSpanningTree(0);
	}
	
	public MST getMinimumSpanningTree(int startingVertex){
		double cost[] = new double[getSize()];
		for(int i=0;i<cost.length;i++)
			cost[i] = Double.POSITIVE_INFINITY;
		cost[startingVertex] = 0;
		int parent[] = new int[getSize()];
		parent[startingVertex] = -1;
		double totalWeight = 0;
		
		List<Integer> T = new ArrayList<Integer>();
		
		while(T.size()<vertices.size()){
			int u = -1;
			double currentMinCost = Double.POSITIVE_INFINITY;
			for(int i=0;i<getSize();i++){
				if(!T.contains(i) && cost[i]<currentMinCost){
					currentMinCost = cost[i];
					u = i;
				}
			}
			
			T.add(u);
			totalWeight+=cost[u];
			
			for(Edge edge:neighbors.get(u)){
				if(!T.contains(edge.v) && cost[edge.v] > ((WeightedEdge)edge).weight)
				{
					cost[edge.v] = ((WeightedEdge)edge).weight;
					parent[edge.v] = u;
				}
			}
		}
		return new MST(startingVertex,parent,T,totalWeight);
	}
	
	public class MST extends Tree{
		private double totalWeight;
		
		public MST(int root,int []parent,List<Integer>searchOrder,double totalWeight){
			super(root,parent,searchOrder);
			this.totalWeight = totalWeight;
		}
		
		public double getTotalWeight(){
			return totalWeight;
		}
		
		public ShortestPathTree getShortestPath(int sourceVertex){
			double cost[] = new double[getSize()];
			for(int i=0;i<getSize();i++)
				cost[i] = Double.POSITIVE_INFINITY;
			cost[sourceVertex] = 0;
			int parent [] = new int[getSize()];
			parent[sourceVertex] = -1;
			List<Integer> T = new ArrayList<Integer>();
			
			while(T.size()<vertices.size()){
				int u = -1;
				double currentMinCost = Double.POSITIVE_INFINITY;
				for(int i=0;i<getSize();i++){
					if(!T.contains(i) && cost[i]<currentMinCost){
						currentMinCost = cost[i];
						u = i;
					}
				}
				
				T.add(u);
				totalWeight+=cost[u];
				
				for(Edge edge:neighbors.get(u)){
					if(!T.contains(edge.v) && cost[edge.v] > cost[u]+((WeightedEdge)edge).weight)
					{
						cost[edge.v] = cost[u]+((WeightedEdge)edge).weight;
						parent[edge.v] = u;
					}
				}
			}
			return new ShortestPathTree(sourceVertex,parent,T,cost);
		}
	}
	
	public class ShortestPathTree extends Tree{
		private double cost[];
		public ShortestPathTree(int source,int []parent,List<Integer> searchOrder,double[]cost){
			super(source,parent,searchOrder);
			this.cost = cost;
		}
		
		public double getCost(int v){
			return cost[v];
		}
		
		public void printAllPaths(){
			System.out.println("All shortest paths from "+vertices.get(getRoot())+" are:");
			for(int i=0;i<cost.length;i++){
				printPath(i);
				System.out.println("(cost:"+cost[i]+")");
			}
		}
	}
}
