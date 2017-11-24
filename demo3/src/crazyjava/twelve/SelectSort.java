package crazyjava.twelve;

public class SelectSort {

	public void selectSort(DataWrap []data){
		int length = data.length;
		for(int i=0;i<length-1;i++){
			int minIndex = i;
			for(int j=i+1;j<length;j++){
				if(data[j].compareTo(data[minIndex]) < 0){
					minIndex = j;
				}
			}
			if(minIndex != i){
				swap(data,minIndex,i);
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
		SelectSort sort = new SelectSort();
		sort.selectSort(list);
		
	}
}
