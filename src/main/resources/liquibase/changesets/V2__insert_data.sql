INSERT INTO details (email, phone_number)
VALUES ('JosephLopez@example.com', '+79123456789'),
       ('MiaGonzalez@example.com', '+79234567890'),
       ('DavidNelson@example.com', '+79345678901'),
       ('IsabellaCarter@example.com', '+79456789012'),
       ('EmmaTurner@example.com', '+79567890123'),
       ('AvaBrown@example.com', '+79678901234'),
       ('WilliamMiller@example.com', '+79789012345'),
       ('SophiaGarcia@example.com', '+79890123456'),
       ('JamesHernandez@example.com', '+79901234567'),
       ('OliviaMartinez@example.com', '+78012345678'),
       ('EmilyDavis@example.com', '+78023456789'),
       ('MichaelJohnson@example.com', '+78034567890'),
       ('JaneSmith@example.com', '+78045678901'),
       ('JohnDoe@example.com', '+78056789012'),
       ('RobertWilson@example.com', '+78067890123');

INSERT INTO users (date_of_birth, first_name, last_name, patronymic, details_id)
VALUES ('1995-02-14', 'Joseph', 'Lopez', 'Walker', 1),
       ('1986-10-10', 'Mia', 'Gonzalez', 'Allen', 2),
       ('1997-09-03', 'David', 'Nelson', 'Adams', 3),
       ('1998-11-27', 'Isabella', 'Carter', 'Baker', 4),
       ('1999-07-17', 'Emma', 'Turner', 'Evans', 5),
       ('1996-06-25', 'Ava', 'Brown', 'Clark', 6),
       ('1989-12-02', 'William', 'Miller', 'Lee', 7),
       ('1994-08-08', 'Sophia', 'Garcia', 'White', 8),
       ('1987-04-18', 'James', 'Hernandez', 'Jackson', 9),
       ('1991-11-05', 'Olivia', 'Martinez', 'Thomas', 10),
       ('1988-07-22', 'Emily', 'Davis', 'Wilson', 11),
       ('1985-09-30', 'Michael', 'Johnson', 'Brown', 12),
       ('1992-05-15', 'Jane', 'Smith', 'Doe', 13),
       ('1990-01-01', 'John', 'Doe', 'Smith', 14),
       ('1997-12-28', 'Robert', 'Wilson', 'Taylor', 15);

INSERT INTO security_user(password, role, email)
VALUES ('$2a$10$RjBEAucotkZiUNFbYfKdaOgVjQtQ5fPKc20XENi3LEpk5BFZn9RZa', 'ADMIN', 'admin');