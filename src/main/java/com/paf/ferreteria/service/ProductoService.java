package com.paf.ferreteria.service;

import java.util.List;

import com.paf.ferreteria.entity.Producto;
import com.paf.ferreteria.entity.Categoria;

public interface ProductoService {
	public List<Producto> findAll();
	public Producto findById(int id);
	public Producto findByNombre(String nombre);
	public List<Producto> findByNombreContaining(String nombre);
	public Producto create(Producto obj);
	public Producto update(Producto obj);
	public int delete(int id);
	public List<Categoria> selectCategoria();	
}
