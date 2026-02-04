package com.rd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rd.project.entity.rduser;

public interface rduserrepo extends JpaRepository<rduser, Integer>{
	
	@Query(value = "SELECT count(*) FROM rduser", nativeQuery = true)
	 Long getUsers();

	

}
