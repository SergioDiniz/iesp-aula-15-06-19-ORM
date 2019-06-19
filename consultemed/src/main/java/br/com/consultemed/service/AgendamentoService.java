package br.com.consultemed.service;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.model.Agendamento;

public class AgendamentoService implements IAgendamentoService {

    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();


    public AgendamentoService() {
    }

    @Override
    public void cadastrar(Agendamento agendamento) {
        agendamento.getConsulta().setAgendamento(agendamento);
        agendamentoDAO.add(agendamento);
    }

    @Override
    public Agendamento buscarPorID(Long id) {
        return agendamentoDAO.findById(id);
    }

    //Consultar por periodo

    //Cancelar

    //Reagendar
}
