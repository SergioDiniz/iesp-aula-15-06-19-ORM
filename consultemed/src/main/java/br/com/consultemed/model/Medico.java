package br.com.consultemed.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Medico extends Pessoa{

    private String CRM;

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    public Medico() {}

    public Medico(String CRM) {
        this.CRM = CRM;
    }

    public Medico(String nome, String cpf, Date dataNascimento, String CRM) {
        super(nome, cpf, dataNascimento);
        this.CRM = CRM;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
