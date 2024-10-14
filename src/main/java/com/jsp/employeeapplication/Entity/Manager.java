package com.jsp.employeeapplication.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	@NotNull(message = "name is manadatory")
	private String name;
	@NotBlank
	@NotNull(message = "email is manadatory")
	@Column(unique = true)
	private String email;
	@NotBlank
	@NotNull(message = "password is manadatory")
	@Size(min = 5, max = 20, message = "password must be between 5 and 20 characters")
	private String password;
	@NotBlank
	@NotNull(message = "bloodgroup is manadatory")
	private String bloodgroup;

	@JsonIgnore
	@OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST ,fetch = FetchType.LAZY) // Reference to Employee
	private List<Employee> employees; // List of Employees managed by this Manager

}
