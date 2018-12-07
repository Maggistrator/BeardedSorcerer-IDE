package logic.workspace.navigation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;
import logic.EnchancedWriter;
import ui.navigation.NavigationPanel;

/**
 *
 * @author Сова
 */
public class PopupSaveListener extends MouseAdapter{
        
    JTextArea dataSource;
    NavigationPanel navigation;

    public PopupSaveListener(JTextArea dataSource, NavigationPanel navigation) {
        this.dataSource = dataSource;
        this.navigation = navigation;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        DefaultMutableTreeNode selectedNode = navigation.getLastEditedFileNode(); 
   
        String filename = (String) selectedNode.getUserObject();
        EnchancedWriter.SaveFile(filename, dataSource.getText());
        
        System.out.println("Listener called with filename = "+filename+" and data="+dataSource.getText());
    }

}
