package br.com.consultemed.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Paciente extends Pessoa {

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@OneToMany(mappedBy = "paciente")
	private List<Agendamento> agendamentos;

	@OneToOne
	private Prontuario prontuario;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Contato> contatos = new ArrayList<>();

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

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
