package br.com.prog2.trabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.trabalhoFinal.negocio.Chale;
import br.com.prog2.trabalhoFinal.persistencia.ConnectionFactory;

public class ChaleDaoImp implements ChaleDao{

	@Override
	public String inserir(Chale ch) {
		String sql = "insert into chale(codChale,localizacao,capacidade,valorAltaEstacao,valorBaixaEstacao) values(?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getCodChale());
			pst.setString(2, ch.getLocalizacao());
			pst.setInt(3, ch.getCapacidade());
			pst.setDouble(4, ch.getValorAltaEstacao());
			pst.setDouble(5, ch.getValorBaixaEstacao());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String alterar(Chale ch) {
		String sql = "update chale set localizacao=?,capacidade=?, valorAltaEstacao=?,valorBaixaEstacao=? where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getLocalizacao());
			pst.setInt(2, ch.getCapacidade());
			pst.setDouble(3, ch.getValorAltaEstacao());
			pst.setDouble(4, ch.getValorBaixaEstacao());
			pst.setString(5, ch.getCodChale());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Alterado com sucesso.";
			} else {
				return "Erro ao alterar.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public String excluir(Chale ch) {
		String sql = "delete from chale where codChale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ch.getCodChale());
			int res = pst.executeUpdate();
			if (res > 0) {
				return "Excluído com sucesso.";
			} else {
				return "Erro ao excluir.";
			}
		} catch (SQLException e) {
			return e.getMessage();
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public List<Chale> listarTodos() {
		String sql = "select * from chale";
		Connection con = ConnectionFactory.getConnection();
		List<Chale> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Chale c = new Chale();
					c.setCodChale(rs.getString(1));
					c.setLocalizacao(rs.getString(2));
					c.setCapacidade(rs.getInt(3));
					c.setValorAltaEstacao(rs.getDouble(4));
					c.setValorBaixaEstacao(rs.getDouble(5));
					lista.add(c);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

	@Override
	public Chale pesquisarPorCodigo(String codChale) {
		String sql = "select * from chale where codchale=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codChale);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Chale c = new Chale();
				c.setCodChale(rs.getString(1));
				c.setLocalizacao(rs.getString(2));
				c.setCapacidade(rs.getInt(3));
				c.setValorAltaEstacao(rs.getDouble(4));
				c.setValorBaixaEstacao(rs.getDouble(5));
				return c;
				
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

}
