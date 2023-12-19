package com.paf.ferreteria.service;
import java.util.List;

import com.paf.ferreteria.entity.Categoria;

public interface CategoriaService {
	public List<Categoria> findAll();
	public Categoria findById(int id);
	public Categoria findByNombre(String nombre);
	public List<Categoria> findByNombreContaining(String nombre);
	public Categoria create(Categoria obj);
	public Categoria update(Categoria obj);
	public int delete(int id);
}
