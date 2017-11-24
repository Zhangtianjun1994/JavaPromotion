package reflect;

import java.lang.reflect.Field;

public class TestRefelect {
     public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        ReflectPointer rp1 = new ReflectPointer(3,4);
         changeBtoA(rp1);
         System.out.println(rp1);
         
     }
     
     private static void changeBtoA(Object obj) throws RuntimeException, Exception {
         Field[] fields = obj.getClass().getFields();
         
         for(Field field : fields) {
             //if(field.getType().equals(String.class))
             //�����ֽ���ֻ��һ��,��equals���岻׼ȷ
             if(field.getType()==String.class) {
                 String oldValue = (String)field.get(obj);
                 System.out.println(field.get(obj));
                String newValue = oldValue.replace('b', 'a');
                 field.set(obj,newValue);
             }
         }
     }
 }