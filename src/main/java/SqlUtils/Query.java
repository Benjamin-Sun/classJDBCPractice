package SqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query {
    public static <T> List<T> query(String sql, ResultSetObject<T> resultSetObject, Object ...objects) throws SQLException {
        Connection connection = Util.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            ps = connection.prepareStatement(sql);
            Util.insertParam(ps, objects);
            rs = ps.executeQuery();

            while (rs.next()){
                T t = resultSetObject.getResult(rs);
                list.add(t);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            Util.close(rs, ps, connection);
        }
        if(list == null|| list.size() == 0){
            return null;
        }
        return list;
    }

    public static int update(String sql,Object ...objs) throws SQLException {
        Connection connection=null;
        PreparedStatement pstm=null;
        int i=-1;
        connection=Util.getConn();
        try {
            pstm=connection.prepareStatement(sql);
            Util.insertParam(pstm,objs);
            i=    pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Util.close(pstm,connection);
        }
        return i;

    }
}
