package br.com.consultemed.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

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
        System.out.println("1 - Cadastro de Pasciente");
        Paciente p = new Paciente("Sergio", "159753123419", new Date());
        p.getContatos().add(new Contato("Bel", "bel@g.com.br", "8355555555", p));
        p.setEndereco(new Endereco("58925000", "Santa helena", "Centro", "Paraiba", "PB"));
        p.getEmails().add(new Email("sergio@g.com.br", p));
        p.getTelefones().add(new Telefone("83", "88888888", p));
        ps.cadastrar(p);

        // 1 - Cadastro de Medico
        ms.cadastrar(new Medico("Sergio", "159753123457", new Date(), "1234568"));
        ms.cadastrar(new Medico("Arthur", "159753123520", new Date(), "1234568"));


        // 1 - Cadastro de Pasciente
        Paciente p1 = new Paciente("Arthur", "159753123430", new Date());
        p1.getContatos().add(new Contato("Bel", "bel@g.com.br", "8355555555", p));
        p1.setEndereco(new Endereco("58925000", "Santa helena", "Centro", "Paraiba", "PB"));
        p1.getEmails().add(new Email("sergio@g.com.br", p));
        p1.getTelefones().add(new Telefone("83", "88888888", p));
        ps.cadastrar(p1);
        // 1 - Cadastro de Pasciente
        Paciente p2 = new Paciente("Arthugio", "159753123450", new Date());
        p2.getContatos().add(new Contato("Bel", "bel@g.com.br", "8355555555", p));
        p2.setEndereco(new Endereco("58925000", "Santa helena", "Centro", "Paraiba", "PB"));
        p2.getEmails().add(new Email("sergio@g.com.br", p));
        p2.getTelefones().add(new Telefone("83", "88888888", p));
        ps.cadastrar(p2);



        // 2 - Cadastro Agendamento/Consulta
        System.out.println("2 - Cadastro Agendamento/Consulta");
        System.out.println("2 - Agendamento com data retroativa");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("18/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(1l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento no mesmo dia mas em hora retroativa");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("27/06/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(4l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento 1 - Mesmo dia para paciente e medico diferentes");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento 2 - Mesmo dia para paciente e medico diferentes");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(4l),
                new Consulta(ms.buscarPorID(3l))
        ));
        System.out.println("2 - Agendamento 3 - Mesmo Horario que Agendamento 1");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 10:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento 4 - Data e Hora valida");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 10:30:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento 5 - Data e Hora valida");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 11:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));
        System.out.println("2 - Agendamento 6 - Data e Hora valida");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 12:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));


        // 3 - Consultar Consultas por PerÃ­odo
        System.out.println("3 - Consultar Consultas por Perí­odo");
        cs.consultarPorPeriodo(
                DataUtils.stringToDate("18/06/2019"),
                DataUtils.stringToDate("20/06/2019")).forEach(System.out::println);


        // 4 - Consultar Agendamento por PerÃ­odo
        System.out.println("4 - Consultar Agendamento por Perí­odo");
        as.consultarPorPeriodo(
                DataUtils.stringToDate("18/06/2019"),
                DataUtils.stringToDate("20/06/2019")).forEach(System.out::println);

        // 5 - Consultar Paciente
        System.out.println("5 - Consultar Paciente");
        Optional<Paciente> opPaci = ps.consultarPaciente("15975312341");
        if(opPaci.isPresent()){
            System.out.println(opPaci.get().toString());
        }


        //6 - Cancelar consultas
        System.out.println("6 - Cancelar consultas");
        Consulta cCancelar = cs.buscarPorID(4L);
        cs.cancelar(cCancelar);

        //7 - Cancelar um agendamento
        System.out.println("7 - Cancelar um agendamento");
        Agendamento aCancelar = as.buscarPorID(3L);
        System.out.println("Agendamento: " + aCancelar.getId() + " cancelado");
        as.cancelar(aCancelar);
        //7 - Cancelar um agendamento
        Agendamento aCancelar2 = as.buscarPorID(4L);
        System.out.println("Agendamento: " + aCancelar2.getId() + " cancelado");
        as.cancelar(aCancelar2);
        

        //8 - Reagendamento de consulta
        System.out.println("8 - Reagendamento de consulta");
        Agendamento aReagendar = as.buscarPorID(3L);
        aReagendar.setDataDaConsulta(DataUtils.stringToDate("20/07/2019 13:00:00", "dd/MM/yyyy hh:mm:ss"));
        as.reeagendar(aReagendar);

        System.out.println("2 - Agendamento 7 - Agendando em uma hora cancelada");
        as.cadastrar(new Agendamento(
                DataUtils.stringToDate("20/07/2019 11:00:00", "dd/MM/yyyy hh:mm:ss"),
                ps.buscarPorID(5l),
                new Consulta(ms.buscarPorID(2l))
        ));
    }

}
