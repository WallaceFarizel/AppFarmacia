package br.com.farmacia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.farmacia.model.negocio.Pharmacos;
import br.com.farmacia.model.service.PharmacosService;

@Controller
public class PharmacosController {

	@Autowired
	private PharmacosService service;
	
	@RequestMapping(value = "/produto/pharmacos", method = RequestMethod.GET)
	public String showLista(
				Model model
			) {
		model.addAttribute("pharmacos", service.obterLista());
		
		return "/produto/pharmaco/lista";
	}
	
	@RequestMapping(value = "/produto/pharmaco", method = RequestMethod.GET)
	public String showDetalhe() {
		return "/produto/pharmaco/detalhe";
	}
	
	@RequestMapping(value = "/produto/pharmaco", method = RequestMethod.POST)
	public String incluir(
				Model model,
				Pharmacos pharmaco
			) {
		
		service.incluir(pharmaco);
		
		return this.showLista(model);
	}
	
	@RequestMapping(value = "/produto/pharmaco/excluir/{id}", method = RequestMethod.GET)
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		service.excluir(id);
		
		return this.showLista(model);
	}

	public PharmacosService getService() {
		return service;
	}
	public void setService(PharmacosService service) {
		this.service = service;
	}
}