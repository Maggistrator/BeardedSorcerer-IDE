package logic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Сова
 */
public class FileManagerSingleton {
    public static final String DEFAULT_TEMP_PATH = "temp";
    public static final File DEFAULT_CONFIG_FILE = new File("sys/recepy_of_immortality.properties");
    
    private static FileManagerSingleton instance = new FileManagerSingleton();

    private FileManagerSingleton() {}
   
    private static HashMap<String, File> tempFiles = new HashMap<>();
    private static HashMap<String, File> residentFiles = new HashMap<>();
 
    public static FileManagerSingleton getInstance(){
        return instance;
    }
    
    public File getFile(String alias){
        System.out.println("Trying to fetch file... "+(tempFiles.containsKey(alias)||residentFiles.containsKey(alias)));
        File file = tempFiles.containsKey(alias) ? tempFiles.get(alias) : residentFiles.get(alias);
        return file;
    }    
    
    public void addFile(String alias, File file, boolean isTemporary){
        if(isTemporary) tempFiles.put(alias, file);
        else residentFiles.put(alias, file);
    }
    
    public void createTempFile(String alias, String path){
        try {
            File file = new File(path);
            file = File.createTempFile(alias, ".java", new File(path));
            if(file != null) tempFiles.put(alias, file);
            System.out.println("File created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка! Файл не создался - вероятно, не хватает прав для записи");
        }
    }

    public void createResidentFile(String alias, String path){
        try {
            File directories = new File(path);
            directories.mkdirs();
            File file = new File(path+alias+".java");
            file.createNewFile();
            residentFiles.put(alias, file);
            System.out.println("File created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка! Файл не создался - вероятно, не хватает прав для записи");
        }
    }
    
    public void createDir(String alias, boolean isTemporary, String path){
        
    }
    
    public boolean isTemporary(String alias){
        return tempFiles.containsKey(alias) ? true : false;
    }
    
    public void resetTempFiles(){
        tempFiles.forEach((key, value) -> {
            if(value.delete()){
            System.out.println(key+" File deleted");
        }else System.out.println("File "+key+" doesn't exists");
        });
    }
    
}