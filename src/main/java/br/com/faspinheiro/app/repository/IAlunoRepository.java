package br.com.faspinheiro.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.faspinheiro.app.negocio.Aluno;

@Repository
public interface IAlunoRepository extends CrudRepository<Aluno, Integer>{
}
