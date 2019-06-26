package br.com.consultemed.service;

import br.com.consultemed.model.Agendamento;

import java.util.Date;
import java.util.List;

public interface IAgendamentoService extends ICRUDService<Agendamento> {

    List<Agendamento> consultarPorPeriodo(Date inicio, Date fim);

}
