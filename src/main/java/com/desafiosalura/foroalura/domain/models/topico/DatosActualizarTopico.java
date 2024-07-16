package com.desafiosalura.foroalura.domain.models.topico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(

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
