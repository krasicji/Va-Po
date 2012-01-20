/**
 * 
 */
package va_po;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author krasicji
 *
 */
@SuppressWarnings("serial")
public class VapoFrame extends JFrame {
	
	public VapoFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSizeAndCenter();
		this.setTitle("Va-Po");
		this.setIcon();
		this.add(new JLabel(this.getBackgroundImage()));
		//this.add(new LayoutPanel());
	}
	
	private ImageIcon getBackgroundImage() {
		String path = "background.png";
		
		java.net.URL imgURL = getClass().getResource(path);
		
		if (imgURL != null) {
			ImageIcon background = new ImageIcon(imgURL, "Backgound");
			Image img = background.getImage();  
			Image newbackground = img.getScaledInstance(this.getWidth(), this.getHeight(),  java.awt.Image.SCALE_SMOOTH); 
	        return new ImageIcon(newbackground);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}

	private void setSizeAndCenter(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		this.setSize(new Dimension((int)(width*.7),(int)(height*.93)));
		this.setLocation(width/2 - (int)(width*.7*.5), (int)(height/2 - height*.93*.52));
		this.setResizable(false);
	}
	
	private void setIcon(){
		java.net.URL imgURL = getClass().getResource("icon.png");
		
		BufferedImage image = null;

	    try {
	        image = ImageIO.read(imgURL);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    this.setIconImage(image);
	}
}
