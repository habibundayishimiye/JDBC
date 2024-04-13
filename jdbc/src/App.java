import java.sql.*;
public class App {
    static final String DB_URL = "jdbc:mysql://localhost:3306/student_inf";
    static final String USER = "root";
    static final String PASS = "Hab.jass52";
    static final String QUERY = " SELECT * FROM jdbc";
    public static void main(String args[]) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(QUERY);){
            while(rs.next()){
                System.out.print("Roll:"+rs.getString("roll"));
                System.out.print("Name:"+rs.getString("name"));
                System.out.println("CGPA:"+rs.getString("cgpa"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
