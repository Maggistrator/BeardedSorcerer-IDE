package logic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Сова
 */
public class FileManager {
    
    private static HashMap<String, File> tempFiles = new HashMap<>();
    private static HashMap<String, File> residentFiles = new HashMap<>();
    
    public static File getFile(String alias){
        System.out.println("Trying to fetch file... "+(tempFiles.containsKey(alias)||residentFiles.containsKey(alias)));
        File file = tempFiles.containsKey(alias) ? tempFiles.get(alias) : residentFiles.get(alias);
        return file;
    }    
    
    public static void addFile(String alias, File file, boolean isTemporary){
        if(isTemporary) tempFiles.put(alias, file);
        else residentFiles.put(alias, file);
    }
    
    public static void createFile(String alias, boolean isTemporary, String path){
            File file = null;
        try {
            file = new File(path);
            System.out.println(file.getAbsoluteFile());
            if(isTemporary) file = File.createTempFile(alias, ".tmp", new File(path));
            if(file != null) tempFiles.put(alias, file);
            System.out.println("File created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка! Файл не создался - вероятно, не хватает прав для записи");
        }
    }
    
    public static void createDir(String alias, boolean isTemporary, String path){
        
    }
    
    public static boolean isTemporary(String alias){
        return tempFiles.containsKey(alias) ? true : false;
    }
    
    public static void resetTempFiles(){
    
    }
    
    
}
