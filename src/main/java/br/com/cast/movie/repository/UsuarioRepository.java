package br.com.cast.movie.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.movie.dto.CredencialDTO;
import br.com.cast.movie.entity.Usuario;

@Repository
public class UsuarioRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public Usuario buscarPorCredencial(CredencialDTO credencialDTO) {
		StringBuilder hql = new StringBuilder();

		hql.append("SELECT u FROM ").append(Usuario.class.getName()).append(" u ").append(" WHERE 1=1 ")
				.append(" AND u.usuario = :usuario ").append(" AND u.senha = :senha ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("usuario", credencialDTO.getUsuario());
		query.setParameter("senha", credencialDTO.getSenha());

		List<Usuario> usuarios = query.getResultList();

		return !usuarios.isEmpty() ? usuarios.get(0) : null;

	}
	
	public void inserir(Usuario usuario) {
		usuario.setId(UUID.randomUUID().toString());
		em.persist(usuario);
	}

}
