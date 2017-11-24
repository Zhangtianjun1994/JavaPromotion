package cn.realty;

public class DLTest {

	public static void main(String[] args) {
		FJ_OF_Month fj = new FJ_OF_Month();	
		System.out.println("开始测试GM模型的应用");
		System.out.println("*****************对大连市的房价进行相关的预测***************");
		//fj.insertToPrice();
		//返回2008-2016年的平均房价序列
		double list_read[] = fj.return_DL_Avgprice();
		int len_origin = list_read.length;
		double list_endyuce[] = new double[len_origin];
		System.out.println("原始序列的长度为："+len_origin);
		double nextYear = 0.0;
		for(int i=0;i<list_endyuce.length;i++)
			list_endyuce[i] = 0.0;
		double list_origin0[] = new double[len_origin];
		double list_origin1[] = new double[len_origin-1];
		double list_origin2[] = new double[len_origin-2];
		double list_origin3[] = new double[len_origin-3];
		double list_origin4[] = new double[len_origin-4];//长度为5
		double list_origin5[] = new double[len_origin-5];//长度为6
		
		
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
			if(i+5<len_origin)
				list_origin5[i] = list_read[i+5];
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
	   
	    //第六个模型
	    list_origin5 = deviation.enableGM(list_origin5);
	    double list_yuce5[] = gm.getOriginYuce(list_origin5);
	    nextYear+=gm.getNextYear(list_origin5);
	    for(int i=0;i<list_yuce5.length;i++){
	    	list_endyuce[i+5] = list_yuce5[i]+list_endyuce[i+5];
	    }
	    
	    //调整租后的预测序列
	    for(int i=0;i<list_endyuce.length;i++){
	    	//System.out.println("before:["+i+"]"+list_endyuce[i]);
	    	if(i<=5)
	    		list_endyuce[i] = list_endyuce[i]/(i+1.0);
	    	else 
	    		list_endyuce[i] = list_endyuce[i]/6.0;
	    	//System.out.println("after:["+i+"]"+list_endyuce[i]);
	    }
	    
	    //预测序列检验
	    System.out.println("***********得到预测序列****************");
	    for(int i=0;i<list_endyuce.length;i++)
	    	System.out.print(list_endyuce[i]+"  ");
	    //开始误差分析
		deviation.deviation_XiangDui(list_read, list_endyuce);
		deviation.deviation_FangCha(list_read, list_endyuce);
		
		System.out.println("2017年的大连市实际房价平均数据为：12961.74");
		System.out.println("根据GM模型预测的2017年大连市平均房价为："+nextYear/6.0);

	}

}
