package soundsystem;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import soundsystem.CompactDisc;

@Component
//@Primary
public class BlankDisc implements CompactDisc{

	private String title="blank";
	private String artist="zhangxuelong";
	
	@Override
	public void play() {
		System.out.println("playing "+title+"by "+artist+"!!");
//		for(String track:tracks)
//			System.out.println(track);
	}

}
