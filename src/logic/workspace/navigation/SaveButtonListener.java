package logic.workspace.navigation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;
import logic.EnchancedWriter;
import ui.navigation.NavigationPanel;

/**
 *
 * @author Сова
 */
public class SaveButtonListener implements ActionListener{
        
    JTextArea dataSource;
    private final NavigationPanel navigation;

    public SaveButtonListener(JTextArea dataSource, NavigationPanel navigation) {
        this.dataSource = dataSource;
        this.navigation = navigation;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {   
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) navigation.getLastEditedFileNode(); 
   
        String filename = (String) selectedNode.getUserObject();
        EnchancedWriter.SaveFile(filename, dataSource.getText());
        
        System.out.println("Listener called with filename = "+filename+" and data="+dataSource.getText());
    }
}
