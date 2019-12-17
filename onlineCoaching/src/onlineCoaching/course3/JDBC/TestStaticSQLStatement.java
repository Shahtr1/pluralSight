package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStaticSQLStatement {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection(DBType.ORADB);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from Countries");
			rs.last();//Error :Invalid operation for forward only resultset : last
			System.out.println("Total Rows : " + rs.getRow());
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
//			System.err.println(e);
		}finally {
			//close them in reverse order
			if(rs != null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}
	}
}
