package ui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import logic.workspace.navigation.SaveButtonListener;
import ui.navigation.NavigationPanel;
/**
 * Панель инструментов.
 * <br>Включает кнопки:
 * <ul>
 * <li>Сохранить
 * <li>Компилировать 
 * <li>Собрать
 * <li>Выполнить
 * </ul> 
 * @author Сова
*/
public class Toolbar extends JPanel{

    //кнопка сохранения 
    JButton save = new JButton();
    //кнопка компиляции
    JButton compile = new JButton();
    //кнопка построения проекта
    JButton build = new JButton();
    //кнопка запуска написанного приложения
    JButton run = new JButton();
    
    public Toolbar(JTextArea textArea, NavigationPanel navigation) {
        GridBagLayout layout = new GridBagLayout();
        
        createButtons();
        
        add(save);
        add(compile);
        add(build);
        add(run);
        
        save.addActionListener(new SaveButtonListener(textArea, navigation));
        
        setPreferredSize(new Dimension(630, 20));
        setMinimumSize(new Dimension(30, 30));
        setLayout(layout);
    }
    
    /**
     * настройка кнопок
     * расширяет конструктор
     */
    private void createButtons() {
        //константы размеров кнопок, чтобы гарантировать их однотипность
        final int button_width = 28;
        final int button_height = 28;
        
        //константы размеров иконок, которые увы, не меняют размеров автоматически
        final int icon_width = 15;
        final int icon_height = 15;

        //создание объектов иконок
        ImageIcon floppy = new ImageIcon("sys/icons/save.png");
        ImageIcon gears = new ImageIcon("sys/icons/compile.png");
        ImageIcon hammer = new ImageIcon("sys/icons/build.png");
        ImageIcon playbutton = new ImageIcon("sys/icons/run.png");
        

        //ресайз и установка иконок на кнопки
        save.setIcon(resizepiconline(floppy, icon_width, icon_height));
        compile.setIcon(resizepiconline(gears, icon_width, icon_height));
        build.setIcon(resizepiconline(hammer, icon_width, icon_height));
        run.setIcon(resizepiconline(playbutton, icon_width, icon_height));

        //установка размеров кнопок
        save.setPreferredSize(new Dimension(button_width, button_height));
        compile.setPreferredSize(new Dimension(button_width, button_height));
        build.setPreferredSize(new Dimension(button_width, button_height));
        run.setPreferredSize(new Dimension(button_width, button_height));
    }
    
    /**функция для ресайза иконок*/
    private ImageIcon resizepiconline(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        return icon;
    }
    
}
