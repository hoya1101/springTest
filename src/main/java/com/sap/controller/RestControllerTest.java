package com.sap.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
