import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class gui{
	public void loginPanel() {
		// 新建ui组件
		JFrame jFrameLogin = new JFrame("图书管理系统");
		Container cotainerLogin = jFrameLogin.getContentPane();
		JPanel loginPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Book Management System.");
		JLabel accountLabel = new JLabel("账号:");
		JLabel passwordLabel = new JLabel("密码:");
		JButton loginButton = new JButton("登陆");
		JButton registerButton = new JButton("注册");
		JTextArea accountArea = new JTextArea();
		JPasswordField passwordArea = new JPasswordField();

		// 设置ui布局
		cotainerLogin.setLayout(null);
		loginPanel.setLayout(null);
		titlePanel.setLayout(null);

		jFrameLogin.setBounds(300, 100, 600, 400);
		titlePanel.setBounds(0, 0, 600, 100);
		loginPanel.setBounds(0, 0, 600, 400);
		title.setBounds(10, 40, 600, 45);
		accountLabel.setBounds(170, 170, 150, 24);
		accountArea.setBounds(230, 170, 150, 24);
		passwordLabel.setBounds(170, 210, 150, 24);
		passwordArea.setBounds(230, 210, 150, 24);
		loginButton.setBounds(200, 270, 60, 24);
		registerButton.setBounds(290, 270, 60, 24);

		// 字体设置
		title.setFont(new java.awt.Font("Bookman Old Style", 3, 40));
		accountLabel.setFont(new java.awt.Font("微软雅黑", 1, 22));
		passwordLabel.setFont(new java.awt.Font("微软雅黑", 1, 22));
		title.setForeground(new Color(171, 178, 191));
		accountLabel.setForeground(new Color(171, 178, 191));
		passwordLabel.setForeground(new Color(171, 178, 191));

		// 设置背景颜色
		titlePanel.setBackground(new Color(40, 44, 52));
		loginPanel.setBackground(new Color(40, 44, 52));

		// 向Container中添加组件
		cotainerLogin.add(titlePanel);
		cotainerLogin.add(loginPanel);
		titlePanel.add(title);
		loginPanel.add(accountLabel);
		loginPanel.add(accountArea);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordArea);
		loginPanel.add(loginButton);
		loginPanel.add(registerButton);

		// 设置按钮事件
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accString = accountArea.getText();
				String pwdString = passwordArea.getText();
				DBOperation dbOperation = new DBOperation();
				if (dbOperation.isCorrect(accString, pwdString)) {
					JDialog correctDialog = new JDialog();
					JLabel correLabel = new JLabel("登陆成功");
					correctDialog.setBounds(500, 250, 120, 60);
					correctDialog.add(correLabel);
					correctDialog.setVisible(true);
					correctDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					jFrameLogin.setVisible(false);
					gui g = new gui();
					g.managePanel();
				} else {
					JDialog incorrectDialog = new JDialog();
					JLabel incorrectLabel = new JLabel("密码错误或账户不存在");
					incorrectDialog.setBounds(500, 250, 120, 60);
					incorrectDialog.add(incorrectLabel);
					incorrectDialog.setVisible(true);
					incorrectDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				}
			}
		});
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accString = accountArea.getText();
				String pwdString = passwordArea.getText();
				DBOperation dbOperation = new DBOperation();
				if (dbOperation.register(accString, pwdString)) {
					JDialog correctDialog = new JDialog();
					JLabel correLabel = new JLabel("注册成功");
					correctDialog.setBounds(500, 250, 120, 60);
					correctDialog.add(correLabel);
					correctDialog.setVisible(true);
					correctDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				} else {
					JDialog incorrectDialog = new JDialog();
					JLabel incorrectLabel = new JLabel("账户已经存在");
					incorrectDialog.setBounds(500, 250, 120, 60);
					incorrectDialog.add(incorrectLabel);
					incorrectDialog.setVisible(true);
					incorrectDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				}
			}
		});

		// 设置窗体可见
		titlePanel.setVisible(true);
		loginPanel.setVisible(true);
		jFrameLogin.setVisible(true);
		jFrameLogin.setDefaultCloseOperation(3);
	}

	public void managePanel() {
		String[] colName = { "图书编号", "ISBN", "书名", "作者", "出版社", "图书价格", "图书库存" };
		DBOperation o = new DBOperation();
		// 新建ui组件
		JFrame jFrameManage = new JFrame("管理界面");
		JPanel dataPanel = new JPanel();
		JPanel bgPanel = new JPanel();
		JTable jTable = new JTable(o.getData(), colName);
		JScrollPane dataPane = new JScrollPane(jTable);
		JButton addButton = new JButton("添加图书记录");
		JButton delButton = new JButton("删除图书记录");
		JButton changeButton = new JButton("修改图书记录");
		JButton findButton = new JButton("查找图书记录");
		
		jFrameManage.setLayout(null);
		bgPanel.setLayout(null);
		dataPanel.setLayout(null);

		jFrameManage.setBounds(300, 100, 700, 500);
		bgPanel.setBounds(0, 0, 700, 500);
		dataPanel.setBounds(90, 250, 520, 200);
		
		jFrameManage.setBackground(new Color(40, 44, 52));
		dataPanel.setBackground(new Color(40, 44, 52));
		bgPanel.setBackground(new Color(40, 44, 52));
		dataPane.setBackground(new Color(40, 44, 52));
		
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setSize(550, 200);
		dataPane.setSize(550, 200);

		dataPanel.add(dataPane);
		jFrameManage.add(dataPanel);
		jFrameManage.add(bgPanel);
		jFrameManage.setVisible(true);
		jFrameManage.setDefaultCloseOperation(3);
	}

}

public class Test {
	public static void main(String[] args) {
		// 设置LAF
		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		gui gui = new gui();
		gui.loginPanel();

	}

}
