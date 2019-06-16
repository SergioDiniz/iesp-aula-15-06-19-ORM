package br.com.consultemed.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medico medico;
    @OneToOne
    private Agendamento agendamento;
    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames;

    public Consulta() { }

    public Consulta(Medico medico, Agendamento agendamento, List<Exame> exames) {
        this.medico = medico;
        this.agendamento = agendamento;
        this.exames = exames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
}
