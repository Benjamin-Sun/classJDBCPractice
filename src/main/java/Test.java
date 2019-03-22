import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       /* Employees e=new Employees();
        e.setEmployee_id(302);
        e.setFirst_name("li");
        e.setSalary(new BigDecimal(8000));
        int i=insert(e);*/
       /*int i=delete(302);
        System.out.println("影响的行数为："+i);*/

     /*  List<Employees> lists=getAll();
       for(Employees e:lists){
           System.out.println(e);
       }*/
        System.out.println(getOne(198));

    }

    public static Employees getOne(int id){
        String sql="select * from employees where employee_id=?";
        List<Employees> lists=QueryUpdate.query(sql, new ResultSetObject<Employees>() {
            @Override
            public Employees getResultSetOne(ResultSet resultSet) throws SQLException {
                Employees e=new Employees();
                e.setEmployee_id(resultSet.getInt("employee_id"));
                e.setFirst_name(resultSet.getString("first_name"));
                e.setLast_name(resultSet.getString("last_name"));
                e.setEmail(resultSet.getString("email"));
                e.setSalary(resultSet.getBigDecimal("salary"));
                e.setHire_date(resultSet.getDate("hire_date"));
                e.setJob_id(resultSet.getString("job_id"));
                e.setPhone_number(resultSet.getString("phone_number"));
                e.setDepartment_id(resultSet.getInt("department_id"));
                e.setManager_id(resultSet.getInt("manager_id"));
                return e;
            }
        },id);
        if(lists==null){
            return null;
        }
        return lists.get(0);
    }


    public static List<Employees> getAll(){
        String sql="select * from employees";
        List<Employees> lists=QueryUpdate.query(sql, new ResultSetObject<Employees>() {
            @Override
            public Employees getResultSetOne(ResultSet resultSet) throws SQLException {
                Employees e=new Employees();
                e.setEmployee_id(resultSet.getInt("employee_id"));
                e.setFirst_name(resultSet.getString("first_name"));
                e.setLast_name(resultSet.getString("last_name"));
                e.setEmail(resultSet.getString("email"));
                e.setSalary(resultSet.getBigDecimal("salary"));
                e.setHire_date(resultSet.getDate("hire_date"));
                e.setJob_id(resultSet.getString("job_id"));
                e.setPhone_number(resultSet.getString("phone_number"));
                e.setDepartment_id(resultSet.getInt("department_id"));
                e.setManager_id(resultSet.getInt("manager_id"));
                return e;
            }
        });
        return lists;
    }






    public static int insert(Employees e){
        String sql="insert into employees(employee_id,first_name,salary) values(?,?,?)";
        return QueryUpdate.update(sql,e.getEmployee_id(),e.getFirst_name(),e.getSalary());
    }

    public static int delete(int id){
        String sql="delete from employees where employee_id=?";
        return QueryUpdate.update(sql,id);

    }

}
