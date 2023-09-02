package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);



	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey("semilla").parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException e) {
			LOG.error("Token caducado {}", e.getMessage());
		} catch (SignatureException e) {
			LOG.error("Token no valido {}", e.getMessage());
		}

		return false;
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey("semilla").parseClaimsJws(token).getBody().getSubject();
	}

}
