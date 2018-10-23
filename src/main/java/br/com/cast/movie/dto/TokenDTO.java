package br.com.cast.movie.dto;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.movie.entity.Token;

public class TokenDTO {

	@JsonProperty("token")
	private String id;
	
	@JsonProperty("usuario")
	private UsuarioDTO usuarioDTO;
	
	@JsonProperty("data_criacao")
	private String dataCriacao;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public static TokenDTO fromEntidade(Token token) {
		if (token == null) return null;
		
		TokenDTO dto = new TokenDTO();
		dto.setId(token.getId());
		dto.setUsuarioDTO(UsuarioDTO.fromEntidade(token.getUsuario()));
		dto.setDataCriacao(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(token.getDataCriacao()));
		
		return dto;
	}

}
