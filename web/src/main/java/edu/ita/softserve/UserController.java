package edu.ita.softserve;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ita.softserve.entity.Adress;
import edu.ita.softserve.entity.User;
import edu.ita.softserve.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/adser", method = RequestMethod.GET)
	public String addUser(Model model) {
		User user = new User("Volodymyr", "Krokhmalyuk", 1, 638607115, new Adress("Lviv","Lychaki","1",1));
		userService.add(user);
		model.addAttribute("user", new User());
		return "add-user";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result) {
		userService.add(user);
		return "add-user";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Locale locale, Model model) {
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
	public String avarageAgeByBookUsing(@RequestParam(value = "bookName") String bookName, Model model) {
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
			@RequestParam(value = "secondName") String secondName, Model model) {
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

	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public String showUsingByPeriod(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "secondName") String secondName, @RequestParam(value = "startDate") Date dateStart,
			@RequestParam(value = "endDate") Date dateEnd, Model model) {
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
}
