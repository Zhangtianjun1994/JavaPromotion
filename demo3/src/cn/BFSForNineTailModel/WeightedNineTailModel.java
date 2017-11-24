package cn.BFSForNineTailModel;

import java.util.ArrayList;
import java.util.List;

public class WeightedNineTailModel extends NineTailModel{
	protected WeightedGraph<Integer>.ShortestPathTree tree;
	public WeightedNineTailModel(){
		List<WeightedEdge> edges = getEdges();
		WeightedGraph<Integer> graph = new WeightedGraph(edges,NUMBER_OF_NODES);
		tree = graph.getShortestPath(511);
	}

	//µÃµ½±ßµÄ
	private List<WeightedEdge> getEdges(){
		List<WeightedEdge> edges = new ArrayList<WeightedEdge>();
		for(int u=0;u<NUMBER_OF_NODES;u++){
			for(int j=0;j<9;j++){
				char []node = getNode(u);
				if(node[j] == 'H'){
					int v = getFlippedNode(node,j);
					int numberOfFips = getNumberOfFlips(u,v);
					edges.add(new WeightedEdge(v,u,numberOfFips));
				}
			}
		}
		return edges;
	}
	
	private static int getNumberOfFlips(int u,int v){
		char node1[] = getNode(u);
		char node2[] = getNode(v);
		int count = 0;
		for(int i=0;i<9;i++){
			if(node1[i] == node2[i])
				count++;
		}
		return count;
	}
//	
//	public List<Integer> getShortestPath(int nodeIndex){
//		return tree.getPath(nodeIndex);
//	}
//	public int getNumberOfFlips(int u){
//		return (int)(WeightedGraph<Integer>.)
//	}
}
