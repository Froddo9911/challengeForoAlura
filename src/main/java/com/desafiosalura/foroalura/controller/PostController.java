package com.desafiosalura.foroalura.controller;
import com.desafiosalura.foroalura.domain.models.DatosPost;
import com.desafiosalura.foroalura.domain.models.DatosPostResponse;
import com.desafiosalura.foroalura.domain.models.Posts;
import com.desafiosalura.foroalura.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publicaciones")
public class PostController {

    PostService publicacionService = new PostService();

    @Autowired
    public PostController(PostService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity savePublicacion(@RequestBody DatosPost datosPost) {

        Posts posts = publicacionService.savePublicacion(datosPost);

        return ResponseEntity.ok().body(posts);
    }

    @GetMapping
    public Page<DatosPostResponse> getAll(@PageableDefault(size = 10) Pageable pageable) {

        return publicacionService.getAll(pageable);
    }


}