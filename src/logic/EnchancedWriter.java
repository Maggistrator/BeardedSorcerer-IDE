package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Сова
 */
public class EnchancedWriter {

    public static void SaveFile(String alias, String data) {
        File file = FileManager.getFile(alias);
        System.out.println("SaveFile called, now file = "+file+" and data="+data);
        SaveFile(file, data);
    }

    public static void SaveFile(File file, String data) {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(data);

            System.out.println("Write successed!");
            bw.close();
        } catch (IOException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Файл не существует, или не хватает прав для сохранения :|");
        }
    }

    public static void SaveProject(File rootDirectory) {

    }

}
