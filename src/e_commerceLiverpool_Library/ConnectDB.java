package e_commerceLiverpool_Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectDB {

	static int executionId;
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(BaseLibrary.configProperties("dbHost_dbName"),BaseLibrary.configProperties("dbUser"),BaseLibrary.configProperties("dbPassword"));		
		}
		catch(Exception e) {
			System.out.println("cannot connect: "+e);
		}
		//if(con != null) {System.out.println("Connect Successfully");}
		return con;
	}
	
	public static void setStepTime(int executionID,String scriptName, String platform, String step, String startDate , String endDate, double durationOf, String key, double serverCPU, double freeMemory) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = connect();
			String query2= "INSERT INTO step_time "
					+ "(execution_id,script_name,platform,step,start_date,end_date,duration_seconds,key_row,server_cpu,server_memory) "
					+ "VALUES ("+"'"+executionID+"'"+","+"'"+scriptName+"'"+","+"'"+platform+"'"+","+"'"+step+"'"+","+"'"+startDate+"'"+","+"'"+endDate+"'"+","+""+durationOf+""+","+"'"+key+"'"+","+""+serverCPU+""+","+""+freeMemory+""+")";
			statement = conn.prepareStatement(query2);
	        statement.executeUpdate();
			statement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public static void setScenarioTime(String scenarioName, String platform, String startDate ) {
		Connection connt = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connt = connect();
			String query = "INSERT INTO script_time (script_name,platform,start_date) VALUES ("+"'"+scenarioName+"'"+","+"'"+platform+"'"+","+"'"+startDate+"'"+")";
			statement = connt.prepareStatement(query,statement.RETURN_GENERATED_KEYS);
			statement.executeUpdate();
			executionId = -1;
			rs = statement.getGeneratedKeys();
			if(rs.next()) {
				executionId = rs.getInt(1);
			}
			statement.close();
			connt.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
		
		}
	
	public static void updateScenarioTime(String endDate, String error, String errorMsg, String errorStep) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = connect();
			String updateScenario = "UPDATE script_time SET end_date ="+"'"+endDate+"'"+", with_error = "+"'"+error+"'"+", error_message = "+"'"+errorMsg+"'"+", error_step = "+"'"+errorStep+"'"+" WHERE id = "+""+executionId+""+"";
			statement = conn.prepareStatement(updateScenario);
			statement.execute();
			statement.close();
			conn.close();
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	public static int getExecuteID() {
		return executionId;
	}
}
