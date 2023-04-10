package com.dambroski.foodDeliveryProject.User;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.dambroski.foodDeliveryProject.Address.Address;
import com.dambroski.foodDeliveryProject.security.Authority;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue(generator = "user_id",strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	private String name;
	private String pwd;
	private String email;
	
	@Past(message = "Birth date must be in the past")
	@JsonFormat(shape = JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	//add @size 
	private String code;
	
	private String role;
	
	@JsonIgnoreProperties({"type","typeId"})
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Address> addresses;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Authority> authorities;
	
}

