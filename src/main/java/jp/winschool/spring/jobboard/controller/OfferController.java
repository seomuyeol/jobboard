package jp.winschool.spring.jobboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.winschool.spring.jobboard.model.Offer;
import jp.winschool.spring.jobboard.service.OfferService;

@Controller
@RequestMapping("offer")
public class OfferController {
	@Autowired
	private OfferService offerService;

	@GetMapping("/list")
	public String List(Model model) {
		List<Offer> offers = offerService.getOfferList();
		model.addAttribute("offers", offers);
		
		return "offer/list";
	}
	

}
