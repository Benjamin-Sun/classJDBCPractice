package study;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParamCon {
    private static Properties properties=new Properties();

    static {
        InputStream is=ParamCon.class.getClassLoader().getResourceAsStream("study/db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  /*  public static void main(String[] args) {
        try {
            //1:io实现文件流
           *//* InputStream is=new FileInputStream("db.properties");*//*
           //2：反射实现文件流
            InputStream is=ParamCon.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(is);
            System.out.println(properties.getProperty("driver"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static final String DRIVER=properties.getProperty("driver");
    public static final String URL=properties.getProperty("url");
    public static final String USERNAME=properties.getProperty("username");
    public static final String PASSWORD=properties.getProperty("password");


}
