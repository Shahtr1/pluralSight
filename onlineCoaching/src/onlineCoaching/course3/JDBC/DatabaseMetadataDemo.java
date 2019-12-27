package onlineCoaching.course3.JDBC;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection conn = DBUtil.getConnection(DBType.MYSQLDB);){
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Logged In User: " + dbmd.getUserName());
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database product Version: " + dbmd.getDatabaseProductVersion());
			
			//Retrieve all the tables names from connected database
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String schemaTypes[] = {"TABLE"};
			ResultSet rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, schemaTypes);
			System.out.println("Tables");
			System.out.println("==============");
			while(rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}
			
			System.out.println();
			System.out.println("==============");
			System.out.println();
			
			//Retrieving Columns Present within the Table
			String columnNamePattern = null;
			rs = dbmd.getColumns(catalog, schemaPattern, "Country", columnNamePattern);
			System.out.println("Column Details");
			System.out.println("=======================");
			while(rs.next()) {
				System.out.println(rs.getString("COLUMN_NAME"));
			}
			
			rs.close();
			
		}catch(SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}

}
