package com.desafiosalura.foroalura.repos;

import com.desafiosalura.foroalura.domain.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {

}
