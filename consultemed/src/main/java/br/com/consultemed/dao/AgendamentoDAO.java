package br.com.consultemed.dao;

import br.com.consultemed.model.Agendamento;

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

}
