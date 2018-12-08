package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.workspace.toolbar.CompileButtonListener;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * Класс, отвечающий за компиляцию.
 * Он компилирует файл исходного кода, и возвращает код, и стандартный поток вывода.
 * @author Сова
 */
public class CompilationUnit {

    String PATH;
    File source;

    public CompilationUnit(File source) {
        this.source = source;
        readPATH();
    }
    
    public class CompilationOutput{
        public int code;
        public String outputMessage;
    }

    public CompilationOutput compile(){ 
        CompilationOutput output = new CompilationOutput();
        
        try {
            ProcessBuilder builder = new ProcessBuilder(PATH, source.getName());

            File templates = new File("C:/Users/Сова/Documents/NetBeansProjects/BeardedSorcerer_IDE/sys/templates");
            builder.directory(new File(FileManagerSingleton.DEFAULT_TEMP_PATH));

            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            builder.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process p = builder.start();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Компиляция не удалась :с");
        }
        
        return output;
    }
    
    /**
     * Выделенная функция для получения пути к компилятору пр помощи ApacheCommonConfigurations
     */
    private void readPATH() {
        Configurations configs = new Configurations();
        try {
            PropertiesConfiguration config = configs.properties(FileManagerSingleton.DEFAULT_CONFIG_FILE);
            PATH = config.getString("PATH");
        } catch (ConfigurationException ex) {
            JOptionPane.showMessageDialog(null, "Упс!.. Файл настроек повреждён");
        }
    }
    
    private Thread cock(Process process, StringBuilder builder) {
        Thread readStream = new Thread();
        Runnable rn = new Runnable() {

            @Override
            public void run() {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                        if (!process.isAlive()) {
                            readStream.interrupt();
                            System.out.println("Output finished!");
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CompilationUnit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        return readStream;
    }
}
