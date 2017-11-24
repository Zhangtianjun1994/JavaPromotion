package reflect;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Reflect {
	public static void main(String[] args) {
        Class<?> clazz = new String().getClass();
        Class[] class1 = clazz.getDeclaredClasses();
        for (int i = 0; i < class1.length; i++) {
            Class<?> innerclass = class1[i];
            System.out
                    .println("================================================================");
            System.out.println("内部类" + i + "为： " + innerclass.getName());

            System.out.println("内部类" + i + "的父类为："
                    + innerclass.getSuperclass().getName());

            System.out.print("内部类" + i + "的所有公共域为：");
            Field[] field = innerclass.getFields();
            if (field.length > 0) {
                System.out.println();
                for (Field field2 : field) {
                    System.out.println("\t" + field2);
                }
            } else {
                System.out.println("空");
            }

            System.out.print("内部类" + i + "的非继承域为：");
            Field[] declaredfield = innerclass.getDeclaredFields();
            if (declaredfield.length > 0) {
                System.out.println();
                for (Field field2 : declaredfield) {
                    System.out.println("\t" + field2);
                }
            } else {
                System.out.println("空");
            }

            System.out.print("内部类" + i + "的所有公共方法为：");
            Method[] methods = innerclass.getMethods();
            if (methods.length > 0) {
                System.out.println();
                for (Method method : methods) {
                    System.out.println("\t" + method);
                }
            } else {
                System.out.println("空");
            }

            System.out.print("内部类" + i + "的非继承方法为：");
            Method[] declaredmethods = innerclass.getDeclaredMethods();
            if (declaredmethods.length > 0) {
                System.out.println();
                for (Method method : declaredmethods) {
                    System.out.println("\t" + method);
                }
            } else {
                System.out.println("空");
            }

        }

    }


}
