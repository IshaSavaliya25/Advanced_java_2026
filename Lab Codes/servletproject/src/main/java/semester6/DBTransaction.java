package semester6;


import java.sql.*;

public class DBTransaction {

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb",
                    "root",
                    ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean insertData(String name, String email, String qualification,
                              String city, String mobile) {

        boolean status = false;

        try {
            Connection con = getConnection();

            if (con == null) {
                System.out.println("DB Connection Failed ❌");
                return false;
            }

            String query = "INSERT INTO users4(name,email,qualification,city,mobile) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, qualification);
            ps.setString(4, city);
            ps.setString(5, mobile);

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            if (rows > 0) status = true;

            con.close();

        } catch (Exception e) {
            System.out.println("Insert Error: " + e.getMessage());
            e.printStackTrace();
        }

        return status;
    }
}