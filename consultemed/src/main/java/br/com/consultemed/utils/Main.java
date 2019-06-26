package br.com.consultemed.utils;

import br.com.consultemed.dao.MedicoDAO;
import br.com.consultemed.dao.PacienteDAO;
import br.com.consultemed.model.*;
import br.com.consultemed.service.AgendamentoService;
import br.com.consultemed.service.ConsultaService;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        PacienteService ps = new PacienteService();
        MedicoService ms = new MedicoService();
        AgendamentoService as = new AgendamentoService();
        ConsultaService cs = new ConsultaService();

        // Cadastro de Pasciente
        ps.cadastrar(new Paciente("Sergio", "159753123419", new Date()));

        // Cadastro de Medico
        ms.cadastrar(new Medico("Sergio", "159753123457", new Date(), "1234568"));

        // Cadastro Agendamento/Consulta
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("15/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(1l),
                new Consulta(ms.buscarPorID(2l))
        ));

        // Cadastro Agendamento/Consulta
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("18/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(1l),
                new Consulta(ms.buscarPorID(2l))
        ));

        	
        //Consultar Consulta
        cs.consultarPorPeriodo(
                DataUtils.stringToDate("18/06/2019"),
                DataUtils.stringToDate("20/06/2019")).forEach(System.out::println);

        //Cancelar um agendamento
        Agendamento aCancelar = as.buscarPorID(2L); 
        aCancelar.toString();        
        as.cancelar(aCancelar);
        
    }

}
