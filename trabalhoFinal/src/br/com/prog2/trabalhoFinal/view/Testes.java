package br.com.prog2.trabalhoFinal.view;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.prog2.trabalhoFinal.controller.ChaleController;
import br.com.prog2.trabalhoFinal.controller.ClienteController;
import br.com.prog2.trabalhoFinal.controller.HospedagemController;
import br.com.prog2.trabalhoFinal.negocio.Chale;
import br.com.prog2.trabalhoFinal.negocio.Cliente;
import br.com.prog2.trabalhoFinal.persistencia.ConnectionFactory;
import br.com.prog2.trabalhoFinal.negocio.Hospedagem;

public class Testes {

	public static void main(String[] args) {

		/*
		 * Connection con = ConnectionFactory.getConnection(); if (con != null) {
		 * System.out.println("OK"); ConnectionFactory.close(con); }
		 */

		//TESTE DO CHALE
		
		/*Chale c = new Chale();
		ChaleController controller = new ChaleController();
		c.setCodChale("555");
		c.setLocalizacao("Brazil");
		c.setCapacidade(100);
		c.setValorAltaEstacao(150.5);
		c.setValorBaixaEstacao(50.5);
		System.out.println(controller.inserir(c));*/

		
		/*Chale c = new Chale();
		ChaleController controller = new ChaleController();
		c.setCodChale("555");
		c.setLocalizacao("Goias");
		c.setCapacidade(50);
		c.setValorAltaEstacao(150.5);
		c.setValorBaixaEstacao(50.5);
		System.out.println(controller.alterar(c));*/
		
		/*Chale c = new Chale();
		ChaleController controller = new ChaleController();
		c.setCodChale("555");
		c.setLocalizacao("Goias");
		c.setCapacidade(50);
		c.setValorAltaEstacao(150.5);
		c.setValorBaixaEstacao(50.5);
		System.out.println(controller.excluir(c));*/
		
		/*ChaleController controller = new ChaleController();
		List<Chale> lista = controller.listarTodos();
		if(lista != null){
			for(Chale c : lista){
			System.out.println("Codigo: "+c.getCodChale());
			System.out.println("Localizacao: "+c.getLocalizacao());
			System.out.println("Capacidade: "+c.getCapacidade());
			System.out.println("ValorAltaEstaca: "+c.getValorAltaEstacao());
			System.out.println("ValorBaixaEstacao: "+c.getValorBaixaEstacao());
			}
		}*/
		
		/*ChaleController controller = new ChaleController();
		Chale c = new Chale();
		c = controller.pesquisarPorCodigo("111");
		if(c != null){
			System.out.println("Codigo: "+c.getCodChale());
			System.out.println("Localizacao: "+c.getLocalizacao());
			System.out.println("Capacidade: "+c.getCapacidade());
			System.out.println("ValorAltaEstaca: "+c.getValorAltaEstacao());
			System.out.println("ValorBaixaEstacao: "+c.getValorBaixaEstacao());
		}*/
		
		// TESTE DA HOSPEDAGEM
		
		/*Hospedagem hosp = new Hospedagem();
		HospedagemController controller = new HospedagemController();
		hosp.setCodHospedagem("123");
		hosp.setCodChale("444");
		hosp.setEstado("Bahia");
		hosp.setDataInicio(LocalDate.of(2019,11,27));
		hosp.setDataFim(LocalDate.of(2019,12,15));
		hosp.setQtdPessoas(2);
		hosp.setDesconto(50.0);
		hosp.setValorFinal(200.0);
		System.out.println(controller.inserir(hosp));*/
		
		
		/*Hospedagem hosp = new Hospedagem();
		HospedagemController controller = new HospedagemController();
		hosp.setCodHospedagem("222");
		hosp.setCodChale("111");
		hosp.setEstado("");
		hosp.setDataInicio(LocalDate.of(2019,11,27));
		hosp.setDataFim(LocalDate.of(2019,11,30));
		hosp.setQtdPessoas(2);
		hosp.setDesconto(10.5);
		hosp.setValorFinal(31.50);
		System.out.println(controller.excluir(hosp));
		*/
		
		/*Hospedagem hosp = new Hospedagem();
		HospedagemController controller = new HospedagemController();
		hosp.setCodHospedagem("222");
		hosp.setCodChale("111");
		hosp.setEstado("Anapolis");
		hosp.setDataInicio(LocalDate.of(2019,11,27));
		hosp.setDataFim(LocalDate.of(2019,12,30));
		hosp.setQtdPessoas(3);
		hosp.setDesconto(150.0);
		hosp.setValorFinal(345.50);
		System.out.println(controller.alterar(hosp));*/

		/*HospedagemController controller = new HospedagemController();
		List<Hospedagem> lista = new ArrayList<>();
		lista = controller.listarTodos();
		if (lista != null){
			for(Hospedagem h : lista) {
				System.out.println("Codigo hospedagem: "+h.getCodHospedagem());
				System.out.println("Codigo chale: "+h.getCodChale());
			}
		}*/
		
		/*List<Hospedagem> lista = new ArrayList<>();
		HospedagemController controller = new HospedagemController();
		lista = controller.pesquisarPorChale("111");
		if (lista != null) {
			for (Hospedagem h : lista) {
				System.out.println("Codigo chale: " + h.getCodChale());
				System.out.println("Codigo hospedagem: " + h.getCodHospedagem());
			}
		}*/
		
		//TESTES DO CLIENTE
		
		/*Cliente c = new Cliente();
		ClienteController con = new ClienteController();
		c.setCodCliente("2222");
		c.setNomeCliente("Juninho");
		c.setRgCliente("1357");
		c.setEnderecoCliente("nenhum");
		c.setBairroCliente("banana");
		c.setCidadeCliente("bobos");
		c.setEstadoCliente("vazio");
		c.setCepCliente("1111");
		c.setNascimentoCliente(LocalDate.of(1994,07,31));
		System.out.println(con.inserir(c));*/
		
		/*Cliente c = new Cliente();
		ClienteController con = new ClienteController();
		c.setCodCliente("1111");
		c.setNomeCliente("Mariana");
		c.setRgCliente("2468");
		c.setEnderecoCliente("nenhum");
		c.setBairroCliente("zero");
		c.setCidadeCliente("bobos");
		c.setEstadoCliente("null");
		c.setCepCliente("0000");
		c.setNascimentoCliente(LocalDate.of(1999,07,01));
		System.out.println(con.alterar(c));
		*/
		
		/*Cliente c = new Cliente();
		ClienteController con = new ClienteController();
		c.setCodCliente("1111");
		c.setNomeCliente("Mariana");
		c.setRgCliente("2468");
		c.setEnderecoCliente("nenhum");
		c.setBairroCliente("zero");
		c.setCidadeCliente("bobos");
		c.setEstadoCliente("null");
		c.setCepCliente("0000");
		c.setNascimentoCliente(LocalDate.of(1999,07,01));
		System.out.println(con.excluir(c));
		*/
		
		/*ClienteController con = new ClienteController();
		List<Cliente> lista = new ArrayList();
		lista = con.listarTodos();
		if (lista != null){
			for(Cliente c:lista) {
				System.out.println("Codigo cliente: " + c.getCodCliente());
			}
		}*/
		
		/*ClienteController con = new ClienteController();
		List<Cliente> lista = new ArrayList();
		lista = con.pesquisarPorChale("1111");
		if (lista != null) {
			for (Cliente c : lista) {
				System.out.println("Codigo cliente: " + c.getCodCliente());
			}
		}*/
	}
}
