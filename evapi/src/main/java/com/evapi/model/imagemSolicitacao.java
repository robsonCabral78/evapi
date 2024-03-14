package com.evapi.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagemSolicitacao")
@SequenceGenerator(name="seq_imagemSolicitacao", sequenceName = "seq_imagemSolicitacao", allocationSize = 1, initialValue = 1)
public class imagemSolicitacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagemSolicitacao")
	private Long id;
	
	@Column(columnDefinition = "text")
	private String imagemOriginal;
	
	@Column(columnDefinition = "text")
	private String imagemMiniatura;

}
