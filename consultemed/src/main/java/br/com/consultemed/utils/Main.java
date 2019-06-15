package br.com.consultemed.utils;

import br.com.consultemed.model.Contato;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        EntityManager factory = JPAUtils.getEntityManagerFactory().createEntityManager();
        System.out.println("Criando o contato");

        Contato contato = new Contato("Sergio Diniz", "sergio@emai.com", "8355555555");

        System.out.println("Contato criado");

        factory.getTransaction().begin();
        factory.persist(contato);
        factory.getTransaction().commit();
        factory.close();

    }

}
