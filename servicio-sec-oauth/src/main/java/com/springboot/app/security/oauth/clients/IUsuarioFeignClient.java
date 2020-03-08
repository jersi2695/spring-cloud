package com.springboot.app.security.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.app.commons.usuarios.model.entity.Usuario;

@FeignClient(name="servicio-usuarios")
public interface IUsuarioFeignClient {

	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam String username);
	
	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);
}
