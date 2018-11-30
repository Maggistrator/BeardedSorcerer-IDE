package ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import ui.workspace.ProjectTree;
import ui.workspace.Toolbar;
import ui.workspace.WorkingArea;

/**
 * Основное окно программы. 
 * @author Сова
 */
public class ApplicationFrame extends JFrame{

    Toolbar toolbar = new Toolbar();
    WorkingArea workingArea = new WorkingArea();
    ProjectTree projectTree = new ProjectTree();
    
    GridBagLayout advancedLayout = new GridBagLayout();

    public ApplicationFrame() throws HeadlessException {
        super("BeardedSorcerer IDE");

        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        pane.setDividerSize(8);
        pane.setDividerLocation(120);
        pane.setLeftComponent(new JScrollPane(projectTree));
        pane.setRightComponent(workingArea);
        
        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        toolbarConstraints.fill = GridBagConstraints.BOTH;
        toolbarConstraints.weightx = 1.0f;
        toolbarConstraints.weighty = 0.03f;
        advancedLayout.addLayoutComponent(toolbar, toolbarConstraints);
        
        GridBagConstraints workingAreaConstraints = new GridBagConstraints();
        workingAreaConstraints.gridx = 0;
        workingAreaConstraints.gridy = 1;
        workingAreaConstraints.anchor = GridBagConstraints.NORTHWEST;
        workingAreaConstraints.fill = GridBagConstraints.BOTH;
        workingAreaConstraints.weightx = 0.75f;
        workingAreaConstraints.weighty = 0.97f;
        workingAreaConstraints.gridwidth = 2;
        workingAreaConstraints.insets = new Insets(0, 0, 0, 2);
        advancedLayout.addLayoutComponent(pane, workingAreaConstraints);
        
        add(toolbar);
        add(pane);
        
        setLayout(advancedLayout);
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon("sys/magic.png").getImage());
        pack();
        
        setLocationRelativeTo(null);
    }
    
}
