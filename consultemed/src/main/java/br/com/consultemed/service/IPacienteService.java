package br.com.consultemed.service;

import br.com.consultemed.model.Paciente;

import java.util.Optional;

public interface IPacienteService extends ICRUDService<Paciente>{

    Optional<Paciente> consultarPaciente(String CPF);

}
