package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
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

    public void init(ApplicationFrame main) {
        GridBagLayout advancedLayout = new GridBagLayout();
        toolbar = new Toolbar(textArea, main.navigationPanel);

        initalizeTextarea(advancedLayout);
        initalizeToolbar(advancedLayout);
        initalizeUserbar(advancedLayout);

        setPreferredSize(new Dimension(400, 300));
        setFocusable(false);
        setLayout(advancedLayout);

        add(toolbar);
        add(userbar);
        add(advancedScrollPane);
    }
    
    public JTextArea getTextArea() {
        return textArea;
    }

    private void initalizeTextarea(GridBagLayout advancedLayout) {
        GridBagConstraints textPanelConstrains = new GridBagConstraints();
        textPanelConstrains.gridx = 0;
        textPanelConstrains.gridy = 1;
        textPanelConstrains.anchor = GridBagConstraints.NORTHWEST;
        textPanelConstrains.fill = GridBagConstraints.BOTH;
        textPanelConstrains.weighty = 0.95;
        textPanelConstrains.weightx = 1;
        textPanelConstrains.gridwidth = 2;
        advancedLayout.addLayoutComponent(advancedScrollPane, textPanelConstrains);

        textArea.setPreferredSize(new Dimension(400, 300));
        advancedScrollPane.setFocusable(false);
        advancedScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        textArea.setCodeFoldingEnabled(true);
    }

    private void initalizeToolbar(GridBagLayout advancedLayout) {
        toolbar.setPreferredSize(new Dimension(300, 30));

        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        toolbarConstraints.fill = GridBagConstraints.HORIZONTAL;
        toolbarConstraints.weightx = 0.999;
        advancedLayout.addLayoutComponent(toolbar, toolbarConstraints);
        
        toolbar.setLayout(new FlowLayout(SwingConstants.WEST, 5, 0));
    }

    private void initalizeUserbar(GridBagLayout advancedLayout) {
        userbar.setPreferredSize(new Dimension(150, 30));

        GridBagConstraints userbarConstraints = new GridBagConstraints();
        userbarConstraints.gridx = 1;
        userbarConstraints.gridy = 0;
        userbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        userbarConstraints.weightx = 0.001;
        advancedLayout.addLayoutComponent(userbar, userbarConstraints);
    }

    
}
