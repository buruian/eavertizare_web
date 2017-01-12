package md.eavertizare.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import md.eavertizare.model.Client;
import md.eavertizare.model.Company;
import md.eavertizare.model.User;
import md.eavertizare.service.ClientService;
import md.eavertizare.service.CompanyService;
import md.eavertizare.service.UserService;
import md.eavertizare.util.MyExcelUtil;
import md.eavertizare.util.MyMailSender;
import md.eavertizare.util.MySmsSender;

@Controller
public class ClientController {

	@Autowired
	private MyMailSender myMailSender;

	@Autowired
	private MySmsSender mySmsSender;

	private ClientService clientService;

	@Autowired(required = true)
	@Qualifier(value = "clientService")
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

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

	@RequestMapping(value = { "/homeUser", "/add-client" }, method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication   Ce Vrau");
		model.addObject("message", "This page is for ROLE_USER only!");

		User user = getCurentUser();

		Company company = null;

		if (companyService.findByUser(user) == null) {
			model.addObject("message", "Trebuie sa adaugati o campanie");
			model.addObject("company", new Company());

			model.setViewName("edit-company");

		} else {
			company = companyService.findByUser(user);

			List<Client> listClients = null;

			listClients = company.getClients();

			model.addObject("listClients", listClients);

			model.setViewName("homeUser");

		}

		return model;

	}

	@RequestMapping(value = { "/addClient", "/editClient" }, method = RequestMethod.GET)
	public ModelAndView addClient() {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();
		System.out.println(user.toString());
		List<Client> listClients = null;
		Company company = companyService.findByUser(user);

		listClients = company.getClients();

		model.addObject("listClients", listClients);

		model.setViewName("add-client");

		return model;

	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public ModelAndView addClient(@RequestParam("file") MultipartFile file) {
		ModelAndView model = new ModelAndView();
		if (!file.isEmpty()) {
			try {

				String[] extension = { "xlsx", "xls", "xlt" };
				if (!FilenameUtils.isExtension(file.getOriginalFilename(), extension)) {
					model.addObject("error", "Incoret file extension. File " + file.getOriginalFilename());
					model.setViewName("add-client");

				} else {

					List<Client> listClients = MyExcelUtil.readClientsFromExcelFile(file);

					User user = getCurentUser();
					System.out.println(user.toString());

					Company company = companyService.findByUser(user);

					for (Client client1 : listClients) {
						client1.setCompany(company);

					}

					this.clientService.save(listClients);

					// Read more at
					// http://www.java2blog.com/2016/02/how-to-read-excel-files-in-java-using.html#A6fWij5RKefBKZ3i.99

					String msg = "You successfully uploaded file=" + file.getOriginalFilename();
					model.addObject("msg", msg);
					model.setViewName("redirect:add-client");
				}
			} catch (Exception e) {
				String msg = "You failed to upload " + file.getOriginalFilename() + " => " + e;
				model.addObject("error", msg);
				model.setViewName("add-client");
			}
		} else {
			String msg = "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
			model.addObject("msg", msg);
			model.setViewName("add-client");
		}

		return model;
	}

	@RequestMapping(value = "/editClient", method = RequestMethod.POST)
	public ModelAndView editClient(@RequestParam("file") MultipartFile file) {
		ModelAndView model = new ModelAndView();
		if (!file.isEmpty()) {
			try {

				String[] extension = { "xlsx", "xls", "xlt" };
				if (!FilenameUtils.isExtension(file.getOriginalFilename(), extension)) {
					model.addObject("error", "Incoret file extension. File " + file.getOriginalFilename());
					model.setViewName("add-client");

				} else {

					User user = getCurentUser();

					Company company = companyService.findByUser(user);

					this.clientService.deleteByCompanyId(company.getId());

					List<Client> listClients = MyExcelUtil.readClientsFromExcelFile(file);

					for (Client client1 : listClients) {
						client1.setCompany(company);
					}

					this.clientService.save(listClients);

					String msg = "You successfully uploaded file=" + file.getOriginalFilename();
					model.addObject("msg", msg);
					model.setViewName("redirect:add-client");
				}
			} catch (Exception e) {
				String msg = "You failed to upload " + file.getOriginalFilename() + " => " + e;
				model.addObject("error", msg);
				model.setViewName("add-client");
			}
		} else {
			String msg = "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
			model.addObject("msg", msg);
			model.setViewName("add-client");
		}

		return model;
	}

	@RequestMapping(value = "/editMessage", method = RequestMethod.GET)
	public ModelAndView editMessage() {

		ModelAndView model = new ModelAndView();

		model.addObject("client", new Client());

		model.setViewName("message");

		return model;

	}

	@RequestMapping(value = "/editMessage", method = RequestMethod.POST)
	public ModelAndView editMessage(@ModelAttribute("client") Client client) {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();

		Company company = companyService.findByUser(user);

		this.clientService.updateMessage(client.getMessage(), company.getId());

		model.setViewName("redirect:add-client");

		return model;

	}

	@RequestMapping(value = "/sendEmail/{id}")
	public ModelAndView editEmail(@PathVariable int id) {
		ModelAndView model = new ModelAndView();

		Client client = this.clientService.findById(id);

		model.addObject("client", client);
		model.setViewName("sendMessage");

		return model;

	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailPost(@ModelAttribute("client") Client client, RedirectAttributes redirectAttributes) {

		ModelAndView model = new ModelAndView();

		if (client.getMessage().isEmpty()) {

			model.addObject("messageEmpty", "The message is empty");
			model.setViewName("sendMessage");

		} else {
			myMailSender.sendMail(client.getEmail(), "Avertizare", client.getMessage());
			mySmsSender.sendSms(client.getPhoneNumber(), client.getMessage());

			redirectAttributes.addFlashAttribute("sendEmailSucces",
					"Mail and SMS send succefull to " + client.getFirstName() + " " + client.getLastName() + " ");

			model.setViewName("redirect:homeUser");
		}

		return model;

	}

	@RequestMapping(value = "/exportPdf", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Company company = companyService.findByUser(getCurentUser());
		List<Client> listClients = company.getClients();

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "listClients", listClients);
	}

	private User getCurentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		return userService.findByName(name);
	}
}