package ru.sg.technicalTask.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import ru.sg.technicalTask.model.Users;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Override
    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            value = "users-details")
    List<Users> findAll();

    @Override
    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            value = "users-details")
    Optional<Users> findById(@NonNull Long id);
}
