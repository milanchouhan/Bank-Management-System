import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Mysql@1234567");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } 
        
    }
}