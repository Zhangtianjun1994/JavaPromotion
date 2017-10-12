package soundsystem;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//@Named("lalala")
@Component
@Qualifier("sing")
public class SgtPeppers implements CompactDisc{
	private String title = "hahaha";
	private String artist = "zxl";
	
	public void play(){
		System.out.println("zxl sing the hahaha!!!");
	}


}
