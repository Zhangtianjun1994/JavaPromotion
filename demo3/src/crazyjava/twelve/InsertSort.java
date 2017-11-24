package crazyjava.twelve;

public class InsertSort {

	public void insertSort(DataWrap []data){
		int len = data.length;
		
		for(int i=1;i<len;i++){
			DataWrap tmp = data[i];
			
			if(data[i-1].compareTo(tmp) > 0){
				int j=i-1;
				for(;j>=0 &&data[j].compareTo(tmp) >= 0;j--){
						data[j+1] = data[j];
				}
				data[j+1] = tmp;
				
		}

	}
		
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
		DataWrap []list = {d1,d2,d3,d4,d5,d6,d7};//
		InsertSort sort = new InsertSort();
		sort.insertSort(list);
	}
}
