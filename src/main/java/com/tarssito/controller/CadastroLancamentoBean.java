package com.tarssito.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.tarssito.model.Lancamento;
import com.tarssito.model.Pessoa;
import com.tarssito.model.TipoLancamento;
import com.tarssito.repository.PessoaRepository;
import com.tarssito.service.LancamentoService;
import com.tarssito.service.exception.BusinessException;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private LancamentoService lancamentoService;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	private Lancamento lancamento = new Lancamento();
	private List<Pessoa> todasPessoas;

	public void prepararCadastro() {		 
		this.todasPessoas = pessoaRepository.findAll();
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			this.lancamentoService.save(this.lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
		} catch (BusinessException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} 
	}

	public List<Pessoa> getTodasPessoas() {
		return this.todasPessoas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

}
