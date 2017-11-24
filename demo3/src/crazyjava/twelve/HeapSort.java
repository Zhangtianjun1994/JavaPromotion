package crazyjava.twelve;

public class HeapSort<T extends Comparable> {

	//构建zuidadui
	private void buileMaxHeap(T []data,int lastIndex){
		int index = (lastIndex-1)/2;
		for(int i=index;i>=0;i--){
			//找到孩子的最大
			int k = i;
			while(2*k+1 <= lastIndex){
				int maxIndex;
				maxIndex = 2*k+1;
				if(maxIndex < lastIndex){
					//int cmp = 0;
					if(data[maxIndex].compareTo(data[maxIndex+1]) < 0)
						maxIndex =  maxIndex+1;
					System.out.println("0000");
				}

				if(data[maxIndex].compareTo(data[k]) > 0){
					swap(data,k,maxIndex);
					k = maxIndex;
					System.out.println("swap");
				}else{
					break;
				}
			}

		}
	}
	
	public void swap(T []data,int i,int j){
		T tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	//最大队的排序
	public void maxHeapSort(T []data){
		int length = data.length;
		for(int i=0;i<length-1;i++){
			buileMaxHeap(data, length-1-i);
			swap(data,0,length-1-i);
			System.out.println("111111111");
		}
		
		for(int j=0;j<data.length;j++){
			System.out.print(data[j]+"  ");
		}
	}
	
	public static void main(String args[]){
		String s[]={"ask","wer","azsxdfv","weuii","ookk","sydfu","sdf"};
		Integer in[] = {new Integer(12),new Integer(25),new Integer(2),new Integer(45),new Integer(32),new Integer(52)};
		
		HeapSort<String> heap = new HeapSort<String>();
		//HeapSort<Integer> heap2 = new HeapSort<Integer>();
		heap.maxHeapSort(s);
		//heap2.maxHeapSort(in);
				
	}

}
