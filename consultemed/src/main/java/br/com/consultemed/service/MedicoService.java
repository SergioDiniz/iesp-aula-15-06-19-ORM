package br.com.consultemed.service;

import br.com.consultemed.dao.MedicoDAO;
import br.com.consultemed.model.Medico;

import java.util.Optional;

public class MedicoService implements IMedicoService {

    MedicoDAO medicoDAO = new MedicoDAO();

    public MedicoService() {  }

    @Override
    public void cadastrar(Medico medico) {
        medicoDAO.add(medico);
    }

    @Override
    public Medico buscarPorID(Long id) {
        return medicoDAO.findById(id);
    }

    @Override
    public Optional<Medico> consultarPaciente(String CPF) {
        return medicoDAO.consultarMedico(CPF);
    }
}
