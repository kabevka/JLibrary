package edu.ita.softserve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ita.softserve.entity.Book;
import edu.ita.softserve.entity.Instance;
import edu.ita.softserve.service.InstanceService;

@Controller
public class InstanceController {

	@Autowired
	InstanceService instanceService;

	@RequestMapping(value = "/allInstance", method = RequestMethod.POST)
	public String findAllInstance(@ModelAttribute("name") String name, Model model) {
		List<Instance> list = instanceService.findByName(name);
		System.out.println(list);

		model.addAttribute("allInstance", list);
		return "instance";
	}

	@RequestMapping(value = "/removeBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("Id") Long id) {
			instanceService.remove(id);
		return "addRemove";
	}

}
