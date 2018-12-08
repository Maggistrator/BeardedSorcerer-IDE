package ui;

import ui.navigation.NavigationPanel;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import logic.FileManagerSingleton;

/**
 * �������� ���� ���������. 
 * @author ����
 */
public class ApplicationFrame extends JFrame{

    //�������� �������� ���������� - ������ ���������, � ������� �������
    WorkingArea workingArea = new WorkingArea();
    NavigationPanel navigationPanel = new NavigationPanel();
    
    //�-� ������� GridBagLayout, �� ����� ���� ����� �� ��� ����������� ��������
    GridBagLayout advancedLayout = new GridBagLayout();

    public ApplicationFrame() throws HeadlessException {
        super("BeardedSorcerer IDE");
        initalizeProgrammData();
        workingArea.init(this);
        navigationPanel.init(this);
        
        //�������������� � ������ �� ����������, � �������� ��������� ������
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "��������� �����, �� ���������� �� ���� ����� ����������", "������� ����?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    FileManagerSingleton.getInstance().resetTempFiles();
                    System.exit(0);
                }
            }
        });

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        pane.setDividerSize(8);
        pane.setDividerLocation(150);
        pane.setLeftComponent(new JScrollPane(navigationPanel));
        pane.setRightComponent(new JScrollPane(workingArea));
        
        //<editor-fold defaultstate="collapsed" desc="�������� ���������� ��� SplitPane">
        GridBagConstraints splitPaneConstrains = new GridBagConstraints();
        splitPaneConstrains.gridx = 0;
        splitPaneConstrains.gridy = 1;
        splitPaneConstrains.anchor = GridBagConstraints.NORTHWEST;
        splitPaneConstrains.fill = GridBagConstraints.BOTH;
        splitPaneConstrains.weightx = 0.75f;
        splitPaneConstrains.weighty = 0.97f;
        splitPaneConstrains.gridwidth = 3;
        splitPaneConstrains.insets = new Insets(0, 0, 0, 2);
        //</editor-fold>
        
        advancedLayout.addLayoutComponent(pane, splitPaneConstrains);
        add(pane);
        
        //��������� ���������� ��������������� ����
        setLayout(advancedLayout);
        setPreferredSize(new Dimension(800, 600));//������
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//��������� ������
        setIconImage(new ImageIcon("sys/magic.png").getImage());//������
        pack();//���������� ����, ���������� UI
        setLocationRelativeTo(null);//������������ �� ������ ������
    }

    public JTree getNavigationTree(){
        return navigationPanel.getNavigationTree();
    }
    
    public JTextArea getTextArea(){
        return workingArea.getTextArea();
    }
    
    /**
     * ������ ��������� ����� �� ������ ���������, ��� �������� ������ ������
     */
    private void initalizeProgrammData(){
        FileManagerSingleton.getInstance().createTempFile("MyClass", FileManagerSingleton.DEFAULT_TEMP_PATH);
        System.out.println("Manager called");
    }

}
