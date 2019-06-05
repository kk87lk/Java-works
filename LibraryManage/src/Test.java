import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
		JFrame jFrame = new JFrame("1");
		JButton jButton = new JButton("m");
		JButton jButton3 = new JButton("3");
		jFrame.setLayout(null);
		jButton.setBounds(10, 10, 20, 20);
		jFrame.add(jButton);
		jFrame.add(jButton3);
		jFrame.setVisible(true);
	}

}
