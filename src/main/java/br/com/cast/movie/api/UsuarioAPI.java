package br.com.cast.movie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.movie.dto.CredencialDTO;
import br.com.cast.movie.dto.TokenDTO;
import br.com.cast.movie.dto.UsuarioDTO;
import br.com.cast.movie.service.UsuarioService;

@RestController
@RequestMapping(path = "usuario")
public class UsuarioAPI {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/autenticar", method = RequestMethod.POST)
	public TokenDTO login(@RequestBody CredencialDTO credencialDTO) {
		return usuarioService.login(credencialDTO);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public void cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
		usuarioService.cadastrar(usuarioDTO);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public UsuarioDTO buscarPorId(@PathVariable("id") String id) {
		return usuarioService.buscarPorId(id);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public TokenDTO alterar(@PathVariable("id") String id, @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioService.alterar(id, usuarioDTO);
	}
}
