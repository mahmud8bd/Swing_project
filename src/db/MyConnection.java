
package db;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class MyConnection {
    
    private static final String username = "root";
    private  static final String password = "112233";
    private static final String dataConn = "jdbc:mysql://localhost:3306/itinstitudemanagement"; //jdbc url
    private static Connection con = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dataConn,username,password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage());
        }
        return con;
    }
    
}
