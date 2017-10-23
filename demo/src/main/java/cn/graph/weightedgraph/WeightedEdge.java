package cn.graph.weightedgraph;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge>{

//	protected int u;
//	protected int v;
	protected double weight;
	public WeightedEdge(int u, int v,double weight) {
		super(u, v);
		this.weight = weight;
	}

	@Override
	public int compareTo(WeightedEdge edge) {
		if(this.weight > edge.weight) return 1;
		else if(this.weight < edge.weight) return -1;
		else return 0;
	}


}
