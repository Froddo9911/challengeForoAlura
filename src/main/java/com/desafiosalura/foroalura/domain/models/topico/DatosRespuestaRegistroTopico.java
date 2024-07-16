package com.desafiosalura.foroalura.domain.models.topico;

import com.desafiosalura.foroalura.domain.models.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DatosRespuestaRegistroTopico(

         Long id,
         String titulo,
         String mensaje,
         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
         LocalDateTime fechaCreacion,
         String autor,
         String curso
)
{
    //constructor para convertir la respuesta de registro de topico
    public DatosRespuestaRegistroTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
