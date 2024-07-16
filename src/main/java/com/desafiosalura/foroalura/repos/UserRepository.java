package com.desafiosalura.foroalura.repos;

import com.desafiosalura.foroalura.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByLogin(String login);
}
