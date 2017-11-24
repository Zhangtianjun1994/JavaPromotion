package cn.BFSForNineTailModel;

public class Edge {
	protected int u;
	protected int v;
	public Edge(int u,int v){
		this.u = u;
		this.v = v;
	}
	public boolean equals(Object o){
		return u == ((Edge)o).u && v == ((Edge)o).v;
	}

}
