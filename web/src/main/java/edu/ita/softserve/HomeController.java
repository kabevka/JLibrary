package edu.ita.softserve;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ita.softserve.entity.Book;
import edu.ita.softserve.service.BookService;

@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Locale locale, Model model){
		return "home";
	}
	

}
