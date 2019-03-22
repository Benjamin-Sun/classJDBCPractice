import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetObject<T> {
    T getResultSetOne(ResultSet resultSet) throws SQLException;

}
