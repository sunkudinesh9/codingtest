package com.tera.codingtest.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roletable", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "roles")
	private List<String> roles = new ArrayList<String>();
	private String name;
	@Column(name = "username")
	private String userName;
	private String email;
	@Embedded
	private Address address;
	private Long phone;
	private String website;
	@Embedded
	private Company company;
	@OneToMany(mappedBy = "user")
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Set<Post> listOfPosts = new HashSet<Post>();
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JsonIgnore
	private Set<Todo> listOfTodo = new HashSet<Todo>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Post> getListOfPosts() {
		return listOfPosts;
	}

	public void setListOfPosts(Set<Post> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	public Set<Todo> getListOfTodo() {
		return listOfTodo;
	}

	public void setListOfTodo(Set<Todo> listOfTodo) {
		this.listOfTodo = listOfTodo;
	}

}
