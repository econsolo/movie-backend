package br.com.cast.movie.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.movie.entity.Token;

@Repository
public class TokenRepository {

	@PersistenceContext
	private EntityManager em;

	public void inserir(Token token) {
		em.persist(token);
	}

	public Token buscarPorId(String token) {
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT t FROM ").append(Token.class.getName()).append(" t ")
		   .append(" LEFT JOIN FETCH t.usuario u")
		   .append(" WHERE 1=1 ")
		   .append(" AND t.id = :id ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("id", token);
		
		try {
			return (Token) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
}
