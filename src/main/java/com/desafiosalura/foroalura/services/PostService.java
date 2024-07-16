package com.desafiosalura.foroalura.services;

import com.desafiosalura.foroalura.domain.models.DatosPost;
import com.desafiosalura.foroalura.domain.models.Posts;
import com.desafiosalura.foroalura.repos.PostRepository;
import com.desafiosalura.foroalura.domain.models.DatosPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostService implements IPostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Posts savePublicacion(DatosPost datosPost) {
        Posts posts = new Posts(datosPost);
        postRepository.save(posts);

        return posts;
    }

    public Page<DatosPostResponse> getAll(Pageable pageable) {
        return postRepository.findAll(pageable).map(DatosPostResponse::new);
    }
}
