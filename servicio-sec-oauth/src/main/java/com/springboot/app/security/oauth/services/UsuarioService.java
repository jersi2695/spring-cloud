package com.springboot.app.security.oauth.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.app.commons.usuarios.model.entity.Role;
import com.springboot.app.commons.usuarios.model.entity.Usuario;
import com.springboot.app.security.oauth.clients.IUsuarioFeignClient;

import brave.Tracer;
import feign.FeignException;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService{
	
	@Autowired
	private IUsuarioFeignClient client;
	
	@Autowired
	private Tracer tracer;
	
	private Logger log = LoggerFactory.getLogger(UsuarioService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			
		
			Usuario usuario = client.findByUsername(username);
						
			List<Role> roles = new ArrayList<Role>();
			
			Role role = new Role();
			role.setId(1L);
			role.setNombre("ROLE_USER");
			roles.add(role);
			
			role = new Role();
			role.setId(2L);
			role.setNombre("ROLE_ADMIN");
			roles.add(role);
			
			usuario.setRoles(roles);
			
			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(r -> new SimpleGrantedAuthority(r.getNombre()))
					.peek(a -> log.info("Role: " + a.getAuthority()))
					.collect(Collectors.toList());
			
			log.info("Usuario autenticado: " + username);
			
			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
		}catch (FeignException e) {
			String error = "Error en el login, no existe el usuario "+ username +" en el sistema";
			log.error(error);
			tracer.currentSpan().tag("error.mensaje", error + ": " + e.getMessage());
			throw new UsernameNotFoundException("Error en el login, no existe el usuario en el sistema");
		}
	}

	@Override
	public Usuario findByUsername(String username) {
		Usuario usuario = client.findByUsername(username);
		return usuario;
		
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		return client.update(usuario, id);
	}

}
