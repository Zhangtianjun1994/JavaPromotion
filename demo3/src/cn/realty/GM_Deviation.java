package cn.realty;

public class GM_Deviation {	
	public GM_Deviation(){

	}
	//计算平均相对误差，第一个是原数列，第二个是预测序列
	public void deviation_XiangDui(double list1[],double list2[]){
//		System.out.println("原始序列和预测序列");
//		for(int i=0;i<list1.length;i++){
//			System.out.print("["+list1[i]+","+list2[i]+"]  ");
//		}

		if(list1.length != list2.length){
			System.out.println("\n不能计算相对误差");
			//return -100.0;
		}else{
			int leng = list1.length;
			double list3[] = new double[leng];//相对误差的的数组
			double sum = 0.0;//相对误差的总和
			for(int i=0;i<leng;i++){
				list3[i] = Math.abs((list1[i]-list2[i])/list1[i]);
				//System.out.println();
				//System.out.println("相对误差个数为："+list3[i]+"  ");
				sum = sum+list3[i];
			}
			double result = sum/leng;
			System.out.print("\n相对误差为："+result+"等级为：");
			//判断相对误差等级
			if(result < 0.01){
				System.out.println("  好（一级）");
			}else if(result < 0.05){
				System.out.println("  良好（二级）");
			}else if(result < 0.10){
				System.out.println("  合格（三级）");
			}else if(result < 0.20){
				System.out.println("  勉强（四级）");
			}else 
				System.out.println("  不合格");
		}
	}
	
	//通过计算方差比来查看误差等级,同时计算小误差概率查看误差等级
	public void deviation_FangCha(double list1[],double list2[]){
//		System.out.println("原始序列和预测序列");
//		for(int i=0;i<list1.length;i++){
//			System.out.print("["+list1[i]+","+list2[i]+"]  ");
//		}
		double sum_origin = 0.0;
		double sum_cancha = 0.0;
		double list_xiangdui[] = new double[list1.length];
		double list_cancha[] = new double[list1.length];
		int leng = list1.length;
		if(list1.length != list2.length){
			System.out.println("不能计算相对误差");
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
			System.out.print("\n均方差比值是：  "+result_fangcha);
			if(result_fangcha < 0.35){
				System.out.println("好（一级）");
			}else if(result_fangcha <0.50){
				System.out.println("良好（二级）");
			}else if(result_fangcha < 0.65){
				System.out.println("合格（三级）");
			}else if(result_fangcha < 0.80){
				System.out.println("勉强（四级）");
			}else
				System.out.println("不合格");
			
			double value_yanzheng = 0.6745*(Math.sqrt(S1_2));
			for(int i=0;i<leng;i++){
				double value = Math.abs(list_cancha[i]-avg_cancha);
				//System.out.println("value"+value);
				if(value < value_yanzheng)
					count++;
			}
			//System.out.println(value_yanzheng);
			result_xiaowucha = (double)count/(double)leng;
			//计算小误差概率
			System.out.print("\n小误差概率是：  "+result_xiaowucha);
			if(result_xiaowucha > 0.95){
				System.out.println("好（一级）");
			}else if(result_xiaowucha > 0.80){
				System.out.println("良好（二级）");
			}else if(result_xiaowucha > 0.70){
				System.out.println("合格（三级）");
			}else if(result_xiaowucha > 0.60){
				System.out.println("勉强（四级）");
			}else
				System.out.println("不合格");
		}
	}
	
	//关联度校验
	public void deviation_relation(){
		
	}
	
	//判断数据序列是否可以建立灰色模型
	public double[] enableGM(double list[]){
		System.out.println("进入检验是否可以应用GM模型的方法");
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
			//System.out.println("本序列不可以建立GM模型,开始迭代");
		}	
		else{
			System.out.println("满足级比验证，可以建立Gm模型");
			
		}
		return list;	
	}
	
	//数据预处理方法
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
	


