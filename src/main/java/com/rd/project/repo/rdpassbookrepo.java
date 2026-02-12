package com.rd.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rd.project.entity.rdpassbook;

import passbookDTO.userpassbookDTO;

public interface rdpassbookrepo extends JpaRepository<rdpassbook, Integer> {
	@Query(value = "SELECT SUM(CAST(rd_amount AS NUMERIC)) FROM rdpassbook", nativeQuery = true)
	Long getTotalAmount();

	@Query(value = "SELECT * FROM rdpassbook WHERE rid=:rid", nativeQuery = true)
	List<rdpassbook> getAllByRid(@Param("rid") int rid);

	@Query(value = "select name,account_number,rdpassbook.rd_amount,rddate from rduser inner join rdpassbook on\r\n"
			+ "rduser.rid=rdpassbook.rid", nativeQuery = true)
	List<Object[]> getUserpassbookDetails();

	@Query(value = "select name,account_number,rdpassbook.rd_amount,rddate from rduser inner join rdpassbook on\r\n"
			+ "rduser.rid=rdpassbook.rid WHERE rdpassbook.rid=:rid", nativeQuery = true)
	List<userpassbookDTO> getUserpassbookDetailById(@Param("rid") int rid);

	@Query(value = "select Rid,name,address,gmail,account_number,dob,occupation,gender,mobile_no,pan_no,adhaar_no,rdpassbook.rd_amount,rddate from rduser inner join rdpassbook on\r\n"
			+ "rduser.rid=rdpassbook.rid", nativeQuery = true)
	List<userpassbookDTO> getUserpassbookDetail();

}
