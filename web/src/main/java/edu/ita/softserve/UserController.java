package edu.ita.softserve;

import java.sql.Date;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ita.softserve.entity.User;
import edu.ita.softserve.service.UserService;

/**
 * 
 * Controller for user pages
 * 
 * @author Volodymyr Krokhmaliuk
 *
 */
@Controller
public class UserController {
	
	/**
	 * User service
	 */
	@Autowired
	UserService userService;

	
	/**
	 * 
	 * @param model
	 * @return add-user page
	 */
	@RequestMapping(value = "/adser", method = RequestMethod.GET)
	public String addUser(final Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")final User user, final BindingResult result) {
		userService.add(user);
		return "add-user";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(final Locale locale, final Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "user";
	}

	@RequestMapping(value = "/deptors", method = RequestMethod.GET)
	public String deptors(Locale locale, Model model) {
		List<User> deptors = userService.getAllDeptors();
		model.addAttribute("users", deptors);
		return "user";
	}

	@RequestMapping(value = "/user-statistic", method = RequestMethod.GET)
	public String userStatistics() {
		return "user-statistic";
	}

	@RequestMapping(value = "/bookTitle", method = RequestMethod.POST)
	public String avarageAgeByBookUsing(@RequestParam(value = "bookName")final String bookName, final Model model) {
		double age = 0;
		try {
			age = userService.getAvarageAgeByBookName(bookName);
		} catch (NullPointerException exception) {
			model.addAttribute("age", "Book don't exist");
		}
		model.addAttribute("age", age);
		return "user-statistic";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUserName(@RequestParam(value = "firstName") String fisrtName,
			@RequestParam(value = "secondName")final String secondName,final Model model) {
		long time = 0;
		try {
			User user = userService.getUserByAllName(fisrtName, secondName);
			time = userService.timeOfLibraryUsing(user);
		} catch (IndexOutOfBoundsException exception) {
			model.addAttribute("timeOfUsing", 0);
		}
		model.addAttribute("timeOfUsing", time);
		return "user-statistic";
	}

	/**
	 * 
	 * Controller for show time of user using library
	 * 
	 * @param firstName 
	 * 			first user name
	 * @param secondName 
	 * 			second user name
	 * @param dateStart 
	 * 			start date for search
	 * @param dateEnd 
	 * 			end date for search
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public String showUsingByPeriod(@RequestParam(value = "firstName")final String firstName,
			@RequestParam(value = "secondName")final String secondName,
			@RequestParam(value = "startDate")final Date dateStart,
			@RequestParam(value = "endDate")final Date dateEnd,final Model model) {
		long count = 0;
		try {
			User user = userService.getUserByAllName(firstName, secondName);
			count = userService.countOfApplicationByTime(dateStart, dateEnd, user);
		} catch (IndexOutOfBoundsException exception) {
			model.addAttribute("count", 0);
		}
		model.addAttribute("count", count);
		return "user-statistic";
	}
	
	@RequestMapping(value = "/give_book", method = RequestMethod.GET)
	 public String displayUserInfo(Map<String, Object> map) {
	  map.put("allUsers", userService.getAll());
	  map.put("allBooks", userService.getAll());
	  return "give_book";
	 }
	
	@RequestMapping(value = "/giveBookForUser", method = RequestMethod.POST)
	 public String addBookForUser(@RequestParam(value = "userValue") String user ) {
	  User user2 = userService.findById(Integer.parseInt(user));	  
	  return "give_book";
	 }
}
