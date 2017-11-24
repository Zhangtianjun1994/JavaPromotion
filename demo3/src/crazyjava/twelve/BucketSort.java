package crazyjava.twelve;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.internal.localstore.Bucket;

//Ͱʽ���򣬼��㷨�����е�ʱ�临�Ӷ�Ϊ���Ե����򷽷�
public class BucketSort {

	public void bucketSort(DataWrap []data,int min,int max){
		int arrayLength = data.length;
		DataWrap tmp[] = new DataWrap[arrayLength];
		int len = max-min+1;
		int buckets[] = new int[len];
		//buckets�����ʼ��
		for(int i=0;i<len;i++){
			buckets[i] = 0;
		}
		//��һ��forѭ��������bucket����
		for(int i=0;i<arrayLength;i++){
			buckets[data[i].getData()-min]++;
		}
		//duibuckets����Ľ�һ������ʹ��Ӧλ�õ�����ȷ����������λ��
		for(int i=1;i<len;i++){
			buckets[i] = buckets[i]+buckets[i-1];
		}
		
		System.arraycopy(data, 0, tmp, 0, arrayLength);
		//��dataԭ����Ӻ���ǰ������Ȼ��ȡ�����λ�õ����飬����ԭ������
		
		for(int i=arrayLength-1;i>=0;i--){
			data[--buckets[tmp[i].getData()-min]] = tmp[i];
		}
		
		//��data�������
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
