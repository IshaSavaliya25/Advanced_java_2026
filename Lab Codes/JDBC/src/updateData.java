// write a JDBC program ,which update user email ID based on their firstname, after record update,display record on screen

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class updateData {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/studentdb";
        Connection con = DriverManager.getConnection(url, "root", "");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name of user whose email ID need to be updated");
        String fname = sc.nextLine();

        System.out.println("Enter new emain ID");
        String updated_email = sc.nextLine();

        String Query = "update student set email=? where firstname=?";
        PreparedStatement ps = con.prepareStatement(Query);
        ps.setString(1, updated_email);
        ps.setString(2, fname);

        int i = ps.executeUpdate();
        if (i > 0)
            System.out.println("Your email ID updated");
        else
            System.out.println("Your record doesn't exist in database");

        // -------- Display After Update --------
        String Query1 = "select * from student";
        PreparedStatement ps1 = con.prepareStatement(Query1);
        ResultSet rs = ps1.executeQuery();

        System.out.println("\n---- Records After Update ----");

        while (rs.next()) {
            String email = rs.getString(1);
            String firstName = rs.getString(2);

            System.out.println("Updated Email: " + email);
            System.out.println("User Name: " + firstName);
            System.out.println("-------------------------");
        }

// write a JDBC program, which delete user from database, after record delete display record on screen
        System.out.println("\nEnter first name of user to delete:");
        String deleteName = sc.nextLine();

        String deleteQuery = "DELETE FROM student WHERE firstname=?";
        PreparedStatement ps2 = con.prepareStatement(deleteQuery);

        ps2.setString(1, deleteName);   // ✅ FIXED

        int j = ps2.executeUpdate();

        if (j > 0)
            System.out.println("Record deleted successfully.");
        else
            System.out.println("Record not found.");

        // -------- Display After Delete --------
        System.out.println("\n---- Records After Delete ----");

        String Query3 = "select * from student";
        PreparedStatement ps3 = con.prepareStatement(Query3);
        ResultSet rs1 = ps3.executeQuery();

        while (rs1.next()) {
            String email = rs1.getString(1);
            String firstName = rs1.getString(2);

            System.out.println("Updated Email: " + email);
            System.out.println("User Name: " + firstName);
            System.out.println("-------------------------");
        }

//write a JDBC program,which retrieve record of the user whose name start with 'a'

        System.out.println("\n---- Records Whose Name Starts With 'a' ----");

        String Query4 = "select * from student where firstname like 'a%'";
        PreparedStatement ps4 = con.prepareStatement(Query4);
        ResultSet rs2 = ps4.executeQuery();

        while (rs2.next()) {
            String email = rs2.getString(1);
            String firstName = rs2.getString(2);

            System.out.println("Email: " + email);
            System.out.println("User Name: " + firstName);
            System.out.println("-------------------------");
        }

        rs2.close();
        ps4.close();

        rs.close();
        rs1.close();
        ps.close();
        ps1.close();
        ps2.close();
        ps3.close();
        con.close();
        sc.close();
    }
}