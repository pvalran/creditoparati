package com.pma.pimacpt.security.jwt;

import com.pma.pimacpt.security.model.UserCredencial;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int experation;

    public String generateToken(Authentication auth) {
        UserCredencial credencial= (UserCredencial) auth.getPrincipal();
        return Jwts.builder()
                .setSubject(credencial.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plusSeconds(experation)))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String getUserNameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return true;
        }
        catch (MalformedJwtException e){
            LOGGER.error("Token Malformado ",e.getCause() );
        }
        catch (UnsupportedJwtException e){
            LOGGER.error("Token No soportado ",e.getCause() );
        }
        catch (ExpiredJwtException e){
            LOGGER.error("Token expirado ",e.getCause() );
        }
        catch (IllegalArgumentException e){
            LOGGER.error("Token vacio ",e.getCause() );
        }
        catch (SignatureException e){
            LOGGER.error("Token fallo firma ",e.getCause() );
        }
        return false;
    }

    private final static Logger LOGGER= LoggerFactory.getLogger(JwtProvider.class);
}
