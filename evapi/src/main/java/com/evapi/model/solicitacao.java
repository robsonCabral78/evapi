package com.evapi.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "solicitacao")
@SequenceGenerator(name = "seq_solicitacao", sequenceName = "seq_solicitacao", allocationSize = 1, initialValue = 1)
public class solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_solicitacao")
	private Long id;

	@OneToOne(targetEntity = pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private pessoa pessoa;

	private String endrecoSolicitacao;

	@Column(length = 20)
	private String numero;

	@Column(length = 50)
	private String bairro;
	
	@Column(length = 80)
	private String pontoReferencia;

	@Column(length = 20)
	private String telefone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoSolicitacao_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "tipoSolicitacao_id_fk"))
	private tipoSolicitacao tipoSolicitacao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "imagemSolicitacao_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "imagemSolicitacao_id_fk"))
	private imagemSolicitacao imgSolicitacao;

	@Temporal(TemporalType.DATE)
	private Date dataSolicitacao;

	@Column(columnDefinition = "VARCHAR(30) DEFAULT 'Em Aberto'")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getEndrecoSolicitacao() {
		return endrecoSolicitacao;
	}

	public void setEndrecoSolicitacao(String endrecoSolicitacao) {
		this.endrecoSolicitacao = endrecoSolicitacao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public tipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(tipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public imagemSolicitacao getImgSolicitacao() {
		return imgSolicitacao;
	}

	public void setImgSolicitacao(imagemSolicitacao imgSolicitacao) {
		this.imgSolicitacao = imgSolicitacao;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		solicitacao other = (solicitacao) obj;
		return Objects.equals(id, other.id);
	}

}
