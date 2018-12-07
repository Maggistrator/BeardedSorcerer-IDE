package ui.navigation;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import logic.workspace.navigation.TreeViewListener;
import ui.ApplicationFrame;

/**
 * ������ ���������
 * �������� �� ������ ������ � �������� � ���
 * @author ����
 */
public class NavigationPanel extends JPanel{
    
    JTree tree = new JTree();
    JLabel projectLabel = new JLabel("Project");
    NavigationOptionsList navList;
    
    DefaultMutableTreeNode lastEditedFileNode; 

    public void init(ApplicationFrame main) {
        initalizeHeader();
        initalizeLayout();
        setNodes(tree); 
        
        navList = new NavigationOptionsList(main.getTextArea(), this);
        
        add(projectLabel);
        add(tree);
        setFocusable(false);
        
        tree.setPreferredSize(new Dimension(100, 350));
        tree.addMouseListener(new TreeViewListener(navList));
    }
    
    public DefaultMutableTreeNode getLastEditedFileNode(){
        return lastEditedFileNode;
    }
    
    public JTree getNavigationTree() {
        return tree;
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
    
    private void setNodes(JTree tree) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Project");
        DefaultMutableTreeNode defaultPackage = new DefaultMutableTreeNode("default");
        DefaultMutableTreeNode defaultClass = new DefaultMutableTreeNode("MyClass");

        lastEditedFileNode = defaultClass;
        root.add(defaultPackage);
        defaultPackage.add(defaultClass);

        tree.setModel(new DefaultTreeModel(root));
    }

    
}
