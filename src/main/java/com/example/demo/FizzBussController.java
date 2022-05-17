package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FizzBussController {

	@RequestMapping("/")
	public String top() {
		return "index";
	}

//	<form action="/appyl" method="post">
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public ModelAndView apply(@RequestParam("num") int num, ModelAndView mv) {
		// ここにFizzBuzz
	if (num ==0 ) {
		mv.addObject("result", "数値を入力してください");
	}
		if (num % 3 == 0 && num % 7 == 0 && num % 5 == 0) {
			mv.addObject("result", "FizzAssBuzz");
		} else if (num % 7 == 0 && num % 5 == 0) {
			mv.addObject("result", "AssBuzz");
		} else if (num % 3 == 0 && num % 5 == 0) {
			mv.addObject("result", "FizzBuzz");
		}else if (num % 3 == 0 && num % 7 == 0) {
			mv.addObject("result", "FizzAzz");
		}

		else if (num % 3 == 0) {
			mv.addObject("result", "Fizz");
		} else if (num % 5 == 0) {
			mv.addObject("result", "Buzz");
		} else if (num % 7 == 0) {
			mv.addObject("result", "Ass");
		}
		else {
			mv.addObject("result", "う");
		}

		// 入力した表示をもう一度表示させるためにhtmlで書いたnumに戻す
		mv.addObject("num", num);

		mv.setViewName("index");
		return mv;
	}
}
