package study;

import java.sql.*;

public class Util {
    //驱动，到了4.0之后，可以自动加载，但是只能应用于api，网站应用的时候，不能省
    static {
        try {
            Class.forName(ParamCon.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(ParamCon.URL,ParamCon.USERNAME,ParamCon.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //向PreparedStatement对象中添加数值的封装
    public static void insertValuesToPreparedStatement(PreparedStatement pstm, Object ...objs){
        if(objs!=null&& objs.length>0) {
            try {
                for (int i = 0; i < objs.length; i++) {
                    pstm.setObject(i + 1, objs[i]);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }




    //6:关闭

    /**
     *
     * @param objects：可变数组
     */
    public static void close(Object ...objects){
        if(objects!=null && objects.length>0){
            try{
                for(Object obj:objects){
                    if(obj!=null){
                        if(obj instanceof Connection){
                            ((Connection)obj).close();
                        }
                        if(obj instanceof Statement){
                            ((Statement)obj).close();
                        }
                        if(obj instanceof ResultSet){
                            ((ResultSet)obj).close();
                        }

                    }

                }


            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

   /* public static void main(String[] args) {
        System.out.println(getConn());
    }*/

}
