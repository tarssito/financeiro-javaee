package com.tarssito.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import com.tarssito.model.Lancamento;
import com.tarssito.model.util.JpaUtil;
import com.tarssito.repository.Lancamentos;

@ManagedBean
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Lancamento> lancamentos;

	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
		this.lancamentos = lancamentos.findAll();
		manager.close();

	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
