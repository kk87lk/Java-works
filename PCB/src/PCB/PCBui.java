package PCB;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PCBui {
//	@SuppressWarnings("deprecation")
	public PCBui() {
		JFrame mainWindow = new JFrame();
		JButton createProcess = new JButton("创建进程");
		JButton suspendProcess = new JButton("挂起进程");
		JButton activeProcess = new JButton("激活进程");
		JButton killProcess = new JButton("终止进程");
		Panel operationPanel = new Panel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT,20,20);
		Container cp = mainWindow.getContentPane();
        cp.setLayout(flowLayout);
		mainWindow.add(operationPanel);
		operationPanel.add(createProcess);
		operationPanel.add(suspendProcess);
		operationPanel.add(activeProcess);
		operationPanel.add(killProcess);
		mainWindow.setVisible(true);
		mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);	
	}
	
}
