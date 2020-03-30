package br.com.faspinheiro.app.testes;

import br.com.faspinheiro.app.controller.EscolaController;
import br.com.faspinheiro.app.negocio.Escola;

public class AppTeste {
	
	public static void main(String[] args) {
		
		EscolaController controle = new EscolaController();
		
		controle.incluir("infnet");
		controle.incluir(new Escola("instituto"));
		controle.incluir("intituto infnet");
		
		System.out.println("Escolas: " + controle.obterLista());
		
		controle.excluir(2);
		
		System.out.println("Escolas: " + controle.obterLista());
		
		controle.excluir(3);
		
		System.out.println("Escolas: " + controle.obterLista());
		
	}
}
