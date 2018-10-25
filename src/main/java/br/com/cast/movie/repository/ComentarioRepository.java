package br.com.cast.movie.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.movie.entity.Comentario;

@Repository
public class ComentarioRepository {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Comentario> getComentariosPorFilme(String id) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT c FROM ").append(Comentario.class.getName()).append(" c ")
		   .append(" INNER JOIN FETCH c.usuario u ")
		   .append(" WHERE c.filme.id = :id ")
		   .append(" ORDER BY c.data ASC ");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	public void inserir(Comentario comentario) {
		comentario.setId(UUID.randomUUID().toString());
		em.persist(comentario);
	}

	public Comentario buscarPorId(String id) {
		return em.find(Comentario.class, id);
	}
	
	public void excluir(Comentario comentario) {
		em.remove(comentario);
	}

}
