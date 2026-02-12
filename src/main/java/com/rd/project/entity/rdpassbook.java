package com.rd.project.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class rdpassbook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	private Integer rid;
	@Column(name = "rddate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate rd_date;
	private String rd_amount;
	private Integer late_days;
	private Integer fine_amount;
	private Integer is_settled;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public LocalDate getRd_date() {
		return rd_date;
	}

	public void setRd_date(LocalDate rd_date) {
		this.rd_date = rd_date;
	}

	public String getRd_amount() {
		return rd_amount;
	}

	public void setRd_amount(String rd_amount) {
		this.rd_amount = rd_amount;
	}

	public Integer getLate_days() {
		return late_days;
	}

	public void setLate_days(Integer late_days) {
		this.late_days = late_days;
	}

	public Integer getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(Integer fine_amount) {
		this.fine_amount = fine_amount;
	}

	public Integer getIs_settled() {
		return is_settled;
	}

	public void setIs_settled(Integer is_settled) {
		this.is_settled = is_settled;
	}

	private String description;
	private String transaction_type;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

}
