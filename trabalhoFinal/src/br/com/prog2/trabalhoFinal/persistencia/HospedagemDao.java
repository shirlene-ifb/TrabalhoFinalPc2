package br.com.prog2.trabalhoFinal.persistencia;

import java.util.List;

import br.com.prog2.trabalhoFinal.negocio.Hospedagem;

public interface HospedagemDao {

	public String inserir(Hospedagem hosp);
	public String alterar(Hospedagem hosp);
	public String excluir(Hospedagem hosp);
	public List<Hospedagem> listarTodos();
	public List<Hospedagem> pesquisarPorChale(String codchale);
}
