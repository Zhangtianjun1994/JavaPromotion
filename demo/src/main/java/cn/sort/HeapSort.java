package cn.sort;

public class HeapSort {
	public static <E extends Comparable<E>> void heapSort(E []list){
		Heap<E> heap = new Heap<E>();
		for(int i=0;i<list.length;i++){
			heap.add(list[i]);
		}
		for(int k=0;k<list.length;k++)
			System.out.print(list[k]+"\t");
		
		for(int j=list.length - 1;j>=0;j--){
			list[j] = heap.remove();
		}
		for(int k=0;k<list.length;k++)
			System.out.print(list[k]+"\t");
	}

	public static void main(String args[]){
		Integer []list = {-44,-5,3,45,20,9,14};
		heapSort(list);

	}
}
