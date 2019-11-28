package br.com.prog2.trabalhoFinal.persistencia;

import java.util.List;
import br.com.prog2.trabalhoFinal.negocio.Cliente;

public interface ClienteDao {

	public String inserir(Cliente c);
	public String alterar(Cliente c);
	public String excluir(Cliente c);
	public List<Cliente> listarTodos();
	public List<Cliente> pesquisarPorCodigo(String codChale);
}
