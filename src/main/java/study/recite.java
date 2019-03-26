package study;

import java.sql.*;
import java.util.List;

public class recite {

    public static void main(String[] args){
//        select();
        update("Ben", 3000);
    }

    public static void select(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = null;

        String url = "jdbc:mysql://localhost:3306/class_practice?useSSL=false";
        try {
            String sql = "SELECT * FROM employees";
            resultSet = DriverManager.getConnection(url, "root", "123456").
                    prepareStatement(sql).
                    executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getObject(1) + " " + resultSet.getObject(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (resultSet != null){
                resultSet.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(String name, float salary){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE employees SET last_name = " + name + ", salary =" + salary + "WHERE employee_id = 100";
        String url = "jdbc:mysql://localhost:3306/class_practice?useSSL=false";
        try {
            ResultSet resultSet = DriverManager.getConnection(url, "root", "123456")
                    .prepareStatement(sql)
                    .executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getObject(1) + " " + resultSet.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
