package cn.realty;

public class GXYQTest {
	public static void main(String[] args) {
		
		FJ_OF_Month fj = new FJ_OF_Month();	
		System.out.println("��ʼ����GMģ�͵�Ӧ��");
		
		//fj.insertToPrice();
		//����2008-2016���ƽ����������
		double list_read[] = fj.return_Avgprice();
		int len_origin = list_read.length;
		double list_endyuce[] = new double[len_origin];
		double nextYear = 0.0;
		for(int i=0;i<list_endyuce.length;i++)
			list_endyuce[i] = 0.0;
		double list_origin0[] = new double[len_origin];
		double list_origin1[] = new double[len_origin-1];
		double list_origin2[] = new double[len_origin-2];
		double list_origin3[] = new double[len_origin-3];
		double list_origin4[] = new double[len_origin-4];//����Ϊ5
		
		
		for(int i=0;i<len_origin;i++){		
			list_origin0[i] = list_read[i];
			if(i+1<len_origin)
				list_origin1[i] = list_read[i+1];
			if(i+2<len_origin)
				list_origin2[i] = list_read[i+2];
			if(i+3<len_origin)
				list_origin3[i] = list_read[i+3];
			if(i+4<len_origin)
				list_origin4[i] = list_read[i+4];
		}
		
		//��������Ƿ�ɹ�
		System.out.println("***********�õ���ʼ����****************");
		for(int i=0;i<list_origin0.length;i++)
			System.out.print(list_origin0[i]+"  ");
		System.out.println();
		
	    //��������������
	    GM_Deviation deviation = new GM_Deviation();
	    
	    //�����Ƿ����Ӧ��GMģ��
	    System.out.println();
	  //��һ��ģ��Ԥ��
	    list_origin0 = deviation.enableGM(list_origin0);
	
	    System.out.println("***************�����������ԭʼ����****************");
		for(int i=0;i<list_origin0.length;i++)
			System.out.print(list_origin0[i]+"  ");
		System.out.println();
	    
//		//����GM��ɫԤ��ģ��
	    GM gm = new GM();
//	    //����Gmģ��Ԥ�⣬�õ�Ԥ������
	    double list_yuce0[] = gm.getOriginYuce(list_origin0);
	    nextYear+=gm.getNextYear(list_origin0);
	    for(int i=0;i<list_yuce0.length;i++){
	    	//System.out.println(list_yuce0[i]);
	    	list_endyuce[i] = list_yuce0[i];
	    }
	    	

	    //�ڶ���ģ��Ԥ��
	    list_origin1 = deviation.enableGM(list_origin1);
	    double list_yuce1[] = gm.getOriginYuce(list_origin1);
	    nextYear+=gm.getNextYear(list_origin1);
	    for(int i=0;i<list_yuce1.length;i++)
	    	list_endyuce[i+1] = list_yuce1[i]+list_endyuce[i+1];
	    
	    //������ģ��Ԥ��
	    list_origin2 = deviation.enableGM(list_origin2);
	    double list_yuce2[] = gm.getOriginYuce(list_origin2);
	    nextYear+=gm.getNextYear(list_origin2);
	    for(int i=0;i<list_yuce2.length;i++)
	    	list_endyuce[i+2] = list_yuce2[i]+list_endyuce[i+2];
	    
	    //���ĸ�ģ��Ԥ��
	    list_origin3 = deviation.enableGM(list_origin3);   
	    double list_yuce3[] = gm.getOriginYuce(list_origin3);
	    nextYear+=gm.getNextYear(list_origin3);
	    for(int i=0;i<list_yuce3.length;i++)
	    	list_endyuce[i+3] = list_yuce3[i]+list_endyuce[i+3];
	    
	    //�����ģ��Ԥ��
	    list_origin4 = deviation.enableGM(list_origin4);
	    double list_yuce4[] = gm.getOriginYuce(list_origin4);
	    nextYear+=gm.getNextYear(list_origin4);
	    for(int i=0;i<list_yuce4.length;i++)
	    	list_endyuce[i+4] = list_yuce4[i]+list_endyuce[i+4];
	   
	    //��������Ԥ������
	    for(int i=0;i<list_endyuce.length;i++){
	    	//System.out.println("before:["+i+"]"+list_endyuce[i]);
	    	if(i<=4)
	    		list_endyuce[i] = list_endyuce[i]/(i+1.0);
	    	else 
	    		list_endyuce[i] = list_endyuce[i]/5.0;
	    	//System.out.println("after:["+i+"]"+list_endyuce[i]);
	    }
	    //Ԥ�����м���
	    System.out.println("***********�õ�Ԥ������****************");
	    for(int i=0;i<list_endyuce.length;i++)
	    	System.out.print(list_endyuce[i]+"  ");
	    //��ʼ������
		deviation.deviation_XiangDui(list_read, list_endyuce);
		deviation.deviation_FangCha(list_read, list_endyuce);
		
		System.out.println("2017��ķż�ƽ������Ϊ��12492.86");
		System.out.println("����GMģ��Ԥ���2017��ƽ������Ϊ��"+nextYear/5.0);
		//deviation.deviation_relation();
		
//		System.out.print("����2�� {9830,9874,10143,11178} >> ");
//		
//		
//		double yuce1[] = gm.gm(ceshi1);
//		double yuce2[] = gm.gm(ceshi2);
//		for(int i=1;i<=yuce2.length;i++){
//			yuce1[i] = (yuce1[i]+yuce2[i-1])/2;
//		}
//		System.out.println("Ԥ������Ϊ��");
//		for(int i=0;i<yuce1.length;i++){
//			System.out.print(yuce1[i]+"  ");
//		}
//		System.out.println("---------------");
//		deviation.deviation_XiangDui(ceshi1, yuce1);
//		deviation.deviation_FangCha(ceshi1, yuce1);
////		fj.avgZZ_GH();
////		fj.insertToPrice();
	}

}
