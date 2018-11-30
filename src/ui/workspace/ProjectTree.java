package ui.workspace;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTree;

/**
 * @author Сова
 */
public class ProjectTree extends JTree{

    public ProjectTree() {
        setPreferredSize(new Dimension(100, 380));
        setFocusable(false);
        setFont(new Font("Courier New", Font.PLAIN, 12));
    }
    
}
