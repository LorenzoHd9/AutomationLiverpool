package e_commerceLiverpool_Library;

import java.sql.DriverManager;

public class Connection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automationtimedb?characterEncoding=utf8","root","Getecsa01");
		}
		catch(Exception e) {
			System.out.println("cannot connect: "+e);
		}
		if(con != null) {
			System.out.println("Connect Successfully");
		}
		return con;
	}
	
	public static void setScenarioTime(String scenariostep, String start, String end) {
		Connection conn = null;
		/*PrepareStatement statement = null;
		try {
			conn = connect();
			String query = "INSERT INTO registrypagetime (step,startTime,endTime) VALUES ("+"'"+scenariostep+"'"+","+"'"+start+"'"+","+"'"+end+"'"+")";
			statement = (statement) conn.statement(query);
			int n = statement.executeUpdate();
			if(n == 1) {
				System.out.println("Successfully insert");
			}
			statement.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
	}
}
