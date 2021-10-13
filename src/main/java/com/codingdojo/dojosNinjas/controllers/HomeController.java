package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.LoginUser;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.models.User;
import com.codingdojo.dojosNinjas.services.DojoService;
import com.codingdojo.dojosNinjas.services.NinjaService;
import com.codingdojo.dojosNinjas.services.UserService;



@Controller
public class HomeController {

	@Autowired
	
	NinjaService ninjaServ;
	
	DojoService dojoServ;
	
	private UserService userServ;

	 public HomeController(DojoService dojoServ, UserService userServ) { 
		 
		 this.dojoServ = dojoServ;
		 
		 this.userServ = userServ;
	 }
	 
	 
	 
	 
	
	    
	    @GetMapping("/")
	    
	    public String index(Model model) {
	    	
	        model.addAttribute("newUser", new User());
	        
	        model.addAttribute("newLogin", new LoginUser());
	        
	        return "index.jsp";
	        
	    }
	    
	    
	    
	    
	    @PostMapping("/register")
	    
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	    		
	            BindingResult result, Model model, HttpSession session) {
	    	
	        userServ.register(newUser, result);
	        
	        if(result.hasErrors()) {
	        	
	            model.addAttribute("newLogin", new LoginUser());
	            
	            return "index.jsp";
	            
	        }
	        
	        session.setAttribute("user_id", newUser.getId());
	        
	        return "redirect:/homepage";
	    }
	    
	    
	    
	    
	    @PostMapping("/login")
	    
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	    		
	            BindingResult result, Model model, HttpSession session) {
	    	
	        User user = userServ.login(newLogin, result);
	        
	        if(result.hasErrors()) {
	        	
	            model.addAttribute("newUser", new User());
	            
	            return "index.jsp";
	            
	        }
	        
	        session.setAttribute("user_id", user.getId());
	        
	        return "redirect:/homepage";
	        
	    }
	 
	 
	
	 
	 @GetMapping("/logout")
	 
	 public String logout(HttpSession session) {
		 
		 session.removeAttribute("user_id");
		 
		 return "redirect:/";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	 
	@RequestMapping("/homepage")
	
	public String homepage(Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
			
			List<Ninja> allNinjas = ninjaServ.allNinjas();
			
			List<Dojo> allDojo = dojoServ.allDojo();

			
			model.addAttribute("ninjas", allNinjas);
			
			model.addAttribute("dojos", allDojo);
			
			Long user_id = (Long) session.getAttribute("user_id");
			
			model.addAttribute("user", userServ.oneUser(user_id));
			
			
			return "homepage.jsp";
			
		}
		
		else {
			
			return "redirect:/";
			
			
		}
	}

	
	
	@RequestMapping("/newNinjas")
	
	public String newNinjas(@ModelAttribute("ninj") Ninja ninja, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
		
		List<Dojo> allDojo = dojoServ.allDojo();
		
		model.addAttribute("dojos", allDojo);
		
		Long user_id = (Long) session.getAttribute("user_id");
		
		model.addAttribute("user", userServ.oneUser(user_id));
		
		return "newNinjas.jsp";
		
		}
		
		else {
			
			return "redirect:/";
			
		}
	}

	
	
	@RequestMapping("/newDojo")
	
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
			
			Long user_id = (Long) session.getAttribute("user_id");
			
			model.addAttribute("user", userServ.oneUser(user_id));
		
			return "newDojo.jsp";
		}
		
		else {
			
			return "redirect:/";
			
		}
		
	}

	
	
	@RequestMapping(value = "/createNinj", method = RequestMethod.POST)
	
	public String create(@Valid @ModelAttribute("ninj") Ninja ninja, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			List<Dojo> allDojo = dojoServ.allDojo();
			
			model.addAttribute("dojos", allDojo);
			
			return "newNinjas.jsp";
			
		}
		
		ninjaServ.create(ninja);
		
		return "redirect:/homepage";
	}
	

		
	@RequestMapping(value = "/createDojo", method = RequestMethod.POST)
	
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if (result.hasErrors()) {
			
			return "newDojo.jsp";
			
		}
		
		dojoServ.create(dojo);
		
		return "redirect:/homepage";
		
	}

	
	
	@RequestMapping("/editNinja/{id}")
	
	public String editNinja(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
		
		Ninja ninj = ninjaServ.oneNinja(id);
		
		model.addAttribute("ninj", ninj);
		
		List<Dojo> allDojo = dojoServ.allDojo();
		
		model.addAttribute("dojos", allDojo);
		
		return "editNinja.jsp";
		
		}
		
		else {
			
			return "redirect:/";
			
		}
		
	}

	

	@RequestMapping(value = "/editNinja/{id}", method = RequestMethod.PUT)
	
	public String editingNinja(@Valid @ModelAttribute("ninj") Ninja ninja, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			List<Dojo> allDojo = dojoServ.allDojo();
			
			model.addAttribute("dojos", allDojo);
			
			return "editNinja.jsp";
			
		} 
		
		else {
			
			ninjaServ.updateNinj(ninja);
			
			return "redirect:/homepage";
			
		}
		
	}

	
	
	@RequestMapping("/oneNinja/{id}")
	
	public String oneNinja(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
			
		User user = userServ.oneUser((Long)session.getAttribute("user_id"));
		
		model.addAttribute("user", user);
		
		model.addAttribute("ninj", ninjaServ.oneNinja(id));
		
		
		

		
		return "oneNinja.jsp";
		
		}
		
		else {
			
			return "redirect:/";	
			
		}
		
	}
	
	
	
	@RequestMapping("oneDojo/{id}")
	
	public String oneDojo(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
		
		model.addAttribute("dojo", dojoServ.oneDojo(id));
		
		Long user_id = (Long) session.getAttribute("user_id");
		
		model.addAttribute("user", userServ.oneUser(user_id));
		
		return "oneDojo.jsp";
		
		}
		
		else {
			
			return "redirect:/";
			
		}
		
	}
	
	@RequestMapping("/myDojos")
	
	public String myDojos(Model model, HttpSession session) {
		
		if(session.getAttribute("user_id") != null) {
			
			Long user_id = (Long) session.getAttribute("user_id");
			
			model.addAttribute("user", userServ.oneUser(user_id));
			
			return "myDojos.jsp";
			
		}
		
		else {
			
			return "redirect:/";
			
		}
		
		
	}

	
	@RequestMapping("/destroy/{id}")
	
	public String destroy(@PathVariable("id") Long id) {
		
		ninjaServ.destroy(id);
		
		return "redirect:/homepage";
		
	}

}
