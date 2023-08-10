package com.dab.rest.dto;

import java.time.LocalDate;

import com.dab.rest.entities.Driver;
import com.dab.rest.entities.Role;
import com.dab.rest.entities.Team;

public class DriverDto {
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer number;

	private LocalDate birthdate;

	private String nacionality;
	private Role role;
	private Team team;

	public DriverDto() {

	}

	public DriverDto(String firstName, String lastName, Integer number, Integer age, LocalDate birthdate,
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

	public static Driver getEntity(DriverDto driverDto) {
		Driver driver = new Driver(driverDto.getFirstName(), driverDto.getLastName(), driverDto.getNumber(),
				driverDto.getAge(), driverDto.getBirthdate(), driverDto.getNacionality(), driverDto.getRole());

		if(driver != null) {
			driver.setId(driverDto.getId());
		}
		
		driver.setTeam(driverDto.getTeam());

		return driver;
	}

	public static DriverDto getDto(Driver driver) {

		DriverDto driverDto = new DriverDto(driver.getFirstName(), driver.getLastName(), driver.getNumber(),
				driver.getAge(), driver.getBirthdate(), driver.getNacionality(), driver.getRole());

		driverDto.setId(driver.getId());
		driverDto.setTeam(driver.getTeam());

		return driverDto;
	}

	@Override
	public String toString() {
		return "DriverDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", number=" + number + ", birthdate=" + birthdate + ", nacionality=" + nacionality + ", role=" + role
				+ ", team=" + team + "]";
	}

}
