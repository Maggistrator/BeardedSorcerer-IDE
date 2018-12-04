package ui.workspace;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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
    Toolbar toolbar = new Toolbar();
    JPanel userbar = new JPanel();

    JButton save = new JButton();
    JButton compile = new JButton();
    JButton build = new JButton();
    JButton run = new JButton();

    public WorkingArea() {
        GridBagLayout advancedLayout = new GridBagLayout();

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
        toolbar.setBorder(new LineBorder(Color.black));

        GridBagConstraints toolbarConstraints = new GridBagConstraints();
        toolbarConstraints.gridx = 0;
        toolbarConstraints.gridy = 0;
        toolbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        toolbarConstraints.fill = GridBagConstraints.HORIZONTAL;
        toolbarConstraints.weightx = 0.999;
        advancedLayout.addLayoutComponent(toolbar, toolbarConstraints);
        
        createButtons();
        toolbar.add(save);
        toolbar.add(compile);
        toolbar.add(build);
        toolbar.add(run);
        
        toolbar.setLayout(new FlowLayout(SwingConstants.WEST, 5, 0));
    }

    private void initalizeUserbar(GridBagLayout advancedLayout) {
        userbar.setPreferredSize(new Dimension(150, 30));
        userbar.setBorder(new LineBorder(Color.black));

        GridBagConstraints userbarConstraints = new GridBagConstraints();
        userbarConstraints.gridx = 1;
        userbarConstraints.gridy = 0;
        userbarConstraints.anchor = GridBagConstraints.NORTHWEST;
        userbarConstraints.weightx = 0.001;
        advancedLayout.addLayoutComponent(userbar, userbarConstraints);
    }

    private void createButtons() {
        int button_width = 28;
        int button_height = 28;
        
        int icon_width = 15;
        int icon_height = 15;
        
        ImageIcon floppy = new ImageIcon("sys/icons/save.png");
        ImageIcon gears = new ImageIcon("sys/icons/compile.png");
        ImageIcon hammer = new ImageIcon("sys/icons/build.png");
        ImageIcon playbutton = new ImageIcon("sys/icons/run.png");

        save.setIcon(resizepiconline(floppy, icon_width, icon_height));
        compile.setIcon(resizepiconline(gears, icon_width, icon_height));
        build.setIcon(resizepiconline(hammer, icon_width, icon_height));
        run.setIcon(resizepiconline(playbutton, icon_width, icon_height));

        save.setPreferredSize(new Dimension(button_width, button_height));
        compile.setPreferredSize(new Dimension(button_width, button_height));
        build.setPreferredSize(new Dimension(button_width, button_height));
        run.setPreferredSize(new Dimension(button_width, button_height));
        
        save.setLocation(200, 0);
    }
    
    private ImageIcon resizepiconline(ImageIcon icon, int width, int height){
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH) ;  
        icon = new ImageIcon( newimg );
        return icon;
    }
    
}
