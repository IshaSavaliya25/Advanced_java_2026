import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertDB2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/productDB";
            String user = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, user, pass);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Product Price: ");
            double price = sc.nextDouble();


            String sql = "INSERT INTO product(id, name, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, price);


            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Data Inserted Successfully!");
            } else {
                System.out.println("Error!");
            }

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}