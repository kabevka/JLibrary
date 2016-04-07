package edu.ita.softserve;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ita.softserve.DTO.RequestDto;
import edu.ita.softserve.entity.Author;
import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Publication;
import edu.ita.softserve.service.BookService;
import edu.ita.softserve.service.InstanceService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	 public String addBook(@ModelAttribute("bookDTO") RequestDto requestDTO){

		Book book = new Book();
		book.setAmountOfPage(requestDTO.getAmountOfPage());
		book.setName(requestDTO.getName());
		book.setDescription(requestDTO.getDescription());
		book.setYear(requestDTO.getYear());
		
		Author author = new Author();
		author.setName(requestDTO.getAuthorName());
		author.setSurname(requestDTO.getAuthorSurname());
				
		Publication publication = new Publication();
		publication.setName(requestDTO.getPublicationName());
		
		book.setAuthor(author);
		book.setPublication(publication);
		
		bookService.addBook(book);
			return "addRemove";
	}
	
	@RequestMapping(value = "/instance")
	 public String local(){
			return "instance";
	}
	
	@RequestMapping(value = "/addRemove")
	 public String redirect(){
			return "addRemove";
	}
	
	@RequestMapping(value = "/main")
	 public String redirectInHome(){
			return "home";
	}
}
