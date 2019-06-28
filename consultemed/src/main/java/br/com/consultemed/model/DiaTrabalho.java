package br.com.consultemed.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DiaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Medico medico;

    @Temporal(TemporalType.DATE)
    private Date dia;

    public DiaTrabalho() {    }

    public DiaTrabalho(Medico medico, Date dia) {
        this.medico = medico;
        this.dia = dia;
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

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "DiaTrabalho{" +
                "id=" + id +
                ", medico=" + medico.toString() +
                ", dia=" + dia +
                '}';
    }
}
