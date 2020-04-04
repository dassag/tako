package com.cloud.taco.Controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cloud.taco.POJO.Ingredients;
import com.cloud.taco.POJO.Ingredients.Type;
import com.cloud.taco.POJO.Order;
import com.cloud.taco.POJO.Taco;
import com.cloud.taco.Repository.IngredientRepository;
import com.cloud.taco.Repository.TacoRepository;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/design")

//ensure that order object in model
//should be able to accept multiple taco orders
@SessionAttributes("order")
public class DesignTacoController {
	
	private final IngredientRepository ingredientRepo;
	private final TacoRepository designRepo;
	

	  @Autowired
	  public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
	    this.ingredientRepo = ingredientRepo;
	    this.designRepo=designRepo;
	    
	  }
	  
	  @ModelAttribute(name = "order")
	  public Order order() {
	    return new Order();
	  }

	  @ModelAttribute(name = "taco")
	  public Taco taco() {
	    return new Taco();
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
	    log.info("model "+model);
	    return "design";
	  }

	private List<Ingredients> filterByType(List<Ingredients> ingredients, Type types) {
		
		return ingredients.stream()
							.filter(o->o.getType().equals(types))
							.collect(Collectors.toList());
	}
	
	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors,
			@ModelAttribute Order order) {
		
		//if (errors.hasErrors()) {
		   // return "design";
		  //}
		
		//injected designrepo is used to save the taco
		Taco saved = designRepo.save(design);
		
		//taco object added to the order
	    //order.addDesign(saved);
	  
	  log.info("Processing design: " + design);

	  return "redirect:/order/current";
	}
}

