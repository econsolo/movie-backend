package br.com.cast.movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cast.movie.dto.DetalheFilmeDTO;
import br.com.cast.movie.dto.MovieDTO;

@Entity
@Table(name = "filme", schema = "filme")
public class Filme {

	@Id
	private String id;

	@Column(name = "titulo", length = 200, nullable = false)
	private String titulo;

	@Column(name = "ano", nullable = false)
	private Integer ano;

	@Column(name = "url_imagem", length = 500, nullable = true)
	private String urlImagem;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_detalhe_filme")
	private DetalheFilme detalheFilme;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public DetalheFilme getDetalheFilme() {
		return detalheFilme;
	}

	public void setDetalheFilme(DetalheFilme detalheFilme) {
		this.detalheFilme = detalheFilme;
	}

	public static Filme fromDTO(MovieDTO movieDTO) {
		Filme f = new Filme();
		f.setId(movieDTO.getId());
		f.setAno(movieDTO.getAno());
		f.setTitulo(movieDTO.getTitulo());
		f.setUrlImagem(movieDTO.getUrlImagem());
		
		DetalheFilmeDTO detalheFilmeDTO = movieDTO.getDetalheFilmeDTO();
		if (detalheFilmeDTO != null) {
			f.setDetalheFilme(DetalheFilme.fromDTO(detalheFilmeDTO));
		}
		
		return f;
	}

}
