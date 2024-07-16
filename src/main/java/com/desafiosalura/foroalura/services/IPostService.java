package com.desafiosalura.foroalura.services;

import com.desafiosalura.foroalura.domain.models.DatosPost;
import com.desafiosalura.foroalura.domain.models.DatosPostResponse;
import com.desafiosalura.foroalura.domain.models.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IPostService {

    Posts savePublicacion(DatosPost datosPost);

    Page<DatosPostResponse> getAll(Pageable pageable);
}
