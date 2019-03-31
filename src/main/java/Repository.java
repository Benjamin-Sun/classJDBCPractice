import SqlUtils.Query;
import SqlUtils.ResultSetObject;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Repository {

    public static List<Student> getAll() throws SQLException {
        String sql = "SELECT * FROM student";
        List<Student> list = Query.query(sql, new ResultSetObject<Student>() {
            @Override
            public Student getResult(ResultSet resultSet) throws SQLException {
                Student student = new Student();
                student.setSno(resultSet.getInt("Sno"));
                student.setSname(resultSet.getString("Sname"));
                student.setSage(resultSet.getInt("Sage"));
                student.setSsex(resultSet.getString("Ssex"));
                student.setSdept(resultSet.getString("Sdept"));
                return student;
            }
        });
        return list;
    }

    public static int delete(int id) throws SQLException {
        String sql="delete from employees where employee_id=?";
        return Query.update(sql,id);
    }
}
