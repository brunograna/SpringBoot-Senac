package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = 5338939688366465017L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String modelo;

	@OneToOne
	@JoinColumn(name = "id_chave")
	private Chave chave;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}
}
