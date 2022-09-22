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
			con = DriverManager.getConnection("jdbc:mysql://"+BaseLibrary.configProperties("dbHost_dbName"),BaseLibrary.configProperties("dbUser"),BaseLibrary.configProperties("dbPassword"));												//
		}
		catch(Exception e) {
			System.out.println("cannot connect: "+e);
		}
		if(con != null) {System.out.println("Connect Successfully");}
		return con;
	}
	
	public static void setScenarioTime(String scriptName, String platform, String step, String startDate , String endDate, double durationOf, String key) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = connect();
			String query2= "INSERT INTO step_time (script_name,platform,step,start_date,end_date,duration_seconds,key_row) VALUES ("+"'"+scriptName+"'"+","+"'"+platform+"'"+","+"'"+step+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+""+durationOf+""+","+"'"+key+"'"+")";
			statement = conn.prepareStatement(query2);
	        statement.executeUpdate();
			statement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
