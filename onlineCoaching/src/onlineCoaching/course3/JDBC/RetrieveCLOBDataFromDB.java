package onlineCoaching.course3.JDBC;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveCLOBDataFromDB {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
		
		String sql = "select resume from newemployees2 where employee_id = 1";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			Clob resume = rs.getClob("resume"); 
			Reader data = resume.getCharacterStream();
			
			int i;
			String resumeDetails = "";
			while((i = data.read()) != -1) {
				resumeDetails += ((char)i);
			}
			System.out.println("Resume Details for Employee 1");
			System.out.println(resumeDetails);
		}else {
			System.err.println("No Record Found For Employee with The ID 1");
		}
		
		rs.close();
		pstmt.close();
		conn.close();
	}

}



