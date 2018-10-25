package br.com.cast.movie.dto;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.movie.entity.Comentario;

public class ComentarioDTO {

	private String id;
	
	@JsonProperty("filme")
	private FilmeDTO filmeDTO;
	
	@JsonProperty("usuario")
	private UsuarioDTO usuarioDTO;
	
	private String descricao;
	
	private String data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FilmeDTO getFilmeDTO() {
		return filmeDTO;
	}

	public void setFilmeDTO(FilmeDTO filme) {
		this.filmeDTO = filme;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuario) {
		this.usuarioDTO = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static ComentarioDTO fromEntidade(Comentario c) {
		ComentarioDTO dto = new ComentarioDTO();

		if (c == null) return null;

		dto.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(c.getData()));
		dto.setDescricao(c.getDescricao());
		//dto.setFilmeDTO(FilmeDTO.fromEntidade(c.getFilme()));
		dto.setId(c.getId());
		dto.setUsuarioDTO(UsuarioDTO.fromEntidade(c.getUsuario()));

		return dto;
	}

}
