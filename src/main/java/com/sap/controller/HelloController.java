package com.sap.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@RestController
@RequestMapping("/mvc")

public class HelloController {
	
	@RequestMapping("test1")
	public String home() throws Exception{
		System.out.println("Jerry test1!");
		
		if(0 == 1) {
			throw new Exception("Generic Exception raised by Jerry");
		}
		return "hello";
	}
	
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("error");
		model.getModelMap().addAttribute("msg", "Jerry message code: " + ex.getErrCode());
		model.getModelMap().addAttribute("msgText", "Jerry message text: " + ex.getErrMsg());

		return model;
	}
	
	// maps to Content-Type in http header
	@RequestMapping(value="i042416", method = RequestMethod.POST, 
			consumes = { "application/json" })
	@ResponseBody
	public String postTemplate(@Valid @RequestBody String template, HttpServletRequest request) {
        System.out.println(template);
        // HttpMediaTypeNotSupportedException a = null;
        
        final String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        System.out.println("extraction from request: " + url);
        StringBuffer requestURL = request.getRequestURL();
        String queryString = request.getQueryString();
        System.out.println("request url: " + requestURL + " query url: " + queryString);
        System.out.println("request toString: " + request.toString());
        return template;
    }
	
	@RequestMapping(value="test2")
	  public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("Jerry: my Controller gets called! test2");
	      return "hellowithModel";
	   }
	
	/*@RequestMapping(value="/{templateId}")
	  public String testParameter(@PathVariable("templateId") String id) {
	      return "value is: " + id;
	   }*/
	
	// @RequestParam("name")
	@RequestMapping(value="/hello")
	  public String testRequestParam(@RequestParam String name) {
	      return "test Request Param: " + name;
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
			Map<String, String> result = new HashMap<String, String>();
			result.put("Scala", "hello");
			result.put("ABAP", "world");
			result.put("Java", "greet");
			System.out.println("test!!!");
			return result;
			//return "Pure string";
		}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelAndView postPic(@RequestPart("picContent111") MultipartFile picContent111,
            HttpServletRequest request) throws IOException {

        if (!picContent111.getContentType().startsWith("image/")) {
            System.out.println("image file is not present");
        }
        
        ModelAndView model = new ModelAndView("uploaded");
        
        String content = getUploadedContentFromStream(picContent111.getInputStream());
        System.out.println("uploaded content: " + content);
		model.getModelMap().addAttribute("content", content);
		
		return model;
    }
	
	private String getUploadedContentFromStream(InputStream inputStream) throws IOException{
		final int bufferSize = 1024;
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		Reader in = new InputStreamReader(inputStream, "UTF-8");
		for (; ; ) {
		    int rsz = in.read(buffer, 0, buffer.length);
		    if (rsz < 0)
		        break;
		    out.append(buffer, 0, rsz);
		}
		return out.toString();
	}
}

