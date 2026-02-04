package com.rd.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rd.project.repo.rdpassbookrepo;

import passbookDTO.userpassbookDTO;

@Service
public class passbookservice 
{
	@Autowired
	private rdpassbookrepo prepo;
	
	public List<userpassbookDTO> getDetail()
	{
		return prepo.getUserpassbookDetail();
	}
	
	public List<userpassbookDTO> getUserpassbookDetailById(int rid)
	{
		return prepo.getUserpassbookDetailById(rid);
	}
}
