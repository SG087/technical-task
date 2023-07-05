package ru.sg.technicalTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sg.technicalTask.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
}
