package br.com.consultemed.dao;

import br.com.consultemed.model.Paciente;

import java.util.Optional;

public class PacienteDAO extends DAO<Paciente> {

    public PacienteDAO() {
        super(Paciente.class);
    }

    public Optional<Paciente> consultarPaciente(String CPF){
        return  this.getManager()
                    .createQuery("SELECT P FROM Paciente P WHERE P.cpf = :cpf")
                    .setParameter("cpf", CPF)
                    .setMaxResults(1)
                    .getResultList()
                    .stream().findFirst();
    }


}
