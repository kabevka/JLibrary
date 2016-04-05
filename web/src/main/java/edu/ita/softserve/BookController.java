package edu.ita.softserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
