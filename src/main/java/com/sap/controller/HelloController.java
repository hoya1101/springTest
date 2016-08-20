package com.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello2")

public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	  public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Jerry: my Controller gets called!");
	      return "1.jsp";
	   }
}
