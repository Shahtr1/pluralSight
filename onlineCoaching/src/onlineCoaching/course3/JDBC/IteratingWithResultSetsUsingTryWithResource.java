package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratingWithResultSetsUsingTryWithResource {
	public static void main(String[] args) throws SQLException{
		
		try (
				Connection conn = DBUtil.getConnection(DBType.ORADB);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Employees");
				){
			
			String format = "%-4s%-20s%-25s%-10f\n";
			
			while(rs.next()) {
				System.out.format(format, rs.getString("Employee_ID"),rs.getString("First_Name"),rs.getString("Last_Name"),rs.getFloat("Salary"));
			}
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}
}
