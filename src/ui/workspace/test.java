/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.workspace;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ����
 */
public class test extends JFrame
{
    private JLabel lblMain;
    private int    dividerMain = 200;
    private final  String TEMPL_lbl = "dividerLocation = %d";
    public test()
    {
        super("������ ����������� ������ JSplitPane");
     
                try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(this, "���������� ���� ���������� -_-"
                                          + "�������: " + ex.getMessage());
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // ������� ����������� ������
        final JSplitPane splitHorizontal = new JSplitPane();
        splitHorizontal.setOneTouchExpandable(true);
        // ������ ����������� ������
        splitHorizontal.setDividerSize(8);
        // ��������� ����������� ������
        splitHorizontal.setDividerLocation(dividerMain);
        // ������������ ����������� ������
        JSplitPane splitVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
        // �������� �������
        splitVertical.setTopComponent   (new JScrollPane());
        splitVertical.setBottomComponent(new JScrollPane());
        // ��������� ����������� ������
        splitVertical.setDividerLocation(100);
        // ��������� ����� ��� ������� ������
        lblMain = new  JLabel(String.format(TEMPL_lbl, dividerMain));
        // ������� ������
        JPanel pnlMain = new JPanel();
        pnlMain.add(lblMain);
        pnlMain.setBackground(Color.cyan);
        // ��������� ������� ������
        splitHorizontal.setLeftComponent(new JScrollPane(pnlMain));
        splitHorizontal.setRightComponent(splitVertical);
        // ��������� ��������� ������� ����������� ������
        splitHorizontal.addPropertyChangeListener(new PropertyChangeListener()
        {
            @Override
            public void propertyChange(PropertyChangeEvent arg0)
            {
                dividerMain = splitHorizontal.getDividerLocation();
                lblMain.setText(String.format(TEMPL_lbl, dividerMain));
            }
        });
        // ���������� ������ � ���������� � ����� ���� �� �����
        getContentPane().add(splitHorizontal);
        setSize(600, 400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new test();
    }
}