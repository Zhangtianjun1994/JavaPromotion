package cn.bingxing;

public class MergeSort {
	
	public static void mergeSort(int []list){
		if(list.length > 1){
			
			int firstHalf[] = new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			//System.out.print("前半部分递归   ");
			mergeSort(firstHalf);
			
			
			int []secondHalf = new int[list.length-list.length/2];
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalf.length);
			//System.out.print("后半部分递归    ");
			mergeSort(secondHalf);
			
			merge(firstHalf,secondHalf,list);
		}

	}

	
	public static void merge(int []list1,int []list2,int []temp){
		int current1 = 0;
		int current2 = 0;
		int current = 0;
		
		while(current1 < list1.length && current2 < list2.length){
			if(list1[current1] < list2[current2])
				temp[current++] = list1[current1++];
			else 
				temp[current++] = list2[current2++];
		}
		
		while(current1 < list1.length)
			temp[current++] = list1[current1++];
		while(current2 < list2.length)
			temp[current++] = list2[current2++];
	}
	
	public static void main(String args[]){
		int a[] = {2,4,3,9,6,7,10,35};
		mergeSort(a);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+"  ");
	}
}
