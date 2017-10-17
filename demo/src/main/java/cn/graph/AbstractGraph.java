package cn.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGraph<V> implements Graph<V> {

	protected List<V> vertices = new ArrayList<V>();
	protected List<List<Edge>> neighbors = new ArrayList<>();//邻接线性表表示图的边来表示图
	
	protected AbstractGraph(){}
	protected AbstractGraph(V []vertices,int [][]edges){
		for(int i=0;i<vertices.length;i++){
			addVertex(vertices[i]);
		}
		
		createAdjacencyLists(edges,vertices.length);
	}
	
	protected AbstractGraph(List<V> vertices,List<Edge> edges){
		for(int i=0;i<vertices.size();i++)
			addVertex(vertices.get(i));
		
		createAdjacencyLists(edges,vertices.size());
	}
	
	protected AbstractGraph(List<Edge> edges,int numberOfVertices){
		for(int i=0;i<numberOfVertices;i++)
			addVertex(((V)new Integer(i)));
		
		createAdjacencyLists(edges,numberOfVertices);
	}
	
	protected AbstractGraph(int [][]edges,int numberOfVertices){
		for(int i=0;i<numberOfVertices;i++)
			addVertex(((V)new Integer(i)));
		
		createAdjacencyLists(edges,numberOfVertices);
	}
	
	private void createAdjacencyLists(int [][]edges,int numberOfVertices){
	
		for(int i=0;i<edges.length;i++)
			addEdge(edges[i][0],edges[i][1]);
	}
	
	private void createAdjacencyLists(List<Edge> edges,int numberOfVertices){
		
		for(Edge edge:edges)
			addEdge(edge.u,edge.v);
	}
	
	@Override
	public int getSize(){
		return vertices.size();
	}
	
	@Override
	public List<V> getVertices(){
		return vertices;
	}
	
	@Override
	public V getVertex(int index){
		return vertices.get(index);
	}
	
	@Override
	public int getIndex(V v){
		return vertices.indexOf(v);
	}
	
	@Override
	public List<Integer> getNeighbors(int index){
		List<Integer> result = new ArrayList<Integer>();
		for(Edge edge:neighbors.get(index))
			result.add(edge.v);
		return result;
	}
	
	@Override
	public int getDegree(int index){
		return  neighbors.get(index).size();
	}
	
	@Override
	public void printEdges(){
		for(int u=0;u<neighbors.size();u++){
			System.out.print(getVertex(u)+"("+u+"):");
			for(Edge edge:neighbors.get(u)){
				System.out.print("("+getVertex(edge.u)+","+getVertex(edge.v)+")");
				
			}
			System.out.println();
		}
	}
	
	@Override
	public void clear(){
		vertices.clear();
		neighbors.clear();
	}
	
	@Override
	public boolean addVertex(V vertex){
		if(!vertices.contains(vertex)){
			vertices.add(vertex);
			neighbors.add(new ArrayList<Edge>());
			return true;
		}
		else
			return false;
	}
	
	protected boolean addEdge(Edge e){
		if(e.u<0 || e.u >getSize()-1)
			throw new IllegalArgumentException("越界");
		if(e.v<0 || e.v>getSize()-1)
			throw new IllegalArgumentException("越界");
		if(!neighbors.get(e.u).contains(e)){
			neighbors.get(e.u).add(e);
			return true;
		}else
			return false;
	}
	@Override
	public boolean addEdge(int u,int v){
		return addEdge(new Edge(u,v));
	}
	
	public class  Tree{
		private int root;
		private int []parent;
		private List<Integer> searchOrder;
		
		public Tree(int root,int[] parent,List<Integer> searchOrder){
			this.root = root;
			this.parent = parent;
			this.searchOrder = searchOrder;
		}
		
		public int getRoot(){
			return root;
		}
		
		public int getParent(int v){
			return parent[v];
		}
		
		public List<Integer> getSearchOrder(){
			return searchOrder;
		}
		
		public int getNumberOfVerticesFound(){
			return searchOrder.size();
		}
		
		//return the path from the vertex to the root
		public List<V> getPath(int index){
			ArrayList<V> path = new ArrayList<V>();
			do{
				path.add(vertices.get(index));
				index = parent[index];
			}while(index!=-1);
			return path;
		}
		
		public void printPath(int index){
			List<V> path = getPath(index);
			System.out.print("A path from "+vertices.get(root)+" to "+vertices.get(index)+"is :");
			for(V v:path){
				System.out.print(v+"  ");
			}
		}
		
		//因为是简单图，所以每个顶点都只有一个父节点
		public void printTree(){
			System.out.println("Root is "+vertices.get(root));
			System.out.println("Edges:");
			for(int i=0;i<parent.length;i++){
				if(parent[i] != -1){
					System.out.print(
				"("+vertices.get(parent[i])+","+vertices.get(i)+")");
				}
				System.out.println();
			}
			System.out.println("输出searchOrder:"+searchOrder);
		}
		
	}
	
	public Tree dfs(int v){
		List<Integer> searchOrder = new ArrayList<Integer>();
		int parent[] = new int[vertices.size()];
		for(int i=0;i<parent.length;i++)
			parent[i] = -1;
		
		boolean[] isVisited = new boolean[vertices.size()];
		dfs(v,parent,searchOrder,isVisited);
		
		return new Tree(v,parent,searchOrder);
	}
	
	private void dfs(int u,int[] parent,List<Integer> searchOrder,boolean[]isVisited){
		searchOrder.add(u);
		isVisited[u] = true;
		
		for(Edge e:neighbors.get(u)){
			if(isVisited[e.v] == false){
				parent[e.v] = u;
				dfs(e.v,parent,searchOrder,isVisited);
			}
		}
		
	}
	
	public Tree bfs(int v){
		List<Integer> searchOrder = new ArrayList<Integer>();
		int parent[] = new int[vertices.size()];
		for(int i=0;i<parent.length;i++)
			parent[i] = -1;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] isVisited = new boolean[vertices.size()];
		queue.addFirst(v);
		isVisited[v] = true;
		
		while(!queue.isEmpty()){
			int u = queue.removeFirst();
			searchOrder.add(u);
			for(Edge e:neighbors.get(u)){
				if(isVisited[e.v] == false){
					queue.offer(e.v);
					parent[e.v] = u;
					isVisited[e.v] = true;
				}
			}
		}
		
		return new Tree(v,parent,searchOrder);
	}


}
