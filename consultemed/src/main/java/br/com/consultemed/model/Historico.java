package br.com.consultemed.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;
    private String descricaoAtendimento;
    @OneToOne
    private Consulta consulta;
    @ManyToOne
    private Prontuario prontuario;

    public Historico() {    }


    public Historico(Date dataAtendimento, String descricaoAtendimento, Consulta consulta, Prontuario prontuario) {
        this.dataAtendimento = dataAtendimento;
        this.descricaoAtendimento = descricaoAtendimento;
        this.consulta = consulta;
        this.prontuario = prontuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getDescricaoAtendimento() {
        return descricaoAtendimento;
    }

    public void setDescricaoAtendimento(String descricaoAtendimento) {
        this.descricaoAtendimento = descricaoAtendimento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
}
