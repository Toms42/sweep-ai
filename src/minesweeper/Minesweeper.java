package minesweeper;

import java.util.Arrays;

import javax.imageio.ImageIO;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Minesweeper extends Thread {
	
	boolean readyToRun=false;
	
	int topX, topY, botX, botY;
	
	final int offsetX=15;
	final int offsetY=-101;
	
	final int botOffsetX=15;
	final int botOffsetY=15;
	
	MineReader mineInterface;
	MineAI mineAI;
	
	
	public void run()
	{
		try {Thread.sleep(300);
		} catch (InterruptedException e1) {}
		
		System.out.println("starting ai...");
		
		locate();
		
		if(readyToRun)
		{
			try {
				updateFieldImage();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
			mineAI = new MineAI(this);
			
			mineAI.initialize();
			mineAI.mainLoop();
			//mineAI.test();
		}
	}
	
	public void updateFieldImage() throws AWTException
	{
		int height = (botY-botOffsetY)-(topY-offsetY);
		int width = (botX-botOffsetX)-(topX+offsetX);
		
		//System.out.println("window of size: " +width +"x" + height + "found");
		
		Rectangle window = new Rectangle(topX+offsetX,topY-offsetY,width,height);
		Robot robot = new Robot();
		
		BufferedImage screenShot = robot.createScreenCapture(window);
		
		try{
			File image = new File("screenshot.png");
			ImageIO.write(screenShot, "png", image);
		} catch (IOException e){}
	}
	
	public void locate()
	{
		System.out.println("Locating minesweeper window... \nPlease do not move the window.");
		
		String windowName = "Minesweeper X";
	    int[] rect;
	    readyToRun=true;
	    try {
	    	rect = GetWindowRect.getRect(windowName);
	    	System.out.println("corner locations for minesweeper: \n"+
	    		   windowName+ Arrays.toString(rect));
	    	topX=rect[0];
	    	topY=rect[1];
	    	botX=rect[2];
	    	botY=rect[3];
	         
	    	}
	    catch (GetWindowRect.WindowNotFoundException e){
	    	System.out.println("Please open minesweeper and try again");
	    	readyToRun=false;
	    }
	    catch (GetWindowRect.GetWindowRectException e){
	    	readyToRun=false;
	    }
	}
}
