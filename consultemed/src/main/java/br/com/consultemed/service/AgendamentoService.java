package br.com.consultemed.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.enums.StatusConsulta;
import br.com.consultemed.exception.DataAgendamentoException;
import br.com.consultemed.model.Agendamento;
import br.com.consultemed.utils.DataUtils;

public class AgendamentoService implements IAgendamentoService {

	AgendamentoDAO agendamentoDAO = new AgendamentoDAO();


	public AgendamentoService() {
	}

	@Override
	public void cadastrar(Agendamento agendamento) {
		//2 - N�o pode efetuar agendamento com data retroativa
		try{
			validarAgendamento(agendamento);

			agendamento.getConsulta().setAgendamento(agendamento);
			agendamentoDAO.add(agendamento);

		} catch (DataAgendamentoException ex){
			ex.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}


	}

	public void validarAgendamento(Agendamento agendamento){
		if(agendamento.getDataDaConsulta().before(new Date())){
			throw new DataAgendamentoException("Data de Agendamento Invalida: " + DataUtils.formatarData(agendamento.getDataDaConsulta(), "dd/MM/yyyy hh:mm:ss"));
		}

		List<Agendamento> agendamentosMarcados = new ArrayList<>();
		agendamentosMarcados.addAll(agendamentoDAO.consultarPorPeriodoMedico(agendamento.getDataDaConsulta(), agendamento.getDataDaConsulta(), agendamento.getConsulta().getMedico()));
		agendamentosMarcados.addAll(agendamentoDAO.consultarPorPeriodoPasciente(agendamento.getDataDaConsulta(), agendamento.getDataDaConsulta(), agendamento.getPaciente()));
		agendamentosMarcados = agendamentosMarcados.stream().filter( a -> a.getStatus() != StatusConsulta.CANCELADA).collect(Collectors.toList());
		if(agendamentosMarcados.size() > 0){
			throw new DataAgendamentoException("Data informada ja possui Agendamento: " + DataUtils.formatarData(agendamento.getDataDaConsulta(), "dd/MM/yyyy hh:mm:ss"));
		}

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

		try{
			agendamento.setStatus(StatusConsulta.REAGENDADA);
			agendamento.getConsulta().setStatus(StatusConsulta.REAGENDADA);

			validarAgendamento(agendamento);

			if(agendamento.getConsulta().getStatus() == StatusConsulta.CANCELADA) {
				throw new DataAgendamentoException("Consulta cancelada não pode ser agendada");
			}

			agendamento.getConsulta().setAgendamento(agendamento);
			agendamentoDAO.update(agendamento);

		} catch (DataAgendamentoException ex){
			ex.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	//Consultar por periodo
	@Override
	public List<Agendamento> consultarPorPeriodo(Date inicio, Date fim) {
		return agendamentoDAO.consultarPorPeriodo(inicio, fim);

	}
}
