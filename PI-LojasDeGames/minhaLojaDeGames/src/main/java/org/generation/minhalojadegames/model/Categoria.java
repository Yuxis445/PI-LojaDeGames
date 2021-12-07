package org.generation.minhalojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@NotBlank
	@Size(min = 2, max = 20 , message = "O atributo Genêro deve ter no min 2 caracteres")
	private String genero; 
	
	@NotBlank
	@Size(min = 2, max = 20 , message = "O atributo Plataforma deve ter no minimo 2 caracteres")
	private String plataforma;
	
	
	private Boolean Multiplayer;
	

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	public List<Produto> getPostagem() {
		return produto;
	}

	public void setPostagem(List<Produto> produto) {
		this.produto = produto;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public String getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}


	
	public Boolean getMultiplayer() {
		return Multiplayer;
	}



	public void setMultiplayer(Boolean multiplayer) {
		Multiplayer = multiplayer;
	}
	

 
}
