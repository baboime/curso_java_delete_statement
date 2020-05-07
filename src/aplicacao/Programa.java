package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegretyException;

public class Programa {

	public static void main(String[] args) {
		
		Connection conexao = null;
		PreparedStatement st = null;
		
		try {
			conexao = DB.getConnection();
			
			st = conexao.prepareStatement(
					"DELETE FROM departamento "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 2);
		
			int linhasExcluidas = st.executeUpdate();
			
			System.out.println("Tabela atualizada, linhas excluídas: " + linhasExcluidas);
		}
		catch(SQLException e) {
			throw new DbIntegretyException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}		
	}
}
