package com.rd.project.entity;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class rduser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rid;
	private String name;
	private String address;
	private String mobile_no;
	private String gmail;
	@Column(name = "dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	private String gender;
	@Column(name = "rddate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate rd_date;

	@Column(name = "last_payment_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate last_payment_date;

	private String rd_amount;
	private String occupation;
	private String account_number;
	private String adhaar_no;
	private String pan_no;
	private String nominee_name;
	private String nominee_address;
	private String nominee_adhaar_no;
	private String nominee_pan_no;
	private boolean agree;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getAdhaar_no() {
		return adhaar_no;
	}

	public void setAdhaar_no(String adhaar_no) {
		this.adhaar_no = adhaar_no;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getNominee_name() {
		return nominee_name;
	}

	public void setNominee_name(String nominee_name) {
		this.nominee_name = nominee_name;
	}

	public String getNominee_address() {
		return nominee_address;
	}

	public void setNominee_address(String nominee_address) {
		this.nominee_address = nominee_address;
	}

	public String getNominee_adhaar_no() {
		return nominee_adhaar_no;
	}

	public void setNominee_adhaar_no(String nominee_adhaar_no) {
		this.nominee_adhaar_no = nominee_adhaar_no;
	}

	public String getNominee_pan_no() {
		return nominee_pan_no;
	}

	public void setNominee_pan_no(String nominee_pan_no) {
		this.nominee_pan_no = nominee_pan_no;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public LocalDate getLast_payment_date() {
		return last_payment_date;
	}

	public void setLast_payment_date(LocalDate last_payment_date) {
		this.last_payment_date = last_payment_date;
	}
}
