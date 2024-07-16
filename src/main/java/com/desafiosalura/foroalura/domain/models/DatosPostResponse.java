package com.desafiosalura.foroalura.domain.models;

import java.time.LocalDate;

public record DatosPostResponse(
        Long id,
        String autor,
        String titulo,
        String contenido,
        LocalDate fecha
) {
    public DatosPostResponse(Posts posts) {

        this(posts.getId(), posts.getAutor(), posts.getTitulo(), posts.getContenido(), posts.getFecha());
    }

}

