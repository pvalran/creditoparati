package com.pma.pimacpt.security.jwt;

import com.pma.pimacpt.service.user.CredencialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CredencialService credencialService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token= getToken(request);
            if(token!=null && jwtProvider.validateToken(token)){
                UserDetails userDetails= credencialService.loadUserByUsername(jwtProvider.getUserNameFromToken(token));
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }
        catch (Exception e){
            LOGGER.error("TokenFilter fallo filtro ",e.getCause() );
        }
        filterChain.doFilter(request,response);
    }

    private String getToken (HttpServletRequest request){
        String authHeader= request.getHeader("Authorization");
        if(authHeader!=null&& authHeader.startsWith("Bearer")){
            return authHeader.replaceAll("Bearer ","");
        }
        else {
            return null;
        }
    }

    private final static Logger LOGGER= LoggerFactory.getLogger(JwtFilter.class);
}
