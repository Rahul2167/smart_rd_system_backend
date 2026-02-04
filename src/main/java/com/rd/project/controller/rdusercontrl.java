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

import com.rd.project.entity.rduser;
import com.rd.project.repo.rduserrepo;

import jakarta.validation.Valid;

@RestController
public class rdusercontrl 
{
	
	@Autowired
	private rduserrepo repo;
	

	@GetMapping("/rduser")
	public List<rduser> pb()
	{
		List<rduser> lst=repo.findAll();
		return lst;
	}
	
////	//	with data name before array
//	@GetMapping("/rduser")
//	public Map<String, List<rduser>> pb()
//	{
//		Map<String, List<rduser>> data=new HashMap();
//		List<rduser> lst=repo.findAll();
//		data.put("data", lst);
//		return data;
//	}
	
	@GetMapping("/activeusers")
	public Map<String, Long> getSummary() {
	    return Map.of("activeUsers", repo.count());
	}
	
	@PostMapping("/saverduser")
	public rduser saveps(@Valid @RequestBody rduser p)
	{
	return repo.save(p);
	}
	
	@PutMapping("/updtrduser")
	public rduser updateps(@Valid @RequestBody rduser p)
	{
	return repo.save(p);
	}

	@DeleteMapping("/dltuser/{id}")
	public String DeleteBlg(@PathVariable("id") int id)
	{
	repo.deleteById(id);
	return "Record Delete Successfully......" ;
	}
	
	@GetMapping("/rduser/{id}")
	public Optional<rduser> findById(@PathVariable("id") int id) 
	{
	return repo.findById(id);
	} 
	
}
