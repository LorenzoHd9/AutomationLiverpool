package e_commerceLiverpool_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class ConnectDB {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://gs-mysql-production-do-user-2410679-0.b.db.ondigitalocean.com:25060/liverpool","liverpool","dgXncfR$7!eg%ZjA");
		//con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automationtimedb?characterEncoding=utf8","root","Getecsa01");														//
		}
		catch(Exception e) {
			System.out.println("cannot connect: "+e);
		}
		if(con != null) {
			System.out.println("Connect Successfully");
		}
		return con;
	}
	
	public static void setScenarioTime(String scriptName, String platform, String step, String startDate , String endDate, int durationOf, String key) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = connect();
			//String query = "INSERT INTO liverpool (script_name,platform,step,start_date,end_date,duration_seconds) VALUES ("+"'"+scriptName+"'"+","+"'"+platform+"'"+","+"'"+step+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+"'"+durationOf+"'"+")";
			String query2= "INSERT INTO step_time (script_name,platform,step,start_date,end_date,duration_seconds) VALUES ("+"'"+scriptName+"'"+","+"'"+platform+"'"+","+"'"+step+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+"'"+durationOf+"'"+","+"'"+key+"'"+")";
			//statement = (PreparedStatement) conn.prepareStatement(query2);
			statement = (PreparedStatement) conn.prepareStatement(query2);
	        int n = statement.executeUpdate();
			if(n == 1) {
				System.out.println("Successfully insert");
			}
			statement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
