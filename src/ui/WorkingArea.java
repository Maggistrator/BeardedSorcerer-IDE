package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import logic.FileManagerSingleton;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * ������� �������, ���������� ��������� �������, ������, � ������ �������������
 *
 * @author ����
 */
public class WorkingArea extends JPanel {

    RSyntaxTextArea textArea = new RSyntaxTextArea();
    RTextScrollPane advancedScrollPane = new RTextScrollPane(textArea);
    Toolbar toolbar;
    JPanel userbar = new JPanel();

    /**
     * ��-�� ��������� �����������, ���������������� ������
     * ����� ��� ����� ��� ��������, ��� � ����� ���� �����
     * @param main - ����������-��������� ��� ��������� ���������, �������� ������ 
     * ������, ����������� ��� ������ ������
     */
    public void init(ApplicationFrame main) {
        GridBagLayout advancedLayout = new GridBagLayout();
        toolbar = new Toolbar(textArea, main.navigationPanel);

        //������, ������������ ���������� ��������� ������ ������������ �� ����� � ���� �����
        //p.s. ����� ����������� �������� �� �� ����������
        initalizeTextarea(advancedLayout);
        initalizeToolbar(advancedLayout);
        initalizeUserbar(advancedLayout);

        //����������� ��������� ������
        setPreferredSize(new Dimension(400, 300));
        setFocusable(false);
        setLayout(advancedLayout);

        //�������� ��� ��� ����� �� ������
        add(toolbar);
        add(userbar);
        add(advancedScrollPane);
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    private void initalizeTextarea(GridBagLayout advancedLayout) {
        //<editor-fold defaultstate="collapsed" desc="��� ������� ����������� �������� ����������">
            GridBagConstraints textPanelConstrains = new GridBagConstraints();
            textPanelConstrains.gridx = 0;
            textPanelConstrains.gridy = 1;
            textPanelConstrains.anchor = GridBagConstraints.NORTHWEST;
            textPanelConstrains.fill = GridBagConstraints.BOTH;
            textPanelConstrains.weighty = 0.95;
            textPanelConstrains.weightx = 1;
            textPanelConstrains.gridwidth = 2;
            advancedLayout.addLayoutComponent(advancedScrollPane, textPanelConstrains);
        //</editor-fold>

        textArea.setPreferredSize(new Dimension(400, 300));
        advancedScrollPane.setFocusable(false);
        advancedScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        
        readDefaultTemplate();
    }

    private void initalizeToolbar(GridBagLayout advancedLayout) {
        toolbar.setPreferredSize(new Dimension(300, 30));

        //<editor-fold defaultstate="collapsed" desc="��������� ��������� ����������">
        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        toolbarConstraints.fill = GridBagConstraints.HORIZONTAL;
        toolbarConstraints.weightx = 0.999;
        advancedLayout.addLayoutComponent(toolbar, toolbarConstraints);
        //</editor-fold>

        toolbar.setLayout(new FlowLayout(SwingConstants.WEST, 5, 0));
    }

    private void initalizeUserbar(GridBagLayout advancedLayout) {
        userbar.setPreferredSize(new Dimension(150, 30));
        //<editor-fold defaultstate="collapsed" desc="��������� ��������� ����������">
        GridBagConstraints userbarConstraints = new GridBagConstraints();
        userbarConstraints.gridx = 1;
        userbarConstraints.gridy = 0;
        userbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        userbarConstraints.weightx = 0.001;
        advancedLayout.addLayoutComponent(userbar, userbarConstraints);
        //</editor-fold>
    }

    /**
     * ���������� ��������� �������, ����������� ������ � ��������� ������� 
     */
    private void readDefaultTemplate() {
        //��� �������
        StringBuilder code = new StringBuilder(); 
        BufferedReader reader = null;
        
        //������ ApacheCC
        Configurations configs = new Configurations();
        try {
            //���� �� FileManager ���� � ����� ������������, � ������ ���� � ���������� �������
            PropertiesConfiguration config = configs.properties(FileManagerSingleton.DEFAULT_CONFIG_FILE);
            String defaultTemplate = config.getString("default_template");
            
            //������� ���. ������� � ��������.
            FileReader fileIO = new FileReader(defaultTemplate);
            reader = new BufferedReader(fileIO);
            
            //������ ������
            int c;
            while ((c = reader.read()) != -1) {
                code.append((char)c);
            }
        } catch (ConfigurationException | IOException ex) {
            JOptionPane.showMessageDialog(null, "���!.. ���� �������� ��������");
        }
        
        //������, ���� ������� ��������� ���� ����� - ���������� ���� � TA
        textArea.setText(code.toString());
    }

}
