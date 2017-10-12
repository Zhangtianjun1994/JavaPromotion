package soundsystem;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackageClasses={SgtPeppers.class,cn.zxl.AppTest.class})
public class CDPlayerConfig {
//	String tracks[] = {"aaa","bbb","ccc"};
//	List list = Arrays.asList(tracks);
	
//	@Bean(name="sgtPeppers")
//	@Primary
//	public CompactDisc sgt(){
//		return new SgtPeppers();
//	}
//	@Bean(name="sgtPeppers1")
//	public CompactDisc sgt1(){
//		return new BlankDisc("zxl","ahang",list);
//	}
//	
//	@Bean
//	public MediaPlayer cdplayer(CompactDisc cd){
//		return new CDPlayer(cd);
//	}
	
//	@Bean
//	public MediaPlayer cdplayer2(){
//		return new CDPlayer(sgt());
//	}
}
