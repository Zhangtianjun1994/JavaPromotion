package cn.zxl;

public class EightQueens {
	
	private static int []queens = {-1,-1,-1,-1,-1,-1,-1,-1};
	
	public boolean search(){
		//System.out.println("111111111");
		int pos = 0;
		while(pos<8 && pos>=0){//行
			
			int j = findPosition(pos);//找到行对应的有效列
			if(j < 0){
				queens[pos] = -1;
				pos--;
			}
			else{
				//System.out.print("pos:"+pos+" ");
				queens[pos] = j;
				pos++;
			}
		}
		if(pos == -1)
			return false;
		else 
			return true;
		
			
	}
	public int findPosition(int k){
		//System.out.println("2222222");
		int start = queens[k]+1;
		for(int j=start;j<8;j++){
		
			if(isValid(k,j)){
				//System.out.print("j:"+j);
				return j;
			}
		}
		return -1;
	}
	public boolean isValid(int row,int colum){
		//System.out.println("##########");
		for(int i=1;i<=row;i++){
			
			if(queens[row-i] == colum || queens[row-i] == colum-i || queens[row-i] == colum+i)
				return false;
		
		}
		return true;
	}
	public static void main(String args[]){
	char map[][] = new char[8][8];
	for(int i =0;i<8;i++){
		for(int j=0;j<8;j++){
			map[i][j] = 'O';
		}
	}
	EightQueens eight = new EightQueens();
		eight.search();
	
	for(int j =0;j < 8;j++){
		int colum = queens[j];
		map[j][queens[j]] = '*';
		//System.out.print("queen"+ queens[j]+"  ");
	}

	
	for(int i =0;i<8;i++){
		for(int j=0;j<8;j++){
			System.out.print(map[i][j]+"  ");
		}
		System.out.println();
	}
	}

}
