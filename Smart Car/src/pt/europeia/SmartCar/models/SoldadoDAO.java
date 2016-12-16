package pt.europeia.SmartCar.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pt.europeia.SmartCar.application.MsgManager;
import pt.europeia.SmartCar.models.Soldier;

public abstract class SoldadoDAO {
	
	
	public static Soldier getSoldier(Soldier soldier) {
				
		Connection con = DBConnector.getConnection();
		if (con != null)
			try {
				
				PreparedStatement stat = con.prepareStatement("select * from soldado where sol_id=? and sol_password=?" );
				stat.setInt(1,soldier.getId());
				stat.setString(2,soldier.getPassword());
				ResultSet rs = stat.executeQuery();
				rs.next();
				soldier.setNome(rs.getString("sol_nome"));
				soldier.setEmail(rs.getString("sol_email"));
				soldier.setSalario(rs.getInt("sol_salario"));
				soldier.setDnsc(rs.getString("sol_dnsc"));
				soldier.setPatente(rs.getString("sol_pat_nome"));
				return soldier;
				
			} catch (SQLException e) {
				MsgManager.aviso("BD error", "Verifique se a BD está online", "Erro no ID ou na Password");
				System.out.println(e);
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					MsgManager.aviso("BD error", "Erro de chamada à bd", "Verifique se a BD está online");
					e.printStackTrace();
				}
			}
		else MsgManager.aviso("BD error", "Erro de chamada à bd", "Verifique se a BD está online");
		
		return null;
		
		
	}

	/*public static ArrayList<Soldier> getSoldados() {
		
		Connection con = DBConnector.getConnection();
		soldiers = new ArrayList<Soldier>();
		
		if (con != null)
			
			try {
				
				Statement stat = con.createStatement();
				ResultSet rs = stat.executeQuery(
						"Select * from soldado");
				
				while (rs.next()) {
					
					int id = rs.getInt("sol_id");
					String nome = rs.getString("sol_nome");
					String local = rs.getString("sol_local");
					String dnsc = rs.getString("sol_dnsc");
					String sexo = rs.getString("sol_sexo");
					String email = rs.getString("sol_email");
					int salario = rs.getInt("sol_salario");
					
					Soldier soldier = new Soldier(nome,local,dnsc,sexo,email, salario);
					
					soldiers.add(soldier);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				MsgManager.aviso("BD error", "Erro de chamada à bd", "Verifique se a BD está online");
				e.printStackTrace();
				
			} finally {
				
				try {
					con.close();
				} catch (SQLException e) {
					MsgManager.aviso("BD error", "Erro de chamada à bd", "Verifique se a BD está online");
					e.printStackTrace();
				}
			}
		else MsgManager.aviso("BD error", "Erro de chamada à bd", "Verifique se a BD está online");	
		return soldiers;
	}*/
	
}