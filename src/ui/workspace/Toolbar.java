package ui.workspace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
/**
 * Панель инструментов.
 * <br>Включает кнопки:
 * <ul>
 * <li>Сохранить
 * <li>Компилировать 
 * <li>Собрать
 * <li>Выполнить
 * </ul>
 * А так же кликабельные иконки с профилями пользователей 
 * @author Сова
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
