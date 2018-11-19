import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class UI {
//	protected static final Graphics Graphics = null;
	static CityUnit cities_Data = new CityUnit();
	
	public static void main(String[] args) {
        // TODO Auto-generated method stub
    	JFrame mainWindow = new JFrame("MinimumSpanningTree--cities");
    	Mypanel graphDisplay = new Mypanel();
    	Container cp = new Container();
    	mainWindow.setSize(1000, 618);
    	graphDisplay.setBounds(0, 0, 480, 480);
    	mainWindow.add(graphDisplay);
    	JButton createCity = new JButton("Create a city");
    	createCity.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphDisplay.cityUnitCreating = true;
//				graphDisplay.cityName;
				JDialog cityNameWindow = new JDialog();
				JLabel cityNameLabel = new JLabel("City's Name:");
				JTextField cityNameField = new JTextField(5);
				cityNameWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 25));
				cityNameWindow.setBounds(220, 200, 300, 180);
				JButton confirm = new JButton("Confirm");
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(cityNameField.getText().length() == 0) {
							JDialog errorWindow = new JDialog(cityNameWindow,"Error",false);
							JButton confirm = new JButton("无效的输入!");
							confirm.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									errorWindow.setVisible(false);
									cityNameWindow.setEnabled(true);
									mainWindow.setVisible(true);
									cityNameWindow.setVisible(true);
								}
							});
							errorWindow.add(confirm);
							errorWindow.setBounds(250, 250, 120, 60);
							cityNameWindow.setEnabled(false);
							errorWindow.add(confirm);
							errorWindow.setDefaultCloseOperation(errorWindow.DO_NOTHING_ON_CLOSE);
							errorWindow.setVisible(true);
						}else {
							cities_Data.setCount(cities_Data.getCount());
							String[] temp = cities_Data.getCityName();
							temp[cities_Data.getCount()] = cityNameField.getText();
							cities_Data.setCityName(temp);
							graphDisplay.cityUnit = cities_Data;
							cityNameWindow.setVisible(false);
						}
					}
					
				});
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						cityNameWindow.setVisible(false);
					}
				});
				cityNameWindow.add(cityNameLabel);
				cityNameWindow.add(cityNameField);
				cityNameWindow.add(confirm);
				cityNameWindow.add(cancel);
				cityNameWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				cityNameWindow.setVisible(true);
			}
		});
    	createCity.setBounds(500, 30, 120, 30);
    	cp.add(createCity);
    	cp.setBounds(0, 0, 1000, 618);
    	mainWindow.add(cp);
    	mainWindow.setLayout(null);
    	mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainWindow.setLocationRelativeTo(null);
    	mainWindow.addMouseListener(graphDisplay);
    	graphDisplay.addMouseListener(graphDisplay);
    	mainWindow.addMouseMotionListener(graphDisplay);
    	graphDisplay.addMouseMotionListener(graphDisplay);
    	mainWindow.setVisible(true);
    	Thread thread = new Thread(graphDisplay);
    	thread.start();
    }
}

class Mypanel extends JPanel implements MouseMotionListener,Runnable,MouseListener {
	CityUnit cityUnit = new CityUnit();
	int mouseX = 0;
	int mouseY = 0;
	String cityName = null;
	boolean cityUnitCreating = false;
	
	public void setCityUnit(CityUnit cityUnit) {
		this.cityUnit = cityUnit;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("GraphDisplayPanel", 200, 20);
		g.drawRect(30, 30, 450, 450);
		g.setColor(Color.white);
		g.fillRect(30, 30, 450, 450);
		g.setColor(Color.red);
		if((cityUnitCreating)&&(mouseX>=40&&mouseX<=470)&&(mouseY>=40&&mouseY<=470)) {
			g.drawString(cityUnit.getCityName()[cityUnit.getCount()], mouseX - cityUnit.getCityName()[cityUnit.getCount()].length() * 3, mouseY + 25);
			g.fillOval(mouseX - 10, mouseY - 10, 20, 20);
		}
//		if((mouseX >= 30 && mouseX <= 480)&&(mouseY >= 30 && mouseY <= 480))
//			g.drawLine(30, 30, mouseX, mouseY);
	}
	
	@Override
	public void run(){		
		while(true){						
			try{				
				Thread.sleep(20);	
				}
			catch(Exception e){}
			repaint();		
			}	
		}	

	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		if((cityUnitCreating)&&(mouseX>=40&&mouseX<=470)&&(mouseY>=40&&mouseY<=470)) {
//			g.drawString("city"+ cityNo, mouseX - 10, mouseY + 25);
//			g.fillOval(mouseX - 10, mouseY - 10, 20, 20);
			
			cityUnitCreating = false;
		}
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
	public void mouseDragged(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
	}
}