package br.com.cast.movie.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cast.movie.dto.ComentarioDTO;

@Entity
@Table(name = "comentario", schema = "filme")
public class Comentario {

	@Id
	@Column(name = "id", length = 36, nullable = false)
	private String id;

	@ManyToOne
	@JoinColumn(name = "id_filme", nullable = false)
	private Filme filme;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;

	@Column(name = "descricao", length = 2000, nullable = false)
	private String descricao;

	@Column(name = "data", nullable = false)
	private Date data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public static Comentario fromDTO(ComentarioDTO dto) {
		if (dto == null) return null;
		
		Comentario c = new Comentario();
		c.setId(dto.getId());
		try {
			c.setData(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dto.getData()));
		} catch (Exception e) { 
			c.setData(new Date());
		}
		
		c.setDescricao(dto.getDescricao());
		c.setFilme(Filme.fromDTO(dto.getFilmeDTO()));
		c.setUsuario(Usuario.fromDTO(dto.getUsuarioDTO()));
		
		return c;
	}
}
