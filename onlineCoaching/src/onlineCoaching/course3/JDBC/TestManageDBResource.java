package onlineCoaching.course3.JDBC;

import java.sql.*;

public class TestManageDBResource {
	
	public static void main(String[] args) throws SQLException{
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.MYSQLDB);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from country");
			rs.last();
			System.out.println("Total No. of Rows  :"+rs.getRow());
			
//			System.out.println("Connection Established to Oracle Database");
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		finally {
			conn.close();
		}
	}
}
