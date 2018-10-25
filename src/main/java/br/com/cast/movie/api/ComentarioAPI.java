package br.com.cast.movie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.movie.dto.ComentarioDTO;
import br.com.cast.movie.service.ComentarioService;

@RestController
@RequestMapping(path = "comentario")
public class ComentarioAPI {

	@Autowired
	private ComentarioService comentarioService;
	
	@RequestMapping(path = "/{idFilme}", method = RequestMethod.GET)
	public List<ComentarioDTO> buscarComentariosPorFilme(@PathVariable("idFilme") String idFilme) {
		return comentarioService.getComentariosPorFilme(idFilme);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void inserir(@RequestBody ComentarioDTO dto) {
		comentarioService.inserir(dto);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("id") String id) {
		comentarioService.excluir(id);
	}
}
