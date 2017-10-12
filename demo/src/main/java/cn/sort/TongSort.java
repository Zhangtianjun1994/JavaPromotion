package cn.sort;

import java.util.ArrayList;

public class TongSort<E> {
	public void tongSort(E[] list,int max){
		int len = list.length;
		ArrayList[] bucket = new ArrayList[max+1];
		for(int i=0;i<len;i++){
			int key = (Integer) list[i];
			if(bucket[key] == null){
				bucket[key] = new ArrayList<>();
				bucket[key].add(list[i]);
			}
			else
				bucket[key].add(list[i]);
		}
		int a=0;
		//System.out.println("11111111");
		for(int j=0;j<max+1;j++){
			if(bucket[j] != null){
			for(int k=0;k<bucket[j].size();k++){
				list[a++] = (E) bucket[j].get(k);
			}
			}
		}
		//System.out.println("222222222");
		for(int b=0;b<list.length;b++){
			System.out.print(list[b]+"\t");
		}
	}
	
	public static void main(String args[]){
		Integer list1[] = {2,4,7,10,5,6,8,3};
		TongSort<Integer> tong = new TongSort<Integer>();
		tong.tongSort(list1, 10);
	}


}
