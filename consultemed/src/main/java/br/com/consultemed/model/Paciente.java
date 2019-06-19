package br.com.consultemed.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Paciente extends Pessoa {

	@OneToOne
	private Endereco endereco;

	@OneToMany(mappedBy = "paciente")
	private List<Agendamento> agendamentos;

	@OneToOne
	private Prontuario prontuario;

	public Paciente() { }

	public Paciente(String nome, String cpf, Date dataNascimento) {
		super(nome, cpf, dataNascimento);
	}

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
