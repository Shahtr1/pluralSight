package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class DBUtil {
	private static final String oraUser = "hr";
	private static final String oraPwd = "hr";
	private static final String mySqlUser = "root";
	private static final String mySqlPwd = "root";
	private static final String oraCS = "jdbc:oracle:thin:@localhost:1522:shahrukh";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/world";
	private static HikariDataSource dataSource;
	
	static {
		try {
			dataSource = new HikariDataSource();
			
			dataSource.setJdbcUrl(mySQLCS);
			dataSource.setUsername(mySqlUser);
			dataSource.setPassword(mySqlPwd);
			
			dataSource.setMinimumIdle(100);
			dataSource.setMaximumPoolSize(10000);
			dataSource.setAutoCommit(false);
			dataSource.setLoginTimeout(3); //like TTL
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(DBType dbType) throws SQLException {
		switch(dbType) {
		case ORADB:
			return DriverManager.getConnection(oraCS,oraUser,oraPwd);
		
		case MYSQLDB:
			return DriverManager.getConnection(mySQLCS,mySqlUser,mySqlPwd);
			
		default:
			return null;
		}
	}
	
	public static void showErrorMessage(SQLException e) {
		System.err.println("Error :" + e.getMessage());
		System.err.println("Error Code :" + e.getErrorCode());
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
