package br.com.prog2.trabalhoFinal.controller;

import java.util.List;

import br.com.prog2.trabalhoFinal.negocio.Chale;
import br.com.prog2.trabalhoFinal.persistencia.ChaleDaoImp;

public class ChaleController {

	public String inserir(Chale hosp) {
		ChaleDaoImp dao = new ChaleDaoImp();
		return dao.inserir(hosp);
	}

	public String alterar(Chale hosp) {
		ChaleDaoImp dao = new ChaleDaoImp();
		return dao.alterar(hosp);
	}

	public String excluir(Chale hosp) {
		ChaleDaoImp dao = new ChaleDaoImp();
		return dao.excluir(hosp);
	}

	public List<Chale> listarTodos() {
		ChaleDaoImp dao = new ChaleDaoImp();
		return dao.listarTodos();
	}

	public Chale pesquisarPorCodigo(String codChale) {
		ChaleDaoImp dao = new ChaleDaoImp();
		return dao.pesquisarPorCodigo(codChale);
	}
}
