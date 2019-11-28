package br.com.prog2.trabalhoFinal.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.prog2.trabalhoFinal.persistencia.ConnectionFactory;
import br.com.prog2.trabalhoFinal.negocio.Hospedagem;

public class HospedagemDaoImp implements HospedagemDao{

	@Override
	public String inserir(Hospedagem hosp) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into hospedagem(codchale,"+"codhospedagem,estado,datainicio, datafim, qtdpessoas, desconto, valorfinal)"+" values(?,?,?,?,?,?,?,?)");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, hosp.getCodChale());
			pst.setString(2, hosp.getCodHospedagem());
			pst.setString(3, hosp.getEstado());
			pst.setObject(4, hosp.getDataInicio());
			pst.setObject(5, hosp.getDataFim());
			pst.setInt(6, hosp.getQtdPessoas());
			pst.setDouble(7, hosp.getDesconto());
			pst.setDouble(8, hosp.getValorFinal());
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
	public String alterar(Hospedagem hosp) {
		StringBuilder sql = new StringBuilder();
		sql.append("update hospedagem set estado=?,datainicio=?, datafim=?, qtdpessoas=?,desconto=?,valorfinal=? where codhospedagem=?"+"and codchale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, hosp.getEstado());
			pst.setObject(2, hosp.getDataInicio());
			pst.setObject(3, hosp.getDataFim());
			pst.setInt(4, hosp.getQtdPessoas());
			pst.setDouble(5, hosp.getDesconto());
			pst.setDouble(6, hosp.getValorFinal());
			pst.setString(7, hosp.getCodHospedagem());
			pst.setString(8, hosp.getCodChale());
			
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
	public String excluir(Hospedagem hosp) {
		StringBuilder sql = new StringBuilder();
		sql.append ("delete from hospedagem where codhospedagem=?"+"and codchale=?");
		Connection con = ConnectionFactory.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, hosp.getCodHospedagem());
			pst.setString(2, hosp.getCodChale());
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
	public List<Hospedagem> listarTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from hospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Hospedagem ep = new Hospedagem();
					ep.setCodChale(rs.getString(1));
					ep.setCodHospedagem(rs.getString(2));
					ep.setEstado(rs.getString(3));
					ep.setDataInicio(rs.getObject(4, LocalDate.class));
					ep.setDataFim(rs.getObject(5,LocalDate.class));
					ep.setQtdPessoas(rs.getInt(6));
					ep.setDesconto(rs.getDouble(7));
					ep.setValorFinal(rs.getDouble(8));
					lista.add(ep);
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
	public List<Hospedagem> pesquisarPorChale(String codchale) {
		StringBuilder sql = new StringBuilder();
		sql.append ("select * from hospedagem where codchale=? order by codhospedagem");
		Connection con = ConnectionFactory.getConnection();
		List<Hospedagem> lista = new ArrayList<>();
		try {
			PreparedStatement pst = con.prepareStatement(sql.toString());
			pst.setString(1, codchale);
			ResultSet rs = pst.executeQuery();
			if (rs != null) {
				while(rs.next()) {
				Hospedagem ep = new Hospedagem();
				ep.setCodChale(rs.getString(1));
				ep.setCodHospedagem(rs.getString(2));
				ep.setEstado(rs.getString(3));
				ep.setDataInicio(rs.getObject(4, LocalDate.class));
				ep.setDataFim(rs.getObject(5, LocalDate.class));
				ep.setQtdPessoas(rs.getInt(6));
				ep.setDesconto(rs.getDouble(7));
				ep.setValorFinal(rs.getDouble(8));
				lista.add(ep);
			}
				return lista;
			}
			 else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			ConnectionFactory.close(con);
		}
	}

}
