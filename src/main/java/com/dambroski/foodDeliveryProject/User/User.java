package com.dambroski.foodDeliveryProject.User;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.dambroski.foodDeliveryProject.security.Authority;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@SequenceGenerator(name = "native",sequenceName = "native")
	@GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String pwd;
	private String email;
	private Date birthDate;
	
	private String role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Authority> authorities;
	
}