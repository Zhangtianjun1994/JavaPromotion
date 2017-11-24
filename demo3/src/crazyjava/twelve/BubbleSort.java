package crazyjava.twelve;

public class BubbleSort {

	public void bubbleSort(DataWrap data[]){
		int len = data.length;
		for(int i=0;i<len-1;i++){
			for(int j = 0;j<len-1-i;j++){
				if(data[j].compareTo(data[j+1]) > 0){
					swap(data,j,j+1);
				}
			}
		}
		for(int k=0;k<data.length;k++){
			System.out.print(data[k]+"  ");
		}
	}
	
	public void swap(DataWrap []data,int i,int j){
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	public static void main(String args[]){
		DataWrap d1 = new DataWrap(25,"zhang");
		DataWrap d2 = new DataWrap(20,"xue");
		DataWrap d3 = new DataWrap(12,"long");
		DataWrap d4 = new DataWrap(30,"zhang");
		DataWrap d5 = new DataWrap(52,"zhang");
		DataWrap d6 = new DataWrap(10,"zhang");
		DataWrap d7 = new DataWrap(45,"zhang");
		DataWrap []list = {d1,d2,d3,d4,d5,d6,d7};
		BubbleSort bubble = new BubbleSort();
		bubble.bubbleSort(list);
	}
}
