package br.com.consultemed.service;

import br.com.consultemed.dao.ConsultaDAO;
import br.com.consultemed.enums.StatusConsulta;
import br.com.consultemed.model.Consulta;
import java.util.Date;
import java.util.List;

public class ConsultaService implements IConsultaService {

    ConsultaDAO consultaDAO = new ConsultaDAO();

    public ConsultaService() { }

    @Override
    public void cadastrar(Consulta consulta) {
        consultaDAO.add(consulta);
    }

    @Override
    public Consulta buscarPorID(Long id) {
        return consultaDAO.findById(id);
    }

    // Consultar por periodo
    @Override
    public List<Consulta> consultarPorPeriodo(Date inicio, Date fim) {
        return consultaDAO.consultarPorPeriodo(inicio, fim);
    }

    public void cancelar(Consulta consulta) {
    	consulta.setStatus(StatusConsulta.CANCELADA);
    	consultaDAO.update(consulta);    	
    }
    
    public void reagendar(Consulta consulta) {
    	consulta.setStatus(StatusConsulta.REAGENDADA);
    	consultaDAO.update(consulta);
    }
}
