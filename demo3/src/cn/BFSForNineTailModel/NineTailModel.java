package cn.BFSForNineTailModel;

import java.util.ArrayList;
import java.util.List;

import org.omg.IOP.CodecFactoryPackage.UnknownEncodingHelper;

public class NineTailModel {
	public final static int NUMBER_OF_NODES = 512;
	protected AbstractGraph<Integer>.Tree tree;
	
	public NineTailModel(){
		List<Edge> edges = getEdges();
		UnWeightedGraph<Integer> graph = new UnWeightedGraph(edges,NUMBER_OF_NODES);
		tree = graph.bfs(511);
	}
	
	private List<Edge> getEdges(){
		List<Edge> edges = new ArrayList<>();
		for(int i=0;i<NUMBER_OF_NODES;i++){
			for(int j=0;j<9;j++){
				char[]node = getNode(i);
				if(node[j] == 'H'){
					int v = getFlippedNode(node,j);
					edges.add(new Edge(v,i));
				}
			}
		}
		return edges;
	}
	
	protected static int getFlippedNode(char []node,int position){
		int row = position/3;
		int colum = position%3;
		flipACell(node,row,colum);
		flipACell(node,row+1,colum);
		flipACell(node,row-1,colum);
		flipACell(node,row,colum+1);
		flipACell(node,row,colum-1);
		return getIndex(node);
	}
	
	public static int getIndex(char[]node){
		int result = 0;
		for(int i=8;i>=0;i--){
			if(node[i] == 'H')
				result = result*2;
			else
				result=result*2+1;
		}
		
		return result;
	}
	
	public static char[] getNode(int index){
		char result[] = new char[9];
		
		for(int i=0;i<9;i++){
			int digit = index%2;
			if(digit == 0)
				result[8-i] = 'H';
			else
				result[8-i] = 'T';
			index = index/2;
		}
		return result;
	}

	private static void flipACell(char[]node,int row,int colum){
		if(row >=0 && row <=2 && colum<=2 && colum>=0){
			if(node[row*3+colum] == 'T')
				node[row*3+colum] = 'H';
			else
				node[row*3+colum] = 'T';
		}
	}
	
	public List<Integer> getShortestPath(int nodeIndex){
		return tree.getPath(nodeIndex);
	}
	
	public static void printNode(char []node){
		for(int i=0;i<9;i++){
			if(i%3 != 2)
				System.out.print(node[i]+"  ");
			else 
				System.out.println(node[i]);
		}
	}
}
