package xmlconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//@Named("lalala")
@Component
public class SgtPeppers implements CompactDisc{
	private String title = "hahaha";
	private String artist = "zxl";
	
	public void play(){
		System.out.println("zxl sing the hahaha!!!");
	}


}
