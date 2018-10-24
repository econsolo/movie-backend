package br.com.cast.movie.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.movie.dto.MovieDTO;
import br.com.cast.movie.entity.Filme;
import br.com.cast.movie.exception.NenhumFilmeEncontradoException;
import br.com.cast.movie.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private MovieClient client;

	@Autowired
	private FilmeRepository filmeRepository;

	@Transactional
	public List<MovieDTO> buscarPorTituloNaNuvem(String titulo) {

		List<MovieDTO> filmes = client.getMovieDTO(titulo);
		List<MovieDTO> filmesLocal = this.buscarPorTituloLocal(titulo);

		if (filmes == null) {
			throw new NenhumFilmeEncontradoException();
		}
		
		for (MovieDTO movieDTO : filmes) {
			if (!filmesLocal.stream().anyMatch(fl -> Objects.equals(fl.getId(), fl.getId()))) {
				filmeRepository.inserir(Filme.fromDTO(movieDTO));
			}
		}

		return filmes;
	}

	public List<MovieDTO> buscarPorTituloLocal(String titulo) {
		List<Filme> filmes = filmeRepository.buscarPorTitulo(titulo);
		return filmes.stream().map(f -> MovieDTO.fromEntidade(f)).collect(Collectors.toList());
	}
	
	public MovieDTO buscarPorId(String id) {
		Filme filme = filmeRepository.buscarPorId(id);
		//TODO fazer
		return MovieDTO.fromEntidade(filme);
	}


}
