package br.com.consultemed.dao;

import br.com.consultemed.model.Consulta;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class ConsultaDAO extends DAO<Consulta> {
    public ConsultaDAO() {
        super(Consulta.class);
    }

    public List<Consulta>  consultarPorPeriodo(Date inicio, Date fim){
        Query query = this.getManager().createQuery("SELECT C FROM Consulta C WHERE C.dataDaConsulta BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", inicio, TemporalType.DATE);
        query.setParameter("dataFinal", fim, TemporalType.DATE);

        List<Consulta> result = query.getResultList();
        return result;
    }
}
