package again;

import java.io.*;
import java.util.Properties;

public class Conn {
    private static Properties properties = new Properties();

//    public static void main(String[] args) {
//        try {
//            InputStream inputStream = new FileInputStream("/Users/benjamin/IdeaProjects/classJDBCPractice/src/main/java/again/db.properties");
//            properties.load(inputStream);
//        }  catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(properties.getProperty("driver"));
//    }

    static {
        try {
            InputStream inputStream = new FileInputStream("/Users/benjamin/IdeaProjects/classJDBCPractice/src/main/java/again/db.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String DRIVER = properties.getProperty("driver");
    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("username");
    public static final String PASSWORD = properties.getProperty("password");

}
