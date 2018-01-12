package controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.ExpediaService;

@Controller
public class ExpediaController {
	
	@Autowired
	private ExpediaService expediaService;
	
	@RequestMapping("/*")
	public ModelAndView getOffers(@RequestParam HashMap<String,String> dataModel){
		ModelAndView modelAndView = new ModelAndView("index");
		HashMap<String,Object> response = expediaService.getOffers(dataModel);
		modelAndView.addObject("hotels", response.get("hotel"));
		return modelAndView;
	}

}
