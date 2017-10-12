package soundsystem;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
//	@Autowired
//	private MediaPlayer player;
	@Autowired
	@Qualifier("sing")
	private CompactDisc cd;
	
//	@Qualifier("blankDisc")
//	public void setCD(CompactDisc cd){
//		this.cd = cd;
//	}

	@Test
	public void test(){
		cd.play();
		//assertNotNull(cd);
	    //player.play();
	}

}
