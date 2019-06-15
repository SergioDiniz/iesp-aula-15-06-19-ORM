package br.com.consultemed.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Pessoa {

	@OneToOne
	private Endereco endereco;

	public Paciente() {
	}

	public Paciente(String nome, String cpf, Date dataNascimento) {
		super(nome, cpf, dataNascimento);
	}


}
