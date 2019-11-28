package br.com.prog2.trabalhoFinal.controller;

import java.util.List;

import br.com.prog2.trabalhoFinal.negocio.Cliente;
import br.com.prog2.trabalhoFinal.persistencia.ClienteDaoImp;

public class ClienteController {

	public String inserir(Cliente c) {
		ClienteDaoImp dao = new ClienteDaoImp();
		return dao.inserir(c);
	}

	public String alterar(Cliente c) {
		ClienteDaoImp dao = new ClienteDaoImp();
		return dao.alterar(c);
	}

	public String excluir(Cliente c) {
		ClienteDaoImp dao = new ClienteDaoImp();
		return dao.excluir(c);
	}

	public List<Cliente> listarTodos() {
		ClienteDaoImp dao = new ClienteDaoImp();
		return dao.listarTodos();
	}

	public List<Cliente> pesquisarPorChale(String codcliente) {
		ClienteDaoImp dao = new ClienteDaoImp();
		return dao.pesquisarPorCodigo(codcliente);
	}
}
