package crazyjava.twelve;

public class QuickSort {

	public void subSort(DataWrap []data,int start,int end){

		//int flag;
		if(start < end){
			DataWrap base = data[start];
			int i=start+1;
			int j = end;
			while(i<j){
				while(data[i].compareTo(base) <= 0 && i < end){
					i++;
					System.out.println("00000");
				}
				while(data[j].compareTo(data[start]) >= 0 && j > start){
					j--;
					System.out.println("1111");
				}
				if(i<j){
					swap(data,i,j);
				}else{
					break;
				}
			}
			swap(data,start,j);
			subSort(data, start, j-1);
			subSort(data, j+1, end);
		}	
	}
	public void swap(DataWrap []data,int i,int j){
		DataWrap tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	public void quickSort(DataWrap []data){
		subSort(data,0, data.length - 1);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
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
		QuickSort sort = new QuickSort();
		sort.quickSort(list);
		
	}
}
