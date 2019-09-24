package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

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

	@OneToOne
	@JoinColumn(name = "documento_id")
	private Documento documento;

	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	@ManyToMany
	@JoinTable(
			name = "carro_acessorio",
			joinColumns = { @JoinColumn(name = "id") },
			inverseJoinColumns = { @JoinColumn(name = "acessorio_id") }
	)
	private List<Acessorio> acessorios;

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

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

}