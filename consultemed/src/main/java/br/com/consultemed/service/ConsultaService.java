package br.com.consultemed.service;

import br.com.consultemed.dao.ConsultaDAO;
import br.com.consultemed.model.Consulta;

public class ConsultaService implements IConsultaService {

    ConsultaDAO consultaDAO = new ConsultaDAO();

    public ConsultaService() { }

    @Override
    public void cadastrar(Consulta consulta) {
        consultaDAO.add(consulta);
    }
}
