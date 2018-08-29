package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class greeting {
	
	
	
	@RequestMapping(value="/greeting",method = RequestMethod.GET)
	public @ResponseBody String greeting() {
		
		
		return "hello world";
	}
	
}
