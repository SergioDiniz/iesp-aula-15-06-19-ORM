package br.com.consultemed.service;

import java.util.Date;
import java.util.List;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.enums.StatusConsulta;
import br.com.consultemed.model.Agendamento;

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
	public boolean reeagendar(Agendamento agendamento) {
		agendamento.setStatus(StatusConsulta.REAGENDADA);
		agendamento.getConsulta().setStatus(StatusConsulta.REAGENDADA);
		if(agendamento.getConsulta().getStatus() != StatusConsulta.CANCELADA) {
			agendamento.getConsulta().setAgendamento(agendamento);
			agendamentoDAO.update(agendamento);
			return true;
		}else {
			return false;	
		}    	  
	}

	//Consultar por periodo
	@Override
	public List<Agendamento> consultarPorPeriodo(Date inicio, Date fim) {
		return agendamentoDAO.consultarPorPeriodo(inicio, fim);

	}
}
