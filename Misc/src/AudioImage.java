import java.awt.*;
import java.applet.*;
import javax.swing.*;

public class AudioImage extends JApplet{

	AudioClip audio;
	Image imgDisplay1;
	Image imgDisplay2;
	Image imgDisplay3;
	public void init() {
		imgDisplay1 = getImage(getCodeBase(),"1.jpg");
		imgDisplay2 = getImage(getCodeBase(),"2.jpg");
		imgDisplay3 = getImage(getCodeBase(),"3.jpg");
		audio = getAudioClip(getCodeBase(),"1.mid");
	}
	public void paint(Graphics g) {
		g.drawString("ÉùÒôºÍÍ¼Ïñ",0,0);
		audio.play();
		g.drawImage(imgDisplay1,20,20,this);
		g.drawImage(imgDisplay2,600,600,this);
		g.drawImage(imgDisplay3,600,20,this);
	}
}
