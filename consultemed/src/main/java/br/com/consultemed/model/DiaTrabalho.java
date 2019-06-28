package br.com.consultemed.model;

import br.com.consultemed.enums.DiasSemana;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DiaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Medico medico;

    @Enumerated(EnumType.STRING)
    private DiasSemana diaSemana;

    public DiaTrabalho(Medico medico, DiasSemana diaSemana) {
        this.medico = medico;
        this.diaSemana = diaSemana;
    }

    public DiaTrabalho() {
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

    public DiasSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiasSemana diaSemana) {
        this.diaSemana = diaSemana;
    }
}
