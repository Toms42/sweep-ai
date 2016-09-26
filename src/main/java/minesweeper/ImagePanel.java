package minesweeper;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = -8023410404165203586L;
	
	private BufferedImage image;
	
	public ImagePanel() {
		try{
			image = ImageIO.read(getClass().getResource("/mineAI.png"));
		} catch(IOException ex) {ex.printStackTrace();}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
}
