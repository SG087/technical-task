package ru.sg.technicalTask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sg.technicalTask.dto.UsersResponse;
import ru.sg.technicalTask.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UsersResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UsersResponse findById(@PathVariable(name = "id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody UsersResponse response) {
        userService.create(response);

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody UsersResponse response,
                                             @PathVariable(name = "id") Long id) {
        userService.update(response, id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
