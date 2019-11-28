package br.com.prog2.trabalhoFinal.persistencia;

import java.util.List;
import br.com.prog2.trabalhoFinal.negocio.Chale;

public interface ChaleDao {

	public String inserir(Chale ch);
	public String alterar(Chale ch);
	public String excluir(Chale ch);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodigo(String codChale);
}
