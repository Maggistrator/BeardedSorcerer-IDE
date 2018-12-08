package logic;

/**
 *
 * @author ����
 */
public class NotiferSingleton {

    private NotiferSingleton instance = new NotiferSingleton();
    
    private NotiferSingleton() {
    }
    
    private NotiferSingleton getInstance(){
        return instance;
    }
    
}
