package crazyjava.twelve;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.internal.localstore.Bucket;

//桶式排序，即算法导论中的时间复杂度为线性的排序方法
public class BucketSort {

	public void bucketSort(DataWrap []data,int min,int max){
		int arrayLength = data.length;
		DataWrap tmp[] = new DataWrap[arrayLength];
		int len = max-min+1;
		int buckets[] = new int[len];
		//buckets数组初始化
		for(int i=0;i<len;i++){
			buckets[i] = 0;
		}
		//第一个for循环，创建bucket数组
		for(int i=0;i<arrayLength;i++){
			buckets[data[i].getData()-min]++;
		}
		//duibuckets数组的进一步处理，使对应位置的数字确定他的排序位置
		for(int i=1;i<len;i++){
			buckets[i] = buckets[i]+buckets[i-1];
		}
		
		System.arraycopy(data, 0, tmp, 0, arrayLength);
		//对data原数组从后向前便利，然后取出相对位置的数组，放在原数组中
		
		for(int i=arrayLength-1;i>=0;i--){
			data[--buckets[tmp[i].getData()-min]] = tmp[i];
		}
		
		//对data遍历输出
		for(int i=0;i<arrayLength;i++){
			System.out.print(data[i]+"  ");
		}
	}
	
	public static void main(String args[]){
		DataWrap d1 = new DataWrap(25,"zhang");
		DataWrap d2 = new DataWrap(20,"xue");

		DataWrap d4 = new DataWrap(30,"zhang");

		DataWrap d6 = new DataWrap(10,"zhang");

		DataWrap []list = {d1,d2,d4,d6};
		BucketSort sort = new BucketSort();
		sort.bucketSort(list, 10, 30);
		PropertyConfigurator.configure("src/log4j.properties");
		Logger log = Logger.getLogger(BucketSort.class);
		log.info(new BucketSort());

	}
}
