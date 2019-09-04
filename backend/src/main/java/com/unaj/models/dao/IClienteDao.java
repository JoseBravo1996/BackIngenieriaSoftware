package com.unaj.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.unaj.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente,Long> {

}
