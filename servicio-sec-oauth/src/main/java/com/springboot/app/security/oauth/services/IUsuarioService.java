package com.springboot.app.security.oauth.services;


import com.springboot.app.commons.usuarios.model.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);
	
	public Usuario update(Usuario usuario,  Long id);

}
