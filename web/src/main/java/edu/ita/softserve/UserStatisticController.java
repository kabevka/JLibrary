package edu.ita.softserve;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ita.softserve.entity.User;
import edu.ita.softserve.service.UserService;

/**
 * 
 * @author Volodymyr Krokhmaliuk
 *
 */
@Controller
public class UserStatisticController {

	/**
	 * User service
	 */
	@Autowired
	UserService userService;

	/**
	 * 
	 * @return redirect on user-statistic
	 */
	@RequestMapping(value = "/user-statistic", method = RequestMethod.GET)
	public String userStatistics() {
		return "user-statistic";
	}
	
	/**
	 * 
	 * @param bookName
	 * 			name of book
	 * @param model 
	 * @return redirect on user-statistic page
	 * 
	 */
	@RequestMapping(value = "/bookTitle", method = RequestMethod.POST)
	public String avarageAgeByBookUsing(@RequestParam(value = "bookName") final String bookName, final Model model) {
		double age = 0;
		try {
			age = userService.getAvarageAgeByBookName(bookName);
		} catch (NullPointerException exception) {
			model.addAttribute("age", "Book don't exist");
		}
		model.addAttribute("age", age);
		return "user-statistic";
	}

	/**
	 * 
	 * @param fisrtName
	 * 			first user name
	 * @param secondName
	 * 			second user name
	 * @param model
	 * @return redirect user-stasistic page
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String addUserName(@RequestParam(value = "firstName") String fisrtName,
			@RequestParam(value = "secondName") final String secondName, final Model model) {
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
	 *            first user name
	 * @param secondName
	 *            second user name
	 * @param dateStart
	 *            start date for search
	 * @param dateEnd
	 *            end date for search
	 * @param model
	 * @return user-statistic page
	 */
	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public String showUsingByPeriod(@RequestParam(value = "firstName") final String firstName,
			@RequestParam(value = "secondName") final String secondName,
			@RequestParam(value = "startDate") final Date dateStart,
			@RequestParam(value = "endDate") final Date dateEnd, final Model model) {
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
