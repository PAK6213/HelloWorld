package Music; // 패키지명은 사용자 환경에 따라 달라질 수 있음

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Music {
	public void start() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("C:\\Users\\admin\\Desktop\\Java\\music.wav"); // 사용시에는 개별 폴더로 변경할 것
		
		Clip clip;
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			Thread.sleep(60000);
			clip.stop();
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	


}
