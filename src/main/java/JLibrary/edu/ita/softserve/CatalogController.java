package JLibrary.edu.ita.softserve;


import java.util.Locale;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class CatalogController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "catalog";
	}
	
	@RequestMapping(value = "catalog", method = RequestMethod.GET)
	public String home(Locale locale, Model model){
		return "catalog";
	}
}
