package com.teresco.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("home")
//	public ModelAndView home(@RequestParam("aname") String myName) {
		public ModelAndView home(Alien alien) {
//		String name = req.getParameter("name");
//		HttpSession session= req.getSession(); 
		ModelAndView mv = new ModelAndView();
//		System.out.println("hi " + myName);
//		session.setAttribute("name", myName);
//		mv.addObject("name", myName);
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
}
