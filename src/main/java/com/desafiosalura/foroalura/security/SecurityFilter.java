package com.desafiosalura.foroalura.security;

import com.desafiosalura.foroalura.domain.models.User;
import com.desafiosalura.foroalura.repos.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository repository;

    @Autowired
    public SecurityFilter(UserRepository repository) {
        this.repository = repository;
    }
    @Autowired
    private TokenService tokenService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring(7); // Extract the token without "Bearer "
                String subject = tokenService.getSubject(token);

                if (subject != null) {
                    User user = repository.findByLogin(subject);

                    if (user != null) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        throw new UsernameNotFoundException("Usuario no encontrado para el token proporcionado");
                    }
                } else {
                    throw new AuthenticationServiceException("No se pudo autenticar el token JWT proporcionado");
                }
            } catch (Exception e) {
                // Manejo de excepciones y respuesta HTTP adecuada
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error de autenticación: " + e.getMessage());
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}