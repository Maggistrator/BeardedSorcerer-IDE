package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import ui.workspace.NavigationPanel;
import ui.workspace.Toolbar;
import ui.workspace.WorkingArea;

/**
 * Основное окно программы. 
 * @author Сова
 */
public class ApplicationFrame extends JFrame{


    WorkingArea workingArea = new WorkingArea();
    NavigationPanel projectTree = new NavigationPanel();
    
    GridBagLayout advancedLayout = new GridBagLayout();

    public ApplicationFrame() throws HeadlessException {
        super("BeardedSorcerer IDE");

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        pane.setDividerSize(8);
        pane.setDividerLocation(120);
        pane.setLeftComponent(new JScrollPane(projectTree));
        pane.setRightComponent(new JScrollPane(workingArea));

//TODO:починить юзербар с flawlayout
        
        GridBagConstraints splitPaneConstrains = new GridBagConstraints();
        splitPaneConstrains.gridx = 0;
        splitPaneConstrains.gridy = 1;
        splitPaneConstrains.anchor = GridBagConstraints.NORTHWEST;
        splitPaneConstrains.fill = GridBagConstraints.BOTH;
        splitPaneConstrains.weightx = 0.75f;
        splitPaneConstrains.weighty = 0.97f;
        splitPaneConstrains.gridwidth = 3;
        splitPaneConstrains.insets = new Insets(0, 0, 0, 2);
        advancedLayout.addLayoutComponent(pane, splitPaneConstrains);

        add(pane);
        
        setLayout(advancedLayout);
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("sys/magic.png").getImage());
        pack();
        
        setLocationRelativeTo(null);
    }
    
}
