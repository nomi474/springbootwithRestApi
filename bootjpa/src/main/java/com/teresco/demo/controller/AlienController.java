package com.teresco.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.teresco.demo.dao.AlienRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teresco.demo.model.Alien;
@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}

//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien) {
//		repo.save(alien);
//		return "home.jsp";
//	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien1(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path="/alien", consumes= {"application/json"})
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
//		return "home.jsp";
		return alien;
	}
	
	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
//		return "home.jsp";
		return alien;
	}

//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("Java"));
//		mv.addObject(alien);
//		return mv;
//	}
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

	@GetMapping(path="/aliens")
//	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@RequestMapping("/deleteAlien")
	public String deleteAlien(@RequestParam int aid) {
		repo.deleteById(aid);
		return "home.jsp";
	}
	
	@RequestMapping("/updateAlien")
	public String updateAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
}
