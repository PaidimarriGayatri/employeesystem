package com.jsp.employeeapplication.Entity;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;



@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@NotNull(message = Message.msg)
	private String firstname;
	@NotBlank
	@NotNull(message = Message.msg)
	private String lastname;
	@NotBlank
	@NotNull(message = "email is manadatory")
	@Column(unique = true)
	private String email;
	@NotBlank
	@NotNull(message = "password is manadatory")
	@Size(min = 5, max = 20, message = "password must be between 5 and 20 characters")
	private String password;
	@NotBlank
	@NotNull(message = Message.msg)
	private String bloodgroup;


	@JoinColumn
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Manager manager;

}
