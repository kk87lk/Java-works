package JFrame;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayPanel {

    void creatMainWindow() {
        JFrame mainWindow = new JFrame("SteamAccountRecorder");
        Container cp = mainWindow.getContentPane();
        cp.setLayout(new GridLayout(10,5);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JButton buttonExit = new JButton("Exit");
        panel1.add(buttonExit);
        JButton buttonExit1 = new JButton("Exit1");
        panel2.add(buttonExit1);
        buttonExit.setSize(50, 25);
        buttonExit.setLocation(50, 50);
        mainWindow.getContentPane().add(buttonExit);
        buttonExit.addActionListener(new Handler());
        buttonExit1.setSize(50, 25);
        buttonExit1.setLocation(200, 50);
        mainWindow.setSize(400, 300);
        mainWindow.setVisible(true);
    }
}

class Handler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}