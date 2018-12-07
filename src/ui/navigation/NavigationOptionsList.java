package ui.navigation;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTree;
import logic.workspace.navigation.PopupSaveListener;
import ui.WorkingArea;

/**
 * Всплывающее меню, меняющееся в зависимости от настраиваемого элемента
 * навигационной панели
 *
 * @author Сова
 */
public class NavigationOptionsList extends JPopupMenu {

    JMenuItem saveResidentFile = new JMenuItem("Сохранить");
    JMenuItem saveTemporaryFile = new JMenuItem("Сохранить на диск");
    JMenuItem saveProject = new JMenuItem("Сохранить проект");
    JMenuItem rename = new JMenuItem("Переименовать");
    JMenuItem delete = new JMenuItem("Удалить");
    JMenuItem newFile = new JMenuItem("Создать файл");
    JMenuItem newPackage = new JMenuItem("Создать пакет");
    JMenuItem openProject = new JMenuItem("Открыть папку исходных кодов");
    JMenuItem projectSettings = new JMenuItem("Настройки проекта");

    public NavigationOptionsList(JTextArea workingArea, NavigationPanel navigation) {
        saveResidentFile.addMouseListener(new PopupSaveListener(workingArea, navigation));
        saveTemporaryFile.addMouseListener(new PopupSaveListener(workingArea, navigation));
        //saveProject.addMouseListener();
    }

    public void setTempFileKit() {
        removeAll();
        add(rename);
        add(saveTemporaryFile);
        add(delete);
    }

    public void setResidentFileKit() {
        removeAll();
        add(rename);
        add(saveResidentFile);
        add(delete);
    }

    public void setDirectoryKit() {
        removeAll();
        add(newFile);
        add(rename);
        add(delete);
    }

    public void setProjectKit() {
        removeAll();
        add(newPackage);
        add(openProject);
        add(saveProject);
        add(projectSettings);
        add(rename);
    }

}
