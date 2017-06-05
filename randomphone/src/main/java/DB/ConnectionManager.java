package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager _instance = null;
	private Connection con = null;

	protected ConnectionManager() {
		// empty
	}

	private void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/randomphone", "root", "secret");
	}

	public Connection getConnection() {
		return this.con;
	}

	public static ConnectionManager getInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if (_instance == null) {
			_instance = new ConnectionManager();
			_instance.init();
		}
		return _instance;
	}

}
