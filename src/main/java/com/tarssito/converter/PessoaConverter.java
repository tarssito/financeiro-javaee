package com.tarssito.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.tarssito.model.Pessoa;
import com.tarssito.repository.PessoaRepository;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

	@Inject
	private PessoaRepository pessoaRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		if (value != null) {
			retorno = this.pessoaRepository.findById(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Pessoa) value).getId().toString();
		}
		return null;

	}

}
