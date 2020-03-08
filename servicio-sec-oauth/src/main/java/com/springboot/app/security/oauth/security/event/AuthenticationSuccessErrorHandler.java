package com.springboot.app.security.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.springboot.app.commons.usuarios.model.entity.Usuario;
import com.springboot.app.security.oauth.services.IUsuarioService;

import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler implements AuthenticationEventPublisher {

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);
	
	@Autowired
	private IUsuarioService usuariService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Succes Login: " + user.getUsername();
		log.info(mensaje);
		
		Usuario usuario = usuariService.findByUsername(authentication.getName());
		usuario.setIntentos(0);
		usuariService.update(usuario, usuario.getId());
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error Login: " + exception.getMessage();
		log.info(mensaje);
		
		try {
			Usuario usuario = usuariService.findByUsername(authentication.getName());
			int intentos = usuario.getIntentos() == null ? 1 : usuario.getIntentos() + 1;
			usuario.setIntentos(intentos);
			
			if(intentos >= 3) {
				log.error(String.format("El usuario %s des-habilitado por máximos instentos.", authentication.getName()));
				usuario.setEnabled(false);
			}
			
			usuariService.update(usuario, usuario.getId());
		}catch (FeignException e) {
			log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));
		}
		
		
	}

}
