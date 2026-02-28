//Create a table
import java.sql.DriverManager;//Loads
import java.sql.Connection;// Connection
import java.sql.Statement;
public class insertDB
{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//1. Register the driver class
        String url = "jdbc:mysql://localhost:3306/productdb";//2. create connection
        String pwd = "root";
        Connection con = DriverManager.getConnection(url, "root", "");
        String query = "create table product(ID int," + "pname varchar(30),price int)";//3. Create query
        Statement st = con.createStatement();
        if (st.execute(query))//4. Execute Query
            System.out.println("Table Created");
        con.close();//colse the quary
        st.close();
    }
}
