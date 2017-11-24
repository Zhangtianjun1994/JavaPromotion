package crazyjava.twelve;

public class MergeSort {
	
	public void merge(DataWrap []data,int left,int center,int right){
		DataWrap []tmp = new DataWrap[data.length];
		int mid = center+1;
		int third = left;
		int tmpIndex = left;
		while(left <= center && mid <= right){
			if(data[left].compareTo(data[mid]) < 0){
				tmp[third++] = data[left++];
			}else{
				tmp[third++] = data[mid++];
			}
		}
		while(mid <= right){
			tmp[third++] = data[mid++];
		}
		while(left<=center){
			tmp[third++] = data[left++];
		}
		//拍好的数据重新协会到data里面
		while(tmpIndex <= right){
			data[tmpIndex] = tmp[tmpIndex++];
		}
		
	}
	
	public void mergeSort(DataWrap []data){
		sort(data,0,data.length-1);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+"  ");
		}
	}
	
	public void sort(DataWrap []data,int left,int right){
		//递归方法的调用
		if(left < right){
			int center = (left+right)/2;
			sort(data,left,center);
			sort(data,center+1,right);
			merge(data,left,center,right);
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
		MergeSort sort = new MergeSort();
		sort.mergeSort(list);
		
	}

}
