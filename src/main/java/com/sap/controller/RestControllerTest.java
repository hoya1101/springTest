package com.sap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin
@RequestMapping("/rest")
public class RestControllerTest {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String redirectToApiConsole() {
    	org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor 
    	a = null;
    	return "hello";
    }
    
    
}
