package com.cloud.taco;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@GetMapping("/current")
	public String orderForm(Model model)
	{
		model.addAttribute("order",new Order());
		return "orderForm";
	}
	
	@PostMapping("/order")
	public String processOrder(Order order)
	{
		log.info("order -"+order);
		return "redirect:/";
	}

}
