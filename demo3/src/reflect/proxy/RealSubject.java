package reflect.proxy;

public class RealSubject implements Subject{
	@Override
	    public String say(String name, int age) {
	        return name + "  " + age;
	}
	@Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }
}
