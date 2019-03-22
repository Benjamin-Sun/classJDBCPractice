import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryUpdate {
    /**
     * 1:查询的结果有多少条
     *    没有  一条， 多条
     *    返回类型 List
     *     因为没有办法确定返回中的对象类型，---泛型方法  <T> List<T>
     *  2：输入的信息
     *     参数：1）sql== String sql
     *           2） 值=== Object ... objs
     *           3)用来处理对象
     */

    public static <T> List<T> query(String sql, ResultSetObject<T> resultSetObject, Object ...objs){
        Connection connection=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;

        List<T> lists=new ArrayList<>();
        connection= Util.getConn();

        try {
            pstm=connection.prepareStatement(sql);
            Util.insertValuesToPreparedStatement(pstm,objs);
            rs=pstm.executeQuery();
            while(rs.next()){
                T t=resultSetObject.getResultSetOne(rs);
                lists.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Util.close(rs,pstm,connection);
        }
        /*
         * 没有数据的时候返回null
         * */
        if(lists==null|| lists.size()==0){
            return null;
        }
        return lists;
    }

    /**
     *  实现insert、delete、udpate三个功能
     *  参数：1：sql语句=== String sql
     *        2：值==== 类型和数量不定，所以 可变数组=== Object ...objs
     *
     * @return
     */
    public static int update(String sql,Object ...objs){
        Connection connection=null;
        PreparedStatement pstm=null;
        int i=-1;
        connection=Util.getConn();
        try {
            pstm=connection.prepareStatement(sql);
            Util.insertValuesToPreparedStatement(pstm,objs);
            i=    pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Util.close(pstm,connection);
        }
        return i;

    }
}
