package com.dab.rest.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DRIVERS")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "NUMBER")
	private Integer number;

	@Column(name = "BIRTH_DATE")
	private LocalDate birthdate;

	@Column(name = "NACIONALITY")
	private String nacionality;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ID_TEAM")
	private Team team;

	public Driver() {
	}

	public Driver(String firstName, String lastName, Integer number, Integer age, LocalDate birthdate,
			String nacionality, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.age = age;
		this.birthdate = birthdate;
		this.nacionality = nacionality;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number="
				+ number + ", birthdate=" + birthdate + ", nacionality=" + nacionality + ", role=" + role + ", team="
				+ team + "]";
	}
	
}
