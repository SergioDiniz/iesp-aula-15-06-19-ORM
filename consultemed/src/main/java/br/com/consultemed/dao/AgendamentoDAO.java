package br.com.consultemed.dao;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class AgendamentoDAO extends DAO<Agendamento> {

    public AgendamentoDAO() {
        super(Agendamento.class);
    }

    public List<Agendamento> consultarPorPeriodo(Date inicio, Date fim){
        Query query = this.getManager().createQuery("SELECT A FROM Agendamento A WHERE A.dataDaConsulta BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", inicio, TemporalType.DATE);
        query.setParameter("dataFinal", fim, TemporalType.DATE);

        List<Agendamento> result = query.getResultList();
        return result;
    }

    public List<Agendamento> consultarPorPeriodoMedico(Date inicio, Date fim, Medico medico){
        Query query = this.getManager().createQuery("SELECT A FROM Agendamento A WHERE A.dataDaConsulta BETWEEN :dataInicial AND :dataFinal AND A.consulta.medico = :medico");
        query.setParameter("dataInicial", inicio, TemporalType.DATE);
        query.setParameter("dataFinal", fim, TemporalType.DATE);
        query.setParameter("medico", medico);

        List<Agendamento> result = query.getResultList();
        return result;
    }

    public List<Agendamento> consultarPorPeriodoPasciente(Date inicio, Date fim, Paciente paciente){
        Query query = this.getManager().createQuery("SELECT A FROM Agendamento A WHERE A.dataDaConsulta BETWEEN :dataInicial AND :dataFinal AND A.paciente = :paciente");
        query.setParameter("dataInicial", inicio, TemporalType.DATE);
        query.setParameter("dataFinal", fim, TemporalType.DATE);
        query.setParameter("paciente", paciente);

        List<Agendamento> result = query.getResultList();
        return result;
    }

    public List<Agendamento> agendamentosComConsultasCancelada(){
        Query query = this.getManager().createQuery("SELECT A FROM Agendamento A where A.status NOT IN (br.com.consultemed.enums.StatusConsulta.CANCELADA) AND A.consulta.status = br.com.consultemed.enums.StatusConsulta.CANCELADA");
        List<Agendamento> result = query.getResultList();

        return result;
    }

}
