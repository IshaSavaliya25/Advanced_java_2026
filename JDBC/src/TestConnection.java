//Write JDBC program to test connection

import java.sql.DriverManager;//Loads
import java.sql.Connection;// Connection

public class TestConnection
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");//Register the driver class
        String url="jdbc:mysql://localhost:3306/";//create connection
        String user="root";
        String pwd="root";
//        Connection con=DriverManager.getConnection(url,user,pwd);
        Connection con=DriverManager.getConnection(url,"root","");
        if(con!=null)
            System.out.println("connection sucess");
        else
            System.out.println("fail");

        con.close();
    }
}
