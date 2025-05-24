import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Id :" +resultSet.getInt("id"));
                System.out.println("Name :" +resultSet.getString("name"));
                System.out.println("age :" +resultSet.getInt("age"));
                System.out.println("marks :" +resultSet.getDouble("marks"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}