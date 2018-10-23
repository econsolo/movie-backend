package br.com.cast.movie.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.movie.entity.Token;

@Repository
public class TokenRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Token token) {
		em.persist(token);
	}
}
