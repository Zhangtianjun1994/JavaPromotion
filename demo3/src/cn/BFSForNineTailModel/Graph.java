package cn.BFSForNineTailModel;

import java.util.List;

public interface Graph<V> {
	public int getSize();
	
	public List<V> getVertices();//得到定点数
	
	public V getVertex(int index);//得到具体下表的顶点
	
	public int getIndex(V v);//得到顶点的下表
	
	public List<Integer> getNeighbors(int index);//得到相邻顶点的下表
	
	public int getDegree(int index);//得到具体下表的度
	
	public void printEdges();
	
	public void clear();
	
	public boolean addVertex(V vertex);
	
	public boolean addEdge(int u,int v);
	
	public AbstractGraph<V>.Tree dfs(int v);
	
	public AbstractGraph<V>.Tree bfs(int v);
	
}
