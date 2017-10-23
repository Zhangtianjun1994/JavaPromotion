package xmlconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackageClasses={SgtPeppers.class,cn.zxl.AppTest.class})
public class CDPlayerConfig {
//	@Bean(name="sgtPeppers")
//	public CompactDisc sgt(){
//		return new SgtPeppers();
//	}
//	
//	@Bean
//	public MediaPlayer cdplayer(CompactDisc compactDisc){
//		return new CDPlayer(compactDisc);
//	}
////	
//	@Bean
//	public MediaPlayer cdplayer2(){
//		return new CDPlayer(sgt());
//	}
}
