package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.fr.adaming.entity.Equipe;
import com.fr.adaming.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class LoginDto {

	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String pwd;
}
