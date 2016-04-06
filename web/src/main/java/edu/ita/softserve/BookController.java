package edu.ita.softserve;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ita.softserve.dao.impl.UserDao;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.User;
import edu.ita.softserve.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	 public String addBook(@ModelAttribute("book") Book book, BindingResult result){
		bookService.add(book);
			return "redirect:/home.jsp";
		    }
	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public String deptors(Locale locale, Model model) {
		List<Book> books = bookService.getAll();
		model.addAttribute("books", books);
		return "catalog";
	}

}
