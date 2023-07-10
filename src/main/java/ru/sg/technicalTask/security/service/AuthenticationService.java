package ru.sg.technicalTask.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sg.technicalTask.security.dto.AuthenticationRequest;
import ru.sg.technicalTask.security.dto.AuthenticationResponse;
import ru.sg.technicalTask.security.dto.RegisterRequest;
import ru.sg.technicalTask.security.exception.EmailAlreadyExistsException;
import ru.sg.technicalTask.security.model.Role;
import ru.sg.technicalTask.security.model.SecurityUser;
import ru.sg.technicalTask.security.repository.SecurityUserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final SecurityUserRepository securityUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        if (securityUserRepository.existsByUsername(request.getUsername())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }

        SecurityUser user = SecurityUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        securityUserRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        SecurityUser user = securityUserRepository.findByUsername(request.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
