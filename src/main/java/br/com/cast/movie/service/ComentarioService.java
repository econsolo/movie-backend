package br.com.cast.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.movie.dto.ComentarioDTO;
import br.com.cast.movie.entity.Comentario;
import br.com.cast.movie.entity.Filme;
import br.com.cast.movie.entity.Usuario;
import br.com.cast.movie.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	@Transactional
	public void inserir(ComentarioDTO dto) {
		Comentario comentario = Comentario.fromDTO(dto);
		comentario.setUsuario(new Usuario().setId(dto.getUsuarioDTO().getId()));
		comentario.setFilme(new Filme().setId(dto.getFilmeDTO().getId()));
		
		comentarioRepository.inserir(comentario);
	}
	
	public List<ComentarioDTO> getComentariosPorFilme(String idFilme) {
		List<Comentario> comentarios = comentarioRepository.getComentariosPorFilme(idFilme);
		return comentarios.stream()
				.map(c -> ComentarioDTO.fromEntidade(c))
				.collect(Collectors.toList());
	}

	@Transactional
	public void excluir(String id) {
		Comentario comentario = comentarioRepository.buscarPorId(id);
		comentarioRepository.excluir(comentario);
	}
}
