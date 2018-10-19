package com.tarssito.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tarssito.model.Lancamento;

public class Lancamentos implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public Lancamentos(EntityManager manager) {
		this.manager = manager;
	}

	public List<Lancamento> findAll() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}

}
