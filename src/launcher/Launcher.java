package launcher;

import com.alee.laf.WebLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.ApplicationFrame;

/**
 * @author Сова
 */
public class Launcher {
    public static void main(String[] args) {
        try {
        setLaf();
        EventQueue.invokeLater(() -> {
            new ApplicationFrame().setVisible(true);
        });
        } catch (HeadlessException ex) {
            System.err.println("programm crushed :/");
        }
    }
    
    private static void setLaf() {
        //<editor-fold defaultstate="collapsed" desc="настройка Look and Feel">
        try {
            WebLookAndFeel webLaF = new WebLookAndFeel();
            UIManager.setLookAndFeel(webLaF);
//            UIManager.setLookAndFeel(new WindowsLookAndFeel());
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Оформление окна отвалилось.. Причина: \n" + ex.getMessage());
        }
        //</editor-fold>
    }
}
