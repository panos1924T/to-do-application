CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       uuid UUID NOT NULL UNIQUE,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       active BOOLEAN NOT NULL DEFAULT TRUE,
                       deleted BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at TIMESTAMPTZ,
                       updated_at TIMESTAMPTZ,
                       deleted_at TIMESTAMPTZ
);