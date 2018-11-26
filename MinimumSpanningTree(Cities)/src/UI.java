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
	static CityGroup cities_Data = new CityGroup();
	
	public static void main(String[] args) {
    	JFrame mainWindow = new JFrame("MinimumSpanningTree--cities"); //主界面
    	Mypanel graphDisplay = new Mypanel();
    	Container cp = new Container();
    	mainWindow.setSize(1000, 618);
    	graphDisplay.setBounds(0, 0, 480, 480);
    	mainWindow.add(graphDisplay);
    	JButton createCity = new JButton("Create a city");//创建city
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
							String temp = cityNameField.getText();
							cities_Data.getCityUnits()[cities_Data.getCount()].setCityName(temp);
							graphDisplay.cityGroup = cities_Data;
							cityNameWindow.setVisible(false);
						}
					}
					
				});
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						graphDisplay.cityUnitCreating = false;
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
    	JButton createPath = new JButton("Create a path");//创建path
    	createPath.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JDialog pathLengthWindow = new JDialog();
				JLabel cityNameLabel = new JLabel("City's Name:");
				JLabel cityNameLabel2 = new JLabel("City's Name:");
				JLabel lengthOfPath = new JLabel("Length of Path:");
				JTextField cityNameField = new JTextField(7);
				JTextField cityNameField2 = new JTextField(7);
				JTextField lengthOfPathField = new JTextField(5);
				pathLengthWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 25));
				pathLengthWindow.setBounds(220, 200, 300, 250);
				JButton confirm = new JButton("Confirm");
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int m = 0;
						while(!cities_Data.getCityUnits()[m].getCityName().equals(cityNameField.getText()))
							m++;
						int n = 0;
						while(!cities_Data.getCityUnits()[n].getCityName().equals(cityNameField2.getText()))
							n++;
