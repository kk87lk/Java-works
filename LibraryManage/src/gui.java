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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


class gui{
	public void loginPanel() {
		// 新建ui组件
		JFrame jFrameLogin = new JFrame("图书管理系统");
		Container cotainerLogin = jFrameLogin.getContentPane();
		JPanel loginPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Book Management System");
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
		titlePanel.setBounds(0, 10, 600, 100);
		loginPanel.setBounds(0, 0, 600, 400);
		title.setBounds(15, 50, 600, 45);
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
				if (dbOperation.isCorrect(accString, pwdString)) {jFrameLogin.setVisible(false);
					jFrameLogin.dispose();
					managePanel();
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
		JButton refreshButton = new JButton("刷新数据");
		JLabel dataLabel = new JLabel("图书信息表");
		
		jFrameManage.setLayout(null);
		bgPanel.setLayout(null);
		dataPanel.setLayout(null);

		jFrameManage.setBounds(300, 100, 700, 500);
		bgPanel.setBounds(0, 0, 700, 500);
		dataPanel.setBounds(90, 250, 520, 200);
		addButton.setBounds(70, 50, 120, 25);
		delButton.setBounds(220, 50, 120, 25);
		changeButton.setBounds(370, 50, 120, 25);
		findButton.setBounds(520, 50, 120, 25);
		refreshButton.setBounds(550, 220, 120, 25);
		dataLabel.setBounds(288, 210, 120, 25);
		
		jFrameManage.setBackground(new Color(40, 44, 52));
		dataPanel.setBackground(new Color(40, 44, 52));
		bgPanel.setBackground(new Color(40, 44, 52));
		dataPane.setBackground(new Color(40, 44, 52));
		dataLabel.setForeground(new Color(171, 178, 191));
		

		dataLabel.setFont(new java.awt.Font("微软雅黑", 1, 22));
		
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setSize(550, 200);
		dataPane.setSize(550, 200);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog addDialog = new JDialog(jFrameManage);
				JLabel bookidJLabel = new JLabel("图书编号");
				JLabel bookisbnJLabel = new JLabel("ISBN");
				JLabel booknameJLabel = new JLabel("名称");
				JLabel bookauthorJLabel = new JLabel("作者");
				JLabel bookpressJLabel = new JLabel("出版社");
				JLabel bookpriceJLabel = new JLabel("价格");
				JLabel booknumberJLabel = new JLabel("库存数");
				JTextArea bookidArea = new JTextArea();
				JTextArea bookisbnArea = new JTextArea();
				JTextArea booknameArea = new JTextArea();
				JTextArea bookauthorArea = new JTextArea();
				JTextArea bookpressArea = new JTextArea();
				JTextArea bookpriceArea = new JTextArea();
				JTextArea booknumberArea = new JTextArea();
				JButton confirm = new JButton("确认");
				JButton cancel = new JButton("取消");
				
				addDialog.setLayout(null);
				
				addDialog.getContentPane().setBackground(new Color(40, 44, 52));
				bookidJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				bookidJLabel.setForeground(new Color(171, 178, 191));
				bookisbnJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				bookisbnJLabel.setForeground(new Color(171, 178, 191));
				booknameJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				booknameJLabel.setForeground(new Color(171, 178, 191));
				bookauthorJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				bookauthorJLabel.setForeground(new Color(171, 178, 191));
				bookpressJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				bookpressJLabel.setForeground(new Color(171, 178, 191));
				bookpriceJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				bookpriceJLabel.setForeground(new Color(171, 178, 191));
				booknumberJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
				booknumberJLabel.setForeground(new Color(171, 178, 191));

				addDialog.setBounds(450, 100, 300, 500);
				bookidJLabel.setBounds(50, 50, 75, 25);
				bookidArea.setBounds(150, 50, 75, 25);
				bookisbnJLabel.setBounds(50, 100, 75, 25);
				bookisbnArea.setBounds(150, 100, 75, 25);
				booknameJLabel.setBounds(50, 150, 75, 25);
				booknameArea.setBounds(150, 150, 75, 25);
				bookauthorJLabel.setBounds(50, 200, 75, 25);
				bookauthorArea.setBounds(150, 200, 75, 25);
				bookpressJLabel.setBounds(50, 250, 75, 25);
				bookpressArea.setBounds(150, 250, 75, 25);
				bookpriceJLabel.setBounds(50, 300, 75, 25);
				bookpriceArea.setBounds(150, 300, 75, 25);
				booknumberJLabel.setBounds(50, 350, 75, 25);
				booknumberArea.setBounds(150, 350, 75, 25);
				confirm.setBounds(50, 400, 75, 25);
				cancel.setBounds(175, 400, 75, 25);
				
				addDialog.add(bookidJLabel);
				addDialog.add(bookidArea);
				addDialog.add(bookisbnJLabel);
				addDialog.add(bookisbnArea);
				addDialog.add(booknameJLabel);
				addDialog.add(booknameArea);
				addDialog.add(bookauthorJLabel);
				addDialog.add(bookauthorArea);
				addDialog.add(bookpressJLabel);
				addDialog.add(bookpressArea);
				addDialog.add(bookpriceJLabel);
				addDialog.add(bookpriceArea);
				addDialog.add(booknumberJLabel);
				addDialog.add(booknumberArea);
				addDialog.add(confirm);
				addDialog.add(cancel);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						o.add(Integer.valueOf(bookidArea.getText()), bookisbnArea.getText(), booknameArea.getText(),bookauthorArea.getText(), bookpressArea.getText(), Double.valueOf(bookpriceArea.getText()), Integer.valueOf(booknumberArea.getText()));
						addDialog.dispose();
					}
				});
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						addDialog.dispose();
					}
				});
				
				addDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				addDialog.setVisible(true);
			}
		});
		delButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog delDialog = new JDialog(jFrameManage);
				JLabel delJLabel = new JLabel("需要删除图书的ISBN");
				JTextArea delArea = new JTextArea();
				JButton confirm = new JButton("确认");
				JButton cancel = new JButton("取消");
				
				delDialog.setLayout(null);
				
				delDialog.getContentPane().setBackground(new Color(40, 44, 52));
				delJLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
				delJLabel.setForeground(new Color(171, 178, 191));
				
				delDialog.setBounds(450, 100, 300, 200);
				delJLabel.setBounds(20, 50, 150, 25);
				delArea.setBounds(180, 50, 75, 25);
				confirm.setBounds(50, 100, 75, 25);
				cancel.setBounds(150, 100, 75, 25);
				
				delDialog.add(delJLabel);
				delDialog.add(delArea);
				delDialog.add(confirm);
				delDialog.add(cancel);
				
				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(o.del(delArea.getText()))
							delDialog.dispose();
						else {
							JDialog warning = new JDialog();
							warning.setBounds(500, 150, 150, 50);
							JLabel warnLabel = new JLabel("未查找到此书!");
							warning.getContentPane().setBackground(new Color(40, 44, 52));
							warnLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
							warnLabel.setForeground(new Color(171, 178, 191));
							warning.add(warnLabel);
							warning.setVisible(true);
						}
					}
				});
				cancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						delDialog.dispose();
					}
				});
				
				delDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				delDialog.setVisible(true);
			}
		});
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog findDialog = new JDialog(jFrameManage);
				JTabbedPane tabbedPane = new JTabbedPane();
				JPanel findnamePanel = new JPanel();
				JPanel findisbnPanel = new JPanel();
				JLabel nLabel = new JLabel("输入查找的书名");
				JLabel iLabel = new JLabel("输入查找的ISBN");
				JTextArea nArea = new JTextArea();
				JTextArea iArea = new JTextArea();
				JButton nconfirm = new JButton("确认");
				JButton ncancel = new JButton("取消");
				JButton iconfirm = new JButton("确认");
				JButton icancel = new JButton("取消");
				
				findnamePanel.setLayout(null);
				findisbnPanel.setLayout(null);
				
				nLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
				nLabel.setForeground(new Color(171, 178, 191));
				iLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
				iLabel.setForeground(new Color(171, 178, 191));
				
				findDialog.setBounds(450, 100, 300, 200);
				findnamePanel.setBounds(0,0,300,180);
				findisbnPanel.setBounds(0,0,300,180);
				nLabel.setBounds(20,30,100,20);
				nArea.setBounds(170,30,100,20);
				iLabel.setBounds(20,30,120,20);
				iArea.setBounds(170,30,100,20);
				nconfirm.setBounds(60,90,70,20);
				ncancel.setBounds(150,90,70,20);
				iconfirm.setBounds(60,90,70,20);
				icancel.setBounds(150,90,70,20);
				
				findnamePanel.setBackground(new Color(40, 44, 52));
				findisbnPanel.setBackground(new Color(40, 44, 52));
				
				tabbedPane.add("按书名查找",findnamePanel);
				tabbedPane.add("按ISBN查找",findisbnPanel);
				findDialog.add(tabbedPane);
				findnamePanel.add(nLabel);
				findnamePanel.add(nArea);
				findnamePanel.add(nconfirm);
				findnamePanel.add(ncancel);
				findisbnPanel.add(iLabel);
				findisbnPanel.add(iArea);
				findisbnPanel.add(iconfirm);
				findisbnPanel.add(icancel);

				nconfirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Book book = new Book();
						book = o.findName(nArea.getText());
						if(book.getBookID()==0) {
							JDialog warning = new JDialog();
							warning.setBounds(500, 150, 150, 50);
							JLabel warnLabel = new JLabel("未查找到此书!");
							warning.getContentPane().setBackground(new Color(40, 44, 52));
							warnLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
							warnLabel.setForeground(new Color(171, 178, 191));
							warning.add(warnLabel);
							warning.setVisible(true);
						}else {
							JDialog displayDialog = new JDialog();
							Object[][] findData = new Object[2][7];
							JTable findTable = new JTable(findData, colName);
							JScrollPane findPane = new JScrollPane(findTable);
							JLabel titleLabel = new JLabel("查询结果");
							titleLabel.setFont(new java.awt.Font("微软雅黑", 1, 20));
							titleLabel.setForeground(new Color(171, 178, 191));
							displayDialog.setLayout(null);
							displayDialog.setBounds(400, 150, 530, 200);
							displayDialog.getContentPane().setBackground(new Color(40, 44, 52));
							findPane.setSize(500,60);
							findData[0][0] = book.getBookID();
							findData[0][1] = book.getBookISBN();
							findData[0][2] = book.getBookName();
							findData[0][3] = book.getBookAuthor();
							findData[0][4] = book.getBookPress();
							findData[0][5] = book.getBookPrice();
							findData[0][6] = book.getBookNumber();
							titleLabel.setBounds(210, 40, 100, 20);
							findTable.setBounds(0,0,550,60);
							findPane.setBounds(0,80,550,60);
							displayDialog.add(titleLabel);
							findTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							displayDialog.add(findPane);
							displayDialog.setVisible(true);
						}
					}
				});
				iconfirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Book book = new Book();
						book = o.findISBN(iArea.getText());
						if(book.getBookID()==0) {
							JDialog warning = new JDialog();
							warning.setBounds(500, 150, 150, 50);
							JLabel warnLabel = new JLabel("未查找到此书!");
							warning.getContentPane().setBackground(new Color(40, 44, 52));
							warnLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
							warnLabel.setForeground(new Color(171, 178, 191));
							warning.add(warnLabel);
							warning.setVisible(true);
						}else {
							JDialog displayDialog = new JDialog();
							Object[][] findData = new Object[2][7];
							JTable findTable = new JTable(findData, colName);
							JScrollPane findPane = new JScrollPane(findTable);
							JLabel titleLabel = new JLabel("查询结果");
							titleLabel.setFont(new java.awt.Font("微软雅黑", 1, 20));
							titleLabel.setForeground(new Color(171, 178, 191));
							displayDialog.setLayout(null);
							displayDialog.setBounds(400, 150, 530, 200);
							displayDialog.getContentPane().setBackground(new Color(40, 44, 52));
							findPane.setSize(500,60);
							findData[0][0] = book.getBookID();
							findData[0][1] = book.getBookISBN();
							findData[0][2] = book.getBookName();
							findData[0][3] = book.getBookAuthor();
							findData[0][4] = book.getBookPress();
							findData[0][5] = book.getBookPrice();
							findData[0][6] = book.getBookNumber();
							titleLabel.setBounds(210, 40, 100, 20);
							findTable.setBounds(0,0,550,60);
							findPane.setBounds(0,80,550,60);
							displayDialog.add(titleLabel);
							findTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
							displayDialog.add(findPane);
							displayDialog.setVisible(true);
						}
					}
				});
				
				ncancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						findDialog.dispose();
					}
				});
				icancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						findDialog.dispose();
					}
				});
				
				findDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				findDialog.setVisible(true);
				
			}
		});
		changeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog findDialog = new JDialog(jFrameManage);
				JTabbedPane tabbedPane = new JTabbedPane();
				JPanel findnamePanel = new JPanel();
				JPanel findisbnPanel = new JPanel();
				JLabel nLabel = new JLabel("需修改书的书名");
				JLabel iLabel = new JLabel("需修改书的ISBN");
				JTextArea nArea = new JTextArea();
				JTextArea iArea = new JTextArea();
				JButton nconfirm = new JButton("确认");
				JButton ncancel = new JButton("取消");
				JButton iconfirm = new JButton("确认");
				JButton icancel = new JButton("取消");
				
				findnamePanel.setLayout(null);
				findisbnPanel.setLayout(null);
				
				nLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
				nLabel.setForeground(new Color(171, 178, 191));
				iLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
				iLabel.setForeground(new Color(171, 178, 191));
				
				findDialog.setBounds(450, 100, 300, 200);
				findnamePanel.setBounds(0,0,300,180);
				findisbnPanel.setBounds(0,0,300,180);
				nLabel.setBounds(20,30,100,20);
				nArea.setBounds(170,30,100,20);
				iLabel.setBounds(20,30,120,20);
				iArea.setBounds(170,30,100,20);
				nconfirm.setBounds(60,90,70,20);
				ncancel.setBounds(150,90,70,20);
				iconfirm.setBounds(60,90,70,20);
				icancel.setBounds(150,90,70,20);
				
				findnamePanel.setBackground(new Color(40, 44, 52));
				findisbnPanel.setBackground(new Color(40, 44, 52));
				
				tabbedPane.add("按书名查找",findnamePanel);
				tabbedPane.add("按ISBN查找",findisbnPanel);
				findDialog.add(tabbedPane);
				findnamePanel.add(nLabel);
				findnamePanel.add(nArea);
				findnamePanel.add(nconfirm);
				findnamePanel.add(ncancel);
				findisbnPanel.add(iLabel);
				findisbnPanel.add(iArea);
				findisbnPanel.add(iconfirm);
				findisbnPanel.add(icancel);

				nconfirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						final Book book = o.findName(nArea.getText());
						if(book.getBookID()==0) {
							JDialog warning = new JDialog();
							warning.setBounds(500, 150, 150, 50);
							JLabel warnLabel = new JLabel("未查找到此书!");
							warning.getContentPane().setBackground(new Color(40, 44, 52));
							warnLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
							warnLabel.setForeground(new Color(171, 178, 191));
							warning.add(warnLabel);
							warning.setVisible(true);
						}else {
							JDialog changeDialog = new JDialog(findDialog,"修改数据(留空为无改动)");
							JLabel bookidJLabel = new JLabel("图书编号");
							JLabel bookisbnJLabel = new JLabel("ISBN");
							JLabel booknameJLabel = new JLabel("名称");
							JLabel bookauthorJLabel = new JLabel("作者");
							JLabel bookpressJLabel = new JLabel("出版社");
							JLabel bookpriceJLabel = new JLabel("价格");
							JLabel booknumberJLabel = new JLabel("库存数");
							JTextArea bookidArea = new JTextArea();
							JTextArea bookisbnArea = new JTextArea();
							JTextArea booknameArea = new JTextArea();
							JTextArea bookauthorArea = new JTextArea();
							JTextArea bookpressArea = new JTextArea();
							JTextArea bookpriceArea = new JTextArea();
							JTextArea booknumberArea = new JTextArea();
							JButton confirm = new JButton("确认");
							JButton cancel = new JButton("取消");
							
							changeDialog.setLayout(null);
							
							changeDialog.getContentPane().setBackground(new Color(40, 44, 52));
							bookidJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookidJLabel.setForeground(new Color(171, 178, 191));
							bookisbnJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookisbnJLabel.setForeground(new Color(171, 178, 191));
							booknameJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							booknameJLabel.setForeground(new Color(171, 178, 191));
							bookauthorJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookauthorJLabel.setForeground(new Color(171, 178, 191));
							bookpressJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookpressJLabel.setForeground(new Color(171, 178, 191));
							bookpriceJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookpriceJLabel.setForeground(new Color(171, 178, 191));
							booknumberJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							booknumberJLabel.setForeground(new Color(171, 178, 191));

							changeDialog.setBounds(450, 100, 300, 500);
							bookidJLabel.setBounds(50, 50, 75, 25);
							bookidArea.setBounds(150, 50, 75, 25);
							bookisbnJLabel.setBounds(50, 100, 75, 25);
							bookisbnArea.setBounds(150, 100, 75, 25);
							booknameJLabel.setBounds(50, 150, 75, 25);
							booknameArea.setBounds(150, 150, 75, 25);
							bookauthorJLabel.setBounds(50, 200, 75, 25);
							bookauthorArea.setBounds(150, 200, 75, 25);
							bookpressJLabel.setBounds(50, 250, 75, 25);
							bookpressArea.setBounds(150, 250, 75, 25);
							bookpriceJLabel.setBounds(50, 300, 75, 25);
							bookpriceArea.setBounds(150, 300, 75, 25);
							booknumberJLabel.setBounds(50, 350, 75, 25);
							booknumberArea.setBounds(150, 350, 75, 25);
							confirm.setBounds(50, 400, 75, 25);
							cancel.setBounds(175, 400, 75, 25);
							
							changeDialog.add(bookidJLabel);
							changeDialog.add(bookidArea);
							changeDialog.add(bookisbnJLabel);
							changeDialog.add(bookisbnArea);
							changeDialog.add(booknameJLabel);
							changeDialog.add(booknameArea);
							changeDialog.add(bookauthorJLabel);
							changeDialog.add(bookauthorArea);
							changeDialog.add(bookpressJLabel);
							changeDialog.add(bookpressArea);
							changeDialog.add(bookpriceJLabel);
							changeDialog.add(bookpriceArea);
							changeDialog.add(booknumberJLabel);
							changeDialog.add(booknumberArea);
							changeDialog.add(confirm);
							changeDialog.add(cancel);
							
							confirm.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									Book tepBook = new Book();
									if(bookidArea.getText().equals(""))
										tepBook.setBookID(book.getBookID());
									else
										tepBook.setBookID(Integer.valueOf(bookidArea.getText()));
									if(bookisbnArea.getText().equals(""))
										tepBook.setBookISBN(book.getBookISBN());
									else
										tepBook.setBookISBN(bookisbnArea.getText());
									if(booknameArea.getText().equals(""))
										tepBook.setBookName(book.getBookName());
									else
										tepBook.setBookName(booknameArea.getText());
									if(bookauthorArea.getText().equals("")) 
										tepBook.setBookAuthor(book.getBookAuthor());
									else
										tepBook.setBookAuthor(bookauthorArea.getText());
									if(bookpressArea.getText().equals(""))
										tepBook.setBookPress(book.getBookPress());
									else
										tepBook.setBookPress(bookpressArea.getText());
									if(bookpriceArea.getText().equals(""))
										tepBook.setBookPrice(book.getBookPrice());
									else
										tepBook.setBookPrice(Double.valueOf(booknumberArea.getText()));
									if(booknumberArea.getText().equals(""))
										tepBook.setBookNumber(book.getBookID());
									else
										tepBook.setBookNumber(Integer.valueOf(booknumberArea.getText()));
									o.changeBook(book.getBookISBN(), tepBook);
									changeDialog.dispose();
								}
							});
							cancel.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									changeDialog.dispose();
								}
							});
							changeDialog.setVisible(true);
						}
					}


				});
				iconfirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						final Book book = o.findISBN(iArea.getText());
						if(book.getBookID()==0) {
							JDialog warning = new JDialog();
							warning.setBounds(500, 150, 150, 50);
							JLabel warnLabel = new JLabel("未查找到此书!");
							warning.getContentPane().setBackground(new Color(40, 44, 52));
							warnLabel.setFont(new java.awt.Font("微软雅黑", 1, 14));
							warnLabel.setForeground(new Color(171, 178, 191));
							warning.add(warnLabel);
							warning.setVisible(true);
						}else {
							JDialog changeDialog = new JDialog(findDialog,"修改数据(留空为无改动)");
							JLabel bookidJLabel = new JLabel("图书编号");
							JLabel bookisbnJLabel = new JLabel("ISBN");
							JLabel booknameJLabel = new JLabel("名称");
							JLabel bookauthorJLabel = new JLabel("作者");
							JLabel bookpressJLabel = new JLabel("出版社");
							JLabel bookpriceJLabel = new JLabel("价格");
							JLabel booknumberJLabel = new JLabel("库存数");
							JTextArea bookidArea = new JTextArea();
							JTextArea bookisbnArea = new JTextArea();
							JTextArea booknameArea = new JTextArea();
							JTextArea bookauthorArea = new JTextArea();
							JTextArea bookpressArea = new JTextArea();
							JTextArea bookpriceArea = new JTextArea();
							JTextArea booknumberArea = new JTextArea();
							JButton confirm = new JButton("确认");
							JButton cancel = new JButton("取消");
							
							changeDialog.setLayout(null);
							
							changeDialog.getContentPane().setBackground(new Color(40, 44, 52));
							bookidJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookidJLabel.setForeground(new Color(171, 178, 191));
							bookisbnJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookisbnJLabel.setForeground(new Color(171, 178, 191));
							booknameJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							booknameJLabel.setForeground(new Color(171, 178, 191));
							bookauthorJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookauthorJLabel.setForeground(new Color(171, 178, 191));
							bookpressJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookpressJLabel.setForeground(new Color(171, 178, 191));
							bookpriceJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							bookpriceJLabel.setForeground(new Color(171, 178, 191));
							booknumberJLabel.setFont(new java.awt.Font("微软雅黑", 1, 15));
							booknumberJLabel.setForeground(new Color(171, 178, 191));

							changeDialog.setBounds(450, 100, 300, 500);
							bookidJLabel.setBounds(50, 50, 75, 25);
							bookidArea.setBounds(150, 50, 75, 25);
							bookisbnJLabel.setBounds(50, 100, 75, 25);
							bookisbnArea.setBounds(150, 100, 75, 25);
							booknameJLabel.setBounds(50, 150, 75, 25);
							booknameArea.setBounds(150, 150, 75, 25);
							bookauthorJLabel.setBounds(50, 200, 75, 25);
							bookauthorArea.setBounds(150, 200, 75, 25);
							bookpressJLabel.setBounds(50, 250, 75, 25);
							bookpressArea.setBounds(150, 250, 75, 25);
							bookpriceJLabel.setBounds(50, 300, 75, 25);
							bookpriceArea.setBounds(150, 300, 75, 25);
							booknumberJLabel.setBounds(50, 350, 75, 25);
							booknumberArea.setBounds(150, 350, 75, 25);
							confirm.setBounds(50, 400, 75, 25);
							cancel.setBounds(175, 400, 75, 25);
							
							changeDialog.add(bookidJLabel);
							changeDialog.add(bookidArea);
							changeDialog.add(bookisbnJLabel);
							changeDialog.add(bookisbnArea);
							changeDialog.add(booknameJLabel);
							changeDialog.add(booknameArea);
							changeDialog.add(bookauthorJLabel);
							changeDialog.add(bookauthorArea);
							changeDialog.add(bookpressJLabel);
							changeDialog.add(bookpressArea);
							changeDialog.add(bookpriceJLabel);
							changeDialog.add(bookpriceArea);
							changeDialog.add(booknumberJLabel);
							changeDialog.add(booknumberArea);
							changeDialog.add(confirm);
							changeDialog.add(cancel);
							
							confirm.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									Book tepBook = new Book();
									if(bookidArea.getText().equals(""))
										tepBook.setBookID(book.getBookID());
									else
										tepBook.setBookID(Integer.valueOf(bookidArea.getText()));
									if(bookisbnArea.getText().equals(""))
										tepBook.setBookISBN(book.getBookISBN());
									else
										tepBook.setBookISBN(bookisbnArea.getText());
									if(booknameArea.getText().equals(""))
										tepBook.setBookName(book.getBookName());
									else
										tepBook.setBookName(booknameArea.getText());
									if(bookauthorArea.getText().equals("")) 
										tepBook.setBookAuthor(book.getBookAuthor());
									else
										tepBook.setBookAuthor(bookauthorArea.getText());
									if(bookpressArea.getText().equals(""))
										tepBook.setBookPress(book.getBookPress());
									else
										tepBook.setBookPress(bookpressArea.getText());
									if(bookpriceArea.getText().equals(""))
										tepBook.setBookPrice(book.getBookPrice());
									else
										tepBook.setBookPrice(Double.valueOf(booknumberArea.getText()));
									if(booknumberArea.getText().equals(""))
										tepBook.setBookNumber(book.getBookID());
									else
										tepBook.setBookNumber(Integer.valueOf(booknumberArea.getText()));
									o.changeBook(book.getBookISBN(), tepBook);
									changeDialog.dispose();
								}
							});
							cancel.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									changeDialog.dispose();
								}
							});
							changeDialog.setVisible(true);
						}
					}
				});
				
				ncancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						findDialog.dispose();
					}
				});
				icancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						findDialog.dispose();
					}
				});
				
				findDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				findDialog.setVisible(true);
				
			}
		});
		refreshButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managePanel();
				jFrameManage.dispose();
			}
		});
		
		dataPanel.add(dataPane);
		jFrameManage.add(dataLabel);
		jFrameManage.add(addButton);
		jFrameManage.add(delButton);
		jFrameManage.add(changeButton);
		jFrameManage.add(refreshButton);
		jFrameManage.add(findButton);
		jFrameManage.add(dataPanel);
		jFrameManage.add(bgPanel);
		jFrameManage.setVisible(true);
		jFrameManage.setDefaultCloseOperation(3);
	}

}
