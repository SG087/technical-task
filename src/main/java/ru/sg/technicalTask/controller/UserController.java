package ru.sg.technicalTask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sg.technicalTask.dto.UserRequest;
import ru.sg.technicalTask.dto.UserResponse;
import ru.sg.technicalTask.mappers.Mapper;
import ru.sg.technicalTask.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final Mapper map;

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll().stream()
                .map(map::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable(name = "id") Long id) {
        return map.toResponse(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody UserRequest request) {
        userService.create(map.toEntity(request));

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody UserRequest request,
                                             @PathVariable(name = "id") Long id) {
        userService.update(map.toEntity(request), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
