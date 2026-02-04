package com.rd.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rd.project.entity.rdpassbook;
import com.rd.project.repo.rdpassbookrepo;
import com.rd.project.service.passbookservice;

import jakarta.validation.Valid;
import passbookDTO.userpassbookDTO;

@RestController
public class rdpassbookcontrl 
{
	@Autowired
	private rdpassbookrepo repo;
	
	@Autowired
	private passbookservice service;
	@GetMapping("/detail")	
	public List<userpassbookDTO> getDetail()
	{
		return service.getDetail();
	}
	
	@GetMapping("/passuser/{rid}")
	public List<userpassbookDTO> getUserpassbookDetailById(@PathVariable("rid") int rid) 
	{
	return service.getUserpassbookDetailById(rid);
	} 
	
	@GetMapping("/rdpass")
	public List<rdpassbook> pb()
	{
		List<rdpassbook> lst=repo.findAll();
		return lst;
	}
	
	@GetMapping("/rdpass/{id}")
	public Optional<rdpassbook> findById(@PathVariable("id") int id) 
	{
	return repo.findById(id);
	} 
	
	@GetMapping("total")
	public Map<String, Object> getSummary()
	{
		Long total = repo.getTotalAmount();
		Map<String, Object> result =new HashMap<>();
		result.put("total", total);
		return result;
	}
	
	@GetMapping("/passbookById/{id}")
		public List<rdpassbook> getRdpassbooks(@PathVariable ("id") int id)
		{
			List<rdpassbook> lst = repo.getAllByRid(id);
			return lst;
		}
		
	@GetMapping("/details")	
		public List<Object[]> getDetails()
		{
			return repo.getUserpassbookDetails();
		}
		
	
	@PostMapping("/saverdpass")
	public rdpassbook saveps(@Valid @RequestBody rdpassbook p)
	{
	return repo.save(p);
	}
	
	@PutMapping("/updtrdpass")
	public rdpassbook updateps(@Valid @RequestBody rdpassbook p)
	{
	return repo.save(p);
	}

	@DeleteMapping("/dltrdpass/{id}")
	public String DeleteBlg(@PathVariable("id") int id)
	{
	repo.deleteById(id);
	return "Record Delete Successfully......" ; 
	}
	
}
