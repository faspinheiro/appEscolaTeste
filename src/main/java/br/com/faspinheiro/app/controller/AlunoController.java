package br.com.faspinheiro.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.faspinheiro.app.negocio.Aluno;
import br.com.faspinheiro.app.repository.IAlunoRepository;

@RestController
@RequestMapping("/api/aluno/")
public class AlunoController {
	
	@Autowired
	private IAlunoRepository repositorio;
	
	@GetMapping
	public List<Aluno> obterLista(){		
		return (List<Aluno>) repositorio.findAll();		
	}
	
	@PostMapping
	public void incluir(@RequestBody Aluno aluno) {
		repositorio.save(aluno);
	}
	
	@PostMapping("new/{nome}")	
	public void incluir(@PathVariable String nome) {
		repositorio.save(new Aluno(nome));
	}
	
	@GetMapping("{id}")
	public Optional<Aluno> obterPorId(@PathVariable Integer id) {		
		return repositorio.findById(id);		
	}
	
	@DeleteMapping("{id}")
	public void excluir (@PathVariable Integer id) {
		repositorio.deleteById(id);
	}	
	
}
