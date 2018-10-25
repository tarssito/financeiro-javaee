package com.tarssito.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.tarssito.model.Lancamento;
import com.tarssito.repository.LancamentoRepository;
import com.tarssito.service.exception.BusinessException;
import com.tarssito.util.Transactional;

public class LancamentoService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoRepository repository;

	@Transactional
	public void save(Lancamento lancamento) throws BusinessException {
		if (lancamento.getDataPagamento() != null && 
				lancamento.getDataPagamento().after(new Date())) {
			throw new BusinessException("Data de pagamento não pode ser uma data futura.");
		}
		this.repository.insert(lancamento);
	}
}
