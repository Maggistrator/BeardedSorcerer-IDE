package ui.workspace;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;

/**
 * Панель навигации
 * Отвечает за дерево файлов и операции с ним
 * @author Сова
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
     * Настраивает параметры лейбла-заголовка блока
     */
    private void initalizeHeader(){
        projectLabel.setMinimumSize(new Dimension(45, 25));
        projectLabel.setPreferredSize(new Dimension(100, 25));
        projectLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    /**
     * Настраивает менеджера компоновки
     */
    private void initalizeLayout(){
        //создание табличного менеджера
        GridBagLayout advancedLayout = new GridBagLayout();
        setLayout(advancedLayout);

        //параметры дерева
        GridBagConstraints treeConstrains = new GridBagConstraints();
        treeConstrains.gridx = 0;//ячейка по горизонтали
        treeConstrains.gridy = 1;//ячейка по вертикали
        treeConstrains.anchor = GridBagConstraints.NORTHWEST;//привязка
        treeConstrains.fill = GridBagConstraints.BOTH;//заполнение (вроде докера в C#)
        treeConstrains.weighty = 0.90;//процент занимаемого размера по вертикали
        treeConstrains.weightx = 1;//процент занимаемого пространства по горизонтали
        
        advancedLayout.addLayoutComponent(tree, treeConstrains);
    }
}
