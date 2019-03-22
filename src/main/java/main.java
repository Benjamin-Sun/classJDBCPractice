import java.sql.*;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        jdbcCon();
    }

    public static void jdbcCon(){
        /**
         * jdbc连接
         * 1.加载驱动
         * 2.连接数据库
         * 3.执行sql语句
         * 4.处理结果集
         * 5.自动提交
         * 6.关闭
         */

        //1、
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2、
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:mysql://localhost:3306/class_practice?useSSL=false";
        try {
            connection = DriverManager.getConnection(url, "root", "123456");
            //3、
            String sql = "SELECT * FROM employees;";
            //预编译sql
            preparedStatement = connection.prepareStatement(sql);
            //4、
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getObject(1) + " " + resultSet.getObject("salary"));
            }
            //5、
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //6、
        try {
            if (resultSet != null){
                resultSet.close();
            }

            if (preparedStatement != null){
                preparedStatement.close();
            }

            if (connection != null){
                connection.close();
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
