CREATE TABLE IF NOT EXISTS t_user (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    nickname VARCHAR(100),
    sex TINYINT,
    time_ms_create /*毫秒*/ BIGINT NOT NULL,
    time_ms_update /*毫秒*/ BIGINT NOT NULL
);