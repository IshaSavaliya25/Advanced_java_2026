import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class StudentService {
    private Connection conn;
    StudentService(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teststud", "root", "");
        }
        catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    public void addStudent(Student student){
        try{
            Statement stmt=conn.createStatement();
            String query="insert into student_tbl(stu_name,stu_addr) value ('"+ student.getName()+"','"+student.getAddress()+"')";
            stmt.executeUpdate(query);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
