CREATE TABLE tasks (
    id  BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status smallint NOT NULL,
    version BIGINT DEFAULT 0
);