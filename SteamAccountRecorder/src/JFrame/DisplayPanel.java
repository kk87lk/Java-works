package JFrame;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DisplayPanel {

    void creatMainWindow() {
        JFrame mainWindow = new JFrame("SteamAccountRecorder");
        JButton buttonExit = new JButton("Exit");
        mainWindow.getContentPane().add(buttonExit);
        mainWindow.setSize(400, 300);
        mainWindow.setVisible(true);
    }
}
