package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Connection pull DB
 * 
 * @author Francesco Garofalo
 *
 */

public class Database {
	
	private static String protocol;
	private static String hostname;
	private static String port;
	private static String username;
	private static String password;
	private static String dbName;
	private static Properties userInfo;
	private static String mySqlUrl;
	private static List<Connection> freeDbConnections;
	static final String driver = "com.mysql.jdbc.Driver";
	// private static final boolean DEBUG = false; jdbc:mysql://mysql6.gear.host:3306/?user=infiniti
	private static final boolean LOCAL = false;

	static {
		protocol = "jdbc:mysql://";

		if (LOCAL) {
			hostname = "localhost:";
			port = "3306/";
			dbName = "myDB";
			mySqlUrl = protocol + hostname + port + dbName;
			
			/**********************************/
			username = "root";
			password = "rooter";
			userInfo = new Properties();
			userInfo.put("user", username);
			userInfo.put("password", password);
			System.out.println("Connessione Locale riuscita");
		} else {
			hostname = "sql2.freemysqlhosting.net:";
			port = "3306/";
			dbName = "sql2200261";
			mySqlUrl = protocol + hostname + port + dbName;
			
			/**********************************/
			username = "sql2200261";
			password = "dS4!qL4*";
			userInfo = new Properties();
			userInfo.put("user", username);
			userInfo.put("password", password);
			System.out.println("Connessione Esterna 2 riuscita");
		}

		freeDbConnections = new LinkedList<Connection>();
		try {
			System.out.println("Test connection");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("DB driver not found:" + e.getMessage());
		}
	}

	/**
	 * Start Connection
	 * 
	 * @return
	 * @throws SQLException
	 * @author Francesco Garofalo
	 */

	private static synchronized Connection createDBConnection() throws SQLException {

		Connection newConnection = null;
		newConnection = DriverManager.getConnection(mySqlUrl, userInfo);
		newConnection.setAutoCommit(false);
		return newConnection;
	}

	/**
	 * Take a DB connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			freeDbConnections.remove(0);

			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();
		}

		return connection;
	}

	/**
	 * Release Connection
	 * 
	 * @param connection
	 * @author Francesco Garofalo
	 */

	public static synchronized void releaseConnection(Connection connection) throws SQLException {
		if (connection != null)
			freeDbConnections.add(connection);
	}
}
