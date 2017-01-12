package md.eavertizare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import md.eavertizare.model.Company;
import md.eavertizare.model.User;
import md.eavertizare.service.CompanyService;
import md.eavertizare.service.UserService;

@Controller
public class CompanyController {

	private CompanyService companyService;

	@Autowired(required = true)
	@Qualifier(value = "companyService")
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/showCompanyClient", method = RequestMethod.GET)
	public ModelAndView showCopanyforClient() {

		ModelAndView model = new ModelAndView();

		Company company = null;

		User user = getCurentUser();

		company = companyService.findByUser(user);

		model.addObject("company", company);

		model.setViewName("company");

		return model;

	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.GET)
	public ModelAndView addCompany() {

		ModelAndView model = new ModelAndView();

		model.addObject("company", new Company());

		model.setViewName("edit-company");

		return model;

	}

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public ModelAndView addCompany(@ModelAttribute("company") Company company, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();

		company.setUser(getCurentUser());
		companyService.save(company);

		model.setViewName("redirect:edit-company");

		return model;

	}

	@RequestMapping(value = "/edit-company", method = RequestMethod.GET)
	public ModelAndView succesCompany() {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();

		Company company = companyService.findByUser(user);

		model.addObject("company", company);

		model.setViewName("company");

		return model;

	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public ModelAndView updateCompany(@ModelAttribute("company") Company company, BindingResult bindingResult) {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();

		System.out.println("UPDATE");

		company.setUser(user);
		companyService.update(company);

		model.setViewName("redirect:edit-company");

		return model;

	}

	@RequestMapping(value = "/updateCompany", method = RequestMethod.GET)
	public ModelAndView updateCompany() {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();
		Company company = companyService.findByUser(user);

		model.addObject("company", company);

		model.setViewName("update-company");

		return model;

	}

	private User getCurentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		return userService.findByName(name);
	}
}