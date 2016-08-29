package com.sap.controller;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestPartMethodArgumentResolver;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/mvc")

public class HelloController {
	
	@RequestMapping("test1")
	public String home(){
		System.out.println("Jerry test1!");
		return "hello";
	}
	
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("error");
		model.getModelMap().addAttribute("msg", "Jerry message code: " + ex.getErrCode());
		model.getModelMap().addAttribute("msgText", "Jerry message text: " + ex.getErrMsg());

		return model;
	}
	
	@RequestMapping(value="i042416", method = RequestMethod.POST, 
			consumes = { "application/json" })
	@ResponseBody
	public String postTemplate(@Valid @RequestBody String template, HttpServletRequest request) {
        System.out.println(template);
        // HttpMediaTypeNotSupportedException a = null;
        return template;
    }
	
	@RequestMapping(value="test2")
	  public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Jerry: my Controller gets called! test2");
	      return "hellowithModel";
	   }
	
	@RequestMapping(value = "/doc/{documentId}", method = RequestMethod.GET, produces = { "application/pdf", "text/html" })
    public void getDocumentById(@PathVariable("documentId") String documentId,
            HttpServletResponse response,
            @RequestParam(value = "type", defaultValue = "xml") String outputType) throws IOException {
        String html = "<html><p>I042416" + "-" + documentId + "</p></html>";
        response.reset();
        if ("html".equals(outputType)) {
            //html = documentService.queryDocumentById(documentId).getInternalDocumentFile();
            response.setContentLength(html.length());
            response.setContentType("text/html");
            response.getOutputStream().println(html);
        } 
        else if("custom".equals(outputType)){
        	throw new CustomGenericException("E888", "This is custom message");
        } else if ("io".equals(outputType)) {
        	throw new IOException(); 
        }
        response.getOutputStream().close();
    }
	
	@RequestMapping("welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
	
	@RequestMapping("test3")
	@ResponseBody
		public Map<String, String> json(){
		DispatcherServlet a = null;
 
			Map<String, String> result = new HashMap<String, String>();
			result.put("Scala", "hello");
			result.put("ABAP", "world");
			result.put("Java", "greet");
			System.out.println("test!!!");
			return result;
			//return "Pure string";
		}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public void postPic(@RequestPart("picContent111") MultipartFile picContent111,
            HttpServletRequest request) throws IOException {

        if (!picContent111.getContentType().startsWith("image/")) {
            System.out.println("image file is not present");
        }
        
        String url = request.getRequestURL().toString() + "/" + "Jerry";
        URI location = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
        Object result = ResponseEntity.created(location).body(location);
        RequestPartMethodArgumentResolver a = null;
    }
}

