package xmlconfig;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
@ActiveProfiles("dev")
public class CDPlayerTest {
	//@Autowired
	//private MediaPlayer player;
	ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:config.xml");
	
	@Autowired
	private BlankDisc cd =  (BlankDisc) factory.getBean("compactDisc");
	
	@Test
	public void test(){
		
		assertNotNull(cd);
		cd.play();
	    //player.play();
	}

}
