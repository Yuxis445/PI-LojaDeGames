package org.generation.minhalojadegames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);

}
