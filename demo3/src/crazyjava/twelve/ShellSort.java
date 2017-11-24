package crazyjava.twelve;


//shellSort是对插入排序的改进，通过设置步长h，h公示为：h = 3h+1；
public class ShellSort {

	public void shellSort(DataWrap data[]){
		int len = data.length;
		int h=1;
		while(3*h+1 < len){
			h = 3 * h +1;
		}
		while(h > 0){
			for(int i=h;i<len;i++){
				DataWrap tmp = data[i];
				if(tmp.compareTo(data[i-h]) < 0){
					int j = i-h;
					for(;j>=0 && tmp.compareTo(data[j]) < 0;j-=h){
						data[j+h] = data[j];
					}
					data[j+h] = tmp;
				}
			}
			h = (h-1)/3;
		}
		
		for(int i=0;i<len;i++){
			System.out.print(data[i]+"  " );
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
		ShellSort sort = new ShellSort();
		sort.shellSort(list);
		
	}
}
