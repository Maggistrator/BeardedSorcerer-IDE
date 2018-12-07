package ui.navigation;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTree;
import logic.workspace.navigation.PopupSaveListener;
import ui.WorkingArea;

/**
 * ����������� ����, ���������� � ����������� �� �������������� ��������
 * ������������� ������
 *
 * @author ����
 */
public class NavigationOptionsList extends JPopupMenu {

    JMenuItem saveResidentFile = new JMenuItem("���������");
    JMenuItem saveTemporaryFile = new JMenuItem("��������� �� ����");
    JMenuItem saveProject = new JMenuItem("��������� ������");
    JMenuItem rename = new JMenuItem("�������������");
    JMenuItem delete = new JMenuItem("�������");
    JMenuItem newFile = new JMenuItem("������� ����");
    JMenuItem newPackage = new JMenuItem("������� �����");
    JMenuItem openProject = new JMenuItem("������� ����� �������� �����");
    JMenuItem projectSettings = new JMenuItem("��������� �������");

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
