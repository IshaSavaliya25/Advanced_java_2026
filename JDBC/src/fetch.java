import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class fetch
{
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//1. Register the driver class
        String url = "jdbc:mysql://localhost:3306/productdb";//2. create connection
        String pwd = "root";
        Connection con = DriverManager.getConnection(url, "root", "");
        String Query="select * from product";
        Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(Query);
            System.out.println("SrNo ID   pname   price");
            int r=1;
            while(rs.next()){
                System.out.print(r+" ");
                System.out.print(rs.getInt("ID")+" ");
                System.out.print(rs.getString("pname")+" ");
//                System.out.print(rs.getInt("price"+" "));
                System.out.println(" ");
                r++;
            }
            rs.close();
            con.close();
            st.close();
    }
}
