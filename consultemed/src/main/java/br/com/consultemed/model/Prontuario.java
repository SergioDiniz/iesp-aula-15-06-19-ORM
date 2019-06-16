package br.com.consultemed.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "prontuario")
    private Paciente paciente;
    @OneToMany(mappedBy = "prontuario")
    private List<Historico> historicos;

    public Prontuario() {  }

    public Prontuario(Paciente paciente, List<Historico> historicos) {
        this.paciente = paciente;
        this.historicos = historicos;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }
}
