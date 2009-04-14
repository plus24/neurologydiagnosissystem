/**
 A <code>MySQLConnection</code> object provides
 connection facilities by connecting to the MySQL Database.
  
 @author      NDS Team
 @since       1.0 (17th December 2008)
 @version     1.0
 */

package ndsapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	public  Connection connection = null;
	private  String driver;
	private  String url;
	private  String user;
	private  String pw;
			
	public void getDatabaseConnection() {

		if (connection == null) {
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, pw);
				System.out.println("MySQL Database connection establised.");
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error loading driver:" + cnfe);
			} catch (SQLException sqle) {
				System.out.println("Error connecting:" + sqle);
			}
		}
	}
	protected void finalize() throws Throwable {
		if (connection != null) {
			try {
				System.out.println("MySQL Database connection closed.");
				connection.close();
			} catch (SQLException sqle) {
				System.out.println("Error closing connection:" + sqle);
			}
		}
	    super.finalize();
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Connection getConnection() {
		return connection;
	}
}
