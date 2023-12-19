package com.paf.ferreteria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paf.ferreteria.entity.Producto;
import com.paf.ferreteria.entity.Categoria;
import com.paf.ferreteria.repository.ProductoRepository;
import com.paf.ferreteria.repository.CategoriaRepository;
import com.paf.ferreteria.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public Producto findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public Producto findByNombre(String nombre) {
		try {
			return repository.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombreContaining(String nombre) {
		try {
			return repository.findByNombreContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional
	public Producto create(Producto obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional
	public Producto update(Producto obj) {
		try {
			Producto productoDb=repository.findById(obj.getId()).orElse(null);
			if(productoDb==null) {
				return null;
			}
			productoDb.setNombre(obj.getNombre());
			productoDb.setPrecio(obj.getPrecio());
			productoDb.setStock(obj.getStock());
			productoDb.setEstado(obj.getEstado());
			productoDb.setCategoria(obj.getCategoria());
			return repository.save(productoDb);
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	@Transactional
	public int delete(int id) {
		try {
			Producto productoDb=repository.findById(id).orElse(null);
			if(productoDb==null) {
				return 0;
			}else {
				repository.delete(productoDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> selectCategoria() {
		try {
			return categoriaRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}
	
}
