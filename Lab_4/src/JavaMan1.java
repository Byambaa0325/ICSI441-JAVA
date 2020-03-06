import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

public class JavaMan1 extends Applet {
	Image img;
	AudioClip clip;
	
	public void paint(Graphics g) {		
		img = getImage(getDocumentBase(),"https://i.insider.com/587fba09f10a9a1d008b8dfc?width=300&format=jpeg&auto=webp");
		g.drawImage(img, 0, 0, this);
		clip = getAudioClip(getDocumentBase(), "https://www.ee.columbia.edu/~dpwe/sounds/music/africa-toto.wav");
		clip.play();
	}
}
