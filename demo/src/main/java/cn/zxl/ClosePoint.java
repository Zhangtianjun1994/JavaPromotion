package cn.zxl;

import static java.lang.Math.*;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ClosePoint {
	static class Point {  
        double x;  
        double y;  
        public Point() {  
        }  
  
        public Point(double x, double y) {  
            this.x = x;  
            this.y = y;  
        }  
    }  
  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        while (true) {  
            int n = scanner.nextInt();  
            Point[] ps = new Point[n];  
            for (int i = 0; i < n; i++) {  
                double x = scanner.nextDouble();  
                double y = scanner.nextDouble();  
                ps[i] = new Point(x, y);  
            }  
            // ����X��������������  
            Arrays.sort(ps, new Comparator<Point>() {  
                @Override  
                public int compare(Point o1, Point o2) {  
                    if (o1.x < o2.x)  
                        return -1;  
                    if (o1.x > o2.x)  
                        return 1;  
                    if (o1.y < o2.y)  
                        return -1;  
                    if (o1.y > o2.y)  
                        return 1;  
                    return 0;  
                }  
            });  
            double minDis = minDistance(ps, 0, n - 1);  
            System.out.println(minDis);  
        }  
  
    }  
  
    /** 
     * ���֮�����С���� 
     *  
     * @param ps 
     * @param l 
     * @param r 
     * @return 
     */  
    public static double minDistance(Point[] ps, int l, int r) {  
        /** 
         * ͬһ����,�����ڵ��,���벻��ȡ0,�������ֵ 
         */  
        if (l == r) {  
            return Double.MAX_VALUE;  
        }  
        if (l + 1 == r) {  
            return distance(ps[l], ps[r]);  
        }  
        
        int center = (r+l-1)/2;
        //int center = l + (r - l) / 2;  
        double dis1 = minDistance(ps, l, center);  
        double dis2 = minDistance(ps, center + 1, r);  
        double minDis = min(dis1, dis2);  
        ArrayList<Point> nearPoints = new ArrayList<>();  
        // ѡ�������м���С��minDis�ĵ�  
        for (Point p : ps) {  
            if (abs(ps[center].x - p.x) <= minDis) {  
                nearPoints.add(p);  
            }  
        }  
        // ����Y����������  
        Collections.sort(nearPoints, new Comparator<Point>() {  
            @Override  
            public int compare(Point o1, Point o2) {  
                if (o1.y < o2.y)  
                    return -1;  
                if (o1.y > o2.y)  
                    return 1;  
                if (o1.x < o2.x)  
                    return -1;  
                if (o1.x > o2.x)  
                    return 1;  
                return 0;  
            }  
        });  
        for (int i = 0; i < nearPoints.size(); i++) {  
            for (int j = i + 1; j < nearPoints.size(); j++) {  
                if (nearPoints.get(j).y - nearPoints.get(i).y > minDis) {  
                    break;// Ԫ��y+1��Ԫ��i��Զ,û��Ҫ�����Ƚ�  
                }  
                double d = distance(nearPoints.get(j), nearPoints.get(i));  
                if (d < minDis) {  
                    minDis = d;  
                }  
            }  
        }  
        return minDis;  
    }  
  
    public static double distance(Point p1, Point p2) {  
        if (p1 == p2)  
            return 0;  
        return sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));  
    }  
  
}
