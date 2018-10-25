package br.com.cast.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.movie.dto.UsuarioDTO;

@Entity
@Table(name = "usuario", schema = "filme")
public class Usuario {

	@Id
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "usuario", length = 50, nullable = false)
	private String usuario;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "senha", length = 50, nullable = false)
	private String senha;

	public String getId() {
		return id;
	}

	public Usuario setId(String id) {
		this.id = id;
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}

	public static Usuario fromDTO(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setUsuario(usuarioDTO.getUsuario());
		return usuario;
	}

}
