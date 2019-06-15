package br.com.consultemed.model;

import java.util.Date;

public class Medico extends Pessoa{

    private String CRM;

    public Medico(String CRM) {
        this.CRM = CRM;
    }

    public Medico(String nome, String cpf, Date dataNascimento, String CRM) {
        super(nome, cpf, dataNascimento);
        this.CRM = CRM;
    }
}
