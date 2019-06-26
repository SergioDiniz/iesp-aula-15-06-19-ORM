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

        // 1 - Cadastro de Pasciente
        Paciente p = new Paciente("Sergio", "159753123419", new Date());
        p.getContatos().add(new Contato("Bel", "bel@g.com.br", "8355555555", p));
        p.setEndereco(new Endereco("58925000", "Santa helena", "Centro", "Paraiba", "PB"));
        p.getEmails().add(new Email("sergio@g.com.br", p));
        p.getTelefones().add(new Telefone("83", "88888888", p));
        ps.cadastrar(p);

        // 1 - Cadastro de Medico
        ms.cadastrar(new Medico("Sergio", "159753123457", new Date(), "1234568"));

        // 1 - Cadastro Agendamento/Consulta
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("15/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(1l),
                new Consulta(ms.buscarPorID(2l))
        ));

        // 2 - Cadastro Agendamento/Consulta
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("18/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(1l),
                new Consulta(ms.buscarPorID(2l))
        ));


        // 3 - Consultar Consultas por Período
        cs.consultarPorPeriodo(
                DataUtils.stringToDate("18/06/2019"),
                DataUtils.stringToDate("20/06/2019")).forEach(System.out::println);


        // 4 - Consultar Agendamento por Período
        as.consultarPorPeriodo(
                DataUtils.stringToDate("18/06/2019"),
                DataUtils.stringToDate("20/06/2019")).forEach(System.out::println);

        // 7 - Cancelar um agendamento
        Agendamento aCancelar = as.buscarPorID(2L);
        aCancelar.toString();
        as.cancelar(aCancelar);

    }

}
