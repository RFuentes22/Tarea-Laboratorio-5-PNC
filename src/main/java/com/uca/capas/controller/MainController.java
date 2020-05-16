package com.uca.capas.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;

	@RequestMapping("/inicio")
	public ModelAndView index() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		return mav;
	}

	// Show students list
	@RequestMapping(value = "/listado")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");

		return mav;

	}

	@RequestMapping("/insert")
	public ModelAndView insert(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudianteClean = new Estudiante();
		
		if (result.hasErrors()) {
			mav.addObject("estudiante", estudiante);
		}else {
			estudianteDAO.insert(estudiante);
			mav.addObject("estudiante", estudianteClean);
		}
		
		mav.setViewName("index");
		return mav;
		
	}
}
