package md.eavertizare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import md.eavertizare.model.User;
import md.eavertizare.model.UserRole;
import md.eavertizare.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {

		ModelAndView model = new ModelAndView();

		model.addObject("client", new User());

		model.setViewName("registration");

		return model;

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registrationAdd(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView();

		try {

			model.addObject("message", "Register Succefull");

			user.setUserRole(new UserRole(user.getUsername(), "ROLE_USER"));
			userService.save(user);

			model.setViewName("redirect:login");
		} catch (Exception e) {
			String msg = "The user with this username = " + user.getUsername() + " exist in the database => " + e;
			redirectAttributes.addFlashAttribute("error", msg);

			model.setViewName("redirect:registration");
		}
		return model;

	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
	public ModelAndView updateUser() {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();
		model.addObject("client", user);

		model.setViewName("userUpdate");

		return model;

	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public ModelAndView updateUserForm(@ModelAttribute("user") User user) {

		ModelAndView model = new ModelAndView();

		userService.update(user);

		model.setViewName("redirect:profile");

		return model;

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile() {

		ModelAndView model = new ModelAndView();

		User user = getCurentUser();
		model.addObject("user", user);
		System.out.println("profile" + user);
		model.setViewName("profile");

		return model;

	}

	private User getCurentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		return userService.findByName(name);
	}

}