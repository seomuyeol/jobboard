package jp.winschool.spring.jobboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {
	
	@GetMapping("/layout1")
	public String layout1() {
		return "layout1";
	}
	
	@GetMapping("/layout2")
	public String layout2() {
		return "layout2";
	}
	
	@GetMapping("/layout/common")
	public String common() {
		return "layout/common";
	}
	
	@GetMapping("/layout/footer")
	public String footer() {
		return "layout/footer";
	}

}
