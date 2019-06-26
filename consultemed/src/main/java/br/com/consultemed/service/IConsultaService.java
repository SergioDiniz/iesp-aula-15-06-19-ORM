package br.com.consultemed.service;

import br.com.consultemed.model.Consulta;

import java.util.Date;
import java.util.List;

public interface IConsultaService extends ICRUDService<Consulta> {

    List<Consulta> consultarPorPeriodo(Date inicio, Date fim);

}
