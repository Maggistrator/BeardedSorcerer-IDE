package ui.workspace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
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
        setMinimumSize(new Dimension(30, 30));
        setBorder(new LineBorder(Color.gray));
        setLayout(layout);
    }
    
}
