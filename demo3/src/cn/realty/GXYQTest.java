package cn.realty;

public class GXYQTest {
	public static void main(String[] args) {
		
		FJ_OF_Month fj = new FJ_OF_Month();	
		System.out.println("开始测试GM模型的应用");
		
		//fj.insertToPrice();
		//返回2008-2016年的平均房价序列
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
		double list_origin4[] = new double[len_origin-4];//长度为5
		
		
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
		
		//测试输出是否成功
		System.out.println("***********得到初始序列****************");
		for(int i=0;i<list_origin0.length;i++)
			System.out.print(list_origin0[i]+"  ");
		System.out.println();
		
	    //建立误差分析对象
	    GM_Deviation deviation = new GM_Deviation();
	    
	    //检验是否可以应用GM模型
	    System.out.println();
	  //第一个模型预测
	    list_origin0 = deviation.enableGM(list_origin0);
	
	    System.out.println("***************经过调整后的原始序列****************");
		for(int i=0;i<list_origin0.length;i++)
			System.out.print(list_origin0[i]+"  ");
		System.out.println();
	    
//		//创建GM灰色预测模型
	    GM gm = new GM();
//	    //根据Gm模型预测，得到预测序列
	    double list_yuce0[] = gm.getOriginYuce(list_origin0);
	    nextYear+=gm.getNextYear(list_origin0);
	    for(int i=0;i<list_yuce0.length;i++){
	    	//System.out.println(list_yuce0[i]);
	    	list_endyuce[i] = list_yuce0[i];
	    }
	    	

	    //第二个模型预测
	    list_origin1 = deviation.enableGM(list_origin1);
	    double list_yuce1[] = gm.getOriginYuce(list_origin1);
	    nextYear+=gm.getNextYear(list_origin1);
	    for(int i=0;i<list_yuce1.length;i++)
	    	list_endyuce[i+1] = list_yuce1[i]+list_endyuce[i+1];
	    
	    //第三个模型预测
	    list_origin2 = deviation.enableGM(list_origin2);
	    double list_yuce2[] = gm.getOriginYuce(list_origin2);
	    nextYear+=gm.getNextYear(list_origin2);
	    for(int i=0;i<list_yuce2.length;i++)
	    	list_endyuce[i+2] = list_yuce2[i]+list_endyuce[i+2];
	    
	    //第四个模型预测
	    list_origin3 = deviation.enableGM(list_origin3);   
	    double list_yuce3[] = gm.getOriginYuce(list_origin3);
	    nextYear+=gm.getNextYear(list_origin3);
	    for(int i=0;i<list_yuce3.length;i++)
	    	list_endyuce[i+3] = list_yuce3[i]+list_endyuce[i+3];
	    
	    //第五个模型预测
	    list_origin4 = deviation.enableGM(list_origin4);
	    double list_yuce4[] = gm.getOriginYuce(list_origin4);
	    nextYear+=gm.getNextYear(list_origin4);
	    for(int i=0;i<list_yuce4.length;i++)
	    	list_endyuce[i+4] = list_yuce4[i]+list_endyuce[i+4];
	   
	    //调整租后的预测序列
	    for(int i=0;i<list_endyuce.length;i++){
	    	//System.out.println("before:["+i+"]"+list_endyuce[i]);
	    	if(i<=4)
	    		list_endyuce[i] = list_endyuce[i]/(i+1.0);
	    	else 
	    		list_endyuce[i] = list_endyuce[i]/5.0;
	    	//System.out.println("after:["+i+"]"+list_endyuce[i]);
	    }
	    //预测序列检验
	    System.out.println("***********得到预测序列****************");
	    for(int i=0;i<list_endyuce.length;i++)
	    	System.out.print(list_endyuce[i]+"  ");
	    //开始误差分析
		deviation.deviation_XiangDui(list_read, list_endyuce);
		deviation.deviation_FangCha(list_read, list_endyuce);
		
		System.out.println("2017年的放假平均数据为：12492.86");
		System.out.println("根据GM模型预测的2017年平均房价为："+nextYear/5.0);
		//deviation.deviation_relation();
		
//		System.out.print("序列2： {9830,9874,10143,11178} >> ");
//		
//		
//		double yuce1[] = gm.gm(ceshi1);
//		double yuce2[] = gm.gm(ceshi2);
//		for(int i=1;i<=yuce2.length;i++){
//			yuce1[i] = (yuce1[i]+yuce2[i-1])/2;
//		}
//		System.out.println("预测序列为：");
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
