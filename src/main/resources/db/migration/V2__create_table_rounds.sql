CREATE TABLE rounds
(
    id             serial PRIMARY KEY,
    name           VARCHAR(80) NOT NULL,
    start_date     TIMESTAMP,
    end_date       TIMESTAMP,
    min_points_win INTEGER
);
