package com.hcm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users", uniqueConstraints = { @UniqueConstraint(columnNames = "username")})
@NoArgsConstructor
@Setter
@Getter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 5, max = 20,  message = "User name should lie between 5 to max 20 character")
	private String username;
	
	@NotBlank
	@Size(min = 8, max = 120 , message = "Password Should lie between 8 to max 120 character")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles",
	              joinColumns = @JoinColumn(name="user_id"),
	              inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> role = new HashSet();

	 
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	

}
