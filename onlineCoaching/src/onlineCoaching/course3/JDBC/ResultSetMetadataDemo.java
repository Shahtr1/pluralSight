package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetadataDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from newemployees");
				){
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			System.out.println("Total Columns : "+columnCount);	
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
		
	}

}
