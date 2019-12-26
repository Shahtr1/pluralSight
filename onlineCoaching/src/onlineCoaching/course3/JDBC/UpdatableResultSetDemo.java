package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableResultSetDemo {
	public static void main(String[] args) throws SQLException {
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery("select employee_id,employee_name,email from newemployees");
				//we should remember that a query cannot use a select *, and also it is mandatory to select all the non-null columns
				//and a query must select single table set only, no joins
				
				
				){
			rs.absolute(2);
			rs.updateString("Department_Name", "Information Technology");
			rs.updateRow();
			
			System.out.println("Record Updated Successfully");
			
			rs.moveToInsertRow();
			rs.updateInt("Department_Id", 999);
			rs.updateString("Department_Name", "Training");
			rs.updateInt("Manager_Id", 200);
			rs.updateInt("Location_Id", 1800);
			rs.insertRow();
			
			System.out.println("Record Inserted Successfully");
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}
}



