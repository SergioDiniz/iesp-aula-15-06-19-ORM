package br.com.consultemed.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Exame {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	private Date dataRealizacao;
	@ManyToOne
	private Consulta consulta;

	public Exame() {}

	public Exame(String descricao, Date dataRealizacao) {
		this.descricao = descricao;
		this.dataRealizacao = dataRealizacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
