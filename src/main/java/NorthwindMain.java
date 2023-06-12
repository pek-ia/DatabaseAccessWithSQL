import java.sql.*;

public class NorthwindMain {
    public static void main(String[] args) {

        String driverClassname = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/northwind";

        try {
            Class.forName(driverClassname);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, "paul", "baibai");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet results = null;

            results = statement.executeQuery("""
                            SELECT * from Products;
                    """);

            while (results.next()) {
                String name = results.getString("ProductName");
                double price = results.getDouble("UnitPrice");
                System.out.printf("%s costs %8.2f\n", name, price);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
