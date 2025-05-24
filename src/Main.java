import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    static Connection connection = null;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

//            insertStudent();
//            updateStudent();
            deleteStudent();
            retrieveStudent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void insertStudent() {
        try {
            Statement stmt = connection.createStatement();
            String query = String.format("INSERT INTO STUDENTS(name, age, marks) VALUES('%s', %o, %f)", "Paresh", 20, 95.55);
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Student inserted successfully");
            }
            else {
                System.out.println("Student insert failed");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void updateStudent() {
        try {
            Statement stmt = connection.createStatement();
            String query = String.format("UPDATE STUDENTS set marks = %f WHERE id = %o", 90.9, 1);
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Student updated successfully");
            }
            else {
                System.out.println("Student update failed");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void deleteStudent() {
        try {
            Statement stmt = connection.createStatement();
            String query = "DELETE from students WHERE id = 3";
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully");
            }
            else {
                System.out.println("Student delete failed");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void retrieveStudent() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Id :" +resultSet.getInt("id"));
                System.out.println("Name :" +resultSet.getString("name"));
                System.out.println("age :" +resultSet.getInt("age"));
                System.out.println("marks :" +resultSet.getDouble("marks"));
                System.out.println("-----------------------------------------------------");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}