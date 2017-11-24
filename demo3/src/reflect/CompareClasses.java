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
            throw new IllegalArgumentException(o1+"��"+o2+"������֮��û����ϵ");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        TreeSet<Class<?>> treeSet = new TreeSet<Class<?>>(
                new CompareClasses());
        System.out.println("����ࡪ��JComponent.class");
        treeSet.add(JComponent.class);
        System.out
        .println("����ࡪ��Container.class");
        treeSet.add(Container.class);
        System.out.println("����ࡪ��JPanel.class");
        treeSet.add(JPanel.class);
        System.out.println("=================�����Ϊ=====================");
        for (Class<?> class1 : treeSet) {
            System.out.println(class1);
        }
        
        System.out.println("------------------");
        System.out.println(String.class.getConstructor(String.class));
    }

}
