package crazyjava.FouthChapter;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
	public static void main(String argsp[]) throws InterruptedException{
		String str = new String ("crazy java!!");
		WeakReference<String> weak = new WeakReference<String>(str);
		str = null;
		System.out.println(weak.get());
		System.gc();
		Thread.sleep(50);
		//System.runFinalization();
		System.out.println(weak.get());
	}

}
