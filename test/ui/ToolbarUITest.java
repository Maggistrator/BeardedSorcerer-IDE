package ui;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Сова
 */
public class ToolbarUITest {
    
    @Test
    /**Проверка на существование иконок на*/
    public void toolbarButtonsIconsExists() {
        File floppyicon = new File("sys/icons/save.png");
        File gearsicon = new File("sys/icons/compile.png");
        File hammericon = new File("sys/icons/build.png");
        File playbuttonicon = new File("sys/icons/run.png");

        assertTrue(floppyicon.exists());
        assertTrue(gearsicon.exists());
        assertTrue(hammericon.exists());
        assertTrue(playbuttonicon.exists());
    }

}
