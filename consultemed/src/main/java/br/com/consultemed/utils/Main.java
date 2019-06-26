package br.com.consultemed.utils;

import java.text.ParseException;
import java.util.Date;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Email;
import br.com.consultemed.model.Endereco;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.model.Telefone;
import br.com.consultemed.service.AgendamentoService;
import br.com.consultemed.service.ConsultaService;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;

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

        //6 - Cancelar consultas
        Consulta cCancelar = cs.buscarPorID(4L);
        cs.cancelar(cCancelar);
        
        //7 - Cancelar um agendamento
        Agendamento aCancelar = as.buscarPorID(4L);
        aCancelar.toString();
        as.cancelar(aCancelar);
        
        //8 - Reagendamento de consulta
        Agendamento aReagendar = as.buscarPorID(5L);    
        aReagendar.setDiaDoAgentamento(DataUtils.stringToDate("18/07/2019"));
        Consulta c = cs.buscarPorID(aReagendar.getConsulta().getId());
        cs.reagendar(c);
        as.reeagendar(aReagendar);
        
    }

}
