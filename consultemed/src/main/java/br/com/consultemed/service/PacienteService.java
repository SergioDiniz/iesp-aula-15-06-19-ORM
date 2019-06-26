package br.com.consultemed.service;

import br.com.consultemed.dao.PacienteDAO;
import br.com.consultemed.model.Paciente;

import java.util.Optional;

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

    @Override
    public Optional<Paciente> consultarPaciente(String CPF) {
        return pacienteDAO.consultarPaciente(CPF);
    }

}
