package ui.workspace;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 * @author Сова
 */
public class WorkingArea extends JScrollPane{

    public WorkingArea() {
        setPreferredSize(new Dimension(400,300));
        //setBorder(new LineBorder(Color.black));
    }
    
}
