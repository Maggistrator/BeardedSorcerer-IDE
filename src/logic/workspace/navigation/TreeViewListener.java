package logic.workspace.navigation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import logic.FileManagerSingleton;
import ui.navigation.NavigationOptionsList;

/**
 * @author Сова
 */
public class TreeViewListener extends MouseAdapter {

    NavigationOptionsList navList;

    public TreeViewListener(NavigationOptionsList list) {
        navList = list;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            DefaultMutableTreeNode selected = null;
            JTree source = null;
            try {
                source = (JTree) e.getSource();
                TreePath path = source.getPathForLocation(e.getX(), e.getY());
                selected = (DefaultMutableTreeNode) path.getLastPathComponent();
            } catch (Exception ex) {
                System.err.println("Выбран невалидный объект дерева!\n" + ex.getMessage());
            }
            if (selected == null) {
                return;
            }

            if(selected.isLeaf()){
                if(FileManagerSingleton.getInstance().isTemporary((String) selected.getUserObject())){
                    navList.setTempFileKit();
                }else{
                    navList.setResidentFileKit();
                }
            } else if (selected.isRoot()) {
                navList.setProjectKit();
            } else {
                navList.setDirectoryKit();
            }
            navList.show(source, e.getX(), e.getY());
        }
    }

}
