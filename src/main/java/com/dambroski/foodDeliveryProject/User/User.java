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
import javax.persistence.Table;

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
	@GeneratedValue(generator = "user_id",strategy = GenerationType.AUTO)
	private Long userId;
	private String name;
	private String pwd;
	private String email;
	private Date birthDate;
	
	private String role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
	private Set<Authority> authorities;
	
}
