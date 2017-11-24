package reflect;

import java.awt.Container;
import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class CompareClasses implements Comparator<Class<?>> {

    @Override
    public int compare(Class<?> o1, Class<?> o2) {
        if (o1.equals(o2)) {
            return 0;
        } else if (o1.isAssignableFrom(o2)) {
            return -1;
        } else if (o2.isAssignableFrom(o1)) {
            return 1;
        } else {
            throw new IllegalArgumentException(o1+"和"+o2+"两个类之间没有联系");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(
                new CompareClasses());
        System.out.println("添加类——JComponent.class");
        treeSet.add(JComponent.class);
        System.out
        .println("添加类——Container.class");
        treeSet.add(Container.class);
        System.out.println("添加类——JPanel.class");
        treeSet.add(JPanel.class);
        System.out.println("=================排序后为=====================");
        for (Class<?> class1 : treeSet) {
            System.out.println(class1);
        }
        
        System.out.println("------------------");
        System.out.println(String.class.getConstructor(String.class));
    }

}
