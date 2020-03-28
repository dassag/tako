package com.cloud.taco;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.taco.Ingredients.Type;
import com.cloud.taco.Taco;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
	
	private final IngredientRepository ingredientRepo;

	  @Autowired
	  public DesignTacoController(IngredientRepository ingredientRepo) {
	    this.ingredientRepo = ingredientRepo;
	  }
	  @GetMapping
	  public String showDesignForm(Model model) {
	    List<Ingredients> ingredients = new ArrayList<>();
	    		ingredientRepo.findAll().forEach(ingredients::add);
	    
	    
	    Type[] types= Ingredients.Type.values();
	    for(Type type:types)
	    {
	    	model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients,type));
	    }
	    model.addAttribute("design", new Taco());
	    //System.out.println(model);
	    //log.info("model "+model);
	    return "design";
	  }

	private List<Ingredients> filterByType(List<Ingredients> ingredients, Type types) {
		
		return ingredients.stream()
							.filter(o->o.getType().equals(types))
							.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors) {
		
		//if (errors.hasErrors()) {
		    //return "design";
		  //}
	  // Save the taco design...
	  // We'll do this in chapter 3
	  log.info("Processing design: " + design);

	  return "redirect:/order/current";
	}
}
