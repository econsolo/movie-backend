package br.com.cast.movie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.movie.dto.MovieDTO;
import br.com.cast.movie.service.FilmeService;

@RestController
@RequestMapping(path = "filme")
public class FilmeAPI {

	@Autowired
	private FilmeService filmeService;
	
	@RequestMapping(path = "/titulo-local/{titulo}", method = RequestMethod.GET)
	public List<MovieDTO> buscarPorTituloLocal(@PathVariable("titulo") String titulo) {
		return filmeService.buscarPorTituloLocal(titulo);
	}

	@RequestMapping(path = "/titulo-nuvem/{titulo}", method = RequestMethod.GET)
	public List<MovieDTO> buscarPorTituloNaNuvem(@PathVariable("titulo") String titulo) {
		return filmeService.buscarPorTituloNaNuvem(titulo);
	}
	
	@RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
	public MovieDTO buscarPorId(@PathVariable("id") String id) {
		return filmeService.buscarPorId(id);
	}
}
