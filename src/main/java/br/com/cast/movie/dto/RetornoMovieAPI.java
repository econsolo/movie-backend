package br.com.cast.movie.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetornoMovieAPI {

	@JsonProperty("Search")
	private List<FilmeDTO> registros;

	public List<FilmeDTO> getRegistros() {
		return registros;
	}

	public void setRegistros(List<FilmeDTO> registros) {
		this.registros = registros;
	}

}