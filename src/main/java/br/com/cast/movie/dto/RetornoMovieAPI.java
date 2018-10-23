package br.com.cast.movie.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetornoMovieAPI {

	@JsonProperty("Search")
	private List<MovieDTO> registros;

	public List<MovieDTO> getRegistros() {
		return registros;
	}

	public void setRegistros(List<MovieDTO> registros) {
		this.registros = registros;
	}

}