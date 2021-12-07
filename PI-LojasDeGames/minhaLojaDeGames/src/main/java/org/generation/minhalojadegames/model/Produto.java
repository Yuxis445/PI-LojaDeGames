package org.generation.minhalojadegames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "Produto")

public class Produto {
		
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank (message = "Insira Nome")
	@Size (min= 1, max =50)
	private String nome;
	
	@NotNull
	private double preco;
	
	@NotBlank (message = "Insira tipo de midia")
	@Size (min= 1, max =50)
	private String tpmidia;
	
	@NotBlank (message= "Insira o tamanho da midia")
	@Size (min =2, max =20)
	private String tamanho;
	
	@NotBlank (message= "Qual o desenvolvedor")
	@Size (min=1, max=50)
	private String desenvolvedor;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getTpmidia() {
		return tpmidia;
	}

	public void setTpmidia(String tpmidia) {
		this.tpmidia = tpmidia;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(String desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
