package reflect;

import java.lang.reflect.Array;

public class Test {
	public static void main(String[] args) {
		        double[] temp={1,2,3,4,5};
		         Class<?>demo=temp.getClass().getComponentType();
		        System.out.println("�������ͣ� "+demo.getName());
		         System.out.println("���鳤��  "+Array.getLength(temp));
		         System.out.println("����ĵ�һ��Ԫ��: "+Array.get(temp, 0));
		         Array.set(temp, 0, 100);
		         System.out.println("�޸�֮�������һ��Ԫ��Ϊ�� "+Array.get(temp, 0));
		}
}
