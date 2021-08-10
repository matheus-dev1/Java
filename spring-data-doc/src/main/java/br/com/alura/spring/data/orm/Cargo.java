package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cargos")
public class Cargo {
	@Id
	// Nesta coluna ID, ele vai gerar de forma sequencial.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricaoCargo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricaoCargo() {
		return descricaoCargo;
	}
	public void setDescricaoCargo(String descricaoCargo) {
		this.descricaoCargo = descricaoCargo;
	}
	
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", descricaoCargo=" + descricaoCargo + "]";
	}

}
