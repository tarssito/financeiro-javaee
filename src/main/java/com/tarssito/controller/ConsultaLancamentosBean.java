package com.tarssito.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.tarssito.model.Lancamento;
import com.tarssito.repository.LancamentoRepository;
import com.tarssito.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;

	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		LancamentoRepository lancamentos = new LancamentoRepository(manager);
		this.lancamentos = lancamentos.findAll();
		manager.close();

	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
