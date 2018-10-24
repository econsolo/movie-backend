package br.com.cast.movie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.cast.movie.entity.DetalheFilme;

public class DetalheFilmeDTO {

	@JsonProperty("imdbID")
	private String id;

	@JsonProperty("Released")
	private String lancamento;

	@JsonProperty("Year")
	private Integer ano;

	@JsonProperty("Runtime")
	private String duracao;

	@JsonProperty("Genre")
	private String genero;

	@JsonProperty("Director")
	private String diretor;

	@JsonProperty("Writer")
	private String escritor;

	@JsonProperty("Actors")
	private String atores;

	@JsonProperty("Plot")
	private String sinopse;

	@JsonProperty("Language")
	private String idioma;

	@JsonProperty("Country")
	private String pais;

	@JsonProperty("Awards")
	private String premios;

	@JsonProperty("Production")
	private String produtora;

	@JsonProperty("Website")
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

	public static DetalheFilmeDTO fromEntidade(DetalheFilme df) {
		if (df == null)
			return null;

		DetalheFilmeDTO dto = new DetalheFilmeDTO();
		dto.setAtores(df.getAtores());
		dto.setDiretor(df.getDiretor());
		dto.setDuracao(df.getDuracao());
		dto.setEscritor(df.getEscritor());
		dto.setGenero(df.getGenero());
		dto.setId(df.getId());
		dto.setIdioma(df.getIdioma());
		dto.setLancamento(df.getLancamento());
		dto.setPais(df.getPais());
		dto.setPremios(df.getPremios());
		dto.setProdutora(df.getProdutora());
		dto.setSinopse(df.getSinopse());
		dto.setWebsite(df.getWebsite());
		dto.setAno(df.getAno());
		return dto;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
