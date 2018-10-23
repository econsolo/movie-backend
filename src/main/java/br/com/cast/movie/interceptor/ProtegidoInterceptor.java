package br.com.cast.movie.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.cast.movie.dto.TokenDTO;
import br.com.cast.movie.exception.CredencialInvalidaException;
import br.com.cast.movie.exception.NaoAutorizadoException;
import br.com.cast.movie.service.TokenService;

public class ProtegidoInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private TokenService tokenService;
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
        Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            
            Protegido annotation = handlerMethod.getMethod().getAnnotation(Protegido.class);
            
            if (annotation != null) {
            	
            	String token = request.getHeader("token");
            	
            	if (StringUtils.isEmpty(token)) {
            		throw new NaoAutorizadoException();
            	}
            	
            	TokenDTO tokenDTO = tokenService.buscarPorId(token);
            	
            	if (tokenDTO == null) {
            		throw new CredencialInvalidaException();
            	}
            	
            }
            
        }
        return true;
    }
	
}
