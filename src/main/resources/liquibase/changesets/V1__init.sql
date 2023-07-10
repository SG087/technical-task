CREATE TABLE IF NOT EXISTS details
(
    id           BIGSERIAL    NOT NULL,
    email        VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users
(
    id            BIGSERIAL    NOT NULL,
    date_of_birth DATE         NOT NULL,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    patronymic    VARCHAR(255),
    details_id    INT8,
    PRIMARY KEY (id),
    CONSTRAINT fk_details_users
        FOREIGN KEY (details_id)
            REFERENCES details (id)
);

CREATE TABLE IF NOT EXISTS security_user
(
    id       BIGSERIAL    NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255),
    email    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);