//						System.out.println(m +" "+n);
						int[][] cityUnitsTemp = cities_Data.getConnect();
						cityUnitsTemp[m][n] = Integer.parseInt(lengthOfPathField.getText());
						cityUnitsTemp[n][m] = Integer.parseInt(lengthOfPathField.getText());
						cities_Data.setConnect(cityUnitsTemp);
						pathLengthWindow.setVisible(false);
					}
				});
				JButton cancel = new JButton("Cancel");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						graphDisplay.cityUnitCreating = false;
						pathLengthWindow.setVisible(false);
					}
				});
				pathLengthWindow.add(cityNameLabel);
				pathLengthWindow.add(cityNameField);
				pathLengthWindow.add(cityNameLabel2);
				pathLengthWindow.add(cityNameField2);
				pathLengthWindow.add(lengthOfPath);
				pathLengthWindow.add(lengthOfPathField);
				pathLengthWindow.add(confirm);
				pathLengthWindow.add(cancel);
				pathLengthWindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pathLengthWindow.setVisible(true);
			}
		});
    	createPath.setBounds(500, 70, 120, 30);
    	JButton writeIntoFile = new JButton("Write into file");
    	writeIntoFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileFlow fileFlow = new FileFlow();
				fileFlow.writeIntoFile(cities_Data);
			}
		});
    	writeIntoFile.setBounds(500, 110, 120, 30);
    	JButton readFromFile = new JButton("Read from file");
    	readFromFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileFlow fileFlow = new FileFlow();
				cities_Data = fileFlow.readFromFile();
				graphDisplay.cityGroup = cities_Data;
			}
		});
    	readFromFile.setBounds(500, 150, 120, 30);
    	JButton prim = new JButton("Prim");
    	prim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithm prim = new Algorithm();
				graphDisplay.cityGroup_Prim = graphDisplay.cityGroup;
				graphDisplay.cityGroup_Prim.setConnect(prim.prim(graphDisplay.cityGroup));
				graphDisplay.status = 1;
			}
		});
    	prim.setBounds(500, 190, 120, 30);
    	JButton kruskal = new JButton("Kruskal");
    	kruskal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Algorithm kruskal = new Algorithm();
				graphDisplay.cityGroup_Kruskal = graphDisplay.cityGroup;
				graphDisplay.cityGroup_Kruskal.setConnect(kruskal.kruskal(graphDisplay.cityGroup));
				graphDisplay.status = 2;
			}
		});
    	kruskal.setBounds(500, 230, 120, 30);
    	JButton reset = new JButton("Reset");
    	reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				graphDisplay.status = 0;
			}
		});
    	reset.setBounds(500, 270, 120, 30);
    	cp.add(createPath);
    	cp.add(writeIntoFile);
    	cp.add(readFromFile);
    	cp.add(prim);
    	cp.add(kruskal);
    	cp.add(reset);
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
	CityGroup cityGroup = new CityGroup();
	CityGroup cityGroup_Prim = new CityGroup();
	CityGroup cityGroup_Kruskal = new CityGroup();
	int status = 0;//0-normal 1-prim 2-kruskal
	int mouseX = 0;
	int mouseY = 0;
	String cityName = null;
	boolean cityUnitCreating = false;
	
	public void paint(Graphics g) {
		super.paint(g);
		paintCityUnit(g, 0, status);
		paintCityUnit_Creating(g);
	}
	public void paintCityUnit(Graphics g, int i, int status) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawString("GraphDisplayPanel", 200, 20);
		g.drawRect(30, 30, 450, 450);
		g.setColor(Color.white);
		g.fillRect(30, 30, 450, 450);
		g.setColor(Color.red);
		while(cityGroup.getCityUnits()[i].getX() != 0) {
			g.drawString(cityGroup.getCityUnits()[i].getCityName(), cityGroup.getCityUnits()[i].getX() - cityGroup.getCityUnits()[i].getCityName().length() * 3, cityGroup.getCityUnits()[i].getY() + 25);
			g.fillOval(cityGroup.getCityUnits()[i].getX() - 10, cityGroup.getCityUnits()[i].getY() - 10, 20, 20);
			i++;
		}
		switch(status) {
			case 0:
				for(int m = 0;cityGroup.getCityUnits()[m].getX() != 0; m++) {
					for(int n = 0;cityGroup.getCityUnits()[n].getX() != 0; n++) {
						if(cityGroup.getConnect()[m][n] != 0) {
							g.drawString(String.valueOf(cityGroup.getConnect()[m][n]),(cityGroup.getCityUnits()[m].getX()+cityGroup.getCityUnits()[n].getX())/2 , (cityGroup.getCityUnits()[m].getY()+cityGroup.getCityUnits()[n].getY())/2);
							g.drawLine(cityGroup.getCityUnits()[m].getX(), cityGroup.getCityUnits()[m].getY(), cityGroup.getCityUnits()[n].getX(), cityGroup.getCityUnits()[n].getY());
	
						}
					}
				}
			break;
			case 1:
				for(int m = 0;cityGroup_Prim.getCityUnits()[m].getX() != 0; m++) {
					for(int n = 0;cityGroup_Prim.getCityUnits()[n].getX() != 0; n++) {
						if(cityGroup_Prim.getConnect()[m][n] != 0) {
							g.drawString(String.valueOf(cityGroup_Prim.getConnect()[m][n]),(cityGroup_Prim.getCityUnits()[m].getX()+cityGroup_Prim.getCityUnits()[n].getX())/2 , (cityGroup_Prim.getCityUnits()[m].getY()+cityGroup.getCityUnits()[n].getY())/2);
							g.drawLine(cityGroup_Prim.getCityUnits()[m].getX(), cityGroup_Prim.getCityUnits()[m].getY(), cityGroup_Prim.getCityUnits()[n].getX(), cityGroup_Prim.getCityUnits()[n].getY());
	
						}
					}
				}
			
			break;
			case 2:
				for(int m = 0;cityGroup_Kruskal.getCityUnits()[m].getX() != 0; m++) {
					for(int n = 0;cityGroup_Kruskal.getCityUnits()[n].getX() != 0; n++) {
						if(cityGroup_Kruskal.getConnect()[m][n] != 0) {
							g.drawString(String.valueOf(cityGroup_Kruskal.getConnect()[m][n]),(cityGroup_Kruskal.getCityUnits()[m].getX()+cityGroup_Kruskal.getCityUnits()[n].getX())/2 , (cityGroup_Kruskal.getCityUnits()[m].getY()+cityGroup.getCityUnits()[n].getY())/2);
							g.drawLine(cityGroup_Kruskal.getCityUnits()[m].getX(), cityGroup_Kruskal.getCityUnits()[m].getY(), cityGroup_Kruskal.getCityUnits()[n].getX(), cityGroup_Kruskal.getCityUnits()[n].getY());
	
						}
					}
				}
			break;
			default:
				return;
		}
		
	}
	
	public void paintCityPath(Graphics g,int m, int n) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawString("GraphDisplayPanel", 200, 20);
		g.drawRect(30, 30, 450, 450);
		g.setColor(Color.white);
		g.fillRect(30, 30, 450, 450);
		g.setColor(Color.red);
		g.drawLine(cityGroup.getCityUnits()[m].getX() - 10, cityGroup.getCityUnits()[m].getY() - 10, cityGroup.getCityUnits()[n].getX() - 10, cityGroup.getCityUnits()[n].getY() - 10);	
	}

	void paintCityUnit_Creating(Graphics g) {
		if((cityUnitCreating)&&(mouseX>=40&&mouseX<=470)&&(mouseY>=40&&mouseY<=470)) {
			g.drawString(cityGroup.getCityUnits()[cityGroup.getCount()].getCityName(), mouseX - cityGroup.getCityUnits()[cityGroup.getCount()].getCityName().length() * 3, mouseY + 25);
			g.fillOval(mouseX - 10, mouseY - 10, 20, 20);
		}
	}
	
	
	
	
	@Override
	public void run(){		
		while(true){						
			try{
				Thread.sleep(30);
			}
			catch(Exception e){}
			repaint();		
		}	
	}	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent arg0) {
		if((cityUnitCreating)&&(mouseX>=40&&mouseX<=470)&&(mouseY>=40&&mouseY<=470)) {
			cityGroup.getCityUnits()[cityGroup.getCount()].setX(mouseX);
			cityGroup.getCityUnits()[cityGroup.getCount()].setY(mouseY);

			cityGroup.setCount(cityGroup.getCount() + 1);
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