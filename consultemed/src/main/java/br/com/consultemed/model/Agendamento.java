package br.com.consultemed.model;

import br.com.consultemed.enums.StatusConsulta;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDaConsulta;
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaDoAgentamento;
    @ManyToOne
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL)
    private Consulta consulta;
    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    public Agendamento() { }

    public Agendamento(Date dataDaConsulta, Paciente paciente, Consulta consulta) {
        this.dataDaConsulta = dataDaConsulta;
        this.paciente = paciente;
        this.consulta = consulta;
    }

    @PrePersist
    private void prePersist(){
        this.diaDoAgentamento = new Date();
        this.status = StatusConsulta.NORMAL;
        this.consulta.setDataDaConsulta(this.dataDaConsulta);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDaConsulta() {
        return dataDaConsulta;
    }

    public void setDataDaConsulta(Date data) {
        this.dataDaConsulta = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Date getDiaDoAgentamento() {
        return diaDoAgentamento;
    }

    public void setDiaDoAgentamento(Date diaDoAgentamento) {
        this.diaDoAgentamento = diaDoAgentamento;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", dataDaConsulta=" + dataDaConsulta +
                ", diaDoAgentamento=" + diaDoAgentamento +
                ", paciente=" + paciente +
                ", status=" + status +
                '}';
    }
}
