package br.com.consultemed.service;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.enums.StatusConsulta;
import br.com.consultemed.model.Agendamento;
import br.com.consultemed.utils.DataUtils;

import java.util.Date;
import java.util.List;

public class AgendamentoService implements IAgendamentoService {

    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();


    public AgendamentoService() {
    }

    @Override
    public void cadastrar(Agendamento agendamento) {
    	//2 - N�o pode efetuar agendamento com data retroativa
        agendamento.getConsulta().setAgendamento(agendamento);        
        agendamentoDAO.add(agendamento);
    }

    @Override
    public Agendamento buscarPorID(Long id) {
        return agendamentoDAO.findById(id);
    }


    //Cancelar
    public void cancelar(Agendamento agendamento) {
    	agendamento.setStatus(StatusConsulta.CANCELADA);
    	agendamentoDAO.update(agendamento);    	
    }

    //Reagendar
    public void reeagendar(Agendamento agendamento) {
    	agendamento.setStatus(StatusConsulta.REAGENDADA);
    	agendamentoDAO.update(agendamento);    
    }

    //Consultar por periodo
    @Override
    public List<Agendamento> consultarPorPeriodo(Date inicio, Date fim) {
        return agendamentoDAO.consultarPorPeriodo(inicio, fim);

    }
}
