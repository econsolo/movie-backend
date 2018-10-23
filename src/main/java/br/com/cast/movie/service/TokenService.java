package br.com.cast.movie.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.movie.dto.TokenDTO;
import br.com.cast.movie.entity.Token;
import br.com.cast.movie.entity.Usuario;
import br.com.cast.movie.repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	@Transactional
	public TokenDTO gerarToken(Usuario usuario) {
		
		Token token = new Token();
		token.setId(UUID.randomUUID().toString());
		token.setUsuario(usuario);
		token.setDataCriacao(new Date());
		
		tokenRepository.inserir(token);
		return TokenDTO.fromEntidade(token);
	}

}
