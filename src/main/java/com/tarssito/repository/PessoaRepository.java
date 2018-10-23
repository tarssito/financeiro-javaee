package com.tarssito.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tarssito.model.Pessoa;;

public class PessoaRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Pessoa> findAll() {
		TypedQuery<Pessoa> query = manager.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}

	public Pessoa findById(Long id) {
		return manager.find(Pessoa.class, id);
	}

}
