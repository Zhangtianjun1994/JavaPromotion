package cn.BFSForNineTailModel;

import java.util.List;

public interface Graph<V> {
	public int getSize();
	
	public List<V> getVertices();//�õ�������
	
	public V getVertex(int index);//�õ������±�Ķ���
	
	public int getIndex(V v);//�õ�������±�
	
	public List<Integer> getNeighbors(int index);//�õ����ڶ�����±�
	
	public int getDegree(int index);//�õ������±�Ķ�
	
	public void printEdges();
	
	public void clear();
	
	public boolean addVertex(V vertex);
	
	public boolean addEdge(int u,int v);
	
	public AbstractGraph<V>.Tree dfs(int v);
	
	public AbstractGraph<V>.Tree bfs(int v);
	
}
