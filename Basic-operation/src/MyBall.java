import java.awt.*;
import java.awt.event.*;
public class MyBall{	
	public static void main(String args[])	{		
		Frame w = new Frame();		
		w.setSize(300,400);		
		MyPanel mp = new MyPanel();		
		w.add(mp);		
		Thread t= new Thread(mp);		
		t.start();		//ע�������̬����¼������磺���		
		w.addMouseListener(mp);		
		mp.addMouseListener(mp);		//ע�������̬����¼������磺��ק		
		w.addMouseMotionListener(mp);		
		mp.addMouseMotionListener(mp);		
		w.show();	
		}
	}
class MyPanel extends Panel implements Runnable,MouseListener,MouseMotionListener{ 	
	int x;//С�������	
	int y;	
	int mx;//��������	
	int my;	
	Boolean markC=false;//��ʶ����Ƿ�������С��֮��	
	Boolean markM=false;//��ʶ����Ƿ�ѡ��С��	
	MyPanel(){		
		x=(int)(Math.random()*300);		
		y=(int)(Math.random()*300);	
		}	
	public void paint(Graphics g){		
		g.fillOval(x,y,20,20);//С���������С�����λ��		
		g.setColor(Color.RED);		//�ֱ���ʾ��������С������		
		g.drawString("Mouse   X: "+mx+" Y: "+my,5,15);		
		g.drawString("Ball  X: "+x+" Y: "+y,5,25);		
		if(markM){			
			g.drawString("  Please Click!",5,35);//���������С��֮��ʱ��ʾ��ѡ��		
			if(markC){			
				g.drawString("  Bingo!",105,35);//���ѡ��С��ʱ��ʾ��ѡ����			
				}		
			}else{				
				g.drawString("  Miss!",5,35);//���δѡ��С����δ������С����ʱ��ʾδ����		
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
		
	}	//������¼�	
	@Override    
	public void mouseClicked(MouseEvent e) {		
			   
		}	//@Override MouseMotoionListener	
	//����ƶ��¼�	
	//��ȡ������� �����ж� ������Ƿ�������С��֮��	
	//�����������С��֮�ϣ���markM��Ϊtrue	
	@Override	
	public void mouseMoved(MouseEvent e) {		
		mx=e.getX();		
		my=e.getY();		
		if((mx-x)<20&&(mx-x)>0&&(my-y)<20&&(my-y)>0){			
			markM=true;
			}else{			
				markM=false;			
				markC=false; //������뿪С������ʱ�������ɵ�markC������Ϊfalse��		
				}
		}	//�����ק�¼�	
	//�����������С��֮�ϣ�markMΪtrue�������ѡ��С��markCΪtrue��ʱ	
	//С�����걻��ֵΪ�������	
	//ʵ��С���������ק�ƶ���Ч��	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(markC==true&&markM==true){	
			x=e.getX();	
			y=e.getY();
			} 
	}
}

