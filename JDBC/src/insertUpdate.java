import java.io.IOException;
import java.sql.*;

public class insertUpdate
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");//1. Register the driver class
        String url = "jdbc:mysql://localhost:3306/productdb";//2. create connection
        String pwd = "root";
        Connection con = DriverManager.getConnection(url, "root", "");
        String Query="insert into product values(101,'mobile',10000)";
        Statement st=con.createStatement();
            int i=st.executeUpdate(Query);
            if(i>0) {
                System.out.println("record inserted");
            }
            else {
                System.out.println("Check sql syntex");
            }
            con.close();
            st.close();
    }

}
