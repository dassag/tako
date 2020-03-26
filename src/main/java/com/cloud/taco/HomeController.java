package com.cloud.taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home()
	{
		return "home"; //interpreted as the logical view name which is home.html here
	}

}
