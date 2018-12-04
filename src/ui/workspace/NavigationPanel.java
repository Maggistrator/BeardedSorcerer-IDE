package ui.workspace;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;

/**
 * ������ ���������
 * �������� �� ������ ������ � �������� � ���
 * @author ����
 */
public class NavigationPanel extends JPanel{
    JTree tree = new JTree();
    JLabel projectLabel = new JLabel("Project");

    public NavigationPanel() {
        initalizeHeader();
        initalizeLayout();
        tree.setPreferredSize(new Dimension(100, 350));
        add(projectLabel);
        add(tree);
        setFocusable(false);
    }
    
    /**
     * ����������� ��������� ������-��������� �����
     */
    private void initalizeHeader(){
        projectLabel.setMinimumSize(new Dimension(45, 25));
        projectLabel.setPreferredSize(new Dimension(100, 25));
        projectLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    /**
     * ����������� ��������� ����������
     */
    private void initalizeLayout(){
        //�������� ���������� ���������
        GridBagLayout advancedLayout = new GridBagLayout();
        setLayout(advancedLayout);

        //��������� ������
        GridBagConstraints treeConstrains = new GridBagConstraints();
        treeConstrains.gridx = 0;//������ �� �����������
        treeConstrains.gridy = 1;//������ �� ���������
        treeConstrains.anchor = GridBagConstraints.NORTHWEST;//��������
        treeConstrains.fill = GridBagConstraints.BOTH;//���������� (����� ������ � C#)
        treeConstrains.weighty = 0.90;//������� ����������� ������� �� ���������
        treeConstrains.weightx = 1;//������� ����������� ������������ �� �����������
        
        advancedLayout.addLayoutComponent(tree, treeConstrains);
    }
}
