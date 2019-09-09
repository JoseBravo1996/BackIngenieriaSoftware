package com.unaj.models.services;

import com.unaj.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);

}
