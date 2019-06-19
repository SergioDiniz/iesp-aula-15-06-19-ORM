package br.com.consultemed.model;

import br.com.consultemed.enums.StatusConsulta;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medico medico;
    @OneToOne(mappedBy = "consulta")
    private Agendamento agendamento;
    @OneToMany(mappedBy = "consulta")
    private List<Exame> exames;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaConsulta;
    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    public Consulta() { }

    public Consulta(Medico medico) {
        this.medico = medico;
    }

    public Consulta(Medico medico, Agendamento agendamento) {
        this.medico = medico;
        this.agendamento = agendamento;
    }

    @PrePersist
    public void prePersist(){
        this.status = StatusConsulta.NORMAL;
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

    public Date getDataDaConsulta() {
        return dataDaConsulta;
    }

    public void setDataDaConsulta(Date dataDaConsulta) {
        this.dataDaConsulta = dataDaConsulta;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", medico=" + medico +
                ", agendamento=" + agendamento +
                ", dataDaConsulta=" + dataDaConsulta +
                ", status=" + status +
                '}';
    }
}
