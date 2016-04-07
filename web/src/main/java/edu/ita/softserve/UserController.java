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
	@RequestMapping(value = "/addNewUser", method = RequestMethod.GET)
	public String addUser(final Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}
	/**
	 * 
	 * @param user 
	 * 		User for add
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user")final User user, final BindingResult result) {
		userService.add(user);
		return "add-user";
	}
	/**
	 * 
	 * @param model
	 * @return redirect on page user
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(final Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "user";
	}

	@RequestMapping(value = "/deptors", method = RequestMethod.GET)
	public String deptors(Locale locale, Model model) {
		List<User> deptors = userService.getAllDeptors();
		model.addAttribute("users", deptors);
		return "deptors";
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
