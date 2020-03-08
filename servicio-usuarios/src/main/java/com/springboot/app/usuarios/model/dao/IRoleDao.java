package com.springboot.app.usuarios.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.app.commons.usuarios.model.entity.Role;

public interface IRoleDao extends PagingAndSortingRepository<Role, Long> {

}
