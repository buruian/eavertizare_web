package md.eavertizare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {

		ModelAndView model = new ModelAndView();

		model.setViewName("about");

		return model;

	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ModelAndView contacts() {

		ModelAndView model = new ModelAndView();

		model.setViewName("contacts");

		return model;

	}

}