package ui.workspace;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
/**
 * ������ ������������.
 * <br>�������� ������:
 * <ul>
 * <li>���������
 * <li>������������� 
 * <li>�������
 * <li>���������
 * </ul>
 * � ��� �� ������������ ������ � ��������� ������������� 
 * @author ����
*/
public class Toolbar extends JPanel{

    public Toolbar() {
        GridBagLayout layout = new GridBagLayout();
        
        JLabel projectSettings = new JLabel("Project");
        
        setPreferredSize(new Dimension(630, 20));
        setMinimumSize(new Dimension(30, 15));
        setBorder(new BevelBorder(BevelBorder.RAISED));
        setLayout(layout);
    }
    
}
