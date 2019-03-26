package again;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Conn {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream inputStream = new FileInputStream("db.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static final String DRIVER = properties.getProperty("driver");
    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("username");
    public static final String PASSWORD = properties.getProperty("password");

}
