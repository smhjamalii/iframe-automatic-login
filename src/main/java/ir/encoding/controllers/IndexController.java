package ir.encoding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/login")
	public String auth() {
		return "login.html";
	}		
	
	@GetMapping("/")
	public String welcome() {
		return "index.html";
	}	

	@GetMapping("/index")
	public String index() {
		return "index.html";
	}
	
}
