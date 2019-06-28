package br.com.consultemed.dao;

import br.com.consultemed.model.Medico;

import java.util.Optional;

public class MedicoDAO extends DAO<Medico> {
    public MedicoDAO() {
        super(Medico.class);
    }

    public Optional<Medico> consultarMedico(String CPF){
        return  this.getManager()
                .createQuery("SELECT M FROM Medico M WHERE M.cpf = :cpf")
                .setParameter("cpf", CPF)
                .setMaxResults(1)
                .getResultList()
                .stream().findFirst();
    }
}
