package cn.realty;

public class GM_Deviation {	
	public GM_Deviation(){

	}
	//����ƽ���������һ����ԭ���У��ڶ�����Ԥ������
	public void deviation_XiangDui(double list1[],double list2[]){
//		System.out.println("ԭʼ���к�Ԥ������");
//		for(int i=0;i<list1.length;i++){
//			System.out.print("["+list1[i]+","+list2[i]+"]  ");
//		}

		if(list1.length != list2.length){
			System.out.println("\n���ܼ���������");
			//return -100.0;
		}else{
			int leng = list1.length;
			double list3[] = new double[leng];//������ĵ�����
			double sum = 0.0;//��������ܺ�
			for(int i=0;i<leng;i++){
				list3[i] = Math.abs((list1[i]-list2[i])/list1[i]);
				//System.out.println();
				//System.out.println("���������Ϊ��"+list3[i]+"  ");
				sum = sum+list3[i];
			}
			double result = sum/leng;
			System.out.print("\n������Ϊ��"+result+"�ȼ�Ϊ��");
			//�ж�������ȼ�
			if(result < 0.01){
				System.out.println("  �ã�һ����");
			}else if(result < 0.05){
				System.out.println("  ���ã�������");
			}else if(result < 0.10){
				System.out.println("  �ϸ�������");
			}else if(result < 0.20){
				System.out.println("  ��ǿ���ļ���");
			}else 
				System.out.println("  ���ϸ�");
		}
	}
	
	//ͨ�����㷽������鿴���ȼ�,ͬʱ����С�����ʲ鿴���ȼ�
	public void deviation_FangCha(double list1[],double list2[]){
//		System.out.println("ԭʼ���к�Ԥ������");
//		for(int i=0;i<list1.length;i++){
//			System.out.print("["+list1[i]+","+list2[i]+"]  ");
//		}
		double sum_origin = 0.0;
		double sum_cancha = 0.0;
		double list_xiangdui[] = new double[list1.length];
		double list_cancha[] = new double[list1.length];
		int leng = list1.length;
		if(list1.length != list2.length){
			System.out.println("���ܼ���������");
			//return -100.0;
		}else{
			
			for(int i=0;i<leng;i++){
				sum_origin+=list1[i];
				list_cancha[i] = list1[i]-list2[i];
				sum_cancha+=list_cancha[i];
			}
			
			double avg_origin = sum_origin/leng;
			double avg_cancha = sum_cancha/leng;
			
			double S1_2 = 0.0;
			double S2_2 = 0.0;
			double result_fangcha = 0.0;
			double result_xiaowucha = 0.0;
			int count = 0;
			for(int i=0;i<leng;i++){
				S1_2 = (list1[i]-avg_origin)*(list1[i]-avg_origin);
				S2_2 = (list_cancha[i]-avg_cancha)*(list_cancha[i]-avg_cancha);
			}
			result_fangcha = Math.sqrt(S2_2)/Math.sqrt(S1_2);
			System.out.print("\n�������ֵ�ǣ�  "+result_fangcha);
			if(result_fangcha < 0.35){
				System.out.println("�ã�һ����");
			}else if(result_fangcha <0.50){
				System.out.println("���ã�������");
			}else if(result_fangcha < 0.65){
				System.out.println("�ϸ�������");
			}else if(result_fangcha < 0.80){
				System.out.println("��ǿ���ļ���");
			}else
				System.out.println("���ϸ�");
			
			double value_yanzheng = 0.6745*(Math.sqrt(S1_2));
			for(int i=0;i<leng;i++){
				double value = Math.abs(list_cancha[i]-avg_cancha);
				//System.out.println("value"+value);
				if(value < value_yanzheng)
					count++;
			}
			//System.out.println(value_yanzheng);
			result_xiaowucha = (double)count/(double)leng;
			//����С������
			System.out.print("\nС�������ǣ�  "+result_xiaowucha);
			if(result_xiaowucha > 0.95){
				System.out.println("�ã�һ����");
			}else if(result_xiaowucha > 0.80){
				System.out.println("���ã�������");
			}else if(result_xiaowucha > 0.70){
				System.out.println("�ϸ�������");
			}else if(result_xiaowucha > 0.60){
				System.out.println("��ǿ���ļ���");
			}else
				System.out.println("���ϸ�");
		}
	}
	
	//������У��
	public void deviation_relation(){
		
	}
	
	//�ж����������Ƿ���Խ�����ɫģ��
	public double[] enableGM(double list[]){
		System.out.println("��������Ƿ����Ӧ��GMģ�͵ķ���");
		double [] list1 = new double[list.length-1];
		double [] after = new double[list.length];
		for(int i=0;i<list.length-1;i++){
			list1[i] = list[i]/list[i+1];
		}
		int leng = list.length;
		int count =0;
		double min = Math.exp(-2.0/(leng+1));
		double max = Math.exp(2.0/(leng+1));
		
		for(int i=0;i<list1.length;i++){
			if(list1[i]<min || list1[i]>max){
				count ++;
			}
				
		}
		System.out.println("min:"+min+"  max:"+max);
		if(count > 0){
			list = preData(list);
			enableGM(after);
			//System.out.println("�����в����Խ���GMģ��,��ʼ����");
		}	
		else{
			System.out.println("���㼶����֤�����Խ���Gmģ��");
			
		}
		return list;	
	}
	
	//����Ԥ������
	public double [] preData(double list[]){
		double list1[] = new double[list.length];
		int len = list.length;
		for(int i=1;i<list1.length-1;i++){
			list1[i]=(list[i-1]+2*list[i]+list[i+1])/4.0;
		}
		list1[0] = (3*list[0]+list[1])/4.0;
		list1[len-1] = (3*list[len-1]+list[len-2])/4.0;
		return list1;
	}
}
	


