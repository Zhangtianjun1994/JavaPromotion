package pagerank;

import java.util.Scanner;

/**
 * PageRank�㷨
 * �����㷨��ͨ���ڽӾ����ʾͼ���������ڽӱ�
 * @author DELL
 * 
 */
public class Main37 {

    private final static int ITTIME=10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        int[][] numb;
        System.out.println("��ʼ....����N");
        while (scanner.hasNext()) {
            m = scanner.nextInt();
            numb = new int[m][m];
            for (int i = 0; i < m; i++) {
                //System.out.println("������ֵ��");
                for (int j = 0; j < m; j++) {
                    numb[i][j] = scanner.nextInt();
                }
            }
            // ������ǰPageRank��ֵ
            double[] nowRank = new double[m];
            // �������չ��ƵĽ��
            double[] resultRank = new double[m];
            for (int i = 0; i < m; i++)
                nowRank[i] = 1.0 / m;
            boolean flag = true;// ��ʾ��ǰ������ҳ���ӹ�������
            double r = 0.15;// ������������0 1 0 1 0 0 1 0 0 0 0 1 1 0 0 0
            int sum=0;//��ʾ����������
            while (flag) {
                if(sum==Main37.ITTIME)
                    break;
                sum++;
                System.out.println("��"+sum+"�ֵ�����ʼ----");
                for (int i = 0; i < m; i++)
                    resultRank[i] = r / m;
                // ��������һ���ڵ㣬��һ���������ڵĽڵ㼯��
                for (int i = 0; i < m; i++) {
                    int count = 0;// ͳ�ƺͽڵ�i�����Ľڵ����
                    for (int j = 0; j < m; j++) {
                        if (numb[i][j] != 0) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        for (int j = 0; j < m; j++) {
                            if (numb[i][j] != 0) {double value=(1 - r)*nowRank[i]/ count;
                                resultRank[j] +=value;
                            }
                        }
                    } else {
                        for(int j=0;j<m;j++){
                            resultRank[j]+=(1-r)*nowRank[i]/m;
                        }
                    }
                    //nowRank=resultRank;-----fuck you
                    for(int j=0;j<m;j++){
                        nowRank[j]=resultRank[j];
                    }
                    System.out.println("������һ���ڵ�------------------------------------------------");
                    //-------
                }
                for(int i=0;i<m;i++){
                    System.out.print(";  �ڵ�"+i+" ����:"+resultRank[i]);
                }
                System.out.println("\n-------------------------------------");
            }

        }
    }
}