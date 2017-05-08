import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mm on 2017/5/3.
 */
public class PropertiesTest {

    public Properties getProp(){
        InputStream is = this.getClass().getResourceAsStream("dbconfig.properties");
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }


    public static void main(String[] args) {
        PropertiesTest pt  = new PropertiesTest();
        Properties p = pt.getProp();
        String url = p.get("jdbc.url").toString();
        System.out.println(url);
        String username = p.get("jdbc.username").toString();
        System.out.println(username);
        String password = p.get("jdbc.password").toString();
        System.out.println(password);
    }
}
