package ru.sg.technicalTask.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import ru.sg.technicalTask.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            value = "users-details")
    List<User> findAll();

    @Override
    @NonNull
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            value = "users-details")
    Optional<User> findById(@NonNull Long id);
}
