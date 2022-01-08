package com.hcm.dto;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponseDTO {
	
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private List<String> roles;
	
	public JwtResponseDTO(String accessToken, Long id, String username, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.roles = roles;
	}

}
