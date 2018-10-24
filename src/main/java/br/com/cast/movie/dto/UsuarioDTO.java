package br.com.cast.movie.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.movie.entity.Usuario;

public class UsuarioDTO {

	@JsonProperty("id")
	private String id;

	@JsonProperty("usuario")
	private String usuario;

	@JsonProperty("email")
	private String email;

	@JsonIgnore
	@JsonProperty("senha")
	private String senha;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static UsuarioDTO fromEntidade(Usuario usuario) {
		if (usuario == null)
			return null;
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuario.getId());
		dto.setEmail(usuario.getEmail());
		dto.setUsuario(usuario.getUsuario());
		dto.setSenha(usuario.getSenha());
		return dto;
	}

}
