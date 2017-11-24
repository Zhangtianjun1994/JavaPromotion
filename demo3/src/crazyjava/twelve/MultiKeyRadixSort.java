package crazyjava.twelve;

import java.util.Arrays;

//基数排序，方法是基于多个关键字进行排序，例如数字排序，按照个十百为的顺序依次排序，为最终顺序
public class MultiKeyRadixSort {

	//radix表示按多少紧致进行拆分，d 表示可以拆分成多少个关键字
	public void radixSort(DataWrap data[],int radix,int d){
		int arrayLength = data.length;
		DataWrap []tmp = new DataWrap[arrayLength];
		
		int buckets[] = new int[radix];
		
		for(int i=0,rate = 1;i<d;i++){
			//System.out.println("i:"+d);
			Arrays.fill(buckets, 0);
			System.arraycopy(data, 0, tmp, 0, arrayLength);
//			for(int j=0;j<buckets.length;j++){
//				System.out.print(buckets[j]+" ");
//			}
			for(int j=0;j<arrayLength;j++){
				int subKey = (data[j].getData()/rate) % radix;
				buckets[subKey]++;
				//System.out.print(buckets[j]+" ");
			}
			
			for(int j=1;j<radix;j++){
				buckets[j] = buckets[j] + buckets[j-1];
				//System.out.print(buckets[j]);
			}
			
			for(int j=arrayLength-1;j>=0;j--){
				int subKey = (tmp[j].getData()/rate)%radix;
				//System.out.println(buckets[subKey]);
				data[--buckets[subKey]] = tmp[j];
			}
			rate = rate*radix;
		}
		
		for(int j=0;j<arrayLength;j++){
			System.out.print(data[j]+"  ");
		}
	}
	
	public static void main(String args[]){
		DataWrap d1 = new DataWrap(252,"zhang");
		DataWrap d2 = new DataWrap(20,"xue");

		DataWrap d4 = new DataWrap(305,"zhang");

		DataWrap d6 = new DataWrap(109,"zhang");

		DataWrap []list = {d1,d2,d4,d6};
		MultiKeyRadixSort sort = new MultiKeyRadixSort();
		sort.radixSort(list, 10, 3);
	}
}
