package br.com.smartpoint.security.utils.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_AUDIENCE = "audience";
	static final String CLAIM_KEY_CREATED = "created";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private Long expiration;

	public String getUsernameFromToken(String token) 
	{
		String username;

		try 
		{
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();

		} catch (Exception cause) 
		{
			username = null;
		}

		return username;

	}
	
	public Date getExpirationDateFromTokenn(String token)
	{
		Date expiration;
		try
		{
		Claims claims = getClaimsFromToken(token);
		expiration = claims.getExpiration();
		}
		catch (Exception cause)
		{
			expiration = null;
		}		
		return expiration;
	}
	
	public String refreshToken (String token)
	{
		String refreshtoken;
		try 
		{
		Claims claims = getClaimsFromToken(token);
		claims.put(CLAIM_KEY_CREATED, new Date());
		refreshtoken = generateToken(claims);
		}		
		catch (Exception cause)
		{
			refreshtoken = null;
		}		
		return refreshtoken;
	}
	
	
	public boolean validToken(String token)
	{
		return !tokenexpired(token);
	}

	private boolean tokenexpired(String token) 
	{
		Date expiration = this.getExpirationDateFromTokenn(token);
		if(Objects.isNull(expiration))
		{
			return false;
		}		
		return expiration.before(new Date());
	}
	
	public String getToken(UserDetails userDetails)
	{
		Map<String , Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(CLAIM_KEY_CREATED, new Date());		
		return generateToken(claims);
	}
	

	private String generateToken(Map<String , Object> claims) 
	{
		return Jwts.builder().setClaims(claims).setExpiration(generateExpiration()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date generateExpiration() 
	{	
		return new Date(System.currentTimeMillis() + expiration * 1000);
	}

	private Claims getClaimsFromToken(String token) 
	{
		Claims claims;		
		try
		{
    		claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();			
		}
		catch(Exception cause)
		{
			claims = null;
		}		
		return claims;
	}
	
	

}
