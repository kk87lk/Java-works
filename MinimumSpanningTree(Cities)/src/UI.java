
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;


public class UI {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
    	JFrame mainWindow = new JFrame("MinimumSpanningTree--cities");
    	Mypanel graphDisplay = new Mypanel();
    	mainWindow.setSize(1000, 618);
    	mainWindow.add(graphDisplay);
    	mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainWindow.setLocationRelativeTo(null);
    	mainWindow.setVisible(true);
    }
}

class Mypanel extends JPanel implements MouseMotionListener,Runnable,MouseListener {
	
	public void paint(Graphics g) {
		g.drawString("GraphDisplayPanel", 200, 20);
		g.drawRect(30, 30, 450, 450);
		g.setColor(Color.white);
		g.fillRect(30, 30, 450, 450);
	}
	public void run(){		
		while(true){						
			try{				
				Thread.sleep(1);			
				}			
			catch(Exception e){}
			repaint();		
			}	
		}	

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}