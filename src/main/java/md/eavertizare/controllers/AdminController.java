package md.eavertizare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import md.eavertizare.service.ClientService;
import md.eavertizare.service.CompanyService;

@Controller
public class AdminController {

	private CompanyService companyService;

	@Autowired(required = true)
	@Qualifier(value = "companyService")
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	private ClientService clientService;

	@Autowired(required = true)
	@Qualifier(value = "clientService")
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/homeAdmin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Home page for Admin");
		model.addObject("message", "This page is for ROLE_ADMIN only!");

		model.addObject("allCompany", companyService.findAll());
		model.setViewName("homeAdmin");

		return model;

	}

	@RequestMapping(value = "/showCompany", method = RequestMethod.GET)
	public ModelAndView showCopany(@RequestParam("name") String name) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.addObject("company", companyService.findByCompanyName(name));
		model.setViewName("homeAdmin");

		return model;

	}

	@RequestMapping(value = "/clientCompany", method = RequestMethod.GET)
	public ModelAndView showCopanyClients(@RequestParam("name") String name) {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Clienti");
		model.addObject("message", "This page is for ROLE_ADMIN only!");

		model.addObject("clientCompany", clientService.findByCompany(companyService.findByCompanyName(name)));
		model.setViewName("homeAdmin");

		return model;

	}

}