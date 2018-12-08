package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import logic.FileManagerSingleton;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Рабочая область, включающая текстовую область, тулбар, и панель пользователей
 *
 * @author Сова
 */
public class WorkingArea extends JPanel {

    RSyntaxTextArea textArea = new RSyntaxTextArea();
    RTextScrollPane advancedScrollPane = new RTextScrollPane(textArea);
    Toolbar toolbar;
    JPanel userbar = new JPanel();

    /**
     * Из-за специфики архитектуры, инициализировать объект
     * нужно уже после его создания, чем и занят этот метод
     * @param main - переменная-контейнер для элементов навигации, хранящих важные 
     * данные, необходимые для работы логики
     */
    public void init(ApplicationFrame main) {
        GridBagLayout advancedLayout = new GridBagLayout();
        toolbar = new Toolbar(textArea, main.navigationPanel);

        //методы, занимающиеся настройкой элементов панели относительно неё самой и друг друга
        //p.s. иначе конструктор разросся бы до безобразия
        initalizeTextarea(advancedLayout);
        initalizeToolbar(advancedLayout);
        initalizeUserbar(advancedLayout);

        //настраиваем параметры панели
        setPreferredSize(new Dimension(400, 300));
        setFocusable(false);
        setLayout(advancedLayout);

        //дбавляем всю эту дрянь на панель
        add(toolbar);
        add(userbar);
        add(advancedScrollPane);
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    private void initalizeTextarea(GridBagLayout advancedLayout) {
        //<editor-fold defaultstate="collapsed" desc="эта колбаса настраивает менеджер компоновки">
            GridBagConstraints textPanelConstrains = new GridBagConstraints();
            textPanelConstrains.gridx = 0;
            textPanelConstrains.gridy = 1;
            textPanelConstrains.anchor = GridBagConstraints.NORTHWEST;
            textPanelConstrains.fill = GridBagConstraints.BOTH;
            textPanelConstrains.weighty = 0.95;
            textPanelConstrains.weightx = 1;
            textPanelConstrains.gridwidth = 2;
            advancedLayout.addLayoutComponent(advancedScrollPane, textPanelConstrains);
        //</editor-fold>

        textArea.setPreferredSize(new Dimension(400, 300));
        advancedScrollPane.setFocusable(false);
        advancedScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
        
        readDefaultTemplate();
    }

    private void initalizeToolbar(GridBagLayout advancedLayout) {
        toolbar.setPreferredSize(new Dimension(300, 30));

        //<editor-fold defaultstate="collapsed" desc="настройка менеджера компоновки">
        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        toolbarConstraints.fill = GridBagConstraints.HORIZONTAL;
        toolbarConstraints.weightx = 0.999;
        advancedLayout.addLayoutComponent(toolbar, toolbarConstraints);
        //</editor-fold>

        toolbar.setLayout(new FlowLayout(SwingConstants.WEST, 5, 0));
    }

    private void initalizeUserbar(GridBagLayout advancedLayout) {
        userbar.setPreferredSize(new Dimension(150, 30));
        //<editor-fold defaultstate="collapsed" desc="настройка менеджера компоновки">
        GridBagConstraints userbarConstraints = new GridBagConstraints();
        userbarConstraints.gridx = 1;
        userbarConstraints.gridy = 0;
        userbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        userbarConstraints.weightx = 0.001;
        advancedLayout.addLayoutComponent(userbar, userbarConstraints);
        //</editor-fold>
    }

    /**
     * Специально обученная функция, считывающая шаблон в текстовую область 
     */
    private void readDefaultTemplate() {
        //код шаблона
        StringBuilder code = new StringBuilder(); 
        BufferedReader reader = null;
        
        //объект ApacheCC
        Configurations configs = new Configurations();
        try {
            //берём из FileManager путь к файлу конфигурации, и читаем путь к дефолтному шаблону
            PropertiesConfiguration config = configs.properties(FileManagerSingleton.DEFAULT_CONFIG_FILE);
            String defaultTemplate = config.getString("default_template");
            
            //типовой код. шаманим с потоками.
            FileReader fileIO = new FileReader(defaultTemplate);
            reader = new BufferedReader(fileIO);
            
            //читаем шаблон
            int c;
            while ((c = reader.read()) != -1) {
                code.append((char)c);
            }
        } catch (ConfigurationException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Упс!.. Файл настроек повреждён");
        }
        
        //строка, ради которой затевался весь метод - присвоение кода в TA
        textArea.setText(code.toString());
    }

}
