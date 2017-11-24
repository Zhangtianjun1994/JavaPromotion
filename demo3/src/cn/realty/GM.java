package cn.realty;

public class GM {
    public double[] gm(double[] fs) {
        // Ԥ��ģ�ͺ���
        int size = fs.length;
        int tsize = fs.length - 1;
        double[] arr = fs;// ԭʼ����
        
        double[] arr1 = new double[size];// ����һ���ۼ�����
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
            arr1[i] = sum;
        }
        double[] arr2 = new double[tsize];// arr1�Ľ��ھ�ֵ����
        for (int i = 0; i < tsize; i++) {
            arr2[i] = (double) (arr1[i] + arr1[i + 1]) / 2;
        }
        /*
         * 
         * ���潨�� ����B��YN���������������� �������a,b
         */
        /*
         * ���潨������B, B��5��2�еľ��� �൱��һ����ά���顣
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
         * ���潨������YN
         */
        double[][] YN = new double[tsize][1];
        for (int i = 0; i < tsize; i++) {
            for (int j = 0; j < 1; j++) {
                YN[i][j] = arr[i + 1];//ԭ����ĵڶ�������n�����ݣ��൱��Y����
            }
        }

        /*
         * B��ת�þ���BT,2��5�еľ���
         */
        double[][] BT = new double[2][tsize];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < tsize; j++) {
                BT[i][j] = B[j][i];
            }
        }
        /*
         * ��BT��B�ĳ˻����õ��Ľ����Ϊ����B2T,��B2T��һ��2*2�ľ���
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
        /* ������B2T���������ΪB_2T����ô������һ��ľ��� */
        //���ô�������ʽ���
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
         * ������������ĸ���֪�����������������δ֪��a��b�����������������B_2T*BT*YN
         * �������Ƿֱ�����Щ����ĳ˻���������B_2T*BT����B_2T*BT�ĳ˻�ΪA������A����һ��2*5�ľ���
         */
        /*
         * 
         * 
         * 
         * ��������A����
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
         * ������A��YN����ĳ˻�����˻�ΪC������C����һ��2*1�ľ���
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
        /* ��������������a=C[0][0],b=C[1][0]; */
        double a = C[0][0], b = C[1][0];
        double []arr_yuce = new double[arr.length+1];
        
        //�Է�չϵ�������ж�
        System.out.println("aλ��"+a);
        if(Math.abs(a) > 0.5){
          System.out.println("************************************");
          System.out.println("��չϵ��������Ҫ�󣬲����Խ���Ԥ�⣡��չϵ��aΪ��"+a);
          System.out.println("************************************");
        	return fs;
        }else{
        	 //��ԭʼ���е�Ԥ�⣬����x(0)�����Ԥ��
            for(int i=1;i<arr.length+1;i++){
            	double Y = (1-Math.exp(a))*(arr[0] - b / a) * Math.exp(-a * (i-1));//�õ�����i��λ�õ�Ԥ��ֵ
            	//System.out.println("Y��Ԥ���ǣ�"+Y);
            	arr_yuce[i] = Y;
            }
            arr_yuce[0] = arr[0];      
//            for(int i=0;i<arr_yuce.length;i++)
//            	System.out.println(arr_yuce[i]);

            return arr_yuce;
        }
    }
        
//        //�õ�ԭʼ���е�Ԥ��ֵ��������������
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
//    //�õ���һ���Ԥ������
    public double getNextYear(double list[]){
    	double list_yuce[] = gm(list);
    	if(list_yuce.length == list.length){
    		System.out.println("���ܵõ�Ԥ������");
    		return 0.0;
    	}
    	int last = list_yuce.length-1;
    	return list_yuce[last];
    }
    //�õ�2018��ķ�����Ϣ
    public double get2018Year(){
    	
    	return 0.0;
    }

}