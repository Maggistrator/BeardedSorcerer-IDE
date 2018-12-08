package logic.workspace.toolbar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;
import logic.CompilationUnit;
import logic.CompilationUnit.CompilationOutput;
import logic.EnchancedWriter;
import logic.FileManagerSingleton;
import ui.navigation.NavigationPanel;

/**
 *
 * @author Сова
 */
public class CompileButtonListener implements ActionListener{
    
    private NavigationPanel navigation;
    private JTextArea dataSource;

    public CompileButtonListener(JTextArea dataSource, NavigationPanel navigation) {
        this.dataSource = dataSource;
        this.navigation = navigation;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) navigation.getLastEditedFileNode(); 
        String filename = (String) selectedNode.getUserObject();
        File file = FileManagerSingleton.getInstance().getFile(filename);
        
        new EnchancedWriter().SaveFile(filename, dataSource.getText());

        CompilationUnit compilator = new CompilationUnit(file);
        CompilationOutput c = compilator.compile();
    }    
}
