package br.com.cast.movie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.movie.entity.Filme;

@Repository
public class FilmeRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Filme> buscarPorTitulo(String titulo) {
		StringBuilder hql = new StringBuilder();

		hql.append("SELECT f FROM ").append(Filme.class.getName()).append(" f ")
				.append(" LEFT JOIN FETCH f.detalheFilme df ").append(" WHERE 1=1 ")
				.append(" AND UPPER(f.titulo) LIKE :titulo ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("titulo", "%" + titulo.toUpperCase() + "%");

		List<Filme> filmes = query.getResultList();

		return filmes;

	}

	public void inserir(Filme filme) {
		em.persist(filme);
	}

	public void alterar(Filme filme) {
		em.merge(filme);
	}

	public Filme buscarPorId(String id) {
		StringBuilder hql = new StringBuilder();

		hql.append("SELECT f FROM ").append(Filme.class.getName()).append(" f ")
				.append(" LEFT JOIN FETCH f.detalheFilme df ")
				.append(" WHERE 1=1 ")
				.append(" AND f.id = :id ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("id", id);

		try {
			return (Filme) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}
}
