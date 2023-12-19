package com.paf.ferreteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.ferreteria.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	List<Producto> findByNombreContaining(String texto);
	Producto findByNombre(String texto);
}

