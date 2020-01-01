package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolingTutorialTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try(Connection connection = DBUtil.getDataSource().getConnection();
				Statement stmt = connection.createStatement(); 
				){
			String sql = "select * from newemployees";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String eNAme = rs.getString("employee_name");
				String email = rs.getString("email");
				
				System.out.println(empId + "   "+eNAme+"   "+email);
			}
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
