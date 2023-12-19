package com.paf.ferreteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.ferreteria.entity.Producto;
import com.paf.ferreteria.entity.Categoria;
import com.paf.ferreteria.service.impl.ProductoServiceImpl;
import com.paf.ferreteria.service.impl.CategoriaServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoServiceImpl service;
	@Autowired
	private CategoriaServiceImpl serviceCategoria;
	
	//localhost:8091/api/productos (GET)
	@GetMapping() 
	public ResponseEntity<List<Producto>> getAll(){
		List<Producto> productos= service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}
	
	//localhost:8091/api/productos/1 (GET)
	@GetMapping(value="/{id}") 
	public ResponseEntity<Producto> getById(@PathVariable("id") int id) {
		Producto producto = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(producto);
	}
	
	//localhost:8091/api/productos (POST)
	@PostMapping 
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		Producto productoDb=service.create(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDb);
	}
	
	//localhost:8091/api/productos/1 (PUT)
	@PutMapping
	public ResponseEntity<Producto> update(@RequestBody Producto producto) {
		Producto productoDb=service.update(producto);
		return ResponseEntity.status(HttpStatus.OK).body(productoDb);
	}
	
	//localhost:8091/api/productos/1 (DELETE)
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
	//localhost:8091/api/productos/selectCategorias (get)
	@GetMapping(value="/selectCategorias")
	public ResponseEntity<List<Categoria>>  selectCategorias(){
		List<Categoria> categorias= serviceCategoria.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(categorias);
	}
}
