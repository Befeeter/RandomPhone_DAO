package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	private final static String driver = "com.mysql.jdbc.Driver";
    private final static String path = "jdbc:mysql://127.0.0.1:3306/randomphone";
    private final static String usuario = "root";
    private final static String pass = "secret";
    private static Connection conexion;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(path, usuario, pass);
        } 
        catch (SQLException sqle) {
        	System.out.println(sqle.getMessage());
            //JOptionPane.showMessageDialog(null, "Impossivel se conectar a base de dados", "Login", JOptionPane.ERROR_MESSAGE);
        } 
        catch (ClassNotFoundException cnfe) {
        	System.out.println(cnfe.getMessage());
            //JOptionPane.showMessageDialog(null, "Impossivel encontrar a classe driver", "Login", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }    
}