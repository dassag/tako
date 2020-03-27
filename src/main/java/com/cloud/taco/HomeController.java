package com.cloud.taco;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//this controller is not populating
//any module
//i.e it does nothing but
//forward a request to a view
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home()
	{
		return "home"; //interpreted as the logical view name which is home.html here
	}
	

}
