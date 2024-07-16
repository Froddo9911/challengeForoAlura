package com.desafiosalura.foroalura.controller;


import com.desafiosalura.foroalura.security.DatosJWT;
import com.desafiosalura.foroalura.security.TokenService;
import com.desafiosalura.foroalura.domain.models.DatosLogin;
import com.desafiosalura.foroalura.domain.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AutenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DatosLogin datosLoginDto){
        Authentication token = new UsernamePasswordAuthenticationToken(datosLoginDto.username(), datosLoginDto.password());
        authenticationManager.authenticate(token);
        var usuarioAutenticado = authenticationManager.authenticate(token);
        var jwt = tokenService.generarToken((User) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWT(jwt));

    }

}
