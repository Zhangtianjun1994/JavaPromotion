package cn.zxl;
import java.util.*;
class point implements Comparable {//ƽ���ϵ�һ����
double x;
double y;
public int compareTo(Object o) {//��y��������,y��ͬ��x����
point b=(point)o;
if(this.y>b.y) return 1;
else if(this.y==b.y ){
if(this.x>b.x) return 1;
else if(this.x==b.x) return 0;
else return -1;
}
else return -1;
}
}   

