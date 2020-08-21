package co.grandcircus.springlab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import co.grandcircus.springlab23.dao.GradeDao;
import co.grandcircus.springlab23.entity.Grade;

@Controller
public class GradeController {

	@Autowired
	private GradeDao dao;

	@RequestMapping("/")
	public String list(Model model) {
		List<Grade> grades = dao.findAll();
		model.addAttribute("grade", grades);
		return "grades";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("id") Long id, Model model) {
		Grade grade = dao.findById(id);
		model.addAttribute("grade", grade);
		if (grade == null) {
			model.addAttribute("msg", "Grade not found");
		}
		return "detail";
	}

	@RequestMapping("/grades/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Grade grade = dao.findById(id);
		model.addAttribute("grade", grade);
		return "edit";
	}

	@PostMapping("/grades/edit")
	public String save(@RequestParam("id") Long id, Grade grade) {
		dao.update(grade);
		return "redirect:/grades/detail?id=" + id;
	}

	@RequestMapping("/add")
	public String showAdd() {
		return "add";
	}

	@PostMapping("/add")
	public String submitAdd(Grade grade) {
		dao.create(grade);
		return "redirect:/detail";
	}

	@RequestMapping("/grades/delete")
	public String remove(@RequestParam("id") Long id) {
		dao.delete(id);
		return "redirect:/";
	}
	
}
