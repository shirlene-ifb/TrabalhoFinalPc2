package br.com.prog2.trabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhoFinal.negocio.Chale;
import br.com.prog2.trabalhoFinal.negocio.Cliente;

public class ClienteDaoImp implements ClienteDao {

	@Override
	public String inserir(Cliente c) {
		String sql = "insert into cliente(codCliente,nomecliente,rgcliente,enderecocliente,bairrocliente,cidadecliente,estadocliente,cepcliente,nascimentocliente) values(?,?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getCodCliente());
			pst.setString(2, c.getNomeCliente());
			pst.setString(3, c.getRgCliente());
			pst.setString(4, c.getEnderecoCliente());
			pst.setString(5, c.getBairroCliente());
			pst.setString(6, c.getCidadeCliente());
			pst.setString(7, c.getEstadoCliente());
			pst.setString(8, c.getCepCliente());
			pst.setObject(9, c.getNascimentoCliente());
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
	public String alterar(Cliente c) {
		String sql = "update cliente set nomecliente=?,rgcliente=?,enderecocliente=?,bairrocliente=?,cidadecliente=?,estadocliente=?,cepcliente=?,nascimentocliente=? where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getNomeCliente());
			pst.setString(2, c.getRgCliente());
			pst.setString(3, c.getEnderecoCliente());
			pst.setString(4, c.getBairroCliente());
			pst.setString(5, c.getCidadeCliente());
			pst.setString(6, c.getEstadoCliente());
			pst.setString(7, c.getCepCliente());
			pst.setObject(8, c.getNascimentoCliente());
			pst.setString(9, c.getCodCliente());
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
	public String excluir(Cliente c) {
		String sql = "delete from cliente where codCliente=?";
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, c.getCodCliente());
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
	public List<Cliente> listarTodos() {
		String sql = "select * from cliente";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cliente c = new Cliente();
					c.setCodCliente(rs.getString(1));
					c.setNomeCliente(rs.getString(2));
					c.setRgCliente(rs.getString(3));
					c.setEnderecoCliente(rs.getString(4));
					c.setBairroCliente(rs.getString(5));
					c.setCidadeCliente(rs.getString(6));
					c.setEstadoCliente(rs.getString(7));
					c.setCepCliente(rs.getString(8));
					c.setNascimentoCliente(rs.getObject(9, LocalDate.class));
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
	public List<Cliente> pesquisarPorCodigo(String codCliente) {
		String sql = "select * from cliente where codcliente=?";
		Connection con = ConnectionFactory.getConnection();
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, codCliente);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				Cliente c = new Cliente();
				c.setCodCliente(rs.getString(1));
				c.setNomeCliente(rs.getString(2));
				c.setRgCliente(rs.getString(3));
				c.setEnderecoCliente(rs.getString(4));
				c.setBairroCliente(rs.getString(5));
				c.setCidadeCliente(rs.getString(6));
				c.setEstadoCliente(rs.getString(7));
				c.setCepCliente(rs.getString(8));
				c.setNascimentoCliente(rs.getObject(9, LocalDate.class));
				lista.add(c);
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

}
