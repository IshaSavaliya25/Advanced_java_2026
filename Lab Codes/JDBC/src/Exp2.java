import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exp2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//1. Register the driver class
        String url = "jdbc:mysql://localhost:3306/studentdb";//2. create connection
        String pwd = "root";
        Connection con = DriverManager.getConnection(url, "root", "");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First name");
        String fname = sc.nextLine();

        System.out.println("Enter Surname");
        String sname = sc.nextLine();

        System.out.println("Enter Email");
        String email = sc.nextLine();

        String Query = "insert into student values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, fname);
        ps.setString(2, sname);
        ps.setString(3, email);

        int i = ps.executeUpdate();
        if (i > 0)
            System.out.print("Record added");
        else
            System.out.print("Fail to add Record");

        //To fetch the record from database
        String Query1="select * from student";
        PreparedStatement ps1=con.prepareStatement(Query1);
        ResultSet rs=ps1.executeQuery();
        System.out.println("\n---- Student Records ----");

        while (rs.next()) {
            String firstName = rs.getString(1);
            String surName = rs.getString(2);
            String mail = rs.getString(3);

            System.out.println("First Name: " + firstName);
            System.out.println("Surname: " + surName);
            System.out.println("Email: " + mail);
            System.out.println("-------------------------");
        }

        rs.close();
        ps.close();
        ps1.close();
        con.close();
        sc.close();
    }
}
