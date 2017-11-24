package crazyjava.twelve;

public class BinaryInsertSort {

	public void binaryInsertSort(DataWrap data[]){
		int len = data.length;
		
		for(int i=1;i<len;i++){
			DataWrap tmp = data[i];
			int low = 0;
			int high = i-1;
			while(low <= high){
				int index = (low +high)/2;
				if(data[index].compareTo(tmp) > 0){
					high = index-1;
				}
				else{
					low = index+1;
				}
				System.out.println("0000");
			}
			for(int j=i-1;j>=low;j--){
				data[j+1] = data[j];
				System.out.println("1111");
			}
			data[low] = tmp;
		}
		for(int i=0;i<len;i++){
			System.out.print(data[i]+ "  ");
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
		BinaryInsertSort sort = new BinaryInsertSort();
		sort.binaryInsertSort(list);
		
	}
}
