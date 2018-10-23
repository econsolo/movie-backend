package br.com.cast.movie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cast.movie.dto.DetalheFilmeDTO;

@Entity
@Table(name = "detalhe_filme", schema = "filme")
public class DetalheFilme {

	@Id
	private String id;

	@Column(name = "lancamento", length = 50)
	private String lancamento;

	@Column(name = "duracao", length = 50)
	private String duracao;

	@Column(name = "genero", length = 50)
	private String genero;

	@Column(name = "diretor", length = 50)
	private String diretor;

	@Column(name = "escritor", length = 100)
	private String escritor;

	@Column(name = "atores", length = 500)
	private String atores;

	@Column(name = "sinopse", length = 2000)
	private String sinopse;

	@Column(name = "idioma", length = 50)
	private String idioma;

	@Column(name = "pais", length = 50)
	private String pais;

	@Column(name = "premios", length = 200)
	private String premios;

	@Column(name = "produtora", length = 100)
	private String produtora;

	@Column(name = "website", length = 200)
	private String website;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPremios() {
		return premios;
	}

	public void setPremios(String premios) {
		this.premios = premios;
	}

	public String getProdutora() {
		return produtora;
	}

	public void setProdutora(String produtora) {
		this.produtora = produtora;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public static DetalheFilme fromDTO(DetalheFilmeDTO dto) {
		DetalheFilme df = new DetalheFilme();
		
		df.setId(dto.getId());
		df.setAtores(dto.getAtores());
		df.setDiretor(dto.getDiretor());
		df.setDuracao(dto.getDuracao());
		df.setEscritor(dto.getEscritor());
		df.setGenero(dto.getGenero());
		df.setId(dto.getId());
		df.setIdioma(dto.getIdioma());
		df.setLancamento(dto.getLancamento());
		df.setPais(dto.getPais());
		df.setPremios(dto.getPremios());
		df.setProdutora(dto.getProdutora());
		df.setSinopse(dto.getSinopse());
		df.setWebsite(dto.getWebsite());
		
		return df;
	}

}
