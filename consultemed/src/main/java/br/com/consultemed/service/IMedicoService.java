package br.com.consultemed.service;

import br.com.consultemed.model.Medico;

import java.util.Optional;

public interface IMedicoService extends ICRUDService<Medico> {

    Optional<Medico> consultarPaciente(String CPF);

}
