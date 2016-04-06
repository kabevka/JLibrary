package edu.ita.softserve;

import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addUser(Locale locale, Model model){
		return "add-user";
	}
	
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User user, BindingResult result){
		userService.add(user);
		return "user";
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
	public String userStatistics(Locale locale, Model model) {
		return "user-statistic";
	}

	@RequestMapping(value = "/bookTitle", method = RequestMethod.POST)
	public String avarageAgeByBookusing(@RequestParam(value = "bookName") String bookName, Model model) {
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
	public String addUserName(@RequestParam(value = "firstName")String fisrtName,@RequestParam(value = "secondName")String secondName, Model model){
		long time = 0;
		try{User user = userService.getUserByAllName(fisrtName, secondName);
		time = userService.timeOfLibraryUsing(user);
		}catch(IndexOutOfBoundsException exception){
			model.addAttribute("timeOfUsing",0);
		}
		model.addAttribute("timeOfUsing",time);
		return "user-statistic";
	}

	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public String showUsingByPeriod(@RequestParam(value = "firstName")String firstName, @RequestParam(value = "secondName")String secondName,
			@RequestParam(value = "startDate")Date dateStart, @RequestParam(value = "endDate")Date dateEnd, Model model){
		long count = 0;
		try{User user = userService.getUserByAllName(firstName, secondName);
		count = userService.countOfApplicationByTime(dateStart, dateEnd, user);
		}catch(IndexOutOfBoundsException exception){
			model.addAttribute("count",0);
		}
		model.addAttribute("count",count);
		return "user-statistic";
	}
	
}

