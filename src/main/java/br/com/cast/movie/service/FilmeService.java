package br.com.cast.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.movie.dto.MovieDTO;
import br.com.cast.movie.entity.Filme;
import br.com.cast.movie.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private MovieClient client;
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Transactional
	public List<MovieDTO> buscarPorTitulo(String titulo) {
		
		List<MovieDTO> filmes = buscar(titulo);
		
		if (filmes.size() == 0) {
			filmes.addAll(client.getMovieDTO(titulo));
			
			for (MovieDTO movieDTO : filmes) {
				filmeRepository.inserir(Filme.fromDTO(movieDTO));
			}
			
		}
		
		
		return filmes;
	}
	
	public MovieDTO buscarPorId(String id) {
		
		return null;
	}

	private List<MovieDTO> buscar(String titulo) {
		List<Filme> filmes = filmeRepository.buscarPorTitulo(titulo);
		return filmes.stream().map(f -> MovieDTO.fromEntidade(f)).collect(Collectors.toList());
	}
		
	
}
