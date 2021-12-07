package org.generation.minhalojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.generation.minhalojadegames.repository.categoriaRepository;
import org.generation.minhalojadegames.model.Categoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    
    @Autowired
    private categoriaRepository repository;

    // retornar todos os temas existentes
    @GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
    // procurar um ema pelo id
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	// procurar um tema pelo nome
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> getByName(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
    // inserir um novo dado no BD
	@PostMapping
	public ResponseEntity<Categoria> post (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
	}

    // atualizar dados ja existentes
	@PutMapping
	public ResponseEntity<Categoria> put (@Valid @RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));				
	}

    // deletar um dado pelo id
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable long id) {
		repository.deleteById(id);
	}
}
