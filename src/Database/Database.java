package Database;

/*
 * Per motivi di Privacy e Sicurezza la connection pool con il db è stata nascosta
 */

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
	
	//Connection pool 

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
