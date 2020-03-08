package com.springboot.app.usuarios.model.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.app.usuarios.model.entity.Rol;

public interface IRolDao extends PagingAndSortingRepository<Rol, Long> {

}
