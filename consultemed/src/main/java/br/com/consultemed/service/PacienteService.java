package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.PacienteDAO;
import br.com.consultemed.model.Paciente;

public class PacienteService implements IPacienteService {

    PacienteDAO pacienteDAO = new PacienteDAO();

    public PacienteService() { }

    @Override
    public void cadastrar(Paciente paciente) {
        pacienteDAO.add(paciente);
    }

    @Override
    public Paciente buscarPorID(Long id) {
        return pacienteDAO.findById(id);
    }

}
