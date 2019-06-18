package br.com.consultemed.utils;

import br.com.consultemed.dao.PacienteDAO;
import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;

import javax.persistence.EntityManager;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        EntityManager factory = JPAUtils.getEntityManagerFactory().createEntityManager();
//        System.out.println("Criando o contato");
//
//        Contato contato = new Contato("Sergio Diniz", "sergio@emai.com", "8355555555");
//
//        System.out.println("Contato criado");
//
//        Paciente paciente = new Paciente("Sergio", "159753123456", new Date());
//        Medico medico = new Medico("Sergio", "159753123456", new Date(), "1234568");
//
//        factory.getTransaction().begin();
//        factory.persist(paciente);
//        factory.persist(medico);
//        factory.getTransaction().commit();
//        factory.close();

        PacienteService ps = new PacienteService();
        ps.cadastrar(new Paciente("Sergio", "159753123419", new Date()));

        MedicoService ms = new MedicoService();
        ms.cadastrar(new Medico("Sergio", "159753123457", new Date(), "1234568"));

    }

}
