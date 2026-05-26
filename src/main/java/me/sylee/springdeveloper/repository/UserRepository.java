package me.sylee.springdeveloper.repository;

import me.sylee.springdeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // select * from users where email = ?
}
