import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAcces {
		private String ipServer;
		private String user;
		private String password;
		private String BD;
		private String database;
		
		private Connection conexion;
		private Statement s;
	DataAcces(String BD){
		this.BD = BD;
		try {
			if(BD.equalsIgnoreCase("MYSQL")){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			}else if(BD.equalsIgnoreCase("ORACLE")){
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			}
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (ClassNotFoundException e) {
		}	
	}
	
	public Connection conectar(){
		try {
			if(BD.equalsIgnoreCase("MYSQL")){
				return conexion = DriverManager.getConnection("jdbc:mysql://"+ipServer+"/"+database+"",user,password);
			}
			else if(BD.equalsIgnoreCase("ORACLE")){
				return conexion = DriverManager.getConnection("jdbc:oracle://"+ipServer+"/"+database+user+password);
			}
			
		} catch (SQLException e) {
		}
		return null;
	}

	public void setIpServer(String server) {
		this.ipServer = server;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public void setData(String query){
		try {
			s = this.conexion.createStatement();
			s.execute(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	public ResultSet getData(String query){
		try {
			 s = this.conexion.createStatement();
			ResultSet rs = s.executeQuery(query);
			return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	public void closeConnection(){
		try {
			this.conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
