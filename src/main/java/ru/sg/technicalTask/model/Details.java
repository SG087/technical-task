package ru.sg.technicalTask.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
