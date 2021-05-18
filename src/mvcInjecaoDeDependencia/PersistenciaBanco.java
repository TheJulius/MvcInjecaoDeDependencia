package mvcInjecaoDeDependencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaBanco extends Persistencia{ //Tive muitos problemas com esse conexao.conectar();
	
	final String NOMEDATABELA = "aluno";
	
	public boolean Create(AlunoDto aluno) {
		try {
			Connection conn = Conexao.getConnection();
			String sql = "INSERT INTO " + NOMEDATABELA + "( cpf ) VALUES (?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("ERRO: " + e.toString());
			return false;
		}
	}
	
	public boolean Read(AlunoDto aluno) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "SELECT FROM " + NOMEDATABELA + "WHERE cpf = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AlunoDto obj = new AlunoDto();
				obj.setCpf(rs.getString(1));
			}
			ps.close();
			conn.close();
			return true;
		}catch(Exception e) {
			System.err.println("ERRO: " + e.toString());
			return false;
		}
	}
	
	public boolean Update(AlunoDto aluno) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "UPDATE " + NOMEDATABELA + "SET cpf = ? where cpf = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		}catch(Exception e){
			System.err.println("ERRO: " + e.toString());
			return false;
		}
	}
	
	public boolean Delete(AlunoDto aluno) {
		try {
			Connection conn = Conexao.conectar();
			String sql = "DELET FROM " + NOMEDATABELA + "WHERE cpf = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getCpf());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		}catch(Exception e) {
			System.err.println("ERRO: " + e.toString());
			return false;
		}
	}
}
