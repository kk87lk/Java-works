package PCB;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class PCBui {
//	@SuppressWarnings("deprecation")
	public PCBui(PCB PCB) {
		PCB pcb = PCB;
		JFrame mainWindow = new JFrame("Process Control Blocks");
		mainWindow.setBounds(200, 200, 600, 400);
		JButton createProcess = new JButton("创建进程");
		createProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog createWindow = new JDialog();
				JLabel pidLabel = new JLabel("PID:");
				JTextField pidText = new JTextField(10);
				JLabel uidLabel = new JLabel("UID:");
				JTextField uidText = new JTextField(10);
				JButton confirm = new JButton("确认");
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(pidText.getText().length() != 0 && uidText.getText().length() != 0) {
							pcb.Create(Integer.parseInt(pidText.getText()),Integer.parseInt(uidText.getText()));
							createWindow.setVisible(false);
							mainWindow.setEnabled(true);
							mainWindow.setVisible(true);
						} else {
							JDialog errorWindow = new JDialog(createWindow,"Error",false);
							JButton confirm = new JButton("无效的输入!");
							confirm.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									errorWindow.setVisible(false);
									createWindow.setEnabled(true);
									mainWindow.setVisible(true);
									createWindow.setVisible(true);
								}
							});
							errorWindow.setBounds(250, 250, 120, 60);
							createWindow.setEnabled(false);
							errorWindow.add(confirm);
							errorWindow.setDefaultCloseOperation(errorWindow.DO_NOTHING_ON_CLOSE);
							errorWindow.setVisible(true);
						}
					}
				});
				JButton cancel = new JButton("取消");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						createWindow.setVisible(false);
						mainWindow.setEnabled(true);
						mainWindow.setVisible(true);
					}
				});
				createWindow.setBounds(200, 200, 400, 300);
				createWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 50));
				createWindow.add(pidLabel);
				createWindow.add(pidText);
				createWindow.add(uidLabel);
				createWindow.add(uidText);
				createWindow.add(confirm);
				createWindow.add(cancel);
				createWindow.setDefaultCloseOperation(createWindow.DO_NOTHING_ON_CLOSE);
				mainWindow.setEnabled(false);
				createWindow.setVisible(true);
			}
		});
		JButton suspendProcess = new JButton("挂起进程");
		suspendProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JDialog suspendWindow = new JDialog(mainWindow);
				JLabel suspendLabel = new JLabel("PID:");
				JTextField pidText = new JTextField(10);
				JButton confirm = new JButton("确认");
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(pidText.getText().length() != 0) {
							pcb.Suspend(Integer.parseInt(pidText.getText()));
							suspendWindow.setVisible(false);
							mainWindow.setEnabled(true);
							mainWindow.setVisible(true);
						} else {
							JDialog errorWindow = new JDialog(suspendWindow,"Error");
							JButton confirm = new JButton("无效的输入!");
							confirm.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									errorWindow.setVisible(false);
									suspendWindow.setEnabled(true);
									mainWindow.setVisible(true);
									suspendWindow.setVisible(true);
								}
							});
							errorWindow.setBounds(250, 250, 120, 60);
							errorWindow.add(confirm);
							errorWindow.setDefaultCloseOperation(errorWindow.DO_NOTHING_ON_CLOSE);
							suspendWindow.setEnabled(false);
							errorWindow.setVisible(true);
						}
					}
				});
				JButton cancel = new JButton("取消");
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						suspendWindow.setVisible(false);
						mainWindow.setEnabled(true);
						mainWindow.setVisible(true);
					}
				});
				suspendWindow.setBounds(200, 200, 400, 200);
				suspendWindow.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 50));
				suspendWindow.add(suspendLabel);
				suspendWindow.add(pidText);
				suspendWindow.add(confirm);
				suspendWindow.add(cancel);
				suspendWindow.setDefaultCloseOperation(suspendWindow.DO_NOTHING_ON_CLOSE);
				mainWindow.setEnabled(false);
				suspendWindow.setVisible(true);
			}
		});
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
        mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);	
        mainWindow.setVisible(true);
	}
	
}
