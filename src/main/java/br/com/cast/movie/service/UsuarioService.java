package br.com.cast.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.movie.dto.CredencialDTO;
import br.com.cast.movie.dto.TokenDTO;
import br.com.cast.movie.dto.UsuarioDTO;
import br.com.cast.movie.entity.Usuario;
import br.com.cast.movie.exception.UsuarioNaoEncontradoException;
import br.com.cast.movie.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Transactional
	public TokenDTO login(CredencialDTO credencialDTO) {
		Usuario usuario = usuarioRepository.buscarPorCredencial(credencialDTO);
		
		if (usuario == null) {
			throw new UsuarioNaoEncontradoException();
		}
		
		TokenDTO tokenDTO = tokenService.gerarToken(usuario);
		
		return tokenDTO;
	}

	@Transactional
	public void cadastrar(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = Usuario.fromDTO(usuarioDTO);
		
		usuarioRepository.inserir(usuario);
	}

}
