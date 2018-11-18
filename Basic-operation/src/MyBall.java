import java.awt.*;
import java.awt.event.*;
public class MyBall{	
	public static void main(String args[])	{		
		Frame w = new Frame();		
		w.setSize(300,400);		
		MyPanel mp = new MyPanel();		
		w.add(mp);		
		Thread t= new Thread(mp);		
		t.start();		//注册监听静态鼠标事件，例如：点击		
		w.addMouseListener(mp);		
		mp.addMouseListener(mp);		//注册监听动态鼠标事件，例如：拖拽		
		w.addMouseMotionListener(mp);		
		mp.addMouseMotionListener(mp);		
		w.show();	
		}
	}
class MyPanel extends Panel implements Runnable,MouseListener,MouseMotionListener{ 	
	int x;//小球的坐标	
	int y;	
	int mx;//鼠标的坐标	
	int my;	
	Boolean markC=false;//标识鼠标是否悬浮在小球之上	
	Boolean markM=false;//标识鼠标是否选中小球	
	MyPanel(){		
		x=(int)(Math.random()*300);		
		y=(int)(Math.random()*300);	
		}	
	public void paint(Graphics g){		
		g.fillOval(x,y,20,20);//小球坐标控制小球出现位置		
		g.setColor(Color.RED);		//分别显示鼠标坐标和小球坐标		
		g.drawString("Mouse   X: "+mx+" Y: "+my,5,15);		
		g.drawString("Ball  X: "+x+" Y: "+y,5,25);		
		if(markM){			
			g.drawString("  Please Click!",5,35);//鼠标悬浮在小球之上时显示请选中		
			if(markC){			
				g.drawString("  Bingo!",105,35);//鼠标选中小球时显示，选中了			
				}		
			}else{				
				g.drawString("  Miss!",5,35);//鼠标未选中小球且未悬浮在小球上时显示未击中		
				}	
		}	
	public void run(){		
		while(true){						
			try{				
				Thread.sleep(1);			
				}			
			catch(Exception e){}
			repaint();		
			}	
		}		//@Override MouseListener	
	@Override	  
	public void mousePressed(MouseEvent e) {			    
		mx=e.getX();		
		my=e.getY();		
		if((mx-x)<20&&(mx-x)>0&&(my-y)<20&&(my-y)>0){			
			markC=true;
			}else{			
				markC=false;
				}	
	}	
	@Override    
	public void mouseReleased(MouseEvent e) {
		
	}	
	@Override    
	public void mouseEntered(MouseEvent e) {			   
		
	}	
	@Override    
	public void mouseExited(MouseEvent e) {			
		
	}	//鼠标点击事件	
	@Override    
	public void mouseClicked(MouseEvent e) {		
			   
		}	//@Override MouseMotoionListener	
	//鼠标移动事件	
	//获取鼠标坐标 进行判断 看鼠标是否悬浮在小球之上	
	//若鼠标悬浮在小球之上，则将markM置为true	
	@Override	
	public void mouseMoved(MouseEvent e) {		
		mx=e.getX();		
		my=e.getY();		
		if((mx-x)<20&&(mx-x)>0&&(my-y)<20&&(my-y)>0){			
			markM=true;
			}else{			
				markM=false;			
				markC=false; //当鼠标离开小球区域时，点击造成的markC重新置为false！		
				}
		}	//鼠标拖拽事件	
	//当鼠标悬浮在小球之上（markM为true）且鼠标选中小球（markC为true）时	
	//小球坐标被赋值为鼠标坐标	
	//实现小球随鼠标拖拽移动的效果	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(markC==true&&markM==true){	
			x=e.getX();	
			y=e.getY();
			} 
	}
}

