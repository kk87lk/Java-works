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
		// �½�ui���
		JFrame jFrameLogin = new JFrame("ͼ�����ϵͳ");
		Container cotainerLogin = jFrameLogin.getContentPane();
		JPanel loginPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Book Management System.");
		JLabel accountLabel = new JLabel("�˺�:");
		JLabel passwordLabel = new JLabel("����:");
		JButton loginButton = new JButton("��½");
		JButton registerButton = new JButton("ע��");
		JTextArea accountArea = new JTextArea();
		JPasswordField passwordArea = new JPasswordField();

		// ����ui����
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

		// ��������
		title.setFont(new java.awt.Font("Bookman Old Style", 3, 40));
		accountLabel.setFont(new java.awt.Font("΢���ź�", 1, 22));
		passwordLabel.setFont(new java.awt.Font("΢���ź�", 1, 22));
		title.setForeground(new Color(171, 178, 191));
		accountLabel.setForeground(new Color(171, 178, 191));
		passwordLabel.setForeground(new Color(171, 178, 191));

		// ���ñ�����ɫ
		titlePanel.setBackground(new Color(40, 44, 52));
		loginPanel.setBackground(new Color(40, 44, 52));

		// ��Container��������
		cotainerLogin.add(titlePanel);
		cotainerLogin.add(loginPanel);
		titlePanel.add(title);
		loginPanel.add(accountLabel);
		loginPanel.add(accountArea);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordArea);
		loginPanel.add(loginButton);
		loginPanel.add(registerButton);

		// ���ð�ť�¼�
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String accString = accountArea.getText();
				String pwdString = passwordArea.getText();
				DBOperation dbOperation = new DBOperation();
				if (dbOperation.isCorrect(accString, pwdString)) {
					JDialog correctDialog = new JDialog();
					JLabel correLabel = new JLabel("��½�ɹ�");
					correctDialog.setBounds(500, 250, 120, 60);
					correctDialog.add(correLabel);
					correctDialog.setVisible(true);
					correctDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
					jFrameLogin.setVisible(false);
					gui g = new gui();
					g.managePanel();
				} else {
					JDialog incorrectDialog = new JDialog();
					JLabel incorrectLabel = new JLabel("���������˻�������");
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
					JLabel correLabel = new JLabel("ע��ɹ�");
					correctDialog.setBounds(500, 250, 120, 60);
					correctDialog.add(correLabel);
					correctDialog.setVisible(true);
					correctDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				} else {
					JDialog incorrectDialog = new JDialog();
					JLabel incorrectLabel = new JLabel("�˻��Ѿ�����");
					incorrectDialog.setBounds(500, 250, 120, 60);
					incorrectDialog.add(incorrectLabel);
					incorrectDialog.setVisible(true);
					incorrectDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
				}
			}
		});

		// ���ô���ɼ�
		titlePanel.setVisible(true);
		loginPanel.setVisible(true);
		jFrameLogin.setVisible(true);
		jFrameLogin.setDefaultCloseOperation(3);
	}

	public void managePanel() {
		String[] colName = { "ͼ����", "ISBN", "����", "����", "������", "ͼ��۸�", "ͼ����" };
		DBOperation o = new DBOperation();
		// �½�ui���
		JFrame jFrameManage = new JFrame("�������");
		JPanel dataPanel = new JPanel();
		JPanel bgPanel = new JPanel();
		JTable jTable = new JTable(o.getData(), colName);
		JScrollPane dataPane = new JScrollPane(jTable);
		JButton addButton = new JButton("���ͼ���¼");
		JButton delButton = new JButton("ɾ��ͼ���¼");
		JButton changeButton = new JButton("�޸�ͼ���¼");
		JButton findButton = new JButton("����ͼ���¼");
		
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
		// ����LAF
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
