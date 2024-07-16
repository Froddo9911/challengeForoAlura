package com.desafiosalura.foroalura.domain.models.topico;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        //Los datos del tópico (título, mensaje, autor y curso)

        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        String autor,
        @NotNull
        String curso
) {
}
