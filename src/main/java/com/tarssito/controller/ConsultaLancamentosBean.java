package com.tarssito.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tarssito.model.Lancamento;
import com.tarssito.repository.LancamentoRepository;

@Named
@ViewScoped
public class ConsultaLancamentosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoRepository lancamentoRepository;

	private List<Lancamento> lancamentos;

	public void consultar() {
		this.lancamentos = lancamentoRepository.findAll();
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

}
