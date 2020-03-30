package br.com.faspinheiro.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faspinheiro.app.negocio.Escola;

@RestController
@RequestMapping("/api/escola/")
public class EscolaController {
	
	private static Map<Integer, Escola> mapaEscola = new HashMap<Integer, Escola>();
	private static Integer chave = 0;
	
	
	@GetMapping
	public List<Escola> obterLista(){		
		return new ArrayList<Escola>(mapaEscola.values());		
	}
	
	@PostMapping
	public void incluir(@RequestBody Escola escola) {
		Integer id = ++chave;		
		escola.setId(id);		
		mapaEscola.put(id, escola);		
	}
	
	@PostMapping("new/{nome}")	
	public void incluir(@PathVariable String nome) {
		Integer id = ++chave;		
		mapaEscola.put(id, new Escola(id, nome));
	}
	
	@GetMapping("{id}")
	public Escola obterPorId(@PathVariable Integer id) {		
		return mapaEscola.get(id);		
	}
	
	@DeleteMapping("{id}")
	public void excluir (@PathVariable Integer id) {
		mapaEscola.remove(id);
	}	
	
}
