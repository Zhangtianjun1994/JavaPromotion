package cn.zxl;
import java.util.*;
class point implements Comparable {//平面上的一个点
double x;
double y;
public int compareTo(Object o) {//按y升序排列,y相同按x升序
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

