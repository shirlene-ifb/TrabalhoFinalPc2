package br.com.prog2.trabalhoFinal.controller;

import java.util.List;

import br.com.prog2.trabalhoFinal.negocio.Hospedagem;
import br.com.prog2.trabalhoFinal.persistencia.HospedagemDaoImp;
public class HospedagemController {

	public String inserir(Hospedagem hosp) {
		HospedagemDaoImp dao = new HospedagemDaoImp();
		return dao.inserir(hosp);
	}

	public String alterar(Hospedagem hosp) {
		HospedagemDaoImp dao = new HospedagemDaoImp();
		return dao.alterar(hosp);
	}

	public String excluir(Hospedagem hosp) {
		HospedagemDaoImp dao = new HospedagemDaoImp();
		return dao.excluir(hosp);
	}

	public List<Hospedagem> listarTodos() {
		HospedagemDaoImp dao = new HospedagemDaoImp();
		return dao.listarTodos();
	}

	public List<Hospedagem> pesquisarPorChale(String codchale) {
		HospedagemDaoImp dao = new HospedagemDaoImp();
		return dao.pesquisarPorChale(codchale);
	}
}
