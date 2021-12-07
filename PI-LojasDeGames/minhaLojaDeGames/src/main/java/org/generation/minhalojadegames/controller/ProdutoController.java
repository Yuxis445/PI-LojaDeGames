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

import org.generation.minhalojadegames.model.Produto;
import org.generation.minhalojadegames.repository.produtoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private produtoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(nome));
	}
	
	@GetMapping("/preco/{preco}")
	public ResponseEntity<List<Produto>> getByPreco(@PathVariable double preco){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(preco));
	}
	
	@GetMapping("/tpmidia/{tpmidia}")
	public ResponseEntity<List<Produto>> getByTpmidia(@PathVariable String tpmidia){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(tpmidia));
	}
	
	@GetMapping("/tamanho/{tamanho}")
	public ResponseEntity<List<Produto>> getByTamanho(@PathVariable String tamanho){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(tamanho));
	}
	
	@GetMapping("/desenvolvedor/{desenvolvedor}")
	public ResponseEntity<List<Produto>> getByDesenvolvedor(@PathVariable String desenvolvedor){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(desenvolvedor));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@Valid @RequestBody Produto produto){
		return ResponseEntity.ok(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable long id) {
		repository.deleteById(id);
	} 
	
	
}