package cn.realty;

public class GM {
    public double[] gm(double[] fs) {
        // 预测模型函数
        int size = fs.length;
        int tsize = fs.length - 1;
        double[] arr = fs;// 原始数组
        
        double[] arr1 = new double[size];// 经过一次累加数组
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            arr1[i] = sum;
        }
        double[] arr2 = new double[tsize];// arr1的紧邻均值数组
        for (int i = 0; i < tsize; i++) {
            arr2[i] = (double) (arr1[i] + arr1[i + 1]) / 2;
        }
        /*
         * 
         * 下面建立 向量B和YN求解待估参数向量， 即求参数a,b
         */
        /*
         * 下面建立向量B, B是5行2列的矩阵， 相当于一个二维数组。
         */
        double[][] B = new double[tsize][2];
        for (int i = 0; i < tsize; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 1)
                    B[i][j] = 1;
                else
                    B[i][j] = -arr2[i];
            }

        }
        /*
         * 下面建立向量YN
         */
        double[][] YN = new double[tsize][1];
        for (int i = 0; i < tsize; i++) {
            for (int j = 0; j < 1; j++) {
                YN[i][j] = arr[i + 1];//原数组的第二个到第n个数据，相当于Y矩阵
            }
        }

        /*
         * B的转置矩阵BT,2行5列的矩阵
         */
        double[][] BT = new double[2][tsize];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < tsize; j++) {
                BT[i][j] = B[j][i];
            }
        }
        /*
         * 将BT和B的乘积所得到的结果记为数组B2T,则B2T是一个2*2的矩阵
         */
        double[][] B2T = new double[2][2];
        for (int i = 0; i < 2; i++) {// rows of BT

            {
                for (int j = 0; j < 2; j++)// cloums of B
                {
                    for (int k = 0; k < tsize; k++)// cloums of BT=rows of B
                    {
                        B2T[i][j] = B2T[i][j] + BT[i][k] * B[k][j];
                    }
                }

            }
        }
        /* 下面求B2T的逆矩阵，设为B_2T，怎么适用于一般的矩阵？ */
        //利用代数余子式求解
        double[][] B_2T = new double[2][2];
        B_2T[0][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * B2T[1][1];
        B_2T[0][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * (-B2T[0][1]);
        B_2T[1][0] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * (-B2T[1][0]);
        B_2T[1][1] = (1 / (B2T[0][0] * B2T[1][1] - B2T[0][1] * B2T[1][0]))
                * B2T[0][0];
        /*
         * 根据以上所求的各已知量下面求待估参数的未知量a和b，待估向量矩阵等于B_2T*BT*YN
         * 下面我们分别求这些矩阵的乘积，首先求B_2T*BT，令B_2T*BT的乘积为A矩阵，则A就是一个2*5的矩阵
         */
        /*
         * 
         * 
         * 
         * 下面先求A矩阵
         */
        double[][] A = new double[2][tsize];
        for (int i = 0; i < 2; i++) {// rows of B_2T
            {
                for (int j = 0; j < tsize; j++)// cloums of BT
                {
                    for (int k = 0; k < 2; k++)// cloums of B_2T=rows of BT
                    {
                        A[i][j] = A[i][j] + B_2T[i][k] * BT[k][j];
                    }
                }

            }
        }
        /*
         * 
         * 
         * 下面求A和YN矩阵的乘积，令乘积为C矩阵，则C就是一个2*1的矩阵
         */
        double[][] C = new double[2][1];
        for (int i = 0; i < 2; i++) {// rows of A

            {
                for (int j = 0; j < 1; j++)// cloums of YN
                {
                    for (int k = 0; k < tsize; k++)// cloums of A=rows of YN
                    {
                        C[i][j] = C[i][j] + A[i][k] * YN[k][j];
                    }
                }

            }
        }
        /* 根据以上所得则a=C[0][0],b=C[1][0]; */
        double a = C[0][0], b = C[1][0];
        double []arr_yuce = new double[arr.length+1];
        
        //对发展系数进行判断
        System.out.println("a位："+a);
        if(Math.abs(a) > 0.5){
          System.out.println("************************************");
          System.out.println("发展系数不符合要求，不可以进行预测！发展系数a为："+a);
          System.out.println("************************************");
        	return fs;
        }else{
        	 //对原始序列的预测，即是x(0)级别的预测
            for(int i=1;i<arr.length+1;i++){
            	double Y = (1-Math.exp(a))*(arr[0] - b / a) * Math.exp(-a * (i-1));//得到的是i的位置的预测值
            	//System.out.println("Y的预测是："+Y);
            	arr_yuce[i] = Y;
            }
            arr_yuce[0] = arr[0];      
//            for(int i=0;i<arr_yuce.length;i++)
//            	System.out.println(arr_yuce[i]);

            return arr_yuce;
        }
    }
        
//        //得到原始序列的预测值，并进行误差估计
        public double[] getOriginYuce(double list[]){
        	double list_yuce[] = gm(list);
        	if(list_yuce.length == list.length){
        		return list;
        	}else{
        		double list_OriginYuce[] = new double[list_yuce.length-1];
            	for(int i=0;i<list_OriginYuce.length;i++){
            		list_OriginYuce[i] = list_yuce[i];
            	}
            	return list_OriginYuce;
        	}
        }
        
       
//    
//    
//    //得到下一年的预测数据
    public double getNextYear(double list[]){
    	double list_yuce[] = gm(list);
    	if(list_yuce.length == list.length){
    		System.out.println("不能得到预测数据");
    		return 0.0;
    	}
    	int last = list_yuce.length-1;
    	return list_yuce[last];
    }
    //得到2018年的房价信息
    public double get2018Year(){
    	
    	return 0.0;
    }

}