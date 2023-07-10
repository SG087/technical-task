package ru.sg.technicalTask.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sg.technicalTask.security.model.SecurityUser;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    Optional<SecurityUser> findByUsername(String username);
    boolean existsByUsername(String username);
}
