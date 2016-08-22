package com.sap.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;


@Controller
@RequestMapping("/mvc")

public class HelloController {
	
	@RequestMapping("test1")
	public String home(){
		System.out.println("Jerry test1!");
		return "hello";
	}
	
	@RequestMapping(value="test2")
	  public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Jerry: my Controller gets called! test2");
	      return "hellowithModel";
	   }
	
	@RequestMapping("welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("test3")
	@ResponseBody
		//public Map<String, String> json(){
	public String json(){
			Map<String, String> result = new HashMap<String, String>();
			result.put("Scala", "hello");
			result.put("ABAP", "world");
			result.put("Java", "greet");
			System.out.println("test!!!");
			return "Pure string";
		}
}

