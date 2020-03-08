package com.springboot.app.usuarios.model.dao;

import java.util.List;

import org.apache.catalina.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.springboot.app.commons.usuarios.model.entity.Usuario;

@RepositoryRestResource(path="usuarios")
public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	@RestResource(path = "buscar-username")
	public Usuario findByUsername(@Param("username") String username);
	
	@Query("select u.roles from Usuario u where u.username=?1")
	public List<Role> obtenerRolesPorUsername(@Param("username") String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username);
	
}
