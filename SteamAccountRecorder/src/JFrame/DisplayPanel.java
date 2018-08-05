package JFrame;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DisplayPanel {

    void creatMainWindow() {
        // define the labels,buttons&container
        JFrame mainWindow = new JFrame("SteamAccountRecorder");
        JLabel account = new JLabel("Account");
        JLabel wins = new JLabel("Wins");
        JLabel coolDown = new JLabel("CoolDown");
        JLabel copyLabel = new JLabel("Copy");
        JTextField inputNewAccount = new JTextField(10);
        JButton save = (new JButton("Save"));
        JButton copy = (new JButton("Copy"));
        JButton creat = (new JButton("Creat"));
        Container cp = mainWindow.getContentPane();
        cp.setLayout(null);
        // Location
        account.setBounds(0, 0, 100, 20);
        wins.setBounds(100, 0, 100, 20);
        coolDown.setBounds(200, 0, 100, 20);
        copyLabel.setBounds(300, 0, 100, 20);
        save.setBounds(300, 230, 80, 20);
        // add to Container
        cp.add(account);
        cp.add(wins);
        cp.add(coolDown);
        cp.add(copyLabel);
        cp.add(save);
        // set the JFrame's form
        mainWindow.setSize(400, 300);
        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);
    }
}