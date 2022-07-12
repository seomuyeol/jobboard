package jp.winschool.spring.jobboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.winschool.spring.jobboard.model.Offer;
import jp.winschool.spring.jobboard.service.HomeService;

@Controller
@RequestMapping("/camping")
public class campingController {
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/index")
	public String home(Model model) {
		List<Offer> offers = homeService.getOfferList();
		model.addAttribute("offers", offers);
		
		return "/camping/index";
	}
	

	
}
