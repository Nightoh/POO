package pt.europeia.SmartCar.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pt.europeia.SmartCar.application.MsgManager;


public abstract class DBConnector {
	
	private static String url = "jdbc:mysql://localhost:3306/army?autoReconnect=true&useSSL=false";    
	private static String driverName = "com.mysql.jdbc.Driver";   
	private static String username = "root";   
	private static String password = "hJGDBi01";
	private static Connection con;

	public static Connection getConnection() {
		try {
			if (con == null || con.isClosed() ) {
				Class.forName(driverName);
				con = DriverManager.getConnection(url, username, password);
			}
		} catch (ClassNotFoundException ex) {
			MsgManager.aviso("BD error", "Erro no driver da BD", "Contate a assistência técnica");
			ex.printStackTrace();
			con = null;
		} catch (SQLException ex) {
			MsgManager.aviso("BD error", "Erro na ligação à BD", "Verifique se a BD está online");
			ex.printStackTrace();
			con = null;
		}
		return con;
	}
}
