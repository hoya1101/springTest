package com.sap.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;


@Controller
@RequestMapping("/mvc")

public class HelloController {
	
	@RequestMapping("fuck1")
	public String home(){
		System.out.println("Jerry fuck1!");
		return "hello";
	}
	
	@RequestMapping("")
	public String fuck3(){
		System.out.println("Jerry fuck default page!");
		return "hello.jsp";
	}
	
	@RequestMapping(value="fuck2")
	  public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Jerry: my Controller gets called! fuck2");
	      return "index2.html";
	   }
	
	@RequestMapping("fuck3")
	@ResponseBody
		//public Map<String, String> json(){
	public String json(){
			Map<String, String> result = new HashMap<String, String>();
			result.put("zhangsan", "hello");
			result.put("lisi", "world");
			result.put("wangwu", "nihao");
			System.out.println("Fuck3!!!");
			return "fuck3";
		}
}

/*
@Controller
@RequestMapping("/aopRootJerry")
public class HelloController {
	
	@ResponseBody
	@RequestMapping(value="aop2Jerry/{username}")
	public String aop2(@PathVariable String username, @RequestParam String string) throws InterruptedException{
		
		System.out.println("Jerry parameter passed via browser: " + string);
		System.out.println("Path variable: " + username);
		
		return string + "fuck!!!";
	}
}*/

